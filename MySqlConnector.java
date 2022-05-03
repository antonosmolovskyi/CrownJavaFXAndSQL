package classwork16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classwork14.Pudge;

public class MySqlConnector {
	
	public static final String SELECT_RANKS = "SELECT * FROM ranks";
	
	
	public Connection getMySqlConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/itea?" +  "user=root&password=");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public Ranks getRanks(int id, Connection conn) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Statement st = conn.createStatement();
		ResultSet rs =  st.executeQuery(String.format(SELECT_RANKS) );
		while(rs.next()) {
			System.out.println(rs.getInt("id")+ " name: " +  rs.getString("name") + " steps: " + rs.getInt("steps"));
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
