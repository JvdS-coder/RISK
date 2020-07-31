package nl.novi.risk.service.secure.jwt;

import nl.novi.risk.service.GebruikerDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AuthTokenFilter extracts username/password from the received token using JwtUtils, then based on the extracted
 * data, AuthTokenFilter:
 * – creates a AuthenticationToken (that implements Authentication)
 * – uses the AuthenticationToken as Authentication object and stores it in the SecurityContext for future filter uses
 * (e.g: Authorization filters).
 */
public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private GebruikerDetailsServiceImpl gebruikerDetailsService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthTokenFilter.class);

    private static final String TOKEN_TYPE = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String naam_gebruiker = jwtUtils.getNaam_gebruikerFromJwtToken(jwt);

                UserDetails gebruikerDetails = gebruikerDetailsService.loadUserByUsername(naam_gebruiker);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        gebruikerDetails, null, gebruikerDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            LOGGER.error("Cannot set user authentication: {0}", e);
        }

        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(TOKEN_TYPE)) {
            return headerAuth.substring(TOKEN_TYPE.length());
        }

        return null;
    }
}
