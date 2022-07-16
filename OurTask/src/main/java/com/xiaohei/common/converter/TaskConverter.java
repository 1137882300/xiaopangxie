package com.xiaohei.common.converter;

import com.xiaohei.api.request.AddTaskRequest;
import com.xiaohei.api.request.TaskPageRequest;
import com.xiaohei.api.vo.TaskVO;
import com.xiaohei.repository.po.Task;
import com.xiaohei.repository.query.TaskPageQuery;
import com.xiaohei.service.common.model.TaskModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by cc on 2022/7/10
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskConverter {

    TaskConverter INSTANCE = Mappers.getMapper(TaskConverter.class);


    TaskPageQuery requestToPageQuery(TaskPageRequest request);

    List<TaskVO> POToPageVO(List<Task> taskList);

    @Mappings({
            @Mapping(target = "", source = ""),
    })
    TaskModel requestToModel(AddTaskRequest request);


    @Mappings({
            @Mapping(source = "", target = ""),
    })
    Task modelToPo(TaskModel taskModel);




}
