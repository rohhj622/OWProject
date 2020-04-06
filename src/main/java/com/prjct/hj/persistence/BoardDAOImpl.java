package com.prjct.hj.persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.prjct.hj.domain.PostVO;



@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace="com.prjct.hj.BoardMapper";
	
	@Override
	public void createPost(PostVO post) throws Exception {
		// TODO Auto-generated method stub

			session.insert(namespace+".createPost",post);
		}
}

