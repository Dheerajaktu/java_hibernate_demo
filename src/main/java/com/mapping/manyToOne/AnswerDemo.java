package com.mapping.manyToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerDemo {
	@Id
	@Column(name = "id")
	private int id;
	private String answer;

	@ManyToOne
	private QuestionDemo question;

	public AnswerDemo() {
		super();
	}

	public AnswerDemo(int id, String answer, QuestionDemo question) {
		super();
		this.id = id;
		this.answer = answer;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public QuestionDemo getQuestion() {
		return question;
	}

	public void setQuestion(QuestionDemo question) {
		this.question = question;
	}

}
