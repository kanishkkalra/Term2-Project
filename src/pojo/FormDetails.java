package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FormDetails")
public class FormDetails {
	
	@Id @GeneratedValue
	private int id;
	
	@Column(name = "NAME")
	private String uname;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String pword;
	
	@Column(name = "NUMBER")
	private long num;
	
	@Column(name = "AGE")
	private int age;
	
	@Column(name = "GENDER")
	private String gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "FormDetails [id=" + id + ", uname=" + uname + ", email=" + email + ", pword=" + pword + ", num=" + num
				+ ", age=" + age + ", gender=" + gender + "]";
	}
	
}
