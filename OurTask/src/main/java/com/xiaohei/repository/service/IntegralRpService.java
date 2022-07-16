package com.xiaohei.repository.service;

import com.xiaohei.repository.po.Integral;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-10
 */
public interface IntegralRpService extends IService<Integral> {

    Integral getByTaskId(Long taskId);
}
