package com.stu.dao;

import java.util.List;

import com.stu.entity.Manage;

public interface VManageDao<T> {
	List<T> list();
	Manage login2(Manage m);
}
