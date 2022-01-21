package com.mapping.manyToOne;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class QuestionDemo {
	@Id
	@Column(name = "id")
	private int question_id;
	private String question;

	@OneToMany(mappedBy = "question")
	private List<AnswerDemo> answers;

	public QuestionDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionDemo(int question_id, String question, List<AnswerDemo> answers) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.answers = answers;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<AnswerDemo> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDemo> answers) {
		this.answers = answers;
	}

}
