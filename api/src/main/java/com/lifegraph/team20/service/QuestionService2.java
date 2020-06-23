package com.lifegraph.team20.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

	public void getQuestions() {
		// make ArrayList
		List<Question2> getquestion = new ArrayList<Question2>();
		// insert into list
		getquestion = qr.selectQuestions();

		// shuffle object
		Collections.shuffle(getquestion);

		// limited the number of Questions
		List<Question2> selectQuestions =getquestion.stream()
				.limit(5)
				.collect(Collectors.toList());
		list.addAll(selectQuestions);

	}

	public Question2 updatedQuestion() {
		if(list.isEmpty()) {
			this.getQuestions();
			Question2 selectQuestion = list.get(0);
//			for(Question2 list2 : list) {
//				System.out.println(list2.toString());
//			}
//			System.out.println("-----------------");
			return selectQuestion;
		} else {
			Question2 selectQuestion = list.get(0);

			return selectQuestion;
		}
	}

//	public void updateQuestions() {
//		List<Question2> list = new ArrayList<Question2>();
//		list = qr.selectQuestions();
//		Collections.shuffle(list);
//		List<Question2> list2 = list.stream()
//				.limit(5)
//				.collect(Collectors.toList());
//				for(Question2 question : list2) {
//
//					System.out.println(question.toString());
//				}
//	}
//
//	public List<Question2> shuffle() {
//		List<Question2> list = this.updateQuestions();
//		List<Question2> list2 = list.stream()
//				.limit(5)
//				.collect(Collectors.toList());
//				for(Question2 question : list2) {
//
//					System.out.println(question.toString());
//				}
//		return list2;
//	}
//	public void getQuestionId(QuestionIdResponse id) {
//		Long questionId = id.getQuestionId();
//		System.out.println(questionId);
//		updatedAnswer(questionId);
//	}

	public List<Answer> updatedAnswer(Long questionId) {
		Long id = questionId;
		List<Answer> answer = qr.selectAnswer(id);
		list.remove(0);
		return answer;
	}
}
