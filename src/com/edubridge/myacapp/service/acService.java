package com.edubridge.myacapp.service;

import java.util.List;

import com.edubridge.myacapp.model.ac;
public interface acService {

	

	int addac(ac c);

	List<ac> findac();

	ac findacByName(String name);

	int updateac(ac c);

	int deleteacByName(String name);

	void deleteAllacs();
	
	
	

		
		
		

	}



