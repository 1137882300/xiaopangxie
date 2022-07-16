package com.xiaohei.repository.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohei.repository.po.Integral;
import com.xiaohei.repository.po.Task;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohei.repository.query.TaskPageQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-10
 */
public interface TaskRpService extends IService<Task> {

    Page<Task> getTaskPage(TaskPageQuery taskPageQuery);

    Boolean saveTaskWithIntegral(Task task, Integral integral);

    Boolean updateTaskWithIntegral(Task task, Integral integral);
}
