package javabasic.jdbc.board.main;

import java.util.List;

import javabasic.jdbc.board.model.Article;
import javabasic.jdbc.board.service.ArticleService;
import javabasic.jdbc.board.service.impl.ArticleServiceImpl;

public class ArticleMain {

	public static void main(String[] args) {

		ArticleService articleService = new ArticleServiceImpl();
		
//		List<Article> articleList = articleService.listArticle();
//		for(Article article:articleList) {
//			System.out.println(article);
//		}

//		System.out.println(articleService.getArticle(6));
		
//		articleService.registArticle(new Article(0, "제제목", "내내용", null, 3, 5, "N", "LEE", 3));
		
//		articleService.modifyArticle(new Article(21, "새제목", "새내용", null, 4, 6, "N", "HONG", 2));
		
		articleService.removeArticle(21);

	} // main

} // class
