package com.xiaohei.api.facade;

import com.xiaohei.api.request.TaskAddRequest;
import com.xiaohei.common.model.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cc on 2022/7/3
 */

public interface TaskFacade {

    JsonResult<Boolean> addTask(TaskAddRequest request);

}
