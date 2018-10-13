package springpractise.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("deprecation")
public class CustomerFormData {
	Integer id;
	@Length (max=255, message = "Name is too long")
	String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date dob;
	@Length(max=15, message = "Phone number > 15 characters")
	String phone;
	@Email(message="Invalid email format")
	String email;
	Boolean gender;
	String address;
	String title;
	Integer page;
	Boolean sortName;
	Boolean sortDob;
	Boolean sortPhone;
	Boolean sortEmail;
	
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
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public Boolean getSortName() {
		return sortName;
	}
	public void setSortName(Boolean sortName) {
		this.sortName = sortName;
	}
	public Boolean getSortDob() {
		return sortDob;
	}
	public void setSortDob(Boolean sortDob) {
		this.sortDob = sortDob;
	}
	public Boolean getSortPhone() {
		return sortPhone;
	}
	public void setSortPhone(Boolean sortphone) {
		this.sortPhone = sortphone;
	}
	public Boolean getSortEmail() {
		return sortEmail;
	}
	public void setSortEmail(Boolean sortEmail) {
		this.sortEmail = sortEmail;
	}
	public Customer convert(){
		Customer customer = new Customer(id, name, dob, phone, email, gender, address, title);
		return customer;
	}
}
