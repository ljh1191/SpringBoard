package com.myspring.domain;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
	//��ü����
	public List<BoardDTO> list(String sqlid,HashMap<String, Object> hm);
	//�߰�
	public void insert(String sqlid,BoardDTO dto);
	//���
	public void dapinsert(String sqlid,BoardDTO dto);
	//����
	public void update(String sqlid,BoardDTO dto);
	//����
	public void delete(String sqlid,int seq);
	//�󼼺���
	public BoardDTO view(String sqlid,int seq);
	//�н�����üũ
	public int passcheck(String sqlid,int seq, String password);
	//�Խñۼ�
	public int totcount(String sqlid);
	//�˻��Խñۼ�
	public int searchcount(String sqlid, HashMap<String, Object> hm);
	//Ŭ���Ҷ����� ��ȸ�� ����
	public void hitcount(String sqlid,int seq);
	//��۾���
	public void replywrite(String sqlid,BoardCommentDTO dto);
	//��۸���Ʈ
	public List<BoardCommentDTO> replylist(String sqlid,int boardnum);
}
