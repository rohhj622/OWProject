package com.hyunjin.auto.service;

import java.util.List;

import com.hyunjin.auto.domain.MemberVO;

public interface AddStudentService {
	public void addStudent(List<MemberVO> listMember) throws Exception; //학생 추가
}
