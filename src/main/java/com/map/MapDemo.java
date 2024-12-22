package com.map;

import com.map.entity.Answer;
import com.map.entity.Question;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MapDemo {
	public static void main(String[] args) {
		System.out.println("I am Map");
		Session factory = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			//Create
			Question q1 = new Question();
			q1.setQuestionId(100);
			q1.setQuestion("What is Java?");

			Question q2 = new Question();
			q2.setQuestionId(101);
			q2.setQuestion("What is your name?");

			//Creating Answer
			Answer ans1 = new Answer();
			ans1.setAnswerId(300);
			ans1.setAnswer("Java is programming language");
			ans1.setQuestion(q2);
			q1.setAnswer(ans1);

			Answer ans2 = new Answer();
			ans2.setAnswerId(301);
			ans2.setAnswer("My name is John");
			ans2.setQuestion(q1);
			q2.setAnswer(ans2);

			transaction = factory.beginTransaction();

			factory.save(q1);
			factory.save(q2);
			factory.save(ans1);
			factory.save(ans2);

			transaction.commit();

			//fetching....

			Question newQ = factory.get(Question.class, q2.getQuestionId());
			System.out.println(newQ.getQuestion());
			System.out.println(newQ.getAnswer().getAnswer());

		}
		catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			factory.close();
			HibernateUtil.shutdown();
		}

	}
}
