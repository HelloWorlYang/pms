package com.yunpuvip.pms.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 工时表
 * </p>
 *
 * @author yangchaojian123
 * @since 2018-05-16
 */
@TableName("biz_hours")
public class Hours extends Model<Hours> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 项目ID
     */
    private Integer pid;
    /**
     * 阶段ID
     */
    private Integer hid;
    /**
     * 人员ID
     */
    private Integer uid;
    /**
     * 小时
     */
    private Integer hours;
    /**
     * 工时备注
     */
    private String comment;
    private Date createtime;
    private Date updatetime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Hours{" +
        "id=" + id +
        ", pid=" + pid +
        ", hid=" + hid +
        ", uid=" + uid +
        ", hours=" + hours +
        ", comment=" + comment +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        "}";
    }
}
