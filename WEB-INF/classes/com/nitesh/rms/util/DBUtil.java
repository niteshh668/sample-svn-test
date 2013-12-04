package com.nitesh.rms.util;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author NiteshReddy
 *
 */
public class DBUtil {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public JdbcTemplate getJDBCTemplate()
	{
		return new JdbcTemplate(dataSource);
	}
}
