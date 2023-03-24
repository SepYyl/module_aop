package cn.ac.iie.cloud.iie.logs.aop.dao;

import cn.ac.iie.cloud.iie.logs.aop.vo.LogDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: com.sep.grafana.dao.logMapper
 * @author: sepY
 * @create: 2023-03-20 10:59
 * @description: mapper
 */
@Mapper
public interface LogMapper extends BaseMapper<LogDetail> {
}
