package com.bru.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bru.model.TestBean;
import com.bru.util.ConnectDB;


@Repository
public class TestDao {

	
	//del
	public TestBean amnuay(TestBean bean) throws SQLException {

		ConnectDB con = new ConnectDB();
		PreparedStatement pre = null;
		StringBuilder sql = new StringBuilder();
		
		try {
			sql.append(" SELECT * FROM test WHERE id = ? ");
			pre = con.openConnect().prepareStatement(sql.toString());
		
			pre.setInt(1, bean.getId());
			ResultSet rs = pre.executeQuery();
			
			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return bean;
	}
	
	//insert
	public void insert(TestBean bean) {
		ConnectDB con = new ConnectDB();
		PreparedStatement pre = null;
		StringBuilder sql = new StringBuilder();
		
		try {
			sql.append("INSERT INTO test (email, password) VALUES (?,?)");
			pre = con.openConnect().prepareStatement(sql.toString());
			pre.setString(1, bean.getEmail());
			pre.setString(2, bean.getPassword());
			pre.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// update
		public void update(TestBean bean) {
			ConnectDB con = new ConnectDB();
			PreparedStatement pre = null;
			StringBuilder sql = new StringBuilder();
			try {
				sql.append(" UPDATE test SET  email = ? , password = ? WHERE id = ? ");
				pre = con.openConnect().prepareStatement(sql.toString());
				pre.setString(1, bean.getEmail());
				pre.setString(2, bean.getPassword());
				pre.setInt(3, bean.getId());
				pre.executeUpdate();
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}// end method update
		
		public void delete(int id) {
			ConnectDB con = new ConnectDB();
			PreparedStatement pre = null;
			StringBuilder sql = new StringBuilder();
			try {
				sql.append(" DELETE FROM test WHERE id = ? ");
				pre = con.openConnect().prepareStatement(sql.toString());
				pre.setInt(1, id);
				pre.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	public List<TestBean> findAll(){
		List<TestBean> list = new ArrayList<>();
		ConnectDB con = new ConnectDB();
		PreparedStatement pre = null;
		StringBuilder sql = new StringBuilder();
		
		try {
			sql.append(" SELECT * FROM test ");
			pre = con.openConnect().prepareStatement(sql.toString());
			
			ResultSet rs = pre.executeQuery();
			
			while (rs.next()) {
				TestBean bean = new TestBean();
				bean.setId(rs.getInt("id"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				
				list.add(bean);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	//end
}
