package com.aihui.fenchinghall.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String userQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(userQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/*").permitAll()

                .antMatchers("/").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/about").permitAll()
                .antMatchers("/advantage").permitAll()
                .antMatchers("/coach").permitAll()
                .antMatchers("/culture").permitAll()
                .antMatchers("/fencing").permitAll()
                .antMatchers("/fencingworld").permitAll()
                .antMatchers("/introduction").permitAll()
                .antMatchers("/manage").permitAll()
                .antMatchers("/member").permitAll()
                .antMatchers("/member_time").permitAll()
                .antMatchers("/news").permitAll()
                .antMatchers("/notice").permitAll()
                .antMatchers("/power").permitAll()
                .antMatchers("/rule").permitAll()
                .antMatchers("/course").permitAll()
                .antMatchers("/course_itr").permitAll()
                .antMatchers("/course_s").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/appointment").permitAll()
//

//                .antMatchers("/register").permitAll()
//                .antMatchers("/bgeditappointment").permitAll()
                .antMatchers("/bgeditappointment").hasAuthority("admin")
                .antMatchers("/bghome").hasAuthority("admin")
                .antMatchers("/bguser").hasAuthority("admin")
                .antMatchers("/uploadtime").hasAuthority("coach")
//                .antMatchers("/bgschedule").hasAuthority("admin")
                .anyRequest()
                .authenticated().and().csrf().disable()
                .formLogin()
                .loginPage("/login").failureUrl("/login?error=true")
                .defaultSuccessUrl("/home")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/home").and().exceptionHandling()
                .accessDeniedPage("/deny");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h5plus/**", "/test/**", "/resources/**",
                        "/static/**", "/css/**", "/js/**", "/images/**", "/font-awesome/**", "/logos/**", "/banners/**");
    }


//    @RequestMapping(value="/qufen")
//    public String qufen(){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if(auth.getAuthorities().toString().equals("[user]"))
//            return "index";//如果是客户登录
//        else
//            return "htshouye";//如果是后台管理人员登录
//    }
//    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//    {
//        Assert.notNull(request, "HttpServletRequest required");
//        if (this.invalidateHttpSession) {
//            HttpSession session = request.getSession(false);
//            if (session != null) {
//                session.invalidate(); //使当前会话失效
//            }
//        }
//
//        SecurityContextHolder.clearContext(); //清空安全上下文
//    }

}
