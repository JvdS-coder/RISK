package nl.novi.risk.controller.secure;

import nl.novi.risk.domain.ERole;
import nl.novi.risk.domain.Gebruiker;
import nl.novi.risk.domain.Role;
import nl.novi.risk.payload.request.LoginRequest;
import nl.novi.risk.payload.request.SignupRequest;
import nl.novi.risk.payload.response.JwtResponse;
import nl.novi.risk.payload.response.MessageResponse;
import nl.novi.risk.repository.secure.GebruikerRepository;
import nl.novi.risk.repository.secure.RoleRepository;
import nl.novi.risk.service.GebruikerDetailsImpl;
import nl.novi.risk.service.secure.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Validated
public class AuthorizationService {

    private static final String ROLE_NOT_FOUND_ERROR = "Error: Role is not found.";

    private GebruikerRepository gebruikerRepository;
    private PasswordEncoder encoder;
    private RoleRepository roleRepository;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;

    @Autowired
    public void setGebruikerRepository(GebruikerRepository gebruikerRepository) {
        this.gebruikerRepository = gebruikerRepository;
    }

    @Autowired
    public void setEncoder(PasswordEncoder passwordEncoder) {
        this.encoder = passwordEncoder;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    /**
     *
     * Deze methode verwerkt de gebruiker die wil registreren. De naam_gebruiker en e-mail worden gecheckt. Eventuele rollen
     * worden toegevoegd en de gebruiker wordt opgeslagen in de database.
     *
     * @param signUpRequest de payload signup-request met naam_gebruiker en wachtwoord.
     * @return een HTTP response met daarin een succesbericht.
     */
    public ResponseEntity<MessageResponse> registerUser(@Valid SignupRequest signUpRequest) {
        if (Boolean.TRUE.equals(gebruikerRepository.existsByUsername(signUpRequest.getNaam_gebruiker()))) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Gebruikersnaam is al bezet !"));
        }

        if (Boolean.TRUE.equals(gebruikerRepository.existsByEmail(signUpRequest.getEmail_gebruiker()))) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email adres is al in gebruik !"));
        }

        Gebruiker gebruiker = new Gebruiker(
            signUpRequest.getNaam_gebruiker(),
                signUpRequest.getEmail_gebruiker(),
                signUpRequest.getAfdeling_gebruiker(),
                LocalDate.now(),
                signUpRequest.getPassword()
        );

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName(ERole.ROLE_USER).get());

        gebruiker.setRoles(roles);
        gebruikerRepository.save(gebruiker);

        return ResponseEntity.ok(new MessageResponse("Gebruiker is nu geregistreerd !"));
    }

    /**
     * Deze methode controleert de ontvangen username en wachtwoord. Het gebruikt hiervoor de
     * AuthenticationManager. I.a.w. Spring security doet die allemaal voor ons.
     *
     * Wanneer de gebruikersnaam/wachtwoord combinatie niet klopt, wordt er een Runtime exception gegooid:
     * 401 Unauthorized. Deze wordt gegooid door
     *
     *
     * @param loginRequest De payload met username en password.
     * @return een HTTP-response met daarin de JWT-token.
     */
    public ResponseEntity<JwtResponse> authenticateUser(@Valid LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getNaam_gebruiker(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        GebruikerDetailsImpl gebruikerDetails = (GebruikerDetailsImpl) authentication.getPrincipal();
        List<String> role = gebruikerDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                gebruikerDetails.getNr_gebruiker(),
                gebruikerDetails.getNaam_gebruiker(),
                gebruikerDetails.getEmail_gebruiker(),
                role));
    }
}
