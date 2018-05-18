package com.yunpuvip.pms.modular.system.dao;

import com.yunpuvip.pms.core.node.ZTreeNode;
import com.yunpuvip.pms.modular.system.model.Project;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 项目信息表
 Mapper 接口
 * </p>
 *
 * @author yangchaojian123
 * @since 2018-05-16
 */
public interface ProjectMapper extends BaseMapper<Project> {
    /**
     * 获取ztree的节点列表
     */
    List<ZTreeNode> tree();

    /**
     * 获取所有部门列表
     */
    List<Map<String, Object>> list(@Param("condition") String condition);

}
