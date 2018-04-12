package com.groupwork.Mapper;

import com.groupwork.Model.UserGeneral;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by sangzhe on 2018/4/5.
 */
@Mapper
@Repository
public interface UserGeneralMapper {
    UserGeneral getUserById(String Id);

    int updateUserGeneral(UserGeneral user);

    int insertNewUserGeneral(String Id);

    UserGeneral getUserByEmail(String Email);
}
