package cn.ac.iie.cloud.iie.logs.aop.handle;

import cn.ac.iie.cloud.iie.logs.aop.annotation.OperLog;
import cn.ac.iie.cloud.iie.logs.aop.constant.FuncViewStatus;
import cn.ac.iie.cloud.iie.logs.aop.service.LogService;
import cn.ac.iie.cloud.iie.logs.aop.vo.LogDetail;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: com.sep.grafana.aop.OperLogsAspect
 * @author: sepY
 * @create: 2023-03-20 15:25
 * @description: aop切片操作
 */
@Slf4j
@Aspect
@Component
public class OperLogsAspect {
	//然后spring管理 注解注入
	@Resource
    private LogService logService;

//    public OperLogsAspect(LogService logService) {
//        this.logService = logService;
//    }

    /**
     * 设置操作日志切入点 记录操作日志切入的位置
     */
    @Pointcut("@annotation( cn.ac.iie.cloud.iie.logs.aop.annotation.OperLog)")
    public void  monitorAnnotatedMethods(){}

    @Pointcut("execution(* *(..))")
    public void monitorAllMethods() {}

    @Pointcut("monitorAnnotatedMethods() && monitorAllMethods()")
    public void openLogPointCut(){}

    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
     *
     * @param joinPoint 切入点
     * @param keys      返回结果
     */
    @AfterReturning(value = "openLogPointCut()", returning = "keys")
    public void saveOperLog(JoinPoint joinPoint, Object keys) {
		log.info("你好");

        /**
         * id:自动生成
         * time:切片获取
         * funcView:前端传参获取
         * operDesc:后端手动上传,反射获取
         * ip:RequestAttributes中获取
         * operators:RequestAttributes中获取/获取前端传参
         */
        // 日志记录类
        LogDetail logDetail = new LogDetail();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        // 1.获取当前时间
        logDetail.setTime(time);

        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String addr = request.getRemoteAddr();
        // 2.获取ip
        logDetail.setIp(addr);

        // 从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取切入点所在的方法
        Method method = signature.getMethod();
        // 3.获取操作描述
        OperLog opLog = method.getAnnotation(OperLog.class);
        if (opLog != null) {
            logDetail.setOperDesc(opLog.operDesc());
        }
        // 4.传递的参数
        Map<String, String> maps = converMap(request.getParameterMap());
		if (!maps.isEmpty()){
			Integer funcViewCode = Integer.valueOf(maps.get("funcView"));
			FuncViewStatus viewStatus = FuncViewStatus.getByCode(funcViewCode);
			if (viewStatus != null){
				logDetail.setFuncView(viewStatus.getFuncView());
			}
		}else {
			logDetail.setFuncView(null);
		}


        boolean save = logService.save(logDetail);
        if (save){
            log.info("插入日志成功");
        }else {
            throw new RuntimeException();
        }
    }

    /**
     * 转换request 请求参数
     *
     * @param paramMap request获取的参数数组
     */
    public Map<String, String> converMap(Map<String, String[]> paramMap) {
        Map<String, String> rtnMap = new HashMap<String, String>();
        for (String key : paramMap.keySet()) {
            rtnMap.put(key, paramMap.get(key)[0]);
        }
        return rtnMap;
    }
}

