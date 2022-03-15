package com.inn.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQuery(name="getstudentByName",query="select s from Student s where s.name=:name")

@Entity
@Table(name = "student")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "mobileNo")
	private Long mobileNo;

	
	@Column(name = "email")
	private String email;
	
	@Column(name = "dateOfBirth")
	private String dateOfBirth;
	
	@ManyToOne
	@JoinColumn(name = "TICKET_FAMILY_FK")
	private TicketFamily ticketFamily;

	public TicketFamily getTicketfamily() {
		return ticketFamily;
	}

	public void setTicketfamily(TicketFamily ticketfamily) {
		this.ticketFamily = ticketfamily;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", ticketFamily=" + ticketFamily + "]";
	}

	

	public Student(int id, String name, Long mobileNo, String email, String dateOfBirth, TicketFamily ticketFamily) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.ticketFamily = ticketFamily;
	}

	public Student() {
		super();
	}

	
	
}