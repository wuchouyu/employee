package com.tut.employee.config;

import com.tut.employee.Filter.JWTAuthenticationFilter;
import com.tut.employee.Filter.JWTAuthorizationFilter;
import com.tut.employee.web.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsServiceImpl userDetailsService;


    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/selectStudent").hasAuthority("ROLE_USER")
                .antMatchers("/updateStudent").hasAuthority("ROLE_USER")
                .antMatchers("/selectAllStudent").hasAuthority("ROLE_ADMIN")
                .antMatchers("/queryStudent").hasAuthority("ROLE_ADMIN")
                .antMatchers("/addEmployment").hasAuthority("ROLE_USER")
                .antMatchers("/selectEmployment").hasAuthority("ROLE_USER")
                .antMatchers("/countByCollege").hasAuthority("ROLE_ADMIN")
                .antMatchers("/countByProvince").hasAuthority("ROLE_ADMIN")
                .antMatchers("/countByProfession").hasAuthority("ROLE_ADMIN")
                .antMatchers("/xy_jiuyelv").hasAuthority("ROLE_ADMIN")
                .antMatchers("/selectCompany").hasAuthority("ROLE_COM")
                .antMatchers("/updateCompany").hasAuthority("ROLE_COM")
                .antMatchers("/selectAllCompany").hasAuthority("ROLE_COM")
                .antMatchers("/queryCompany").hasAuthority("ROLE_ADMIN")
                .antMatchers("/shenhe").hasAuthority("ROLE_ADMIN")
                .antMatchers("/shtg").hasAuthority("ROLE_ADMIN")
                .antMatchers("/jj").hasAuthority("ROLE_ADMIN")
                .antMatchers("/selectJobSeekerBySid").hasAuthority("ROLE_USER")
                .antMatchers("/selectJobSeekerByCid").hasAuthority("ROLE_COM")
                .antMatchers("/addResume").hasAuthority("ROLE_USER")
                .antMatchers("/selectResume").hasAuthority("ROLE_USER")
                .antMatchers("/downloadResume").hasAuthority("ROLE_COM")
                .antMatchers("/addJobSeeker").hasAuthority("ROLE_USER")
                .antMatchers("/selectJobSeekerBySid").hasAuthority("ROLE_USER")
                .antMatchers("/selectJobSeekerByCid").hasAuthority("ROLE_COM")
                .antMatchers("/*Demand").hasAuthority("ROLE_USER")
                .antMatchers("/tuijian").hasAuthority("ROLE_COM")
                .antMatchers("/*Position").hasAuthority("ROLE_COM")
                .antMatchers("/addQuestion").hasAuthority("ROLE_USER")
                .anyRequest().permitAll()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
