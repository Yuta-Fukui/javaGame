package com.lifegraph.team20.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifegraph.team20.entity.Answer;
import com.lifegraph.team20.entity.Question2;
import com.lifegraph.team20.repository.QuestionRepository2;


@Service
public class QuestionService2 {

	@Autowired
	private QuestionRepository2 qr;

	List<Question2> list = new ArrayList<Question2>();

	public int count = 0;

	public Question2 getQuestion() {
		// make ArrayList
		List<Question2> getQuestion = new ArrayList<Question2>();

		// insert into list
		getQuestion = qr.selectQuestions();

		// shuffle object
		Collections.shuffle(getQuestion);

		// set to list
		list.addAll(getQuestion);
		Question2 selectQuestion = list.get(0);
		return selectQuestion;

	}

	public Question2 updatedQuestion() {
		// remove question
		list.remove(0);

		// shuffle object
		Collections.shuffle(list);

		// set to list
		Question2 selectQuestion = list.get(0);
		return selectQuestion;
	}

	public List<Answer> updatedAnswer(Long questionId) {
		Long id = questionId;

		// get answer
		List<Answer> answer = qr.selectAnswer(id);
		return answer;
	}
}
