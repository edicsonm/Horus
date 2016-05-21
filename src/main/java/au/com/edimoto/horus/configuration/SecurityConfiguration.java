package au.com.edimoto.horus.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	/*@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("edicson").password("col88031").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");
    }*/
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
  
      http.authorizeRequests()
        .antMatchers("/login","/resources/**","/").permitAll() 
        .antMatchers("/main").access("hasRole('ROLE_USER')")
//        .antMatchers("/private/**").access("hasRole('ROLE_USER')")
        .antMatchers("/db/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_DBA')")
        .anyRequest().authenticated()
		.and().formLogin().loginPage("/login")		
		.and().formLogin().usernameParameter("username").passwordParameter("password")
		.and().formLogin().defaultSuccessUrl("/main")
		.usernameParameter("ssoId").passwordParameter("password")
        .and().exceptionHandling().accessDeniedPage("/Access_Denied")
        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/");
  
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
        	
        	/*For Authentication*/
        	.userSearchBase("ou=users")
        	.userSearchFilter("(uid={0})")
        	
        	/*For Authorization*/
        	.groupSearchBase("ou=groups")
            .groupSearchFilter("(member={0})")
            .groupRoleAttribute("cn")
            .rolePrefix("ROLE_")
            
            
            .contextSource()
            .url("ldap://10.1.1.12:389/dc=edimoto,dc=com")
            .managerDn("cn=edicson,dc=edimoto,dc=com")
            .managerPassword("col88031");
    }
	
}
