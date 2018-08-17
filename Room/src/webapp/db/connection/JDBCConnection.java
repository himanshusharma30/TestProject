package webapp.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCConnection {

	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		/*Connection con = DriverManager.getConnection("jdbc:mysql://162.144.117.2:3306/abroadma_test","abroadma_dev","developer@am");//rb.getString("password"));
*/		
		Connection con=DriverManager.getConnection("jdbc:mysql:///abroadma_test","root","1234");
		return con;
	}

	public static void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(ps != null) {
			ps.close();
		}
		if(con != null) {
			con.close();
		}	
	}

}