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
@TableName("t_task")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 任务类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 任务内容
     */
    @TableField("content")
    private String content;

    /**
     * [1:失效，0:有效]
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
     * 开始时间
     */
    @TableField("start_time")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    private LocalDateTime endTime;

    /**
     * [1:删除,0:未删除]
     */
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;


    public Long getId() {
        return id;
    }

    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Task setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Task setContent(String content) {
        this.content = content;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Task setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getFeatures() {
        return features;
    }

    public Task setFeatures(String features) {
        this.features = features;
        return this;
    }

    public Long getCreator() {
        return creator;
    }

    public Task setCreator(Long creator) {
        this.creator = creator;
        return this;
    }

    public Long getModifier() {
        return modifier;
    }

    public Task setModifier(Long modifier) {
        this.modifier = modifier;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Task setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public Task setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Task setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Task setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public Task setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public static final String ID = "id";

    public static final String TYPE = "type";

    public static final String CONTENT = "content";

    public static final String STATUS = "status";

    public static final String FEATURES = "features";

    public static final String CREATOR = "creator";

    public static final String MODIFIER = "modifier";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String START_TIME = "start_time";

    public static final String END_TIME = "end_time";

    public static final String IS_DELETED = "is_deleted";

    @Override
    public String toString() {
        return "Task{" +
        "id=" + id +
        ", type=" + type +
        ", content=" + content +
        ", status=" + status +
        ", features=" + features +
        ", creator=" + creator +
        ", modifier=" + modifier +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", isDeleted=" + isDeleted +
        "}";
    }
}
