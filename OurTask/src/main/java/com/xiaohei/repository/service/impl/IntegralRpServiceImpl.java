package com.xiaohei.repository.service.impl;

import com.xiaohei.repository.po.Integral;
import com.xiaohei.repository.mapper.IntegralMapper;
import com.xiaohei.repository.service.IntegralRpService;
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
public class IntegralRpServiceImpl extends ServiceImpl<IntegralMapper, Integral> implements IntegralRpService {

    @Override
    public Integral getByTaskId(Long taskId) {
        return baseMapper.getByTaskId(taskId);
    }
}
