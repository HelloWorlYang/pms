package com.yunpuvip.pms.modular.biz.dao;

import com.yunpuvip.pms.core.node.ZTreeNode;
import com.yunpuvip.pms.modular.system.model.ProjectPhase;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 项目开发阶段 Mapper 接口
 * </p>
 *
 * @author yangchaojian123
 * @since 2018-05-16
 */
public interface ProjectPhaseMapper extends BaseMapper<ProjectPhase> {
    List<Map<String, Object>> selectProjectPhase(@Param("id") Integer id);
}
