package com.student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="COURSES")
public class ECourse 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer sr;
	private String NAME;
	public Integer getSr() {
		return sr;
	}
	public void setSr(Integer sr) {
		this.sr = sr;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	@Override
	public String toString() {
		return "ECourse [sr=" + sr + ", NAME=" + NAME + "]";
	}
	
}
