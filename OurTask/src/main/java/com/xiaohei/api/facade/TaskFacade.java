package com.xiaohei.api.facade;

import com.xiaohei.api.request.AddTaskRequest;
import com.xiaohei.common.model.JsonResult;

/**
 * Created by cc on 2022/7/3
 */

public interface TaskFacade {

    JsonResult<Boolean> addTask(AddTaskRequest request);

}
