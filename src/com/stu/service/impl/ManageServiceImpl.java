package com.stu.service.impl;

import java.util.List;

import com.stu.dao.GenericDao;
import com.stu.dao.impl.ManageDaoImpl;
import com.stu.entity.Manage;
import com.stu.service.GenericService;

public class ManageServiceImpl implements GenericService<Manage> {
	GenericDao<Manage> gdao=new ManageDaoImpl();
	ManageDaoImpl tdao=new ManageDaoImpl();
	@Override
	public List<Manage> list() {
		// CourseODO Auto-generated method stub
		return this.gdao.list();
	}

	@Override
	public int add(Manage t) {
		// CourseODO Auto-generated method stub
		return this.gdao.add(t);
	}

	@Override
	public int delete(String id) {
		// CourseODO Auto-generated method stub
		return this.gdao.delete(id);
	}

	@Override
	public int modify(Manage t) {
		// CourseODO Auto-generated method stub
		return this.gdao.modify(t);
	}

	@Override
	public Manage get(String i) {
		// CourseODO Auto-generated method stub
		return this.get(i);
	}


	public List<Manage> findname(String tname) {
		// TODO 自动生成的方法存根
		return this.tdao.findname(tname);
	}


	public List<Manage> findid(String tid) {
		// TODO 自动生成的方法存根
		return this.tdao.findid(tid);
	}



}
