package com.hedou.controller.user;

import com.hedou.controller.base.BaseController;
import com.hedou.controller.common.Email;
import com.hedou.entity.ForgetPasswordInfo;
import com.hedou.entity.User;
import com.hedou.entity.UserRegisterTemp;
import com.hedou.json.BaseJson;
import com.hedou.services.user.IAccountService;
import com.hedou.services.user.IUserService;
import com.hedou.vo.CourseVo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by a3578 on 2017/4/22.
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseController {
    @Resource
    private IAccountService accountService;

    private BaseJson queryJson = new BaseJson();

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseJson login() throws Exception {
        queryJson = new BaseJson();
        queryJson.setErrno(1);
        String email = getHttpRequest().getParameter("u_email_address");
        String password = getHttpRequest().getParameter("u_password");
        if (email == null || password == null) {
            queryJson.setErrmsg("invalid parameter");
            return queryJson;
        }
        User user = accountService.getUserByEmail(email);
        if (user != null) {
            if (password.equals(user.getUPassword())) {
                setUserSession(user.getUId());
                queryJson.setErrno(0);
                queryJson.setErrmsg("success");
            } else {
                queryJson.setErrmsg("password wrong");
            }
        } else {
            queryJson.setErrmsg("no email");
        }
        return queryJson;
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BaseJson register() throws Exception {
        queryJson = new BaseJson();
        queryJson.setErrno(1);
        String name = getHttpRequest().getParameter("u_name");
        String password = getHttpRequest().getParameter("u_password");
        String email_address = getHttpRequest().getParameter("u_email");
        if (email_address == null || password == null || name == null) {
            queryJson.setErrmsg("invalid parameter");
            return queryJson;
        }
        int verify_code = getRandomCode();//产生1000-9999的随机数
        long u_temp_id = accountService.addUserRegisterTemp(name, password, email_address, verify_code);
        if (u_temp_id > 0) {
            try {
                Email email = new Email();
                email.send(email_address, "<h2>禾斗创课验证码：" + verify_code + "</h2>", "禾斗创课注册验证码");
                queryJson.setErrno(0);
                queryJson.setErrmsg("success");
                queryJson.setObj(u_temp_id);
            } catch (Exception ex) {
                queryJson.setErrmsg("send email error");
            }
        } else {
            switch ((int) (u_temp_id)) {
                case -1:
                    queryJson.setErrmsg("account exits");
                    break;
                case -2:
                    queryJson.setErrmsg("unknown error");
                    break;
            }
        }
        return queryJson;
    }

    @ResponseBody
    @RequestMapping(value = "/register/verify", method = RequestMethod.POST)
    public BaseJson registerVerify() throws Exception {
        queryJson = new BaseJson();
        queryJson.setErrno(1);
        Long temp_id = Long.parseLong(getHttpRequest().getParameter("u_temp_id"));
        String verify_code = getHttpRequest().getParameter("u_verify_code");
        if (temp_id == null || verify_code == null) {
            queryJson.setErrmsg("invalid parameter");
            return queryJson;
        }
        UserRegisterTemp temp_user = accountService.getUserRegisterTemp(temp_id);
        if (temp_user != null) {
            if (verify_code.equals(temp_user.getUVerifyCode().toString())) {
                long u_id = accountService.register(temp_id);
                if (u_id > 0) {
                    queryJson.setErrno(0);
                    queryJson.setErrmsg("success");
                } else {
                    queryJson.setErrmsg("unknown error");
                }
            } else {
                queryJson.setErrmsg("verify code wrong");
            }
        } else {
            queryJson.setErrmsg("Invalid u_temp_id");
        }
        return queryJson;
    }

    @ResponseBody
    @RequestMapping(value = "/register/resend", method = RequestMethod.POST)
    public BaseJson registerResend() throws Exception {
        queryJson = new BaseJson();
        queryJson.setErrno(1);
        Long temp_id = Long.parseLong(getHttpRequest().getParameter("u_temp_id"));
        if (temp_id == null) {
            queryJson.setErrmsg("invalid parameter");
            return queryJson;
        }
        int verify_code = getRandomCode();//产生1000-9999的随机数
        String email_address = accountService.updateUserRegisterTemp(temp_id, verify_code);
        if (email_address != null) {
            Email email = new Email();
            email.send(email_address, "<h2>禾斗创课验证码：" + verify_code + "</h2>", "禾斗创课注册验证码");
            queryJson.setErrno(0);
            queryJson.setErrmsg("resend success");
        } else {
            queryJson.setErrmsg("unknown error");
        }
        return queryJson;
    }

    @ResponseBody
    @RequestMapping(value = "/forget_password", method = RequestMethod.POST)
    public BaseJson forgetPassword() throws Exception {
        queryJson = new BaseJson();
        queryJson.setErrno(1);
        String email_address = getHttpRequest().getParameter("u_email_address");
        if (email_address == null) {
            queryJson.setErrmsg("invalid parameter");
            return queryJson;
        }
        User user = accountService.getUserByEmail(email_address);
        if (user == null) {
            queryJson.setErrmsg("email address not exits");
            return queryJson;
        }
        String verify_code = Integer.toString(getRandomCode());
        long fp_id = accountService.addForgetPasswordInfo(email_address, verify_code);
        if (fp_id > 0) {
            queryJson.setErrmsg("success");
            queryJson.setObj(fp_id);
            Email email = new Email();
            email.send(email_address, "<h2>禾斗创课验证码：" + verify_code + "</h2>", "禾斗创课忘记密码验证码");
        } else {
            queryJson.setErrmsg("unknown error");
        }
        return queryJson;
    }

    @ResponseBody
    @RequestMapping(value = "/forget_password/verify", method = RequestMethod.POST)
    public BaseJson forgetPasswordVerify() throws Exception {
        queryJson = new BaseJson();
        queryJson.setErrno(1);
        Long fp_id = Long.parseLong(getHttpRequest().getParameter("fp_id"));
        String verify_code = getHttpRequest().getParameter("verify_code");
        if (fp_id == null || verify_code == null) {
            queryJson.setErrmsg("invalid parameter");
            return queryJson;
        }
        ForgetPasswordInfo forgetPasswordInfo = accountService.getForgetPasswordInfo(fp_id);
        if (forgetPasswordInfo != null) {
            if (verify_code.equals(forgetPasswordInfo.getFpVerifyCode())) {
                setSessionAttribute("forget_password_is_verified", true);
                queryJson.setErrno(0);
                queryJson.setErrmsg("success");
            } else {
                queryJson.setErrmsg("wrong verify code");
            }
        } else {
            queryJson.setErrmsg("fp_id not exits");
        }
        return queryJson;
    }

    @ResponseBody
    @RequestMapping(value = "/forget_password/resend", method = RequestMethod.POST)
    public BaseJson forgetPasswordResend() throws Exception {
        queryJson = new BaseJson();
        queryJson.setErrno(1);
        Long fp_id = Long.parseLong(getHttpRequest().getParameter("fp_id"));
        if (fp_id == null) {
            queryJson.setErrmsg("invalid parameter");
            return queryJson;
        }
        int verify_code = getRandomCode();//产生1000-9999的随机数
        String email_address = accountService.updateForgetPasswordInfo(fp_id, verify_code);
        if (email_address != null) {
            Email email = new Email();
            email.send(email_address, "<h2>禾斗创课验证码：" + verify_code + "</h2>", "禾斗创课忘记密码验证码");
            queryJson.setErrno(0);
            queryJson.setErrmsg("resend success");
        } else {
            queryJson.setErrmsg("unknown error");
        }
        return queryJson;
    }

    @ResponseBody
    @RequestMapping(value = "/forget_password/change_password", method = RequestMethod.POST)
    public BaseJson changePassword() throws Exception {
        queryJson = new BaseJson();
        queryJson.setErrno(1);
        Long fp_id = Long.parseLong(getHttpRequest().getParameter("fp_id"));
        String new_password = getHttpRequest().getParameter("new_password");
        if (fp_id == null || new_password == null) {
            queryJson.setErrmsg("invalid parameter");
            return queryJson;
        }
        Object is_verified = getSessionAttribute("forget_password_is_verified");
        if(is_verified!=null&&(boolean)is_verified){
            ForgetPasswordInfo forgetPasswordInfo = accountService.getForgetPasswordInfo(fp_id);
            if(forgetPasswordInfo!=null){
                int result = accountService.updateUser(forgetPasswordInfo.getFpEmailAddress(),new_password);
                if(result==0){
                    queryJson.setErrno(0);
                    queryJson.setErrmsg("success");
                }else {
                    queryJson.setErrmsg("unknown error");
                }
            }else {
                queryJson.setErrmsg("invalid fp_id");
            }
        }else{
            queryJson.setErrmsg("please verify code");
        }
        return queryJson;
    }

    private int getRandomCode() {
        int verify_code = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;//产生1000-9999的随机数
        return verify_code;
    }
}
