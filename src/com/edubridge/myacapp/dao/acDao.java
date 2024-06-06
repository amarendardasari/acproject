package com.edubridge.myacapp.dao;
import java.util.List;

import com.edubridge.myacapp.model.ac;


public interface acDao {
	

		int addac(ac a);
		List<ac>findac();
		ac findacByName(String name);
		int updateac(ac a);
		int deleteacByName(String name);
		void deleteAllacs();
	
		

	}



