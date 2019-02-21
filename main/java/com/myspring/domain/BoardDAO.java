package com.myspring.domain;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
	//전체보기
	public List<BoardDTO> list(String sqlid,HashMap<String, Object> hm);
	//추가
	public void insert(String sqlid,BoardDTO dto);
	//답글
	public void dapinsert(String sqlid,BoardDTO dto);
	//수정
	public void update(String sqlid,BoardDTO dto);
	//삭제
	public void delete(String sqlid,int seq);
	//상세보기
	public BoardDTO view(String sqlid,int seq);
	//패스워드체크
	public int passcheck(String sqlid,int seq, String password);
	//게시글수
	public int totcount(String sqlid);
	//검색게시글수
	public int searchcount(String sqlid, HashMap<String, Object> hm);
	//클릭할때마다 조회수 증가
	public void hitcount(String sqlid,int seq);
	//댓글쓰기
	public void replywrite(String sqlid,BoardCommentDTO dto);
	//댓글리스트
	public List<BoardCommentDTO> replylist(String sqlid,int boardnum);
}
