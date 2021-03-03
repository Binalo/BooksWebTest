package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BEAN.SachBean;
import BEAN.loaiBean;

public class LoaiDAO {
	public static ArrayList<SachBean> getDsLoai(String loai) {
		ArrayList<SachBean> ds = new ArrayList<SachBean>();
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select * from sach where maloai=?";
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, loai);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				SachBean tam = new SachBean();
				tam.setMasach(rs.getString("masach"));
				tam.setTensach(rs.getString("tensach"));
				tam.setTacgia(rs.getString("tacgia"));
				tam.setSoluong(rs.getLong("soluong"));
				tam.setGia(rs.getLong("gia"));
				tam.setAnh(rs.getString("anh"));
				tam.setMaloai(loai);
				ds.add(tam);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ds;
	}

	public static ArrayList<loaiBean> getLoai() {
		DungChung dc = new DungChung();
		dc.KetNoi();
		ArrayList<loaiBean> dsloai = new ArrayList<loaiBean>();
		String sql = "select * from loai";
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				loaiBean tam = new loaiBean();
				String maloai = rs.getString("maloai");
				String tenloai = rs.getString("tenloai");
				tam.setMaloai(maloai);
				tam.setTenloai(tenloai);
				dsloai.add(tam);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsloai;
	}

	public boolean ktMaLoai(String maloai) throws Exception {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select loai from loai where maloai = ?";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery();
		boolean kq = rs.next();
		dc.cn.close();
		return kq;
	}

	public loaiBean TimMaloai(String maloai) throws Exception {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select * from loai where maloai = ?";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery();
		loaiBean tam = new loaiBean();
		String ml = rs.getString("maloai");
		String tenloai = rs.getString("tenloai");
		tam.setMaloai(ml);
		tam.setTenloai(tenloai);

		return tam;
	}

	public int Xoa(String maloai) throws Exception {
		String sql = "delete from loai where maloai = ?";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		int rs = cmd.executeUpdate();
		return rs;
	}

	public int Them(String maloai, String tenloai) throws Exception {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "insert into loai values( ? , ? )";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		cmd.setString(2, tenloai);
		int rs = cmd.executeUpdate();
		dc.cn.close();
		return rs;
	}

	public int Sua(String maloai, String tenloai) throws Exception {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "update  loai set tenloai = ? where maloai = ?";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(2, maloai);
		cmd.setString(1, tenloai);
		int rs = cmd.executeUpdate();
		dc.cn.close();
		return rs;
	}

	public static loaiBean getTheoMaLoai(String ma) {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select * from loai where maloai = ?";
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, ma);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				loaiBean tam = new loaiBean();
				tam.setMaloai(rs.getString("maloai"));
				tam.setTenloai(rs.getString("tenloai"));

				return tam;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
