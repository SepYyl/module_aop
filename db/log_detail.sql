/*
 Navicat Premium Data Transfer

 Source Server         : local_3306
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : iie

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 23/03/2023 18:28:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log_detail
-- ----------------------------
DROP TABLE IF EXISTS `log_detail`;
CREATE TABLE `log_detail`  (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `time` datetime(5) NULL DEFAULT NULL COMMENT '时间\r\n',
  `func_view` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '功能界面',
  `oper_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作详情',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '登录IP',
  `operators` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log_detail
-- ----------------------------
INSERT INTO `log_detail` VALUES (1, '2023-03-20 00:00:00.00000', 'grafana', '增加日志', NULL, NULL);
INSERT INTO `log_detail` VALUES (2, '2023-03-20 00:00:00.00000', '设备管理界面', '系统设备管理界面展示一条信息', '/grafanas/grafanaPage', NULL);
INSERT INTO `log_detail` VALUES (3, '2023-03-20 00:00:00.00000', '设备管理界面', '系统设备管理界面展示一条信息', '0:0:0:0:0:0:0:1', NULL);
INSERT INTO `log_detail` VALUES (4, '2023-03-20 00:00:00.00000', '设备管理界面', '系统设备管理界面展示一条信息', '0:0:0:0:0:0:0:1', NULL);
INSERT INTO `log_detail` VALUES (5, '2023-03-20 00:00:00.00000', '设备管理界面', '系统设备管理界面展示一条信息', '0:0:0:0:0:0:0:1', NULL);
INSERT INTO `log_detail` VALUES (6, '2023-03-20 00:00:00.00000', '设备管理界面', '系统设备管理界面展示一条信息', '127.0.0.1', NULL);
INSERT INTO `log_detail` VALUES (7, '2023-03-23 17:20:41.00000', NULL, '系统设备管理界面展示一条信息', '127.0.0.1', NULL);
INSERT INTO `log_detail` VALUES (8, '2023-03-23 18:18:14.00000', NULL, '系统设备管理界面展示一条信息', '127.0.0.1', NULL);

SET FOREIGN_KEY_CHECKS = 1;
