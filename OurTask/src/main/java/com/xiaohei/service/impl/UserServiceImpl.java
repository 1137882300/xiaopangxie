package com.xiaohei.service.impl;

import com.xiaohei.po.User;
import com.xiaohei.mapper.UserMapper;
import com.xiaohei.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private void tt(){
        System.out.println("sss");
    }
}
