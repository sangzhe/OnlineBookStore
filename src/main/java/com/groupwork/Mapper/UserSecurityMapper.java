package com.groupwork.Mapper;

import com.groupwork.Model.UserSecurity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by sangzhe on 2018/4/7.
 */
@Mapper
@Repository
public interface UserSecurityMapper {
    UserSecurity getUserSecurityByEmail(String Email);

    UserSecurity getUserSecurityById(String Id);

    int updateUserPassword(UserSecurity user);

    int insertNewUserSecurity(UserSecurity user);
}
