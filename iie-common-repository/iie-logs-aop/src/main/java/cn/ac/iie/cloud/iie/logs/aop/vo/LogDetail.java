package cn.ac.iie.cloud.iie.logs.aop.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: com.sep.grafana.vo.LogDetail
 * @author: sepY
 * @create: 2023-03-20 10:53
 * @description: 日志记录
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("log_detail")
public class LogDetail {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private  String time;
    private  String funcView;
    private  String operDesc;
    private  String ip;
    private  String operators;

}
