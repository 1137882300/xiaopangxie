package com.xiaohei.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-03
 */
@TableName("t_gift")
public class Gift implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 礼物类型：穿着、电子设备、食物...
     */
    @TableField("type")
    private Integer type;

    /**
     * 礼物的描述
     */
    @TableField("describe")
    private String describe;

    /**
     * [1:过期，0:正常]
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


    public Long getId() {
        return id;
    }

    public Gift setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Gift setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public Gift setDescribe(String describe) {
        this.describe = describe;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Gift setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getFeatures() {
        return features;
    }

    public Gift setFeatures(String features) {
        this.features = features;
        return this;
    }

    public Long getCreator() {
        return creator;
    }

    public Gift setCreator(Long creator) {
        this.creator = creator;
        return this;
    }

    public Long getModifier() {
        return modifier;
    }

    public Gift setModifier(Long modifier) {
        this.modifier = modifier;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Gift setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public Gift setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public Gift setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public static final String ID = "id";

    public static final String TYPE = "type";

    public static final String DESCRIBE = "describe";

    public static final String STATUS = "status";

    public static final String FEATURES = "features";

    public static final String CREATOR = "creator";

    public static final String MODIFIER = "modifier";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String IS_DELETED = "is_deleted";

    @Override
    public String toString() {
        return "Gift{" +
        "id=" + id +
        ", type=" + type +
        ", describe=" + describe +
        ", status=" + status +
        ", features=" + features +
        ", creator=" + creator +
        ", modifier=" + modifier +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDeleted=" + isDeleted +
        "}";
    }
}
