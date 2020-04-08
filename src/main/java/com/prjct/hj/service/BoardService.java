package com.prjct.hj.service;

import java.util.List;

import com.prjct.hj.domain.AttachedFileVO;
import com.prjct.hj.domain.PostVO;

public interface BoardService {
	public void insertPost(PostVO post) throws Exception; //글 작성 
	public int selectPostIdx(PostVO post) throws Exception; //글 작성후 번호 가져오기
	public int selectMaxPostIdx() throws Exception; //가장 큰 글번호 가져오기 
	public void insertAttachedFile(AttachedFileVO af) throws Exception; //첨부파일 내용 테이블 인서트 
	public List<PostVO> selectAllPost() throws Exception;
}
