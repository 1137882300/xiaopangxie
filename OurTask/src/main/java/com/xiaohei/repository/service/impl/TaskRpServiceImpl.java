package com.xiaohei.repository.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohei.repository.mapper.IntegralMapper;
import com.xiaohei.repository.po.Integral;
import com.xiaohei.repository.po.Task;
import com.xiaohei.repository.mapper.TaskMapper;
import com.xiaohei.repository.query.TaskPageQuery;
import com.xiaohei.repository.service.TaskRpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohei.service.common.constant.ValueConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-10
 */
@Service
public class TaskRpServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskRpService {

    @Resource
    private TaskMapper taskMapper;
    @Resource
    private IntegralMapper integralMapper;

    @Override
    public Page<Task> getTaskPage(TaskPageQuery query) {
        Page<Task> page = new Page<>(query.getCurrent(), query.getSize());
        page.setRecords(taskMapper.getTaskPage(page, query));
        return page;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean saveTaskWithIntegral(Task task, Integral integral) {
        int insertTask = taskMapper.insert(task);
        int insertIntegral = integralMapper.insert(integral);
        return insertTask + insertIntegral == ValueConstants.affect_tWo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateTaskWithIntegral(Task task, Integral integral) {
        int updateTask = taskMapper.updateById(task);
        int updateIntegral = integralMapper.updateById(integral);
        return updateTask + updateIntegral == ValueConstants.affect_tWo;
    }
}
