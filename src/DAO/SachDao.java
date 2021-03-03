package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BEAN.SachBean;

public class SachDao {
	public static ArrayList<SachBean> getSach() {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select * from sach";
		ArrayList<SachBean> ds = new ArrayList<SachBean>();
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				SachBean tam = new SachBean();
				tam.setMasach(rs.getString("masach"));
				tam.setTensach(rs.getString("tensach"));
				tam.setTacgia(rs.getString("tacgia"));
				tam.setSoluong(rs.getLong("soluong"));
				tam.setGia(rs.getLong("gia"));
				tam.setAnh(rs.getString("anh"));
				tam.setMaloai(rs.getString("maloai"));
				tam.setMota(rs.getString("mota"));
				ds.add(tam);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public static ArrayList<SachBean> getSachTheoTen(String ten) {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select * from sach where tensach like ?";
		ArrayList<SachBean> ds = new ArrayList<SachBean>();
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, "%" + ten + "%");
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				SachBean tam = new SachBean();
				tam.setMasach(rs.getString("masach"));
				tam.setTensach(rs.getString("tensach"));
				tam.setTacgia(rs.getString("tacgia"));
				tam.setSoluong(rs.getLong("soluong"));
				tam.setGia(rs.getLong("gia"));
				tam.setAnh(rs.getString("anh"));
				tam.setMaloai(rs.getString("maloai"));
				tam.setMota(rs.getString("mota"));
				ds.add(tam);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;

	}

	public static boolean checkMaSach(String ma) {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select * from sach where masach = ?";
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, ma);
			ResultSet rs = cmd.executeQuery();
			if (rs.next())
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public static int themSach(String masach, String tensach, String tacgia, Long soluong, Long gia, String anh,
			String maloai, String mota) {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "INSERT INTO sach (masach, tensach, tacgia, soluong, gia, anh, maloai, mota) VALUES ( ? , ? , ? , ? ,?,?,?,? );";

		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			cmd.setString(2, tensach);
			cmd.setString(3, tacgia);
			cmd.setLong(4, soluong);
			cmd.setLong(5, gia);
			cmd.setString(6, anh);
			cmd.setString(7, maloai);
			cmd.setString(8, mota);
			return cmd.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public static int suaSach(String masach, String tensach, String tacgia, Long soluong, Long gia, String anh,
			String maloai, String mota) {
		DungChung dc = new DungChung();
		System.out.println("ms=" + masach + ";tensach=" + tensach + ";tacgia=" + tacgia + ";soluong=" + soluong
				+ ";gia=" + gia + ";anh=" + anh + ";maloai=" + maloai + ";mota=" + mota);
		dc.KetNoi();
		String sql = "update sach set tensach = ? , tacgia=?, soluong=?, gia=?, anh=?,maloai=?,mota=? where masach = ?";
		if (anh == "" || anh == null) {
			sql = "update sach set tensach = ? , tacgia=?, soluong=?, gia=?, anh= ?, maloai=?, mota=? where masach = ?";
			try {
				PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
				cmd.setString(8, masach);
				cmd.setString(1, tensach);
				cmd.setString(2, tacgia);
				cmd.setLong(3, soluong);
				cmd.setLong(4, gia);
				cmd.setLong(5, gia);
				cmd.setString(6, maloai);
				cmd.setString(7, mota);
				return cmd.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
				cmd.setString(8, masach);
				cmd.setString(1, tensach);
				cmd.setString(2, tacgia);
				cmd.setLong(3, soluong);
				cmd.setLong(4, gia);
				cmd.setString(5, anh);
				cmd.setString(6, maloai);
				cmd.setString(7, mota);
				return cmd.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;

	}

	public static int xoaSach(String masach) {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "delete from sach where masach = ?";
		System.out.println(sql + masach);
		System.out.println(masach);
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			return cmd.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public static SachBean getSachTheoMa(String ma) {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select * from sach where masach = ?";
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, ma);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				SachBean tam = new SachBean();
				tam.setMasach(rs.getString("masach"));
				tam.setTensach(rs.getString("tensach"));
				tam.setTacgia(rs.getString("tacgia"));
				tam.setSoluong(rs.getLong("soluong"));
				tam.setGia(rs.getLong("gia"));
				tam.setAnh(rs.getString("anh"));
				tam.setMaloai(rs.getString("maloai"));
				tam.setMota(rs.getString("mota"));
				return tam;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
