package com.stu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stu.dao.BaseDao;

import com.stu.dao.VManageDao;
import com.stu.entity.Manage;
	public class VManageDaoImpl extends BaseDao implements VManageDao {
		@Override
		public List<Manage> list() {
			// TODO Auto-generated method stub
			List<Manage> list = new ArrayList<Manage>();
			String sql = "select * from Manage";
			Object[] params = null;
			ResultSet rs = this.executeQuery(sql, params);
			try {
				while (rs.next()) {
					Manage s = new Manage(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
					list.add(s);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeAll(rs, null, null);
			}
			return list;
		}

		@Override
		public Manage login2(Manage m) {
			// TODO Auto-generated method stub
			Manage manage = null;
			String sql = "select * from manage where manageId= ? and managePassword = ? and manageAuthority='π‹¿Ì‘±'";
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
