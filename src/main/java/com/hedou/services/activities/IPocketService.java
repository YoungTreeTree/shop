package com.hedou.services.activities;

import java.util.List;


import com.hedou.services.common.ICommService;

public interface IPocketService extends ICommService {
			
	public List getPocketsHis(String user_id) throws Exception;
	
}
