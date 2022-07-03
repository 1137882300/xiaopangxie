package com.xiaohei.controller;

import com.xiaohei.api.request.TaskAddRequest;
import com.xiaohei.common.model.JsonResult;
import com.xiaohei.api.facade.TaskFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-03
 */
@Controller
@RequestMapping("/task")
public class TaskController implements TaskFacade {

    @Override
    public JsonResult<Boolean> addTask(TaskAddRequest request) {
        return null;
    }
}
