package pl.niziolekp.app.userservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, JwtAuthenticationConverter jwtAuthenticationConverter) throws Exception {
        httpSecurity.authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/for-all").permitAll()
                        .requestMatchers("/for-debug").authenticated()
                        .requestMatchers("/for-auth").authenticated()
                        .requestMatchers("/for-user").hasAnyAuthority("user-role")
                        .requestMatchers("/for-admin").hasAnyAuthority("admin-role")
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 ->
                        oauth2
                                .jwt(jwt -> jwt
                                        .jwtAuthenticationConverter(jwtAuthenticationConverter)));
        return httpSecurity.build();
    }
  //z realma pobierane role
    /*@Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            Object realmAccess = jwt.getClaims().get("realm_access");
            if (realmAccess instanceof Map<?, ?> accessMap) {
                Object roles = accessMap.get("roles");
                if (roles instanceof Collection<?> rolesList) {
                    return rolesList.stream()
                            .filter(String.class::isInstance)
                            .map(String.class::cast)
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());
                }
            }
            return List.of();
        });
        return converter;
    }*/
    //role pobierane z klienta
    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            Object resourceAccess = jwt.getClaims().get("resource_access");
            if (resourceAccess instanceof Map<?, ?> accessMap) {
                Object livestreamClient = accessMap.get("marketplace-client");
                if (livestreamClient instanceof Map<?, ?> clientMap) {
                    Object roles = clientMap.get("roles");
                    if (roles instanceof Collection<?> rolesList) {
                        return rolesList.stream()
                                .filter(String.class::isInstance)
                                .map(String.class::cast)
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList());
                    }
                }
            }
            return List.of();
        });
        return converter;
    }
}

