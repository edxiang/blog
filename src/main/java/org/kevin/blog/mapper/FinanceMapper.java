package org.kevin.blog.mapper;

import org.apache.ibatis.annotations.Param;
import org.kevin.blog.model.Finance;

import java.util.Date;
import java.util.List;

public interface FinanceMapper {
    int insert(Finance record);

    int insertSelective(Finance record);

    List<Finance> findList(Integer limit);

    List<Finance> selectByCondition(Finance record);

    double sumByDate(@Param("fromDate") Date fromDate,
                     @Param("toDate") Date toDate);
}