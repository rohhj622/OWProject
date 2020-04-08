package com.prjct.hj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
	public List<PostVO> selectAllPost() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAllPost();
	}


}
