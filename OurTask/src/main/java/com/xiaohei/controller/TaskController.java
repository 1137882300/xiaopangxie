package com.xiaohei.controller;

import com.xiaohei.api.facade.TaskFacade;
import com.xiaohei.api.request.AddTaskRequest;
import com.xiaohei.common.model.JsonResult;
import com.xiaohei.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-10
 */
@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController implements TaskFacade {

    @Resource
    private TaskService taskService;


    @PostMapping("/addTask")
    public JsonResult<Boolean> addTask(@Valid AddTaskRequest request) {
        return JsonResult.success(taskService.addTask(request));
    }


}
