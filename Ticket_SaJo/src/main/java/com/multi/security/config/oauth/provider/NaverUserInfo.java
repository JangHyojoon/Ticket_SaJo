package com.multi.security.config.oauth.provider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class NaverUserInfo implements OAuth2UserInfo{

	private Map<String, Object> attributes;
	
    public NaverUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
	
    @Override
    public String getProviderId() {
        return (String) attributes.get("id");
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
		return "naver";
	}
	
	@Override
	public Date getBirthday() {
//		return (String) attributes.get("birthday");
		//birthday=02-07, birthyear=1996}
		String day = (String) attributes.get("birthday");
		String year = (String) attributes.get("birthyear");
		//birthday=02-07, birthyear=1996}

//		String[] month_day_split = day.split("-");
		String myString = year + "-" + day;// yyyy-MM-dd 년월일 순으로 설정 
		Date mydate = new Date();
//		String myString = year+month_day_split[0]+month_day_split[1];// 년월일 순으로 설정 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			mydate = sdf.parse(myString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return mydate;
	}
	
	@Override
	public String getGender() {
		String gender = (String) attributes.get("gender");
		if(gender.equals("M")) {
			return "men";
		}else {
			return "women";
		}

	}

}
