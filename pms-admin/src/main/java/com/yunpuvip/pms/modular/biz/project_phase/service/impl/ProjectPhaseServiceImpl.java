package com.yunpuvip.pms.modular.biz.project_phase.service.impl;

import com.yunpuvip.pms.core.node.ZTreeNode;
import com.yunpuvip.pms.modular.system.model.ProjectPhase;
import com.yunpuvip.pms.modular.system.dao.ProjectPhaseMapper;
import com.yunpuvip.pms.modular.biz.project_phase.service.IProjectPhaseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 项目开发阶段 服务实现类
 * </p>
 *
 * @author yangchaojian123
 * @since 2018-05-16
 */
@Service
public class ProjectPhaseServiceImpl extends ServiceImpl<ProjectPhaseMapper, ProjectPhase> implements IProjectPhaseService {
    @Override
    public List<ZTreeNode> tree() {
        return this.baseMapper.tree();
    }

    @Override
    public List<Map<String, Object>> list(String condition) {
        return this.baseMapper.list(condition);
    }
}
