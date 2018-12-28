package org.kevin.blog.service;

import com.github.pagehelper.PageInfo;
import org.kevin.blog.model.Finance;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2018-12-28
 */
public interface FinanceService {
    int insert(Finance record);

    List<Finance> findList(Integer limit);

    PageInfo<Finance> list(Finance record, Integer pageNum, Integer pageSize);
}
