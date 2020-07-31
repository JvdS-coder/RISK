package nl.novi.risk.service;

import nl.novi.risk.domain.Gebruiker;
import nl.novi.risk.repository.secure.GebruikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GebruikerDetailsServiceImpl implements UserDetailsService {

    GebruikerRepository gebruikerRepository;

    @Autowired
    public GebruikerDetailsServiceImpl(GebruikerRepository gebruikerRepository) {
        this.gebruikerRepository = gebruikerRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String naam_gebruiker)  {
        Gebruiker gebruiker = gebruikerRepository.findByUsername(naam_gebruiker)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found: " + naam_gebruiker));
        return GebruikerDetailsImpl.build(gebruiker);
    }
}