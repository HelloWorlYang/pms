package com.yunpuvip.pms.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 项目信息表

 * </p>
 *
 * @author yangchaojian123
 * @since 2018-05-16
 */
@TableName("biz_project")
public class Project extends Model<Project> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 项目名称
     */
    @TableField("project_name")
    private String projectName;
    /**
     * 项目代码
     */
    @TableField("project_code")
    private String projectCode;
    /**
     * 预估人天
     */
    private BigDecimal manday;
    /**
     * 预估小时
     */
    private BigDecimal manhour;
    /**
     * 开始日期
     */
    @TableField("start_date")
    private Date startDate;
    /**
     * 结束日期
     */
    @TableField("end_date")
    private Date endDate;
    /**
     * 项目是否有阶段
     */
    @TableField("has_phase")
    private String hasPhase;
    /**
     * 描述
     */
    private String description;
    private Date createtime;
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public BigDecimal getManday() {
        return manday;
    }

    public void setManday(BigDecimal manday) {
        this.manday = manday;
    }

    public BigDecimal getManhour() {
        return manhour;
    }

    public void setManhour(BigDecimal manhour) {
        this.manhour = manhour;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getHasPhase() {
        return hasPhase;
    }

    public void setHasPhase(String hasPhase) {
        this.hasPhase = hasPhase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "Project{" +
        "id=" + id +
        ", projectName=" + projectName +
        ", projectCode=" + projectCode +
        ", manday=" + manday +
        ", manhour=" + manhour +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", hasPhase=" + hasPhase +
        ", description=" + description +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        "}";
    }
}
