package com.prjct.hj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.prjct.hj.commons.pagination.Pagination;
import com.prjct.hj.domain.AttachedFileVO;
import com.prjct.hj.domain.PostVO;
import com.prjct.hj.persistence.BoardDAO;


@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	@Override
	public void insertPost(PostVO post) throws Exception {	
		// TODO Auto-generated method stub
		dao.insertPost(post);		
	}

	@Override
	public int selectPostIdx(PostVO post) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPostIdx(post);
	}

	@Override
	public int selectMaxPostIdx() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectMaxPostIdx();
	}

	@Override
	public void insertAttachedFile(AttachedFileVO af) throws Exception {
		// TODO Auto-generated method stub
		dao.insertAttachedFile(af);
		
	}

	@Override
	public List<PostVO> selectAllPost(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAllPost(pagination);
	}

	@Override
	public int selectPostCnt() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPostCnt();
	}

	@Override
	public PostVO selectPostOne(int post_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPostOne(post_idx);
	}

	@Override
	public List<AttachedFileVO> selectAttachedFile(int post_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAttachedFile(post_idx);
	}

	@Override
	public int selectPostView(int post_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPostView(post_idx);
	}

	@Override
	public void updatePostView(int post_idx) throws Exception {
		// TODO Auto-generated method stub
		dao.updatePostView(post_idx);
	}

	@Override
	public int deletePost(int post_idx) throws Exception {
		// TODO Auto-generated method stub
		dao.deletePost(post_idx);
		return 1;
	}

	@Override
	public int updateAttachedFileIsDel(int post_idx) throws Exception {
		// TODO Auto-generated method stub
		dao.updateAttachedFileIsDel(post_idx);
		return 1;
	}

	@Override
	public List<PostVO> selectPostSido(Pagination pagination, PostVO post) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPostSido(pagination, post);
	}

	@Override
	public List<PostVO> selectPostSidoTheme(Pagination pagination, PostVO post) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPostSidoTheme(pagination, post);
	}

	@Override
	public List<PostVO> selectPostSidoGugun(Pagination pagination, PostVO post) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPostSidoGugun(pagination, post);
	}

	@Override
	public List<PostVO> selectPostTheme(Pagination pagination, PostVO post) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPostTheme(pagination, post);
	}


}
