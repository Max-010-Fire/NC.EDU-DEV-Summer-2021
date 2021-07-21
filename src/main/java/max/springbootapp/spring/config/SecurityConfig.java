package max.springbootapp.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users/**").hasRole( "ADMIN")
                .antMatchers("/tasks").hasAnyRole("USER", "ADMIN")
                .antMatchers("/tasks/modify/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/tasks/delete/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/tasks/**").hasRole( "ADMIN")
                .antMatchers("/**").permitAll()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                "select name, password, 'true' from users " +
                        "where name=?")
                .authoritiesByUsernameQuery(
                        "select name, roles.role_name from users, user_roles, roles " +
                                "where user_roles.user_id=users.id and user_roles.role_id=roles.id and users.name=?");;
    }
}