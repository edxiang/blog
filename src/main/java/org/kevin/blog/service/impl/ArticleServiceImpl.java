package org.kevin.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.kevin.blog.common.ResultCode;
import org.kevin.blog.common.util.CommonUtils;
import org.kevin.blog.mapper.ArticleMapper;
import org.kevin.blog.model.Article;
import org.kevin.blog.model.ArticleWithBLOBs;
import org.kevin.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 12/9/18
 */
@Service(value = "articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int insert(ArticleWithBLOBs record) {
        return articleMapper.insert(record);
    }

    @Override
    public int insertSelective(ArticleWithBLOBs record) {
        record.setId(CommonUtils.getUUID32());
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setDeleteFlag(false);
        record.setForeword(CommonUtils.replaceLineCharacter(record.getForeword()));
        if(articleMapper.insertSelective(record) > 0)
            return ResultCode.SUCCESS.getCode();

        return ResultCode.FAIL.getCode();
    }

    @Override
    public List<ArticleWithBLOBs> findList(Integer limit) {
        return articleMapper.findList(limit);
    }

    @Override
    public PageInfo<ArticleWithBLOBs> list(ArticleWithBLOBs record, int pageNum, int pageSize) {
        PageInfo<ArticleWithBLOBs> page = PageHelper.startPage(pageNum,pageSize).setOrderBy("create_time desc")
                .doSelectPageInfo(() -> articleMapper.selectByCondition(record));
        return page;
    }

    @Override
    public ArticleWithBLOBs selectByPrimaryKey(String id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(ArticleWithBLOBs record) {
        return articleMapper.updateByPrimaryKey(record);
    }
}
