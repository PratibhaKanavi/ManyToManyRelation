package com.tvd.rel.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MQuestion")
public class MQuestion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String questionname;
	
	@ManyToMany(targetEntity=MAnswers.class,cascade=CascadeType.ALL)
	@JoinTable(name="MQuestion123", 
			  joinColumns = { @JoinColumn(name = "q1_id") },   
	            inverseJoinColumns = { @JoinColumn(name = "ans_id") })  
	private List<MAnswers> ans;

	public int getQid() {
		return id;
	}

	public void setQid(int id) {
		this.id = id;
	}

	public String getQuestionname() {
		return questionname;
	}

	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}

	public List<MAnswers> getAns() {
		return ans;
	}

	public void setAns(List<MAnswers> ans) {
		this.ans = ans;
	}
	

}
