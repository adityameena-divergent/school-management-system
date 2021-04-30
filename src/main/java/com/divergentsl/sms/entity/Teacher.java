package com.divergentsl.sms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "teacher")
@Setter
@Getter
public class Teacher implements Serializable {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	@ManyToOne(targetEntity = Subject.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "subject_id")
	Subject subject;

	public Teacher(String firstName, String lastName, Subject subject) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.subject = subject;
	}

	public Teacher() {
		super();
	}
	
	

	
}
