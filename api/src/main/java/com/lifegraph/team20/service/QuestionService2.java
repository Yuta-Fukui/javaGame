package com.lifegraph.team20.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifegraph.team20.entity.Question2;
import com.lifegraph.team20.repository.QuestionRepository2;


@Service
public class QuestionService2 {

	@Autowired
	private QuestionRepository2 qr;

	public List<Question2> updateQuestions() {
		List<Question2> list = new ArrayList<Question2>();
		list = qr.selectQuestions();
		Collections.shuffle(list);//レコードの順番をシャッフルに
		List<Question2> listC = restrict(list);

	return listC;
	}
	public List<Question2> restrict(List<Question2> list) {
			list.stream()//streamのメソッドを使うよ
			.limit(5)//streamの中間操作（5個だけ取り出す）
			.collect(Collectors.toList());//streamの終端操作（中間操作をした物をListの形に戻す）

	return list;
	}
}
