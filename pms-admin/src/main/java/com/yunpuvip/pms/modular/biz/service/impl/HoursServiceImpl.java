package com.yunpuvip.pms.modular.biz.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yunpuvip.pms.modular.biz.service.IHoursService;
import com.yunpuvip.pms.modular.biz.dao.HoursMapper;
import com.yunpuvip.pms.modular.system.model.Hours;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 工时表 服务实现类
 * </p>
 *
 * @author yangchaojian123
 * @since 2018-05-16
 */
@Service
public class HoursServiceImpl extends ServiceImpl<HoursMapper, Hours> implements IHoursService {
    @Override
    public List<Map<String, Object>> selectHours(Integer pid ,Integer uid ,Integer hid){
        return this.baseMapper.selectHours(pid,uid,hid);
    }
}
