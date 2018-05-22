package com.yunpuvip.pms.modular.biz.controller;

import com.yunpuvip.pms.core.base.controller.BaseController;
import com.yunpuvip.pms.core.log.LogObjectHolder;
import com.yunpuvip.pms.core.node.ZTreeNode;
import com.yunpuvip.pms.modular.biz.service.IProjectPhaseService;
import com.yunpuvip.pms.modular.system.model.ProjectPhase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 项目开发阶段控制器
 *
 * @author fengshuonan
 * @Date 2018-05-16 10:47:41
 */
@Controller
@RequestMapping("/projectPhase")
public class ProjectPhaseController extends BaseController {

    private String PREFIX = "/project_phase/projectPhase/";

    @Autowired
    private IProjectPhaseService projectPhaseService;

    /**
     * 跳转到项目开发阶段首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "projectPhase.html";
    }

    /**
     * 跳转到添加项目开发阶段
     */
    @RequestMapping("/projectPhase_add")
    public String projectPhaseAdd() {
        return PREFIX + "projectPhase_add.html";
    }

    /**
     * 跳转到修改项目开发阶段
     */
    @RequestMapping("/projectPhase_update/{projectPhaseId}")
    public String projectPhaseUpdate(@PathVariable Integer projectPhaseId, Model model) {
        ProjectPhase projectPhase = projectPhaseService.selectById(projectPhaseId);
        model.addAttribute("item",projectPhase);
        LogObjectHolder.me().set(projectPhase);
        return PREFIX + "projectPhase_edit.html";
    }

    /**
     * 获取项目开发阶段列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return projectPhaseService.selectList(null);
    }

    /**
     * 新增项目开发阶段
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ProjectPhase projectPhase) {
        projectPhaseService.insert(projectPhase);
        return SUCCESS_TIP;
    }

    /**
     * 删除项目开发阶段
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer projectPhaseId) {
        projectPhaseService.deleteById(projectPhaseId);
        return SUCCESS_TIP;
    }

    /**
     * 修改项目开发阶段
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(ProjectPhase projectPhase) {
        projectPhaseService.updateById(projectPhase);
        return SUCCESS_TIP;
    }

    /**
     * 项目开发阶段详情
     */
    @RequestMapping(value = "/detail/{projectPhaseId}")
    @ResponseBody
    public Object detail(@PathVariable("projectPhaseId") Integer projectPhaseId) {
        return projectPhaseService.selectById(projectPhaseId);
    }
}
