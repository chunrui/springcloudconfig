package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.ScenicType;



public interface ScenicTypeDao {
	       //��ѯ���з羰����
			public List<ScenicType> findScenictype();
			
			//����ftid��Ų�����ʳ��������
			public String  gettypebyid(int stid);
}
