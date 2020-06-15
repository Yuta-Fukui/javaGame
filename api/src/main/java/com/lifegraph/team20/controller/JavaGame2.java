package com.lifegraph.team20.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lifegraph.team20.entity.Question2;
import com.lifegraph.team20.repository.QuestionRepository2;
import com.lifegraph.team20.service.QuestionService2;


@Controller
public class JavaGame2 {
	@Autowired
	private QuestionRepository2 qr;
	private QuestionService2 qs;

	@GetMapping(value = "/question")
	public ResponseEntity<List<Question2>> question() throws IOException {
		// Listを適当に作っていれる

		// メソッドを入れるところ
		List<Question2> q = qr.selectQuestions();
		qs.updateQuestions();
//		System.out.println(q.toString());
//		System.out.println("テスト");

		return ResponseEntity.ok(q);
	}
}
