package com.prjct.hj.persistence;

import java.util.List;

import com.prjct.hj.commons.pagination.Pagination;
import com.prjct.hj.domain.AttachedFileVO;
import com.prjct.hj.domain.PostVO;

public interface BoardDAO{
	public void insertPost(PostVO post) throws Exception;
	public int selectPostIdx(PostVO post)throws Exception;
	public void insertAttachedFile(AttachedFileVO af)throws Exception;
	public int selectMaxPostIdx() throws Exception;
	public List<PostVO> selectAllPost(Pagination pagination) throws Exception;
	public int selectPostCnt() throws Exception;
	public PostVO selectPostOne(int post_idx) throws Exception;
	public List<AttachedFileVO> selectAttachedFile(int post_idx) throws Exception;
	public int selectPostView(int post_idx) throws Exception;
	public void updatePostView(int post_idx) throws Exception;
	
	
}
