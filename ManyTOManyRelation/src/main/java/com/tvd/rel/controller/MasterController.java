package com.tvd.rel.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tvd.rel.dto.MAnswers;
import com.tvd.rel.dto.MQuestion;

@Controller
public class MasterController {
	
	@Autowired
	SessionFactory sf;
	
	@RequestMapping("/")
	public ModelAndView home() {
		
		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();
		
	MAnswers ans1= new MAnswers();
	ans1.setAns("java is platform independent programing lang");
	ans1.setPostedBy("james");
	
	MAnswers ans2= new MAnswers();
	ans2.setAns("java is Object Oriented robust programing lang");
	ans2.setPostedBy("Gosling");
	
	List<MAnswers> l1 = new ArrayList<MAnswers>();
	l1.add(ans1);
	l1.add(ans2);
	
	MQuestion qes1 = new MQuestion();
	qes1.setQuestionname("What is java?");
	qes1.setAns(l1);
	
	
	MAnswers ans3= new MAnswers();
	ans3.setAns("Servlet is an API");
	ans3.setPostedBy("Patrick");
	
	MAnswers ans4= new MAnswers();
	ans4.setAns("Servlet is an interface");
	ans4.setPostedBy("dutch");
	
	List<MAnswers> l2 = new ArrayList<MAnswers>();
	l2.add(ans3);
	l2.add(ans4);
	
	MQuestion qes2 = new MQuestion();
	qes2.setQuestionname("What is Servlet?");
	qes2.setAns(l2);
		
		ses.persist(qes1);
		ses.persist(qes2);
		tx.commit();
		ses.close();
		
		return new ModelAndView("home");
		
	}

}
