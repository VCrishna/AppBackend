package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.model.Constants;
import com.model.DataStructures;


@Repository
public class ApplicationDAOImpl implements ApplicationDAO {
	
	@Autowired
	Environment env;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ApplicationDAOImpl.class);
	
	Connection conn = null;
	
	public Connection connect() {
        try {
        	
        	conn = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));
//            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "pass");
            LOGGER.info(conn!=null?"Connected to the PostgreSQL server successfully!!":"Failed to make connection!");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }

        return conn;
    }
	
	@Override
	public List<DataStructures> getDataStructures() {
		String query = Constants.getDataStructure;
		List<DataStructures> empList = new ArrayList<DataStructures>();
		Connection con = connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				DataStructures emp = new DataStructures();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				empList.add(emp);
			}
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				LOGGER.error(e.getMessage());
				e.printStackTrace();
			}
		}
		LOGGER.info("getDataStructures() DAO Successful!");
		return empList;
	}
	
}
