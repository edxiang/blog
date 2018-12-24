package org.kevin.blog.mapper;

import org.kevin.blog.model.SecretMoment;

import java.util.List;

public interface SecretMomentMapper {
    int insert(SecretMoment record);

    int insertSelective(SecretMoment record);

    List<SecretMoment> findList(Integer limit);

    List<SecretMoment> selectByCondition(SecretMoment record);
}