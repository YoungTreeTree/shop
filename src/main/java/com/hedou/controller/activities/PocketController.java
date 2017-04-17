package com.hedou.controller.activities;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


import com.hedou.controller.base.BaseController;
import com.hedou.json.BaseJson;
import com.hedou.services.activities.IPocketService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/pocketController")
public class PocketController extends BaseController {

    @Resource
    private IPocketService pocketService;

    private BaseJson queryJson = new BaseJson();

    @ResponseBody
    @RequestMapping(value = "/getPocketsHis", method = RequestMethod.POST)
    public BaseJson getPocketsHis() throws Exception {
        queryJson = new BaseJson();
        HttpSession session = getHttpRequest().getSession();
        String idStr = session.getAttribute("aaaa").toString();
        List result = pocketService.getPocketsHis(idStr);
        if (!result.isEmpty()) {
            queryJson.setObj(result);
            queryJson.setRetcode("0000");
        } else {
            queryJson.setRetcode("0001");
            queryJson.setErrorMsg("暂无钱包数据！");
        }

        return queryJson;
    }

}

