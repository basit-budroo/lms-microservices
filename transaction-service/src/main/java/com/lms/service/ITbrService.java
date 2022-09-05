package com.lms.service;

import java.util.List;

import com.lms.bean.Tbr;

public interface ITbrService {
	List<Tbr> findAllTbr(); 
	void deleteByid(int tbrid);
	Tbr addEntry(Tbr tbr,double fine);
}
