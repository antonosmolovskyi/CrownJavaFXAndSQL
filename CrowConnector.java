package classwork16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classwork14.Pudge;

public class CrowConnector {
	
	public static final String SELECT_RANK = "SELECT * FROM ranks";
	public static final String INSERT_RANK = "INSERT INTO ranks (name, steps) VALUES ('%s', %d)";
	
	public Connection getMySqlConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/thesis?" +  "user=root&password=");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public void addCrow(String name, int steps) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = getMySqlConnection();
		Statement st = conn.createStatement();
		st.execute(String.format(INSERT_RANK, name, steps));
		if(st != null) {
			st.close();
		}
		conn.close();
	}
	
	public Ranks getRank() throws SQLException {
		Connection conn = getMySqlConnection();
		Statement st = conn.createStatement();
		ResultSet rs =  st.executeQuery(String.format(SELECT_RANK) );
		while(rs.next()) {
			System.out.println(rs.getInt("id")+ " name: " +  rs.getString("name") + " steps=" + rs.getString("steps"));
			return new Ranks(rs.getInt("id"), rs.getString("name"), rs.getInt("steps"));
		}
		if(st != null) {
			st.close();
		}
		rs.close();
		conn.close();
		return null;
	}
}
