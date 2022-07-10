package com.xiaohei.controller;

import com.xiaohei.api.facade.TaskFacade;
import com.xiaohei.api.request.AddTaskRequest;
import com.xiaohei.api.request.TaskPageRequest;
import com.xiaohei.api.vo.PageVO;
import com.xiaohei.api.vo.TaskVO;
import com.xiaohei.common.converter.TaskConverter;
import com.xiaohei.common.model.JsonResult;
import com.xiaohei.repository.query.TaskPageQuery;
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
    @Override
    public JsonResult<Boolean> addTask(@Valid AddTaskRequest request) {
        return JsonResult.success(taskService.addTask(request));
    }

    @PostMapping("/getTaskPage")
    @Override
    public JsonResult<PageVO<TaskVO>> getTaskPage(TaskPageRequest request) {
        TaskPageQuery taskPageQuery = TaskConverter.INSTANCE.requestToPageQuery(request);
        return JsonResult.success(taskService.getTaskPage(taskPageQuery));
    }


}
