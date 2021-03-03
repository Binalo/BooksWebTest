package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BEAN.KhachHangBean;

public class KhachHangDao {
	public static void InsertKH(String ht, String dc, String sdt, String email, String tendn, String pass) {
		String sql = "insert into KhachHang (hoten,diachi,SoDT,email,tendn,pass,quyen) values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, ht);
			cmd.setString(2, dc);
			cmd.setString(3, sdt);
			cmd.setString(4, email);
			cmd.setString(5, tendn);
			cmd.setString(6, pass);
			cmd.setBoolean(7, false);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean kttontai(String tendn) {
		String sql = "select * from KhachHang where tendn=?";
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			ResultSet rs = cmd.executeQuery();
			if (rs.next())
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean DangNhap(String tendn, String pass) {
		String sql = "select * from KhachHang where tendn=? and pass=?";

		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			if (rs.next())
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static long getSoluongKH() {
		String sql = "select Count(*) as sl from KhachHang where quyen=0";
		try {
			DungChung dc = new DungChung();
			dc.KetNoi();
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			long soluong = rs.getLong("sl");
			System.out.println(soluong + "..................................");
			return soluong;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static ArrayList<KhachHangBean> getDsKhachHang() {
		ArrayList<KhachHangBean> ds = new ArrayList<KhachHangBean>();
		String sql = "select * from KhachHang";
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				KhachHangBean tam = new KhachHangBean(rs.getString("makh"), rs.getString("hoten"),
						rs.getString("diachi"), rs.getString("sodt"), rs.getString("email"), rs.getString("tendn"),
						rs.getString("pass"), rs.getBoolean("quyen"));
				ds.add(tam);
			}
			return ds;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public static void XoaKhachHang(String makh) {
		//
		String sql1 = "delete from chitiethoadon where mahoadon in (Select mahoadon from hoadon where makh=?)";
		String sql2 = "delete from hoadon where makh=?";
		String sql = "delete from KhachHang where makh=?";
		try {
			PreparedStatement cmd1 = DungChung.cn.prepareStatement(sql1);
			cmd1.setString(1, makh);
			cmd1.executeUpdate();

			PreparedStatement cmd2 = DungChung.cn.prepareStatement(sql2);
			cmd2.setString(1, makh);
			cmd2.executeUpdate();

			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, makh);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
