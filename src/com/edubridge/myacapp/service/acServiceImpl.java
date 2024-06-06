package com.edubridge.myacapp.service;

import java.util.List;




import com.edubridge.myacapp.dao.acDao;
import com.edubridge.myacapp.dao.acDaoImpl;
import com.edubridge.myacapp.model.ac;


public class acServiceImpl implements acService {

	 acDao dao = new acDaoImpl();
		
	
@Override
	public int addac(ac c) {
		
		return dao.addac(c);
	}
@Override
	public List<ac> findac() {
		
		return dao.findac();
	}

	@Override
	public ac findacByName(String name) {
		

		return dao.findacByName(name);
	}

	@Override
	public int updateac(ac c) {

		
		return dao.updateac(c);
	}

	@Override
	public int deleteacByName(String name) {
		
		return dao.deleteacByName(name);
	}

	public void deleteAllacs() {
		dao.deleteAllacs();
		
	}
}




	