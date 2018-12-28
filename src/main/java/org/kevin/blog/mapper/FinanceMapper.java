package org.kevin.blog.mapper;

import org.kevin.blog.model.Finance;

import java.util.List;

public interface FinanceMapper {
    int insert(Finance record);

    int insertSelective(Finance record);

    List<Finance> findList(Integer limit);

    List<Finance> selectByCondition(Finance record);
}