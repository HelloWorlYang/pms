package com.yunpuvip.pms.modular.biz.warpper;

import com.yunpuvip.pms.core.base.warpper.BaseControllerWarpper;
import com.yunpuvip.pms.core.common.constant.factory.ConstantFactory;

import java.util.Map;
import java.util.List;

public class HoursWarpper extends BaseControllerWarpper {
    public HoursWarpper(List<Map<String,Object>> list){ super(list); }

    @Override
    public void warpTheMap(Map<String,Object> map){
        Integer pid = (Integer) map.get("pid");
        Integer uid = (Integer) map.get("uid");
        Integer hid = (Integer) map.get("hid");
        Integer hoursId = (Integer) map.get("id");

        map.put("projectName",ConstantFactory.me().getProjectNameById(pid));
        map.put("userName",ConstantFactory.me().getUserNameById(uid));
        map.put("phaseName",ConstantFactory.me().getPhaseNameById(hid));
        map.put("hours",ConstantFactory.me().getHours(hoursId));
    }
}
