package com.board.dao;

import java.util.HashMap;
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
	//게시물 조회
	@Override
	public BoardVO view(int bno) throws Exception {
		
		return sql.selectOne(namespace + ".view", bno);
		
	}
	//게시물 수정
	@Override
	public void modify(BoardVO vo) throws Exception {
		sql.update(namespace + ".modify", vo);
		
	}
	//게시물 삭제
	@Override
	public void delete(int bno) throws Exception {
		sql.delete(namespace + ".delete", bno);
		
	}
	
	//게시물 총 개수
	@Override
	public int count() throws Exception {
		return sql.selectOne(namespace + ".count");
		
	}

	// 게시물 목록 + 페이징
		@Override
		public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {

			HashMap<String, Integer> data = new HashMap<String, Integer>();
			
			data.put("displayPost", displayPost);
			data.put("postNum", postNum);
			
			return sql.selectList(namespace + ".listPage", data);
		}

		// 게시물 목록 + 페이징 + 검색
		@Override
		public List<BoardVO> listPageSearch(
				int displayPost, int postNum, String searchType, String keyword) throws Exception {

			HashMap<String, Object> data = new HashMap<String, Object>();
			
			data.put("displayPost", displayPost);
			data.put("postNum", postNum);
			
			data.put("searchType", searchType);
			data.put("keyword", keyword);
			
			return sql.selectList(namespace + ".listPageSearch", data);
		}
	
	

}
