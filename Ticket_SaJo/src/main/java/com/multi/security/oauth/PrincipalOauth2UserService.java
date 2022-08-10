package com.multi.security.oauth;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;
//import com.cos.securityex01.config.oauth.provider.FaceBookUserInfo;
//import com.cos.securityex01.config.oauth.provider.GoogleUserInfo;
//import com.cos.securityex01.config.oauth.provider.NaverUserInfo;
//import com.cos.securityex01.config.oauth.provider.OAuth2UserInfo;
import com.multi.security.config.auth.PrincipalDetailsCustVO;
import com.multi.security.config.oauth.provider.FaceBookUserInfo;
import com.multi.security.config.oauth.provider.GoogleUserInfo;
import com.multi.security.config.oauth.provider.NaverUserInfo;
import com.multi.security.config.oauth.provider.OAuth2UserInfo;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

//	@Autowired
//	private UserRepository userRepository;
//	
	@Autowired
	CustBiz cbiz;
	

	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// userRequest 는 code를 받아서 accessToken을 응답 받은 객체
	// google로부터 받은 userRequest데이터에 대한 후처리 되는 함수  
	// 함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어진다. 
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		// userRequest 에 담겨있는 정보 = 구글 로그인 버튼 클릭 -> 구글 로그인창 -> 로그인 완료 -> code를 리턴받음 (OAuth-Client라이브러리가 대신받아줌) -> AccessToken 요청
		// userRequest 에 담겨있는 정보를 활용해 회원프로필 정보를 받아야한다. (loadUser 함수 이용)
		System.out.println("userRequest : " + userRequest);
		System.out.println("userRequest1 : " + userRequest.getClientRegistration().getClientName());
		
//		Person profile = peopleService.people().get("people/me")
//			    .setPersonFields("names,emailAddresses")
//			    .execute();
		
//		System.out.println("getClientRegistration : " + userRequest.getClientRegistration()); // registrationId로 어떤 플렛폼으로 로그인 했는지 알 수 있다. ex) 'google'
//		System.out.println("getAccessToken : " + userRequest.getAccessToken().getTokenValue());//이게 google 서버로부터 받은 access Token이다. 
		
		OAuth2User oAuth2User = super.loadUser(userRequest); // google의 회원 프로필 조회
		System.out.println("getAttributes : " + oAuth2User.getAttributes());
		
		// 어느 플랫폼으로 가입한 건지 판별하는 곳  
		OAuth2UserInfo oAuth2UserInfo = null;
		if(userRequest.getClientRegistration().getRegistrationId().equals("google")) {// google 플랫폼으로 로그인한 경우 
			System.out.println("google 로그인 요청");
			oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
			System.out.println("user birthday : " + oAuth2UserInfo.getBirthday());
			
		}else if (userRequest.getClientRegistration().getRegistrationId().equals("facebook")) { // facebook 플랫폼에서 로그인한 경우 
			System.out.println("facebook 로그인 요청");
			oAuth2UserInfo = new FaceBookUserInfo(oAuth2User.getAttributes());
		}else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
			System.out.println("naver 로그인 요청");
			oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
			
		}else {
			System.out.println("google 과 facebook, naver 만 지원합니다. ");
		}
		
		
//		// google 하나만 있을 경우 
//		// 회원 가입을 강제로 진행한다. 
//		String provider = userRequest.getClientRegistration().getRegistrationId(); // 플렛폼 이름이 들어간다. 
//		String providerId = oAuth2User.getAttribute("sub"); //sub 안에 구글에서 사용되는 패스워드가 들어가있다.
//		// database에 저장될 id
//		String username = provider + "_" + providerId; // google_10231354824 이런 형태로 id를 생성함 -> sub의 값은 유일하기 때문에 User 객체의 primary key로 설정가능
//		// database에 저장될 password
////		String password = bCryptPasswordEncoder.encode("겟인데어"); 
//		String email = oAuth2User.getAttribute("email"); // email 정보가 들어가있다. 
//		String role = "ROLE_USER"; // role을 user로 설정 
		
		// 여러개 플랫폼 있을 경우 
		// 회원 가입을 강제로 진행한다. 
		String provider = oAuth2UserInfo.getProvider(); // 플렛폼 이름이 들어간다. 
		String providerId = oAuth2UserInfo.getProviderId(); //sub 안에 구글에서 사용되는 패스워드가 들어가있다.
		// database에 저장될 id
//		String username = provider + "_" + providerId; // google_10231354824 이런 형태로 id를 생성함 -> sub의 값은 유일하기 때문에 User 객체의 primary key로 설정가능
		String username = oAuth2UserInfo.getName();
		String email = oAuth2UserInfo.getEmail(); // email 정보가 들어가있다. 
		Date birthday = oAuth2UserInfo.getBirthday();  
		String gender = oAuth2UserInfo.getGender();  
		String role = "ROLE_USER"; // role을 user로 설정 
		
		// 유저 정보가 database에 존재하는지 확인 
//		User userEntity = userRepository.findByUsername(username);
		CustVO c = new CustVO(email, "0000", username,birthday,0,gender);// 초기 비밀번호 0000 
		try {
			CustVO cust = cbiz.get(email);// 이메일 찾기 
			if(cust == null) {// 일치하는 cust가 없을경우 회원가입
				//INSERT INTO cust VALUES (#{id},#{pwd},#{name},#{birth},#{point},#{sex})
				c.setUsed(true);
				cbiz.register(c);// 데이터베이스에 유저정보 저장 
				//session에 정보 저장 
				
			}else {
				System.out.println("이미 회원가입한  아이디 입니다. ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
//		if(userEntity == null) {// 유저 정보가 database에 존재하지 않는경우 -> 최초로 로그인한 경우 
//			System.out.println("로그인이 최초입니다. "); 
//			userEntity = User.builder()// User 객체에다가 값을 셋팅 
//					.username(username)
////					.password(password)
//					.email(email)
//					.birthday(birthday)
//					.gender(gender)
//					.role(role)
//					.provider(provider)
//					.providerId(providerId)
//					.build();
//			userRepository.save(userEntity);// database에 user 정보를 저장 
//			
//			// principalDetails는 Authentication 객체 안에 들어갈 것이다. -> 
//			// Authentication객체는 시큐리티 session에 들어갈 것이다.
//			
//		}else {
//			System.out.println("로그인을 이미 한적이 있습니다. 당신은 자동회원가입이 되어있습니다.  ");
//			
//		}
		return new PrincipalDetailsCustVO(c,oAuth2User.getAttributes()); 
//		return new PrincipalDetails(userEntity,oAuth2User.getAttributes());  
//		return super.loadUser(userRequest); // 위의 정보만 확인할때 return 사용 

//		// code를 통해 구성한 정보
//		System.out.println("userRequest clientRegistration : " + userRequest.getClientRegistration());
//		// token을 통해 응답받은 회원정보
//		System.out.println("oAuth2User : " + oAuth2User);
//	
//		return processOAuth2User(userRequest, oAuth2User);
	}

//	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
//
//		// Attribute를 파싱해서 공통 객체로 묶는다. 관리가 편함.
//		OAuth2UserInfo oAuth2UserInfo = null;
//		if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
//			System.out.println("구글 로그인 요청~~");
//			oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
//		} else if (userRequest.getClientRegistration().getRegistrationId().equals("facebook")) {
//			System.out.println("페이스북 로그인 요청~~");
//			oAuth2UserInfo = new FaceBookUserInfo(oAuth2User.getAttributes());
//		} else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")){
//			System.out.println("네이버 로그인 요청~~");
//			oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
//		} else {
//			System.out.println("우리는 구글과 페이스북만 지원해요 ㅎㅎ");
//		}
//
//		//System.out.println("oAuth2UserInfo.getProvider() : " + oAuth2UserInfo.getProvider());
//		//System.out.println("oAuth2UserInfo.getProviderId() : " + oAuth2UserInfo.getProviderId());
//		Optional<User> userOptional = 
//				userRepository.findByProviderAndProviderId(oAuth2UserInfo.getProvider(), oAuth2UserInfo.getProviderId());
//		
//		User user;
//		if (userOptional.isPresent()) {
//			user = userOptional.get();
//			// user가 존재하면 update 해주기
//			user.setEmail(oAuth2UserInfo.getEmail());
//			userRepository.save(user);
//		} else {
//			// user의 패스워드가 null이기 때문에 OAuth 유저는 일반적인 로그인을 할 수 없음.
//			user = User.builder()
//					.username(oAuth2UserInfo.getProvider() + "_" + oAuth2UserInfo.getProviderId())
//					.email(oAuth2UserInfo.getEmail())
//					.role("ROLE_USER")
//					.provider(oAuth2UserInfo.getProvider())
//					.providerId(oAuth2UserInfo.getProviderId())
//					.build();
//			userRepository.save(user);
//		}
//
//		return new PrincipalDetails(user, oAuth2User.getAttributes());
//	}
}
