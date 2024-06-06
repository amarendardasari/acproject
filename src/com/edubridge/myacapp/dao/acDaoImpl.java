package com.edubridge.myacapp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.myacapp.dao.acDao;
import com.edubridge.myacapp.model.DButils;
import com.edubridge.myacapp.model.ac;


public class acDaoImpl implements acDao{


	
	static Connection con =DButils.getConnection();
	
	@Override
	public int addac(ac c) {
		String INSERT_QUERY = "insert into ac(ac_id,ac_name,ac_cost,ac_dop,ac_colour) values(?,?,?,?,?)";
		int status = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			
			ps.setInt(1, c.getId());
			ps.setString(2,c.getName());
			ps.setFloat(3, c.getCost());
			ps.setString(4,c.getDop());
			ps.setString(5,c.getColour());
			status = ps.executeUpdate();
			
			
		} catch (SQLException e) {
		
			
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public List<ac> findac() {
		
		String SELECT_QUERY = "select * from ac";
		List<ac>acList = new ArrayList<>();
		
		 
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ac c = new ac();
				c.setId(rs.getInt("ac_id"));
				c.setName(rs.getString("ac_name"));
				c.setCost(rs.getFloat("ac_cost"));
				c.setDop(rs.getString("ac_dop"));
				c.setColour(rs.getString("ac_colour"));
				
				acList.add(c);
				
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return  acList;
	}

	@Override
	public ac findacByName(String name) {
		
		ac c= null;
		
		String SELECT_QUERY = "select * from ac where ac_name =?";
		try {
			PreparedStatement ps =con.prepareStatement(SELECT_QUERY);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				c = new ac();
				c.setId(rs.getInt("ac_id"));
				c.setName(rs.getString("ac_name"));
				c.setCost(rs.getFloat("ac_cost"));
				c.setDop(rs.getString("ac_dop"));
				c.setColour(rs.getString("ac_colour"));
	
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public int updateac(ac c) {
		
		String UPDATE_QUERY="update ac set ac_name =?,ac_cost=?,ac_dop=?,ac_colour = ? where ac_id =?";
int status = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
			
			ps.setString(1,c.getName());
			ps.setFloat(2,c.getCost());
			ps.setString(3,c.getDop());
			ps.setString(4,c.getColour());
			ps.setInt(5,c.getId());

			status = ps.executeUpdate();
			
			
		} catch (SQLException e) {
		
			
			e.printStackTrace();
		}
		
		return status;
	}

		
		

	@Override
	public int deleteacByName(String name) {
		
		String DELETE_QUERY ="delete from ac where ac_name =?";
		int status =0;
		try {
			PreparedStatement ps =con.prepareStatement(DELETE_QUERY);
			
			ps.setString(1,name);
			status = ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public void deleteAllacs() {
		String DELETE_QUERY ="delete from ac";
		try {
			PreparedStatement ps =con.prepareStatement(DELETE_QUERY);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
}