package org.kevin.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kevin.blog.common.util.CommonUtils;
import org.kevin.blog.mapper.FinanceMapper;
import org.kevin.blog.model.Finance;
import org.kevin.blog.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2018-12-28
 */
@Service(value = "financeService")
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    private FinanceMapper financeMapper;

    @Override
    public int insert(Finance record) {
        record.setId(CommonUtils.getUUID32());
        record.setCreateTime(new Date());
        return financeMapper.insert(record);
    }

    @Override
    public List<Finance> findList(Integer limit) {
        return financeMapper.findList(limit);
    }

    @Override
    public PageInfo<Finance> list(Finance record, Integer pageNum, Integer pageSize) {
        PageInfo<Finance> page = PageHelper.startPage(pageNum, pageSize).setOrderBy("create_time desc")
                .doSelectPageInfo(() -> financeMapper.selectByCondition(record));
        return page;
    }

    @Override
    public String sumByDate(String fromDate, String toDate) {
        Date fDate = CommonUtils.getDate(fromDate);
        Date tDate = CommonUtils.getDate(toDate);
        double sum = financeMapper.sumByDate(fDate,tDate);
        return "the sum of you choose dates is: " + sum;
    }
}
