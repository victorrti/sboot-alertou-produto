package com.alertou.sboot_atom_produto.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private  SecurityFilter securityFilter;
    private static final String[] AUTH_SWAGGER_LIST = {
            "/swagger-ui.html",
            "/v3/api-docs/**",
            "/api-docs/**",
            "/swagger-ui/**",
            "/docs/**",
            "/swagger-resources/**",
            "/swagger-ui/index.html"
    };
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{

        http.csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth ->{
                    auth.requestMatchers(AUTH_SWAGGER_LIST).permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .addFilterBefore(securityFilter, BasicAuthenticationFilter.class);

        return http.build();
    }




    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173")); // Origem permitida (React)
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE","OPTIONS","HEAD", "TRACE", "CONNECT")); // Métodos permitidos
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type","Accept")); // Headers permitidos
        configuration.setAllowCredentials(true); // Permitir envio de cookies e credenciais

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
