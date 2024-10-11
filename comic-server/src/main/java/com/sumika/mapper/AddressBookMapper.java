package com.sumika.mapper;

import com.sumika.annotation.AutoFill;
import com.sumika.entity.AddressBook;
import com.sumika.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-19 08:33
 */

@Mapper
public interface AddressBookMapper {

    @AutoFill(OperationType.INSERT)
    void insert(AddressBook addressBook);



}
