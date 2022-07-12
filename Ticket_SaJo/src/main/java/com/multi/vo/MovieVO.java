package com.multi.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieVO {
	private int id;
	private int gid;
	private String title;
	private String director;
	private String mainactor;
	private Date releasedate;
	private String posterimg1;
	private String posterimg2;
	private String country;
	private String runningtime;
	private String text;

	private String gname;
	private double star;
	private int hgid;

	
	public MovieVO(int gid, String title, String director, String mainactor, Date releasedate, String posterimg1,
			String posterimg2, String country, String runningtime, String text) {
		this.gid = gid;
		this.title = title;
		this.director = director;
		this.mainactor = mainactor;
		this.releasedate = releasedate;
		this.posterimg1 = posterimg1;
		this.posterimg2 = posterimg2;
		this.country = country;
		this.runningtime = runningtime;
		this.text = text;
	}


//	// 0712 안원영 추가 - 생성자 14개 -> 필드 더 추가될 경우 사용 
//	public MovieVO(int id, int gid, String title, String director, String mainactor, Date releasedate,
//			String posterimg1, String posterimg2, String country, String runningtime, String text, String gname,
//			int hgid, double star) {
//		super();
//		this.id = id;
//		this.gid = gid;
//		this.title = title;
//		this.director = director;
//		this.mainactor = mainactor;
//		this.releasedate = releasedate;
//		this.posterimg1 = posterimg1;
//		this.posterimg2 = posterimg2;
//		this.country = country;
//		this.runningtime = runningtime;
//		this.text = text;
//		this.gname = gname;
//		this.hgid = hgid;
//		this.star = star;
//	}


	public MovieVO(int id, int gid, String title, String director, String mainactor, Date releasedate,
			String posterimg1, String posterimg2, String country, String runningtime, String text) {
		this.id = id;
		this.gid = gid;
		this.title = title;
		this.director = director;
		this.mainactor = mainactor;
		this.releasedate = releasedate;
		this.posterimg1 = posterimg1;
		this.posterimg2 = posterimg2;
		this.country = country;
		this.runningtime = runningtime;
		this.text = text;
	}

	
}
