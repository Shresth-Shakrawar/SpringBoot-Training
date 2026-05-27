package com.example.demo;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "customers")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message= "Customer name cannot be blank.")
	@Size(min = 3, max =20 ,message = "Customer name should be between 3 and 20 characters")
	private String cust_name;
	@NotBlank(message = "Address could not be blank")
	private String address;
	@NotBlank(message = "Credit Score cannot be blank")
	@Min(value = 300,message="Credit Score should be atleast 300")
	@Max(value = 800,message = "Credit Score should be less than 801")
	private float creditScore;
	@Min(value = 0,message="Days Registered cannot be negative.")
	private int daysRegistered;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(float creditScore) {
		this.creditScore = creditScore;
	}
	public int getDaysRegistered() {
		return daysRegistered;
	}
	public void setDaysRegistered(int daysRegistered) {
		this.daysRegistered = daysRegistered;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", cust_name=" + cust_name + ", address=" + address + ", creditScore="
				+ creditScore + ", daysRegistered=" + daysRegistered + "]";
	}
	public Customer() {
		super();
	}
	public Customer(int id,
			@NotBlank(message = "Customer name cannot be blank.") @Size(min = 3, max = 20, message = "Customer name should be between 3 and 20 characters") String cust_name,
			@NotBlank(message = "Address could not be blank") String address,
			@NotBlank(message = "Credit Score cannot be blank") @Min(value = 300, message = "Credit Score should be atleast 300") @Max(value = 800, message = "Credit Score should be less than 801") float creditScore,
			@Min(value = 0, message = "Days Registered cannot be negative.") int daysRegistered) {
		super();
		this.id = id;
		this.cust_name = cust_name;
		this.address = address;
		this.creditScore = creditScore;
		this.daysRegistered = daysRegistered;
	}
	
}
