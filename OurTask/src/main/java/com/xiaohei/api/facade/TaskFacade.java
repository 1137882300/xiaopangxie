package com.xiaohei.api.facade;

import com.xiaohei.api.request.*;
import com.xiaohei.api.vo.PageVO;
import com.xiaohei.api.vo.TaskVO;
import com.xiaohei.common.model.JsonResult;

/**
 * Created by cc on 2022/7/3
 */

public interface TaskFacade {
    /**
     * 添加任务
     *
     * @param request
     * @return
     */
    JsonResult<Boolean> addTask(AddTaskRequest request);

    /**
     * 任务分页查询
     *
     * @param request
     * @return
     */
    JsonResult<PageVO<TaskVO>> getTaskPage(TaskPageRequest request);

    /**
     * 1. 编辑任务
     * 2. 失效任务
     *
     * @param request
     * @return
     */
    JsonResult<Boolean> editTask(EditTaskRequest request);

    /**
     * 领取任务
     *
     * @param request
     * @return
     */
    JsonResult<Boolean> receiveTask(ReceiveTaskRequest request);

    /**
     * 完成任务
     *
     * @param request
     * @return
     */
    JsonResult<Boolean> completeTask(CompleteTaskRequest request);
}
