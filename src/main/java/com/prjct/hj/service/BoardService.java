package com.prjct.hj.service;

import java.util.List;

import com.prjct.hj.commons.pagination.Pagination;
import com.prjct.hj.domain.AttachedFileVO;
import com.prjct.hj.domain.PostVO;

public interface BoardService {
	public void insertPost(PostVO post) throws Exception; //글 작성 
	public int selectPostIdx(PostVO post) throws Exception; //글 작성후 번호 가져오기
	public int selectMaxPostIdx() throws Exception; //가장 큰 글번호 가져오기 
	public void insertAttachedFile(AttachedFileVO af) throws Exception; //첨부파일 내용 테이블 인서트 
	public List<PostVO> selectAllPost(Pagination pagination) throws Exception; //전체 게시물 가져오기 
	public int selectPostCnt() throws Exception; //전체 게시글 수
	public PostVO selectPostOne(int post_idx) throws Exception; //post_idx에 맞는 post 가져오기
	public List<AttachedFileVO> selectAttachedFile(int post_idx) throws Exception; //post_idx에 맞는 첨부파일 정보 가져오기
	public int selectPostView(int post_idx) throws Exception; //post_idx에 맞는 조회수 가져오기 
	public void updatePostView(int post_idx) throws Exception; // 조회수 + 1 
	
	
}
