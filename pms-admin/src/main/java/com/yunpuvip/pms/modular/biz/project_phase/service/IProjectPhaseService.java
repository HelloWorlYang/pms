package com.yunpuvip.pms.modular.biz.project_phase.service;

import com.yunpuvip.pms.core.node.ZTreeNode;
import com.yunpuvip.pms.modular.system.model.ProjectPhase;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 项目开发阶段 服务类
 * </p>
 *
 * @author yangchaojian123
 * @since 2018-05-16
 */
public interface IProjectPhaseService extends IService<ProjectPhase> {
    /**
     * 获取ztree的节点列表
     */
    List<ZTreeNode> tree();

    /**
     * 获取所有部门列表
     */
    List<Map<String, Object>> list(@Param("condition") String condition);
}
