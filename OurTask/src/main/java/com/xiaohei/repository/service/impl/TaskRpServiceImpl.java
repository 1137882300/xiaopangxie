package com.xiaohei.repository.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohei.repository.po.Task;
import com.xiaohei.repository.mapper.TaskMapper;
import com.xiaohei.repository.query.TaskPageQuery;
import com.xiaohei.repository.service.TaskRpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-10
 */
@Service
public class TaskRpServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskRpService {

    @Override
    public Page<Task> getTaskPage(TaskPageQuery query) {
        Page<Task> page = new Page<>(query.getCurrent(), query.getSize());
        page.setRecords(baseMapper.getTaskPage(page, query));
        return page;
    }
}
