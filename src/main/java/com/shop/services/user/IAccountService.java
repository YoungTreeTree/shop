package com.shop.services.user;

import com.shop.entity.ForgetPasswordInfo;
import com.shop.entity.User;
import com.shop.entity.UserRegisterTemp;
import com.shop.services.common.ICommService;

/**
 * Created by a3578 on 2017/4/22.
 */
public interface IAccountService extends ICommService {
    public User getUserByEmail(String email);

    public long addUserRegisterTemp(String name, String password, String email, int verify_code);

    public long register(long temp_id);

    public UserRegisterTemp getUserRegisterTemp(long temp_id);

    public String updateUserRegisterTemp(long temp_id, int verify_code);

    public long addForgetPasswordInfo(String email_address, String verify_code);

    public ForgetPasswordInfo getForgetPasswordInfo(long fp_id);

    public String updateForgetPasswordInfo(long fp_id,int verify_code);

    public int updateUser(String email_address,String new_password);
}
