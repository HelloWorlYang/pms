package com.yunpuvip.pms.modular.biz.hours.controller;

import com.yunpuvip.pms.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.yunpuvip.pms.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.yunpuvip.pms.modular.system.model.Hours;
import com.yunpuvip.pms.modular.biz.hours.service.IHoursService;

/**
 * 员工工时控制器
 *
 * @author fengshuonan
 * @Date 2018-05-16 10:42:52
 */
@Controller
@RequestMapping("/hours")
public class HoursController extends BaseController {

    private String PREFIX = "/hours/hours/";

    @Autowired
    private IHoursService hoursService;

    /**
     * 跳转到员工工时首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "hours.html";
    }

    /**
     * 跳转到添加员工工时
     */
    @RequestMapping("/hours_add")
    public String hoursAdd() {
        return PREFIX + "hours_add.html";
    }

    /**
     * 跳转到修改员工工时
     */
    @RequestMapping("/hours_update/{hoursId}")
    public String hoursUpdate(@PathVariable Integer hoursId, Model model) {
        Hours hours = hoursService.selectById(hoursId);
        model.addAttribute("item",hours);
        LogObjectHolder.me().set(hours);
        return PREFIX + "hours_edit.html";
    }

    /**
     * 获取员工工时列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return hoursService.selectList(null);
    }

    /**
     * 新增员工工时
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Hours hours) {
        hoursService.insert(hours);
        return SUCCESS_TIP;
    }

    /**
     * 删除员工工时
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer hoursId) {
        hoursService.deleteById(hoursId);
        return SUCCESS_TIP;
    }

    /**
     * 修改员工工时
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Hours hours) {
        hoursService.updateById(hours);
        return SUCCESS_TIP;
    }

    /**
     * 员工工时详情
     */
    @RequestMapping(value = "/detail/{hoursId}")
    @ResponseBody
    public Object detail(@PathVariable("hoursId") Integer hoursId) {
        return hoursService.selectById(hoursId);
    }
}
