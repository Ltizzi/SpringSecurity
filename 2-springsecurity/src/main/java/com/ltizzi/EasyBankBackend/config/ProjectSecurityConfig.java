package com.ltizzi.EasyBankBackend.config;

import com.ltizzi.EasyBankBackend.filter.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;


@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        //se crea un contexto de seguridad que envia la cookie en el primer login (jsessionID)
        http.securityContext((context)-> context.requireExplicitSave(false))
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setMaxAge(3600L);
                        return config;
                    }
            }))
                .csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler)
                                .ignoringRequestMatchers("/contact", "/register")
                                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests((requests) -> requests
                        //primera version sin authZ
                        //    .requestMatchers("/myAccount","/myBalance", "myLoans", "/myCards", "/user").authenticated()

                        //segunda versión con authZ usando authorities
                            /*        .requestMatchers("/myAccount").hasAuthority("VIEWACCOUNT")
                                    .requestMatchers("/myBalance").hasAnyAuthority("VIEWACCOUNT", "VIEWBALANCE")
                                    .requestMatchers("/myLoans").hasAuthority("VIEWLOANS")
                                    .requestMatchers("/myCards").hasAuthority("VIEWCARDS")*/

                        //3RA VERSION CON ROLES
                                    .requestMatchers("/myAccount").hasRole("USER")
                                    .requestMatchers("/myBalance").hasAnyRole("USER", "ADMIN")
                                    .requestMatchers("/myLoans").hasRole("USER")
                                    .requestMatchers("/myCards").hasRole("USER")
                                    .requestMatchers("/user").authenticated()
                                    .requestMatchers("/notices", "/contact", "/register")
                                        .permitAll())
                                .formLogin(Customizer.withDefaults())
                                .httpBasic(Customizer.withDefaults());
        // .anyRequest.denyAll()
        // .anyRequest.permitAll()
        return http.build();
    }

    //previo al custom user details (en la carpeta config también)
   /* @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }*/

    //in memory user details
    //primer aproach
/*    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("12345")
                .authorities("admin")
                .build();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("123")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }*/

    //approach 2
/*    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails admin = User.withUsername("admin")
                .password("123")
                .authorities("admin")
                .build();

        UserDetails user = User.withUsername("user")
                .password("123")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(admin, user);

    }*/

    //NoOpPasswordEncoder
    // no recomendado para produccion, no encripta la pass, plain string
    @Bean
    public PasswordEncoder passwordEncoder(){

        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }


}
