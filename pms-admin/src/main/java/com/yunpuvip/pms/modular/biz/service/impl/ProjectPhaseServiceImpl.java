package com.yunpuvip.pms.modular.biz.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yunpuvip.pms.core.node.ZTreeNode;
import com.yunpuvip.pms.modular.biz.service.IProjectPhaseService;
import com.yunpuvip.pms.modular.biz.dao.ProjectPhaseMapper;
import com.yunpuvip.pms.modular.system.model.ProjectPhase;
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
}
