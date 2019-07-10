package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Scenic;

public interface ScenicDao {

	//���羰������Ҵ˷����µľ�������
		public int getCountByStid(int stid);
		//���羰������Ҵ˷����µķ羰����,�ӵ�start����ʼ
		public List<Scenic> scenicListByStid(int stid,int start);

		//ͳ������ģ����ѯ����
		public int getCountByLike(String like,int stid);
		//��ѯ����ģ����ѯ�ķ羰����
		public List<Scenic> scenicListByLike(String like,int stid,int start);
}
