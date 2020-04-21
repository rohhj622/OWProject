package com.prjct.hj.persistence;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.prjct.hj.commons.pagination.Pagination;
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

//	@Override
//	public List<PostVO> selectAllPost(Pagination pagination) throws Exception {
//		// TODO Auto-generated method stub
//		return session.selectList(namespace+".selectAllPost",pagination);
//	}
	
	@Override
	public List<PostVO> selectAllPost(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectAllPost",pagination);
	}


	@Override
	public int selectPostCnt() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectPostCnt");
	}

	@Override
	public PostVO selectPostOne(int post_idx) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectPostOne",post_idx);
	}

	@Override
	public List<AttachedFileVO> selectAttachedFile(int post_idx) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectAttachedFile",post_idx);
	}

	@Override
	public int selectPostView(int post_idx) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectPostView",post_idx);
	}

	@Override
	public void updatePostView(int post_idx) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".updatePostView",post_idx);
	}

	@Override
	public int deletePost(int post_idx) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".deletePost",post_idx);
		return 1;
		
	}

	@Override
	public int updateAttachedFileIsDel(int post_idx) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".updateAttachedFileIsDel",post_idx);
		return 1;
		
	}

	@Override
	public List<PostVO> selectPostSido(Pagination pagination, PostVO post) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectPostSido",post);
	}

	@Override
	public List<PostVO> selectPostSidoTheme(Pagination pagination, PostVO post) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectPostSidoTheme",post);
	}

	@Override
	public List<PostVO> selectPostSidoGugun(Pagination pagination, PostVO post) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectPostSidoGugun",post);
	}

	@Override
	public List<PostVO> selectPostTheme(Pagination pagination, PostVO post) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectPostTheme",post);
	}
}

