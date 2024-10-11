package com.sumika.mapper;

import com.sumika.annotation.AutoFill;
import com.sumika.entity.DetailedUser;
import com.sumika.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-18 12:31
 */


@Mapper
public interface DetailedUserMapper {

    @AutoFill(OperationType.INSERT)
    void insert(DetailedUser detailedUser);

    @AutoFill(OperationType.UPDATE)
    void updateByUserId(DetailedUser du);
}
