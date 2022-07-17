package com.xiaohei.service.impl;

import com.xiaohei.api.request.CompleteTaskRequest;
import com.xiaohei.api.request.ReceiveTaskRequest;
import com.xiaohei.repository.po.Relation;
import com.xiaohei.repository.service.RelationRpService;
import com.xiaohei.service.RelationService;
import com.xiaohei.service.common.enums.DeleteEnum;
import com.xiaohei.service.common.enums.RelationTypeEnum;
import com.xiaohei.service.common.enums.TaskStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;

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
        request.verifyRequest();
        Boolean receive = request.getReceive();
        Relation relation = new Relation();
        relation.setType(RelationTypeEnum.task_human.getCode());
        relation.setMaster(request.getTaskId());
        relation.setSlave(request.getRecipient());
        if (receive) {
            relation.setStatus(TaskStatusEnum.received.getCode());
        } else {
            relation.setStatus(TaskStatusEnum.refused.getCode());
        }
        relation.setCreator(request.getRecipient());
        relation.setModifier(request.getRecipient());
        relation.setCreateTime(LocalDateTime.now());
        relation.setUpdateTime(LocalDateTime.now());
        relation.setIsDeleted(DeleteEnum.undelete.getCode());
        return relationRpService.save(relation);
    }

    @Override
    public Boolean completeTask(CompleteTaskRequest request) {
        request.verifyRequest();
        Relation relation = relationRpService.getByTaskIdAndType(request.getTaskId(), RelationTypeEnum.task_human.getCode());
        if (Objects.nonNull(relation)) {
            relation.setModifier(request.getRecipient());
            relation.setStatus(TaskStatusEnum.completed.getCode());
            relation.setUpdateTime(LocalDateTime.now());
            relation.setVersion(relation.getVersion() + 1);
        }
        return relationRpService.updateById(relation);
    }
}
