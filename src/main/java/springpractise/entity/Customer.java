package springpractise.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import springpractise.validator.Phone;

public class Customer implements Serializable{
	Integer id;
	@NotBlank(message="Name is required")
	@Length(max=255,message="Name too long")
	String name = null;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Date of Birth is require")
	Date dob;
	@NotBlank(message = "Phone number is required")
	@Phone
	String phone;
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	String email;
	@NotNull(message = "Gender is required")
	Boolean gender;
	@NotBlank(message = "Address is required")
	String address;
	String title;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Customer(Integer id, String name, Date dob, String phone, String email, Boolean gender, String address,
			String title) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.title = title;
	}
	public Customer() {
	}
}
