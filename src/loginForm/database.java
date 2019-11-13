package loginForm;

import java.sql.*;

public class database {
	Connection con;
	PreparedStatement pst, sign;
	ResultSet rs;

	database() {
		try {

			// MAKE SURE YOU KEEP THE mysql_connector.jar file in java/lib folder
			// ALSO SET THE CLASSPATH
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSCELOGIN", "root", "banyaboy");
			pst = con.prepareStatement("select * from LoginRecords where emailid=? and password=?");
			sign = con.prepareStatement("insert into LoginRecords(emailid,password) values(?,?)");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void fillData(String email, String pwd) {
		try {

//    		sign.setInt(1,id);
			sign.setString(1, email); // this replaces the 1st "?" in the query for username
			sign.setString(2, pwd);

			// this replaces the 2st "?" in the query for password
			// executes the prepared statement
			sign.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error while validating " + e);
		}
	}

	// ip:username,password
	// return boolean
	public Boolean checkLogin(String uname, String pwd) {
		try {

			pst.setString(1, uname); // this replaces the 1st "?" in the query for username
			pst.setString(2, pwd); // this replaces the 2st "?" in the query for password
			// executes the prepared statement
			rs = pst.executeQuery();
			if (rs.next()) {
				// TRUE iff the query founds any corresponding data
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error while validating" + e);
			return false;
		}
	}
}