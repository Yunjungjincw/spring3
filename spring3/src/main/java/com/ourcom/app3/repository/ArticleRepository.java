package com.ourcom.app3.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ourcom.app3.domain.Article;


@Repository
public class ArticleRepository {
	
	
	/*action-mybatis.xml에서   sqlSession이름으로  bean객체만들어진 것을
	 * 자동주입(@Autowired)시켜준다
	<bean id="sqlSession"
		  class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg index="0" ref="sqlSessionFactory"></constructor-arg>
	</bean>*/

	//필드
	@Autowired
	private SqlSession sqlSession;
	
	
	/*여기에서는 action-mybatis.xml에서   
	 실행하고자하는 쿼리를 가진 문서는 아래와 같이 설정하였다
	 <property name="mapperLocations" 
	           value="classpath:mybatis/mappers/*.xml" />*/
	//전체 게시물수 조회
	public int getTotalCnt(){
		int cnt =(Integer)sqlSession.selectOne("mapper.article.totalCnt");
		System.out.println(cnt);
		return cnt;
	}
	
	public List<Article> articleList(Article article){
		List<Article> list =sqlSession.selectList("articleList",article);
		return list;
	}
	
	
	public Article articleContent(int articleNo) {
		Article article = sqlSession.selectOne("articleContent", articleNo);
		return article;
	}
}
