package com.groupwork.Mapper;

import com.groupwork.Model.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sangzhe on 2018/4/11.
 */
@Mapper
@Repository
public interface AddressMapper {
    List<Address> getAddressesByUsername(String Email);

    int insertAddress(Address Address);

    int insertUserAddress(@Param("AddressId") String AddressId,@Param("UserId") String UserId);

    int deleteAddress(@Param("AddressId") String AddressId);

    Address getAddressById(String Id);


//    int updateAddress(@Param("Address") Address Address);

}
