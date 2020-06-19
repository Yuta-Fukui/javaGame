package com.lifegraph.team20.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lifegraph.team20.entity.Question2;
import com.lifegraph.team20.service.QuestionService2;



@Controller
public class JavaGame2 {
	@Autowired//抽象クラスからメソッドを使える用にインポートしてる
	private QuestionService2 qs;//qsは名前つけただけ

	@GetMapping(value = "/question")
	public ResponseEntity<List<Question2>> question() throws IOException {
		//そもそもlistとは・・・複数のオブジェクトが入っている参照型のデータ型。

		List<Question2> listA = qs.updateQuestions();
		System.out.println(listA.toString());

		//シャッフルとかできているか１つ１つ出して確認
		for(Question2 listB : listA) {
		System.out.println(listB.toString());
		//ブロック内の変数を使いなさい！（forの最後が;になってて「listBなんてなかったんや！」ってなってた）
		}
		return ResponseEntity.ok(listA);
	}
}
