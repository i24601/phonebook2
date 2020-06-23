package com.javaex.dao;

import java.util.List;

import com.javaex.vo.PersonVo;

public class PhoneTest {

	public static void main(String[] args) {
		PhoneDao pDao = new PhoneDao();
		
		List<PersonVo> pList = pDao.getPersonList();
		System.out.println(pList.toString());
		
	}

}
