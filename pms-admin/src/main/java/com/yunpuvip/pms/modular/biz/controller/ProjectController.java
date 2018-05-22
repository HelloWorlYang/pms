package com.yunpuvip.pms.modular.biz.controller;

import com.yunpuvip.pms.core.base.controller.BaseController;
import com.yunpuvip.pms.core.log.LogObjectHolder;
import com.yunpuvip.pms.core.node.ZTreeNode;
import com.yunpuvip.pms.modular.biz.service.IProjectService;
import com.yunpuvip.pms.modular.system.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 项目信息控制器
 *
 * @author fengshuonan
 * @Date 2018-05-16 10:32:28
 */
@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController {

    private String PREFIX = "/project/project/";

    @Autowired
    private IProjectService projectService;

    /**
     * 跳转到项目信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "project.html";
    }

    /**
     * 跳转到添加项目信息
     */
    @RequestMapping("/project_add")
    public String projectAdd() {
        return PREFIX + "project_add.html";
    }

    /**
     * 跳转到修改项目信息
     */
    @RequestMapping("/project_update/{projectId}")
    public String projectUpdate(@PathVariable Integer projectId, Model model) {
        Project project = projectService.selectById(projectId);
        model.addAttribute("item",project);
        LogObjectHolder.me().set(project);
        return PREFIX + "project_edit.html";
    }

    /**
     * 获取项目信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return projectService.selectList(null);
    }

    /**
     * 新增项目信息
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Project project) {
        projectService.insert(project);
        return SUCCESS_TIP;
    }

    /**
     * 删除项目信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer projectId) {
        projectService.deleteById(projectId);
        return SUCCESS_TIP;
    }

    /**
     * 修改项目信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Project project) {
        projectService.updateById(project);
        return SUCCESS_TIP;
    }

    /**
     * 项目信息详情
     */
    @RequestMapping(value = "/detail/{projectId}")
    @ResponseBody
    public Object detail(@PathVariable("projectId") Integer projectId) {
        return projectService.selectById(projectId);
    }

}
