package org.kevin.blog.mapper;

import org.kevin.blog.model.SecretMoment;

public interface SecretMomentMapper {
    int insert(SecretMoment record);

    int insertSelective(SecretMoment record);
}