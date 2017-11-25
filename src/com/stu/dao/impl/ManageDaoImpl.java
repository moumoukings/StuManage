package com.stu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stu.dao.BaseDao;
import com.stu.dao.GenericDao;
import com.stu.entity.Manage;

public class ManageDaoImpl extends BaseDao implements GenericDao<Manage>{

	@Override
	public List<Manage> list() {
		// TODO Auto-generated method stub
		List<Manage>list=new ArrayList<Manage>();
		String sql="select * from manage where manageAuthority=?";
		Object[] params={"教师"};
		ResultSet rs = this.executeQuery(sql, params);
		try {
			while(rs.next()){
				Manage t = new Manage(rs.getString(1), rs.getString(2),rs.getString(3));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, null, null);
		}
		return list;
	}

	@Override
	public int add(Manage t) {
		// TODO 自动生成的方法存根
		String sql="insert into manage(manageId,managePassword,manageName,manageAuthority) values(?,?,?,?)";
		Object[] params={t.getmanageId(),t.getmanagePassword(),t.getmanageName(),t.getmanageAuthority()};
		BaseDao upd=new BaseDao();
		return (upd.executeUpdate(sql, params));
	}

	@Override
	public int delete(String id) {
		// TODO 自动生成的方法存根
		String sql="DELETE FROM manage WHERE manageId=?";
		Object[] params={id};
		BaseDao del=new BaseDao();
		del.executeUpdate(sql, params);
		return 0;
	}

	@Override
	public int modify(Manage t) {
		// TODO 自动生成的方法存根
		String sql="update manage set manageName=?,managePassword=? WHERE manageId=?";
		Object[] params={t.getmanageName(),t.getmanagePassword(),t.getmanageId()};
		BaseDao upd=new BaseDao();
		upd.executeUpdate(sql, params);
		return 0;
	}

	@Override
	public Manage get(String i) {
		// TODO 自动生成的方法存根
		return null;
	}

	
	public List<Manage> findid(String tid) {
		// TODO Auto-generated method stub
		List<Manage>list=new ArrayList<Manage>();
		String sql="select * from manage where manageId=?";
		Object[] params={tid};
		ResultSet rs = this.executeQuery(sql, params);
		try {
			while(rs.next()){
				Manage t = new Manage(rs.getString(1), rs.getString(2),rs.getString(3));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, null, null);
		}
		return list;
	}

	public List<Manage> findname(String tname) {
		// TODO Auto-generated method stub
		List<Manage>list=new ArrayList<Manage>();
		String sql="select * from manage where manageName=?";
		Object[] params={tname};
		ResultSet rs = this.executeQuery(sql, params);
		try {
			while(rs.next()){
				Manage t = new Manage(rs.getString(1), rs.getString(2),rs.getString(3));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(rs, null, null);
		}
		return list;
	}
	
	public Manage login1(Manage m) {
		// TODO Auto-generated method stub
		Manage manage = null;
		String sql = "select * from manage where manageId= ? and managePassword = ? and manageAuthority='教师'";
		Object[] params = { m.getmanageId(), m.getmanagePassword() };
		ResultSet rs = this.executeQuery(sql, params);
		try {
			if (rs.next()) {
				manage = new Manage(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, null, null);
		}
		return manage;
	}
}
