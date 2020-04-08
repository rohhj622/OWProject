package com.prjct.hj.persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.prjct.hj.domain.AttachedFileVO;
import com.prjct.hj.domain.PostVO;



@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace="com.prjct.hj.BoardMapper";
	
	@Override
	public void insertPost(PostVO post) throws Exception {
		// TODO Auto-generated method stub

			session.insert(namespace+".insertPost",post);
		}

	@Override
	public int selectPostIdx(PostVO post) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectPostIdx",post);
	}

	@Override
	public void insertAttachedFile(AttachedFileVO af) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".insertAttachedFile",af);
	}

	@Override
	public int selectMaxPostIdx() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectMaxPostIdx");
	}

	@Override
	public List<PostVO> selectAllPost() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectAllPost");
	}
}

