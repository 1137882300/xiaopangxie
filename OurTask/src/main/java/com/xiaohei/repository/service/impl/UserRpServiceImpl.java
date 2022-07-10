package com.xiaohei.repository.service.impl;

import com.xiaohei.repository.po.User;
import com.xiaohei.repository.mapper.UserMapper;
import com.xiaohei.repository.service.UserRpService;
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
public class UserRpServiceImpl extends ServiceImpl<UserMapper, User> implements UserRpService {

}
