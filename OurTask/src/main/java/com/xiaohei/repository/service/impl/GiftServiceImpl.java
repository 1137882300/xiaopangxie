package com.xiaohei.repository.service.impl;

import com.xiaohei.repository.po.Gift;
import com.xiaohei.repository.mapper.GiftMapper;
import com.xiaohei.repository.service.IGiftService;
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
public class GiftServiceImpl extends ServiceImpl<GiftMapper, Gift> implements IGiftService {

}
