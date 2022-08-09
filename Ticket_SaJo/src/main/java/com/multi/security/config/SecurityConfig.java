package com.multi.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.multi.security.oauth.PrincipalOauth2UserService;


@SuppressWarnings("deprecation")
@Configuration // IoC 빈(bean)을 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) // secured 어노테이션 활성화  
// 특정 주소 접근시 권한 및 인증을 위한 어노테이션 활성화 -> 
//controller에서 @Secured ,@PreAuthorize로 ROLE을 설정해 접근을 제한할 수 있다.
// @Secured : 한가지의 접근권한 설정시 사용 
// @PreAuthorize : 여러가지 접근권한 설정시 사용 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PrincipalOauth2UserService principalOauth2UserService;
	
	// 해당 메서드의 리턴되는 오브젝트를 Ioc 로 등록해준다. 
	@Bean
	public BCryptPasswordEncoder encodePwd() {// 회원가입시 비밀번호를 암호화 하는 방법 
		return new BCryptPasswordEncoder();
	}
//	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/user/**").authenticated()
//			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")// /admin페이지로 가기 위해서는 Role이 Admin이거나 User 여야한다. 
//			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest().permitAll()
		.and()
			.formLogin()
			.loginPage("/sigin")
//			.usernameParameter("username2") // 만약 로그인폼 페이지의 form-name-username을 username2로 변경했을 경우 추가해야한다. 
			.loginProcessingUrl("/login")//login 주소가 호출되면 시큐리티가 낚아채서 대신 로그인을 진행해 준다. 
			.defaultSuccessUrl("/loginsuccess")//로그인 완료되면 해당 페이지로 이동하도록 설정하는 곳이다. 
		//이때 권한이 필요한 페이지 요청했을 때 login 한 뒤에 권한 필요한 페이지를 자동으로 띄워준다. 
		.and()  
			.oauth2Login() // loginForm 페이지에서 /oauth2/authorization/google 주소 호출시 동작하는 곳
			.loginPage("/sigin") // googole 로그인이 완료된 뒤의 후처리가 필요하다. 
			.defaultSuccessUrl("/loginsuccess")
			.userInfoEndpoint() //구글 로그인이 완료된 뒤의 후처리가 필요함. 코드를 받는것이 아니라 (엑세스토큰 + 사용자프로필정보 ) 를 받아온다. 
			// 후처리는 PrincipalOauth2UserService에서 처리된다. 
			.userService(principalOauth2UserService);
	}
}


//@EnableWebSecurity
//@RequiredArgsConstructor
//@Configuration(proxyBeanMethods = false)
//@ConditionalOnDefaultWebSecurity
//@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
//public class SecurityConfig {
//
//	@Autowired
//  private final CustomOAuth2UserService customOAuth2UserService;
//
//  @Bean
//  @Order(SecurityProperties.BASIC_AUTH_ORDER)
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//      http
//              .csrf().disable()
//              .headers().frameOptions().disable()
//              .and()
//              .authorizeRequests()
//              .antMatchers("/", "/css/**", "/images/**",
//                      "/js/**", "/h2-console/**").permitAll()
//              .antMatchers("/api/v1/**").hasRole(Role.
//                      USER.name())
//              .anyRequest().authenticated()
//              .and()
//              .logout()
//              .logoutSuccessUrl("/")
//              .and()
//              .oauth2Login()
//              .userInfoEndpoint()
//              .userService(customOAuth2UserService);
//      return http.build();
//  }
//  
//  
//
//}



