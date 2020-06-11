package com.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVO;

// DAO에 특화된 어노테이션. @Component 어노테이션을 써도 상관 없지만, DAO 클래스들에 @Repository 어노테이션을 사용함으로써
// @Component 어노테이션이 가진 특성과 함께, DAO의 메소드에서 발생할 수 있는 unchecked exception들을 스프링의 DataAccessException으로
// 처리할 수 있는 장점 또한 갖는다.
@Repository
public class BoardDAOImpl implements BoardDAO {
	
//	name으로 DI를 가능케 한다. 자바에서 지원하는 어노테이션이며 프레임워크에 종속적이지 않아 상사용해도 좋다.
//	타입으로 연결한다.
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.board.mappers.board";
	
	//게시물 목록
	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".list");
	}
	
	//게시물 작성
	@Override
	public void write(BoardVO vo) throws Exception {
		
		sql.insert(namespace + ".write", vo);
		
	}

}
