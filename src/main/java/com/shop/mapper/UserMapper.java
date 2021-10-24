package com.shop.mapper;

import com.shop.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 根据用户名，密码登录
     * @param username
     * @param password
     * @return
     */
    User login( String username, String password);

    /**
     *
     * @param username
     * @return
     */
    User getUserInfo(String username);

    /**
     *
     * @param username
     * @param newPassword
     * @return
     */
    int updatePassword(String username,String newPassword);

}
