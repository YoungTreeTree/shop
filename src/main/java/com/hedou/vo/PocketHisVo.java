package com.hedou.vo;

import java.sql.Timestamp;

public class PocketHisVo{

	// Fields

	private Double overage;
	private Double change_his;
	private Timestamp modify_time;

	public Double getOverage() {
		return this.overage;
	}

	public void setOverage(Double overage) {
		this.overage = overage;
	}
	
	public Double getChange_his() {
		return this.change_his;
	}

	public void setChange_his(Double change_his) {
		this.change_his = change_his;
	}

	public Timestamp getModify_time() {
		return this.modify_time;
	}

	public void setModify_time(Timestamp modify_time) {
		this.modify_time = modify_time;
	}


}