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

	List<Question2> list = new ArrayList<Question2>();//listを定義。
	public int count = 0;

	public void getQuestions() {
		List<Question2> question = new ArrayList<Question2>();
		question = qr.selectQuestions();

		Collections.shuffle(question);
		List<Question2> list2 =question.stream()
				.limit(5)
				.collect(Collectors.toList());
		list.addAll(list2);//結構上で定義したlistに、streamでいじったlist2を追加している。ここではlist=list2

		//getters,settersを下で定義している。それを動かすメソッド。
//		list2 = this.getList();
//		setList(list2);
	}

	public Question2 updatedQuestion() {
		if(list.isEmpty()) {//isEmpty：listが空かどうかを判別（空であればtrue）
			this.getQuestions();//上で定義。SQl文を用いてデータを取得、シャッフル、List化している。最終的にlistへ代入。
			Question2 question = list.get(0);//listの0個目の要素を取得
//for(Question2 list2 : list) {
//System.out.println(list2.toString());
//}
			return question;
		} else {//listに何か入っている時
//List<Question2> questions = list;
//questions = this.getList();
//for(Question2 list2 : list) {
//System.out.println(list2.toString());
//}
			Question2 question = list.get(0);
//			System.out.println("-----------------");
//
			return question;
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

	public List<Answer> updatedAnswer(Long questionId,String correctAnswer) {
		Long id = questionId;
		List<Answer> answer = qr.selectAnswer(id);
		list.remove(0);
//		list = this.getList();
//		setList(list);

		// もし問題に正解したらカウントする
		if(qr.confilmedAnswer(questionId,correctAnswer)) {
			isTrue();
		}
//		List<Question2> list3 = list;
//		for(Question2 list4 : list3) {
//			System.out.println(list4.toString());
//		}
//
//		System.out.println("-----------------");
		return answer;
	}

	public void setList(List<Question2> list) {
		this.list = list;
	}

	public List<Question2> getList() {
		return list;
	}

	public void isTrue() {
		this.count ++;
	}

	// correct_
	public void isResult() {

	}
}
