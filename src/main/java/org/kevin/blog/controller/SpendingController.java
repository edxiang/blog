package org.kevin.blog.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.kevin.blog.model.Finance;
import org.kevin.blog.model.dto.DataTables;
import org.kevin.blog.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/spending/list", method = RequestMethod.POST)
    @ResponseBody
    public String list(HttpServletRequest request) {
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        int draw = Integer.parseInt(request.getParameter("draw"));

        PageInfo<Finance> pageInfo = financeService.list(null,start/length + 1,length);

        DataTables dt = new DataTables();
        dt.setRecordsTotal((int)pageInfo.getTotal());
        dt.setRecordsFiltered((int)pageInfo.getTotal());
        dt.setDraw(draw);
        dt.setData(pageInfo.getList());
        return JSON.toJSONString(dt);
    }

    @PostMapping("/spending/sum")
    @ResponseBody
    public String sum(@RequestParam("fromDate")String fromDate,
                      @RequestParam("toDate")String toDate,
                      @RequestParam("type")String type){
        return financeService.sumByDate(fromDate,toDate,type);
    }
}
