package pe.org.group02.ventaboletoscine.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Autowired
    JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(HttpMethod.POST, "/user/login").permitAll()
                        //Usuarios
                        .requestMatchers(HttpMethod.POST, "/user/add").hasAnyRole("Operador", "Administrador")
                        .requestMatchers(HttpMethod.GET, "/user/find").hasAnyRole("Operador", "Administrador")
                        .requestMatchers(HttpMethod.PATCH, "/user/update").hasRole("Administrador")
                        .requestMatchers(HttpMethod.DELETE, "/user/delete").hasRole("Administrador")
                        //PeliculasGenero
                        .requestMatchers(HttpMethod.POST, "/movies/add").hasAnyRole("Operador", "Administrador")
                        .requestMatchers(HttpMethod.GET, "/movies/find").hasAnyRole("Operador", "Administrador")
                        .requestMatchers(HttpMethod.PATCH, "/movies/update").hasAnyRole("Administrador")
                        .requestMatchers(HttpMethod.DELETE, "/movies/delete").hasRole("Administrador")
                        //Funciones
                        .requestMatchers(HttpMethod.POST, "/function/add").hasAnyRole("Operador", "Administrador")
                        .requestMatchers(HttpMethod.GET, "/function/find").hasAnyRole("Operador", "Administrador")
                        .requestMatchers(HttpMethod.PATCH, "/function/update").hasRole("Administrador")
                        .requestMatchers(HttpMethod.DELETE, "/function/delete").hasRole("Administrador")
                        //Empleados
                        .requestMatchers(HttpMethod.POST, "/employee/add").hasAnyRole("Operador", "Administrador")
                        .requestMatchers(HttpMethod.GET, "/employee/find").hasAnyRole("Operador", "Administrador")
                        .requestMatchers(HttpMethod.PATCH, "/employee/update").hasRole("Administrador")
                        .requestMatchers(HttpMethod.DELETE, "/employee/delete").hasRole("Administrador")
                        //Boletos
                        .requestMatchers(HttpMethod.POST, "/ticket/add").hasAnyRole("Operador", "Administrador")
                        .requestMatchers(HttpMethod.GET, "/ticket/find").hasAnyRole("Operador", "Administrador")
                        .requestMatchers(HttpMethod.PATCH, "/ticket/update").hasRole("Administrador")
                        .requestMatchers(HttpMethod.DELETE, "/ticket/delete").hasRole("Administrador")

                        //PeliculasGeneroService
                        .requestMatchers(HttpMethod.POST, "/movies/add").hasAnyRole("Operador", "Administrador")
                        .requestMatchers(HttpMethod.GET, "/movies/find").hasAnyRole("Operador", "Administrador")
                        .requestMatchers(HttpMethod.PATCH, "/movies/update").hasRole("Administrador")
                        .requestMatchers(HttpMethod.DELETE, "/movies/delete").hasRole("Administrador")

                        .anyRequest().authenticated()
                )
                .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
