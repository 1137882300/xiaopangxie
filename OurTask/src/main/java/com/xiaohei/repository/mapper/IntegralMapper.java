package com.xiaohei.repository.mapper;

import com.xiaohei.repository.po.Integral;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-10
 */
public interface IntegralMapper extends BaseMapper<Integral> {

    Integral getByTaskId(@Param("taskId") Long taskId);
}
