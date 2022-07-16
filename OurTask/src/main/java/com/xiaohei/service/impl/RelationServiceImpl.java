package com.xiaohei.service.impl;

import com.xiaohei.api.request.CompleteTaskRequest;
import com.xiaohei.api.request.ReceiveTaskRequest;
import com.xiaohei.repository.service.RelationRpService;
import com.xiaohei.service.RelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by cc on 2022/7/16
 */
@Slf4j
@Service
public class RelationServiceImpl implements RelationService {

    @Resource
    private RelationRpService relationRpService;

    @Override
    public Boolean receiveTask(ReceiveTaskRequest request) {
        return null;
    }

    @Override
    public Boolean completeTask(CompleteTaskRequest request) {
        return null;
    }
}
