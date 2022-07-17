package com.xiaohei.repository.service.impl;

import com.xiaohei.repository.po.Relation;
import com.xiaohei.repository.mapper.RelationMapper;
import com.xiaohei.repository.service.RelationRpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 关联关系表 服务实现类
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-10
 */
@Service
public class RelationRpServiceImpl extends ServiceImpl<RelationMapper, Relation> implements RelationRpService {

    @Resource
    private RelationMapper relationMapper;

    @Override
    public Relation getByTaskIdAndType(Long taskId, String type) {
        return relationMapper.getByTaskIdAndType(taskId, type);
    }
}
