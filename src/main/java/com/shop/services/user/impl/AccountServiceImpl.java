package com.shop.services.user.impl;

import com.shop.entity.*;
import com.shop.services.common.impl.CommServiceImpl;
import com.shop.services.user.IAccountService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by a3578 on 2017/4/22.
 */
@Service(value = "accountService")
public class AccountServiceImpl extends CommServiceImpl implements IAccountService {
    public User getUserByEmail(String email) {
        try {
            List<User> users = baseDAO.findByProperty("UEmailAddress", email, User.class);
            if (users.size() > 0) {
                return users.get(0);
            }
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public long addUserRegisterTemp(String name, String password, String email, int verify_code) {
        try {
            List<User> users = baseDAO.findByProperty("UEmailAddress", email, User.class);
            if (users.size() > 0) {
                return -1;
            }
            List<UserRegisterTemp> tmpUsers = baseDAO.findByProperty("UEmailAddress", email, UserRegisterTemp.class);
            UserRegisterTemp tempUser;
            Timestamp now_time = new Timestamp(System.currentTimeMillis());
            if (tmpUsers.size() > 0) {
                tempUser = tmpUsers.get(0);
                tempUser.setUName(name);
                tempUser.setUPassword(password);
                tempUser.setUGenerateDate(now_time);
            } else {
                tempUser = new UserRegisterTemp(name, password, email, now_time, null);
            }
            tempUser.setUVerifyCode(verify_code);
            baseDAO.save(tempUser);
            return tempUser.getId();
        } catch (Exception ex) {
            return -2;
        }
    }

    public UserRegisterTemp getUserRegisterTemp(long temp_id) {
        List<UserRegisterTemp> tempUsers = baseDAO.findByProperty("id", temp_id, UserRegisterTemp.class);
        if (tempUsers.size() > 0) {
            return tempUsers.get(0);
        }
        return null;
    }

    public long register(long temp_id) {
        List<UserRegisterTemp> tempUsers = baseDAO.findByProperty("id", temp_id, UserRegisterTemp.class);
        if (tempUsers.size() > 0) {
            try {
                UserRegisterTemp tempUser = tempUsers.get(0);
                User user = new User(tempUser.getUName(), tempUser.getUPassword(), tempUser.getUEmailAddress(), null, null, null, null, null, null);
                baseDAO.save(user);
                return user.getUId();
            } catch (Exception ex) {
                return -1;
            }
        }
        return -1;
    }

    public String updateUserRegisterTemp(long temp_id, int verify_code) {
        try {
            List<UserRegisterTemp> tmpUsers = baseDAO.findByProperty("id", temp_id, UserRegisterTemp.class);
            UserRegisterTemp tempUser;
            if (tmpUsers.size() > 0) {
                tempUser = tmpUsers.get(0);
                tempUser.setUVerifyCode(verify_code);
                baseDAO.save(tempUser);
                return tempUser.getUEmailAddress();
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    public long addForgetPasswordInfo(String email_address, String verify_code) {
        try {
            List<ForgetPasswordInfo> forgetPasswordInfos = baseDAO.findByProperty("fpEmailAddress", email_address, ForgetPasswordInfo.class);
            ForgetPasswordInfo forgetPasswordInfo;
            Timestamp now_time = new Timestamp(System.currentTimeMillis());
            if (forgetPasswordInfos.size() > 0) {
                forgetPasswordInfo = forgetPasswordInfos.get(0);
                forgetPasswordInfo.setFpVerifyCode(verify_code);
                forgetPasswordInfo.setFpCreateTime(now_time);
            } else {
                forgetPasswordInfo = new ForgetPasswordInfo(email_address, verify_code, now_time);
            }
            baseDAO.save(forgetPasswordInfo);
            return forgetPasswordInfo.getFpId();
        } catch (Exception ex) {
            return 0;
        }
    }

    public ForgetPasswordInfo getForgetPasswordInfo(long fp_id) {
        try {
            List<ForgetPasswordInfo> forgetPasswordInfos = baseDAO.findByProperty("fpId", fp_id, ForgetPasswordInfo.class);
            if (forgetPasswordInfos.size() > 0) {
                return forgetPasswordInfos.get(0);
            }
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public String updateForgetPasswordInfo(long fp_id, int verify_code) {
        try {
            List<ForgetPasswordInfo> forgetPasswordInfos = baseDAO.findByProperty("fpId", fp_id, ForgetPasswordInfo.class);
            ForgetPasswordInfo forgetPasswordInfo;
            if (forgetPasswordInfos.size() > 0) {
                forgetPasswordInfo = forgetPasswordInfos.get(0);
                forgetPasswordInfo.setFpVerifyCode(Integer.toString(verify_code));
                baseDAO.save(forgetPasswordInfo);
                return forgetPasswordInfo.getFpEmailAddress();
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    public int updateUser(String email_address, String new_password) {
        try {
            List<User> users = baseDAO.findByProperty("UEmailAddress", email_address, User.class);
            User user;
            if (users.size() > 0) {
                user = users.get(0);
                user.setUPassword(new_password);
                baseDAO.save(user);
                return 0;
            }
        } catch (Exception ex) {
            return -1;
        }
        return -1;
    }

}