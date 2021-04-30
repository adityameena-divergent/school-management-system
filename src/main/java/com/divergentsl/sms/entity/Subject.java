package com.divergentsl.sms.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "subject")
@Getter
@Setter
public class Subject implements Serializable {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
