package com.xiaohei.service;

import com.xiaohei.api.request.CompleteTaskRequest;
import com.xiaohei.api.request.ReceiveTaskRequest;

/**
 * Created by cc on 2022/7/16
 */
public interface RelationService {

    Boolean receiveTask(ReceiveTaskRequest request);

    Boolean completeTask(CompleteTaskRequest request);
}
