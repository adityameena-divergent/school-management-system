package com.divergentsl.sms.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "class")
@Setter
@Getter
public class Classs {

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int classId;
	
	String className;
	
	String classSection;
	
	@ManyToOne(targetEntity = Subject.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "teacher_id")
	Teacher teacherId;

	@Override
	public String toString() {
		return "Classs [classId=" + classId + ", className=" + className + ", classSection=" + classSection
				+ ", teacherId=" + teacherId + "]";
	}
	
	
	

	
	
	
	
	
}
