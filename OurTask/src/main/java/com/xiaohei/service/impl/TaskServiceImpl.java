package com.xiaohei.service.impl;

import com.alibaba.fastjson.JSON;
import com.xiaohei.api.request.AddTaskRequest;
import com.xiaohei.repository.po.Task;
import com.xiaohei.repository.service.TaskRpService;
import com.xiaohei.service.TaskService;
import com.xiaohei.service.common.constant.ValueConstants;
import com.xiaohei.service.common.enums.StatusEnum;
import com.xiaohei.service.common.enums.TaskTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by cc on 2022/7/10
 * 业务逻辑
 */
@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskRpService taskRpService;

    @Override
    public Boolean addTask(AddTaskRequest request) {
        if (Objects.isNull(request)) {
            log.warn("addTask.taskModel is null");
            return false;
        }
        TaskTypeEnum typeEnum = TaskTypeEnum.getByCode(request.getType());
        Task task = new Task();
        task.setType(typeEnum.getCode());
        task.setContent(Optional.ofNullable(request.getContent()).orElse("没有内容"));
        task.setStatus(StatusEnum.valid.getCode());
        if (MapUtils.isNotEmpty(request.getExtendMap())) {
            task.setFeatures(JSON.toJSONString(request.getExtendMap()));
        }
        task.setCreator(Optional.ofNullable(request.getCreator()).orElse(ValueConstants.default_creator));
        task.setModifier(Optional.ofNullable(request.getCreator()).orElse(ValueConstants.default_modifier));
        LocalDateTime now = LocalDateTime.now();
        task.setCreateTime(now);
        task.setUpdateTime(now);
        task.setStartTime(Optional.ofNullable(request.getStartTime()).orElse(LocalDateTime.of(2022,7,10,15,36)));
        task.setEndTime(Optional.ofNullable(request.getEndTime()).orElse(LocalDateTime.of(2022,7,10,15,36)));
        task.setIsDeleted(ValueConstants.undelete);
        log.info("PO.Task:{}", JSON.toJSONString(task));
        return taskRpService.save(task);
    }
}
