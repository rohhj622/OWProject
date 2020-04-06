package com.prjct.hj.persistence;

import java.util.List;

import com.prjct.hj.domain.PostVO;

public interface BoardDAO{
	public void createPost(PostVO post) throws Exception;
}
