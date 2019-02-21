package com.myspring.domain;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bDao")
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlMap;
	@Override
	public List<BoardDTO> list(String sqlid,HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		List<BoardDTO> list = sqlMap.selectList(sqlid,hm);
		return list;
	}

	@Override
	public void insert(String sqlid, BoardDTO dto) {
		// TODO Auto-generated method stub
		int num = sqlMap.selectOne("seqMaxNum")==null?1:sqlMap.selectOne("seqMaxNum");
		int groups = 0;
		if(dto.getSeq() == 0) {//새글
			groups = num+1;
		}else {//답글
			groups = dto.getGroups();
		}
		int levels = dto.getLevels();
		int steps = dto.getSteps();
		if(dto.getSeq() !=0) {//답변글
			sqlMap.update("dapupdateBoard",dto);
			steps = steps+1;
			levels = levels+1;
		}else {//새글
//			groups = 0;
			steps = 0;
			levels = 0;
		}
		System.out.println(groups);
		dto.setGroups(groups);
		dto.setSteps(steps);
		dto.setLevels(levels);
		sqlMap.insert(sqlid,dto);
	}

	@Override
	public void update(String sqlid, BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlMap.update(sqlid,dto);
	}

	@Override
	public void delete(String sqlid, int seq) {
		// TODO Auto-generated method stub
		sqlMap.delete(sqlid,seq);
	}

	@Override
	public BoardDTO view(String sqlid, int seq) {
		// TODO Auto-generated method stub
		BoardDTO dto = sqlMap.selectOne(sqlid,seq);
		return dto;
	}

	@Override
	public int passcheck(String sqlid, int seq, String password) {
		// TODO Auto-generated method stub
		String Bpassword = sqlMap.selectOne(sqlid,seq);
		int check = 0;
		if(Bpassword.equals(password)) {
			check = 1;
		}
		return check;
	}

	@Override
	public int totcount(String sqlid) {
		// TODO Auto-generated method stub
		int totcount = sqlMap.selectOne(sqlid);
		return totcount;
	}

	@Override
	public int searchcount(String sqlid,HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		int count = sqlMap.selectOne(sqlid,hm);
		return count;
	}

	@Override
	public void hitcount(String sqlid,int seq) {
		// TODO Auto-generated method stub
		sqlMap.update(sqlid,seq);
	}

	@Override
	public void dapinsert(String sqlid, BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlMap.insert(sqlid,dto);
	}

	@Override
	public void replywrite(String sqlid,BoardCommentDTO dto) {
		// TODO Auto-generated method stub
		sqlMap.insert(sqlid,dto);
	}

	@Override
	public List<BoardCommentDTO> replylist(String sqlid, int boardnum) {
		// TODO Auto-generated method stub
		List<BoardCommentDTO> cdto = sqlMap.selectList(sqlid,boardnum);
		return cdto;
	}

}
