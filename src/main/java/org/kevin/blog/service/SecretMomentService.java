package org.kevin.blog.service;

import com.github.pagehelper.PageInfo;
import org.kevin.blog.model.SecretMoment;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 12/8/18
 */
public interface SecretMomentService {
    int insert(SecretMoment record);

    List<SecretMoment> findList(Integer limit);

    PageInfo<SecretMoment> selectByCondition(SecretMoment record, Integer pageNum, Integer pageSize);
}
