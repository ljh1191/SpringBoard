package com.myspring.mapper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myspring.domain.BoardCommentDTO;
import com.myspring.domain.BoardDAOImpl;
import com.myspring.domain.BoardDTO;

@Service("bService")
public class BoardService {
	@Resource(name = "bDao")
	private BoardDAOImpl bDao;
	
	//insert
	public void insert(BoardDTO dto) {
		bDao.insert("insertBoard",dto);
	}
	
	//dapinsert
		public void dapinsert(BoardDTO dto) {
			bDao.dapinsert("dapinsertBoard",dto);
		}
	
	//list
	public List<BoardDTO> list(HashMap<String, Object> hm) {
		List<BoardDTO> list = bDao.list("listBoard",hm);
		return list;
	}
	
	//totcount
	public int totcount() {
		int totcount = bDao.totcount("totcountBoard");
		return totcount;
	}
	
	//view
	public BoardDTO view(int seq) {
		BoardDTO dto = bDao.view("viewBoard", seq);
		return dto;
	}
	
	//update
	public void update(BoardDTO dto) {
		bDao.update("updateBoard",dto);
	}
	
	//delete
	public void delete(int seq) {
		bDao.delete("deleteBoard", seq);
	}
	
	//passcheck
	public int passcheck(int seq, String password) {
		int check = bDao.passcheck("passcheckBoard", seq,password);
		return check;
	}
	
	//searchcount
	public int searchcount(HashMap<String, Object> hm) {
		int count = bDao.searchcount("searchcountBoard",hm);
		return count;
	}
	
	//hitcount
	public void hitcount(int seq) {
		bDao.hitcount("hitcountBoard",seq);
	}
	
	//replywirte
	public void replywrite(BoardCommentDTO dto) {
		bDao.replywrite("replywirteComment",dto);
	}
	
	//replylist
	public List<BoardCommentDTO> replylist(int boardnum){
		List<BoardCommentDTO> cdto = bDao.replylist("replylistComment",boardnum);
		return cdto;
	}
}
