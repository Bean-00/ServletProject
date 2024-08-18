package user.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class UserVO {
	private String name;
	private String gender;
	private Date birthDate;
	private String job;
	private String mobile;
	private String address;
	private String id;
	private String pw;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String year, String month, String day) {
		StringBuilder sb = new StringBuilder();
		sb.append(year);
		sb.append(month);
		sb.append(day);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			this.birthDate = sdf.parse(sb.toString());
		} catch(ParseException e) {
			this.birthDate = null;
		}
	}
	
	public String getBirthDateString() {
		if (Objects.isNull(birthDate)) return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy³â MM¿ù ddÀÏ");
		return sdf.format(birthDate);
	}
	
	public void setBirthDate(Date date) {
		this.birthDate = date;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String firstNum, String midNum, String lastNum) {
		StringBuilder sb = new StringBuilder();
		sb.append(firstNum);
		sb.append("-");
		sb.append(midNum);
		sb.append("-");
		sb.append(lastNum);
		
		this.mobile = sb.toString();
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public boolean checkValidation () {
		if (this.name != null && this.gender != null
				&& this.birthDate != null && this.job != null
				&& this.mobile != null && this.address != null
				&& this.id != null && this.pw != null) {
			return true;
		} else
			return false;
	}

}
