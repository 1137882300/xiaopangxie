package com.xiaohei.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohei.api.enums.TaskErrorEnum;
import com.xiaohei.api.request.AddTaskRequest;
import com.xiaohei.api.request.EditTaskRequest;
import com.xiaohei.api.vo.PageVO;
import com.xiaohei.api.vo.TaskVO;
import com.xiaohei.common.converter.TaskConverter;
import com.xiaohei.common.exception.BizException;
import com.xiaohei.repository.po.Integral;
import com.xiaohei.repository.po.Task;
import com.xiaohei.repository.query.TaskPageQuery;
import com.xiaohei.repository.service.IntegralRpService;
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
import java.util.List;
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
    @Resource
    private IntegralRpService integralRpService;

    @Override
    public Boolean addTask(AddTaskRequest request) {
        if (Objects.isNull(request)) {
            log.warn("addTask.taskModel is null");
            return false;
        }
        //task
        Task task = buildTask(request);
        log.info("PO.Task:{}", JSON.toJSONString(task));
        Long taskId = task.getId();
        //integral
        Integral integral = buildIntegral(taskId, request);
        log.info("PO.Integral:{}", JSON.toJSONString(integral));
        return taskRpService.saveTaskWithIntegral(task, integral);
    }

    @Override
    public PageVO<TaskVO> getTaskPage(TaskPageQuery taskPageQuery) {
        Page<Task> page = taskRpService.getTaskPage(taskPageQuery);
        List<Task> records = page.getRecords();
        List<TaskVO> taskVOS = TaskConverter.INSTANCE.POToPageVO(records);
        return PageVO.convert(page, taskVOS);
    }

    @Override
    public Boolean editTask(EditTaskRequest request) {
        request.validRequest();
        Task task = taskRpService.getById(request.getTaskId());
        if (Objects.isNull(task)) {
            throw new BizException(TaskErrorEnum.TASK_NOT_EXIST);
        }
        if (task.getVersion().equals(request.getVersion())) {
            throw new BizException(TaskErrorEnum.TASK_OPTIMISTIC_LOCKING_ERROR);
        }
        task.setStartTime(request.getStartTime());
        task.setEndTime(request.getEndTime());
        task.setModifier(Optional.ofNullable(request.getModifier()).orElse(ValueConstants.default_modifier));
        task.setUpdateTime(LocalDateTime.now());
        task.setContent(request.getContent());
        if (MapUtils.isNotEmpty(request.getExtendMap())) {
            task.setFeatures(JSON.toJSONString(request.getExtendMap()));
        }
        if (Objects.isNull(request.getStatus()) || request.getStatus()) {
            task.setStatus(ValueConstants.valid);
        } else {
            task.setStatus(ValueConstants.invalid);
        }
        task.setVersion(task.getVersion() + 1);
        Integral integral = integralRpService.getByTaskId(task.getId());
        if (Objects.nonNull(integral)) {
            integral.setQuantity(request.getIntegral());
            integral.setUpdateTime(LocalDateTime.now());
            integral.setModifier(request.getModifier());
            integral.setVersion(integral.getVersion() + 1);
        }
        return taskRpService.updateTaskWithIntegral(task, integral);
    }

    private Task buildTask(AddTaskRequest request) {
        Task task = new Task();
        TaskTypeEnum typeEnum = TaskTypeEnum.getByCode(request.getType());
        task.setId(IdWorker.getId());
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
        task.setStartTime(Optional.ofNullable(request.getStartTime()).orElse(LocalDateTime.of(2022, 7, 10, 15, 36)));
        task.setEndTime(Optional.ofNullable(request.getEndTime()).orElse(LocalDateTime.of(2022, 7, 10, 15, 36)));
        task.setIsDeleted(ValueConstants.undelete);
        task.setVersion(ValueConstants.init_version);
        return task;
    }

    private Integral buildIntegral(Long taskId, AddTaskRequest request) {
        Integral integral = new Integral();
        integral.setTaskId(taskId);
        integral.setQuantity(request.getIntegral());
        integral.setStatus(ValueConstants.valid);
        integral.setCreator(request.getCreator());
        integral.setModifier(request.getCreator());
        integral.setCreateTime(LocalDateTime.now());
        integral.setUpdateTime(LocalDateTime.now());
        integral.setIsDeleted(ValueConstants.undelete);
        integral.setVersion(ValueConstants.init_version);
        return integral;
    }
}
