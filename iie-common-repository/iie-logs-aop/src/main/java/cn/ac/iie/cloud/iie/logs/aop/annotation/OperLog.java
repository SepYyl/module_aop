package cn.ac.iie.cloud.iie.logs.aop.annotation;

import java.lang.annotation.*;

/**
 * @className: com.sep.grafana.aop.OperLog
 * @author: sepY
 * @create: 2023-03-20 10:31
 * @description: 日志操作注解
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented
public @interface OperLog {
//    String operModul() default ""; // 操作模块前端传参接收
//    String operType() default "";  // 操作类型
    String operDesc() default "";  // 操作说明
}