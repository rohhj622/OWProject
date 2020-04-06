package com.hyunjin.auto.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hyunjin.auto.domain.MemberVO;
import com.hyunjin.auto.persistence.AddStudentDAO;

@Service
public class AddStudentServiceImpl implements AddStudentService{

	@Inject
	private AddStudentDAO dao;
	
	@Override
	public void addStudent(List<MemberVO> listMember) throws Exception {
		//System.out.println("service:"+listMember.get(0).getAddress());
		
		dao.addStudent(listMember);
		
	}

}
