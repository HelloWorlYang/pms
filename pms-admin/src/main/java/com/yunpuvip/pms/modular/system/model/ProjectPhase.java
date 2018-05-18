package com.yunpuvip.pms.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 项目开发阶段
 * </p>
 *
 * @author yangchaojian123
 * @since 2018-05-16
 */
@TableName("biz_project_phase")
public class ProjectPhase extends Model<ProjectPhase> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 阶段代码
     */
    @TableField("phase_code")
    private String phaseCode;
    /**
     * 阶段名称
     */
    @TableField("phase_name")
    private String phaseName;
    /**
     * 备注
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

    public String getPhaseCode() {
        return phaseCode;
    }

    public void setPhaseCode(String phaseCode) {
        this.phaseCode = phaseCode;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
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
        return "ProjectPhase{" +
        "id=" + id +
        ", phaseCode=" + phaseCode +
        ", phaseName=" + phaseName +
        ", description=" + description +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        "}";
    }
}
