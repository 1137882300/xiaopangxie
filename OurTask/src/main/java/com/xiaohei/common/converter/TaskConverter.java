package com.xiaohei.common.converter;

import com.xiaohei.api.request.AddTaskRequest;
import com.xiaohei.repository.po.Task;
import com.xiaohei.service.common.model.TaskModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Created by cc on 2022/7/10
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskConverter {

    TaskConverter INSTANCE = Mappers.getMapper(TaskConverter.class);

    @Mappings({
            @Mapping(target = "", source = ""),
    })
    TaskModel requestToModel(AddTaskRequest request);


    @Mappings({
            @Mapping(source = "", target = ""),
    })
    Task modelToPo(TaskModel taskModel);




}
