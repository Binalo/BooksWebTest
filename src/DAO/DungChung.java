package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DungChung {
	public static Connection cn;

	public void KetNoi() {
		try {
			// nap database
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("da xac nhan");
			// ket noi voi csld
			cn = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-PIKNVLI:1433;databaseName=QlSach;username=sa;password=123");
			System.out.println("da xac nhan csdl");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}