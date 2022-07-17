package com.xiaohei.repository.service;

import com.xiaohei.repository.po.Relation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 关联关系表 服务类
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-10
 */
public interface RelationRpService extends IService<Relation> {

    Relation getByTaskIdAndType(Long taskId, String type);
}
