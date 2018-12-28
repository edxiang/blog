package org.kevin.blog.controller;

import com.github.pagehelper.PageInfo;
import org.kevin.blog.model.Finance;
import org.kevin.blog.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Kevin.Z
 * @version 2018-12-28
 */
@Controller
public class SpendingController {

    @Autowired
    private FinanceService financeService;

    @RequestMapping(value = "/spending")
    public String spending() {
        return "spending";
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<Finance> list(@RequestParam(value = "pageNum", required = false) Integer pageNum,
                                  @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Finance record = null;
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        return financeService.list(record,pageNum,pageSize);
    }
}
