package trung.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT USERNAME, PASSWORD, ENABLE FROM USER WHERE USERNAME = ?")
		.authoritiesByUsernameQuery("SELECT USERNAME, ROLE FROM USER WHERE USERNAME = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
		.and().authorizeRequests().antMatchers("/user/**").hasRole("USER")
		.anyRequest().permitAll().and().formLogin().loginPage("/login").loginProcessingUrl("/login")
		.usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/")
		.failureUrl("/login").and().exceptionHandling().accessDeniedPage("/login")
		;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**","/files/**");
	}
}
