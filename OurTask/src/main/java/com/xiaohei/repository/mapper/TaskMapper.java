package com.xiaohei.repository.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohei.repository.po.Task;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohei.repository.query.TaskPageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-10
 */
public interface TaskMapper extends BaseMapper<Task> {

    List<Task> getTaskPage(Page<Task> page, @Param("query") TaskPageQuery query);
}
