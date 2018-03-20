package org.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.model.Student;

public class CallDB {

	public Student getStatus() {

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Student m = null;
		try {
			conn = JDBCConnection.getConnection();
			String query = "select id, name, college from student where  STATUS='A'";

			pstmt = conn.prepareStatement(query); // create a statement

			rs = pstmt.executeQuery();

			// extract data from the ResultSet
			while (rs.next()) {
				m = new Student();
				String studId = rs.getString(1);
				String firstName = rs.getString(2);
				String clg = rs.getString(3);

				m.setStudId(studId);
				m.setName(firstName);
				m.setCollege(clg);

				System.out.println(studId + "\t" + firstName + "\t" + clg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}

}
