package com.multi.security.config.oauth.provider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class GoogleUserInfo implements OAuth2UserInfo{

	private Map<String, Object> attributes;
	
    public GoogleUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
	
    @Override
    public String getProviderId() {// sub = google 로그인시 리턴되는 비밀번호 같은것 
        return (String) attributes.get("sub");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

	@Override
	public String getProvider() {
		return "google";
	}
	@Override
	public Date getBirthday() {
//		return (String) attributes.get("birthday");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse("1996-02-07");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	@Override
	public String getGender() {
//		return (String) attributes.get("gender");
		return "men";
	}
	

	@Override
	public boolean getUsed() {
		return true;
	}


}
