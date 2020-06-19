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
import com.lifegraph.team20.response.QuestionIdResponse;


@Service
public class QuestionService2 {

	@Autowired
	private QuestionRepository2 qr;

//	public void Question(QurstionRepository2 qr) {
//	List<Question2> list = qr.selectQuestions();
//		System.out.println(list.toString());
//	}
	public Question2  updatedQuestions() {
		// make ArrayList
		List<Question2> list = new ArrayList<Question2>();


		// insert into list
		list = qr.selectQuestions();

		// shuffle object
		Collections.shuffle(list);

		// limited the number of Questions
		List<Question2> list2 = list.stream()
				.limit(5)
				.collect(Collectors.toList());

		// get one Question
		Question2 list3 = list2.get(0);
		return list3;
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
	public void getQuestionId(QuestionIdResponse id) {
		Long questionId = id.getQuestionId();
		System.out.println(questionId);
		updatedAnswer(questionId);
	}

	public List<Answer> updatedAnswer(Long questionId) {
		Long id = questionId;
		List<Answer> answer = qr.selectAnswer(id);
		return answer;
	}

	// １回目は問題を表示するだけ
	//　２回目以降は一つ前の問題を削除して、次の問題を出題する
}
