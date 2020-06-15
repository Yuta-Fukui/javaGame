package com.lifegraph.team20.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lifegraph.team20.entity.Question;
import com.lifegraph.team20.service.QuestionService;

@Controller
public class JavaGame {
	@Autowired
	QuestionService qs;

	@GetMapping(value = "/test")
	public  ResponseEntity<List<Question>> question() throws IOException {

		// メソッドを入れるところ
		List<Question> q = qs.test();
		System.out.println(q.toString());
		System.out.println("テスト");

		return ResponseEntity.ok(q);

	}
}
