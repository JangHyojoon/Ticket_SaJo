package com.multi.security.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.multi.vo.CustVO;

import lombok.Data;

// 시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다. 
// 로그인 진행이 완료되면 session을 만들어 준다. -> 시큐리티가 가지는 session이 따로 존재한다. 
// 시큐리티가 가지고있는 session에 들어갈 수 있는 오브젝트 형태가 정해져있다. => Authentication  타입 객체로 들어가야한다. 
// Authentication 안에 user 정보가 있어야 됨 . 

// 정리하자면 시큐리티 session이 저장되는 공간이 따로 존재한다.
// 이때 들어갈 수 있는 객체의 형태는 Authentication 타입의 객체만 들어갈 수 있다.
// Authentication 객체 안에는 UserDetails 타입으로 user 정보가 저장된다. 
// UserDetails 를 implements 헤서 만든 PrincipalDetails 를 Authentication 으로 보낸다.  
// 구조 정리 : Security Session  => Authentication => UserDetails(PrincipalDetails)

// Authentication 객체에 저장할 수 있는 유일한 타입
@Data
public class PrincipalDetailsCustVO implements UserDetails, OAuth2User{

	private static final long serialVersionUID = 1L;
	private CustVO cust;//콤포지션 
	private Map<String, Object> attributes;

	// 일반 시큐리티 로그인시 사용
	public PrincipalDetailsCustVO(CustVO cust) {// 생성자 
		this.cust = cust;
	}
	
	// OAuth2.0 플렛폼 로그인시 사용
	public PrincipalDetailsCustVO(CustVO cust, Map<String, Object> attributes) {
		System.out.println("principalDetails 생성자 user : " + cust);
		this.cust = cust;
		this.attributes = attributes;
	}
	
	public CustVO getUser() {
		return cust;
	}

	@Override
	public String getPassword() {
		return cust.getPwd();
	}

	@Override
	public String getUsername() {
		return cust.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {//비밀번호가 오래되었니
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {//개정이 활성화 되어있는지 
		// 개발하는 사이트에서 1년동안 회원이 로그인을 안하면 휴먼 계정으로 전환해야한다. 
		// User 객체에 Timestemp 만든다음에 => 현재시간 - 로그인 시간 해서 1년 초과시 휴먼계정으로 전환 
		return true;
	}
	
	// 해당 유저의 권한을 리턴하는 곳 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collet = new ArrayList<GrantedAuthority>();
		collet.add(()->{ return cust.getRole();});
		return collet;
	}

	// 리소스 서버로 부터 받는 회원정보
	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	// User의 PrimaryKey
	@Override
	public String getName() {
		return cust.getId()+"";
	}
	
}
