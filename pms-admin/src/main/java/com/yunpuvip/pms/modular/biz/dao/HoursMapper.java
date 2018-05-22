package com.yunpuvip.pms.modular.biz.dao;

import com.yunpuvip.pms.modular.system.model.Hours;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 工时表 Mapper 接口
 * </p>
 *
 * @author yangchaojian123
 * @since 2018-05-16
 */
public interface HoursMapper extends BaseMapper<Hours> {
    List<Map<String ,Object>> selectHours(@Param("pid") Integer pid,@Param("uid") Integer uid,@Param("hid") Integer hid);
}
