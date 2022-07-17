package com.xiaohei.repository.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 关联关系表
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-10
 */
@TableName("t_relation")
public class Relation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联类型
     */
    @TableField("type")
    private String type;

    /**
     * 主
     */
    @TableField("master")
    private Long master;

    /**
     * 次
     */
    @TableField("slave")
    private Long slave;

    /**
     * [1:异常，0:正常]
     */
    @TableField("status")
    private Integer status;

    /**
     * 预留拓展
     */
    @TableField("features")
    private String features;

    /**
     * 创建人
     */
    @TableField("creator")
    private Long creator;

    /**
     * 修改人
     */
    @TableField("modifier")
    private Long modifier;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * [1:删除,0:未删除]
     */
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;
    /**
     * version
     */
    @TableField("version")
    @Version
    private Long version;

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public Long getId() {
        return id;
    }

    public Relation setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Relation setType(String type) {
        this.type = type;
        return this;
    }

    public Long getMaster() {
        return master;
    }

    public Relation setMaster(Long master) {
        this.master = master;
        return this;
    }

    public Long getSlave() {
        return slave;
    }

    public Relation setSlave(Long slave) {
        this.slave = slave;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Relation setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getFeatures() {
        return features;
    }

    public Relation setFeatures(String features) {
        this.features = features;
        return this;
    }

    public Long getCreator() {
        return creator;
    }

    public Relation setCreator(Long creator) {
        this.creator = creator;
        return this;
    }

    public Long getModifier() {
        return modifier;
    }

    public Relation setModifier(Long modifier) {
        this.modifier = modifier;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Relation setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public Relation setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public Relation setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public static final String ID = "id";

    public static final String TYPE = "type";

    public static final String MASTER = "master";

    public static final String SLAVE = "slave";

    public static final String STATUS = "status";

    public static final String FEATURES = "features";

    public static final String CREATOR = "creator";

    public static final String MODIFIER = "modifier";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String IS_DELETED = "is_deleted";

    @Override
    public String toString() {
        return "Relation{" +
        "id=" + id +
        ", type=" + type +
        ", master=" + master +
        ", slave=" + slave +
        ", status=" + status +
        ", features=" + features +
        ", creator=" + creator +
        ", modifier=" + modifier +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDeleted=" + isDeleted +
        ", version=" + version +
        "}";
    }
}
