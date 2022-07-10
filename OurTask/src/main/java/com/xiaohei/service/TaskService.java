package com.xiaohei.service;

import com.xiaohei.api.request.AddTaskRequest;

/**
 * Created by cc on 2022/7/10
 */
public interface TaskService {

    Boolean addTask(AddTaskRequest request);

}
