package com.xiaohei.service;

import com.xiaohei.api.request.AddTaskRequest;
import com.xiaohei.api.request.EditTaskRequest;
import com.xiaohei.api.vo.PageVO;
import com.xiaohei.api.vo.TaskVO;
import com.xiaohei.repository.query.TaskPageQuery;

/**
 * Created by cc on 2022/7/10
 */
public interface TaskService {

    Boolean addTask(AddTaskRequest request);

    PageVO<TaskVO> getTaskPage(TaskPageQuery taskPageQuery);

    Boolean editTask(EditTaskRequest request);
}
