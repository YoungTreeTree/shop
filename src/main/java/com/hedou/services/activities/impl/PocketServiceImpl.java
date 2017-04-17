package com.hedou.services.activities.impl;

import java.util.Date;
import java.util.List;

import com.hedou.entity.User;
import org.springframework.stereotype.Service;


import com.hedou.services.activities.IPocketService;
import com.hedou.services.common.impl.CommServiceImpl;
import com.hedou.vo.PocketHisVo;

@Service(value = "pocketService")
public class PocketServiceImpl extends CommServiceImpl implements IPocketService{

	@Override
	public List getPocketsHis(String user_id) throws Exception {
		// TODO Auto-generated method stub
		String sql="select pocket_his.AFTER_COUNT as overage,(pocket_his.BEFORE_COUNT-pocket_his.AFTER_COUNT) as change_his,pocket_his.MODIFY_TIME as modify_time from pocket_his where pocket_his.USER_ID='"+user_id+"' order by MODIFY_TIME DESC";
		List result=baseDAO.findBySQLForVO(sql, PocketHisVo.class, null);
		return result;
	}



}