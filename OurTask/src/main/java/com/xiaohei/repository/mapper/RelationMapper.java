package com.xiaohei.repository.mapper;

import com.xiaohei.repository.po.Relation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 关联关系表 Mapper 接口
 * </p>
 *
 * @author xiao-pang
 * @since 2022-07-10
 */
public interface RelationMapper extends BaseMapper<Relation> {

    Relation getByTaskIdAndType(@Param("taskId") Long taskId, @Param("type") String type);
}
