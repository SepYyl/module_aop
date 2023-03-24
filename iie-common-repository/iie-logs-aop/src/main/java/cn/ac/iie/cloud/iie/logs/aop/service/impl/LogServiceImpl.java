package cn.ac.iie.cloud.iie.logs.aop.service.impl;

import cn.ac.iie.cloud.iie.logs.aop.dao.LogMapper;
import cn.ac.iie.cloud.iie.logs.aop.service.LogService;
import cn.ac.iie.cloud.iie.logs.aop.vo.LogDetail;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @className: com.sep.grafana.service.logService
 * @author: sepY
 * @create: 2023-03-20 11:00
 * @description: impl
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, LogDetail> implements LogService {
}
