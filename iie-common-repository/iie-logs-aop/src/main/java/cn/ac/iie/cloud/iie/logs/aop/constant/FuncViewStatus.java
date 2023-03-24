package cn.ac.iie.cloud.iie.logs.aop.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @className: com.sep.grafana.enums.FuncViewEnum
 * @author: sepY
 * @create: 2023-03-20 15:07
 * @description: 操作页面枚举
 */
@Getter
@AllArgsConstructor
public enum FuncViewStatus {
    /**
     * 前端传参 后端接收
     */
    LOGIN("登录界面",0),
    CONVENTIONAL_VPN("常规vpn界面",1),
    ENCRYPTION_VPN("加密vpn界面",2),
    CONVENTIONAL_VPN_VERIFY("常规vpn核实界面",3),
    ENCRYPTION_VPN_VERIFY("加密vpn核实界面",4),
    CONVENTIONAL_VPN_LOG("常规vpn日志界面",5),
    ENCRYPTION_VPN_LOG("加密vpn日志界面",6),
    USER_DATA("用户数据管理界面",7),
    SERVICE_DATA("业务数据管理界面",8),
    EXCEL_EXPORT_DATA("人员管理界面",9),
    OPERATION_LOG("操作日志界面",10),
    USRE("用户管理界面",11),
    ROLE("角色管理界面",12),
    DEVICE("设备管理界面",13);
    String funcView;
    Integer code;

    public static FuncViewStatus getByCode(int code) {
        for (FuncViewStatus it : FuncViewStatus.values()) {
            if (it.getCode() == code) {
                return it;
            }
        }
        return null;
    }
}
