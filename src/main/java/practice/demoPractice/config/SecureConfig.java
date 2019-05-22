package practice.demoPractice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecureConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                //.authorizeRequests()
                //.anyRequest()
                //.authenticated()
                .authorizeRequests().antMatchers("/image")//путь шеред даем доступ всем
                .permitAll()

                .antMatchers("/getAll").hasRole("Admin")
                .antMatchers("/getGreater").hasRole("Admin")

                .and()//продолжение
                .httpBasic() // задаем бейси к автриз
                .and()
                .logout()

        ;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { //для пользователя
        auth
                .inMemoryAuthentication()
                .withUser("Aida")
                .password("{noop}123")
                .roles("Admin")



        ;
    }
}
