package com.xiaohei.repository.service.impl;

import com.xiaohei.repository.po.Relation;
import com.xiaohei.repository.mapper.RelationMapper;
import com.xiaohei.repository.service.IRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 关联关系表 服务实现类
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-10
 */
@Service
public class RelationServiceImpl extends ServiceImpl<RelationMapper, Relation> implements IRelationService {

}
