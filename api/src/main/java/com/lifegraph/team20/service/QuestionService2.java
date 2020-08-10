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
//	List<Question2> list;

	public int count = 0;

	public Question2 getQuestion() {
		// make ArrayList
		List<Question2> getQuestion = new ArrayList<Question2>();
		// insert into list
		getQuestion = qr.selectQuestions();

		// shuffle object
		Collections.shuffle(getQuestion);

//		// limited the number of Questions
//		List<Question2> selectQuestions =getQuestion.stream()
//				.limit(5)
//				.collect(Collectors.toList());
		list.addAll(getQuestion);
		Question2 selectQuestion = list.get(0);
		return selectQuestion;

	}

	public Question2 updatedQuestion() {
//		if(list.isEmpty()) {
//			this.getQuestions();
//			Question2 selectQuestion = list.get(0);
////			for(Question2 list2 : list) {
////				System.out.println(list2.toString());
////			}
////			System.out.println("-----------------");
//			return selectQuestion;
//		} else {
			list.remove(0);
			Collections.shuffle(list);
			Question2 selectQuestion = list.get(0);

			return selectQuestion;
		}

	public List<Answer> updatedAnswer(Long questionId) {
		Long id = questionId;
		List<Answer> answer = qr.selectAnswer(id);
		return answer;
	}
}
