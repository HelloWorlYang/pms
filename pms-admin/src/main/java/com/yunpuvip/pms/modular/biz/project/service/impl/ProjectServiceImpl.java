package com.yunpuvip.pms.modular.biz.project.service.impl;

import com.yunpuvip.pms.core.node.ZTreeNode;
import com.yunpuvip.pms.modular.system.model.Project;
import com.yunpuvip.pms.modular.system.dao.ProjectMapper;
import com.yunpuvip.pms.modular.biz.project.service.IProjectService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 项目信息表
 服务实现类
 * </p>
 *
 * @author yangchaojian123
 * @since 2018-05-16
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {
    @Override
    public List<ZTreeNode> tree() {
        return this.baseMapper.tree();
    }

    @Override
    public List<Map<String, Object>> list(String condition) {
        return this.baseMapper.list(condition);
    }
}
