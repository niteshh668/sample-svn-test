package com.nitesh.rms.login.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.nitesh.rms.bean.GenericDTO;
import com.nitesh.rms.bean.LoginDTO;
import com.nitesh.rms.bean.RegistrationDTO;
import com.nitesh.rms.spring.mapper.UserInfoMapper;
import com.nitesh.rms.util.DBUtil;

public class LoginDAOImpl implements LoginDAO{

	private DBUtil dbUtil;
	
	public DBUtil getDbUtil() {
		return dbUtil;
	}
	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}
		
	public GenericDTO registerUser(GenericDTO dto) {
		RegistrationDTO rdto = (RegistrationDTO)dto;
		Connection conn = null;
		Statement stmt = null;
		try{
			/*conn = dbUtil.getJDBCTemplate().getDataSource().getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();*/
			StringBuilder query= new StringBuilder();
			query.append("insert into user_info(user_name,password,email_id")
							.append(",phone,address) values(?,?,?,?,?)");/*
							.append(rdto.getFirstname()).append("','")
							.append(rdto.getPassword()).append("','").append(rdto.getEmail())
							.append("','").append(rdto.getPhonenumber())
							.append("','").append(rdto.getAddress()).append("')");*/
			dbUtil.getJDBCTemplate().update(query.toString(),rdto.getFirstname(),
														rdto.getPassword(),rdto.getEmail(),
																	rdto.getPhonenumber(),rdto.getAddress());
			
			
			
			/*stmt.executeUpdate(query.toString());
			conn.commit();*/
		}catch(Exception e){
			e.printStackTrace();
			/*try {
				conn.rollback();
			} catch (SQLException e1) {
				rdto.setErrorMsg("Error while connecting to database, Please contact admin");
				e1.printStackTrace();
			}*/
		
		}
		finally{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		
		return rdto;
	}
	
	
	public GenericDTO authenticate(GenericDTO dto) {
		LoginDTO ldto = (LoginDTO) dto;
		System.out.println("dto details"+ldto.getPassword()+" - "+ldto.getUsername()+"--"+ldto.getSuccessMsg()+"--"+ldto.getErrorMsg());
		Connection conn= null;
		Statement stmt=null;
		ResultSet rs = null;
		try{
			conn=dbUtil.getJDBCTemplate().getDataSource().getConnection();
			stmt=conn.createStatement();
			rs = stmt.executeQuery("select password from user_info where email_id='"+ldto.getUsername()+"'");
			if(rs.next()){
				if(ldto.getPassword() != null && ldto.getPassword().equals(rs.getString("password"))){
					ldto.setSuccessMsg("User Successfully Logged-in");
				}else{
					ldto.setErrorMsg("Invalid UserName/Password.");
				}
			}else{
				ldto.setErrorMsg("Invalid UserName/Password.");
			}
		}catch(SQLException e){
			e.printStackTrace();
			ldto.setErrorMsg("Error while processing the request. Please contact admin.");
		}
		finally{
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		return ldto;
	}
	
	public GenericDTO retrieveUserDetails(GenericDTO dto) {
		try{
		List<RegistrationDTO> userDetails = dbUtil.getJDBCTemplate().query("select user_name, password,email_id,phone,address from user_info",new UserInfoMapper());
		dto.setGenericList(userDetails);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dto;
	}
	
	

}
