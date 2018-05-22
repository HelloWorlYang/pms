package com.yunpuvip.pms.modular.biz.service;

import com.baomidou.mybatisplus.service.IService;
import com.yunpuvip.pms.modular.system.model.Hours;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 工时表 服务类
 * </p>
 *
 * @author yangchaojian123
 * @since 2018-05-16
 */
public interface IHoursService extends IService<Hours> {
    List<Map<String, Object>> selectHours(@Param("pid") Integer pId, @Param("uid") Integer uId, @Param("hid") Integer hId);
}
