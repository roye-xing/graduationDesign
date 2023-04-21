/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : stars

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 24/02/2023 22:42:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for checkb
-- ----------------------------
DROP TABLE IF EXISTS `checkb`;
CREATE TABLE `checkb`  (
  `id` char(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `time` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `requester` char(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '请求方ID',
  `type` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '类型',
  `phone` varchar(13) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `accept1` tinyint(1) NULL DEFAULT NULL COMMENT '请求1(用户)',
  `accept2` tinyint(1) NULL DEFAULT NULL COMMENT '请求2(HR)',
  `accept3` tinyint(1) NULL DEFAULT NULL COMMENT '请求3(备用)',
  `msg` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `uuid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'UUID'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checkb
-- ----------------------------
INSERT INTO `checkb` VALUES ('1233333', '2023-02-19 17:24:47', '123456', '联系方式', NULL, NULL, 1, NULL, NULL, NULL, '9e9fa3005f9d4c4e8829daabbff43085');
INSERT INTO `checkb` VALUES ('1233333', '2023-02-19 17:28:14', '123456', '录用', NULL, NULL, 1, 1, 1, NULL, '9e9fa3005f9d4c4e8829daabbff43087');
INSERT INTO `checkb` VALUES ('1233333', '2023-02-20 12:14:22', '123456', '录用', NULL, NULL, NULL, 1, NULL, NULL, '93aae1e5f18d4ae4b19109fdf017a81d');
INSERT INTO `checkb` VALUES ('1233333', '2023-02-20 15:10:08', 'woshihr', '录用', NULL, NULL, NULL, 1, NULL, NULL, '54db720bf9a44475990cc2be26ffafd7');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公司编号(6位UUID码)',
  `name` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司名称',
  `tel` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司电话',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('3Wp621SL', '广东潜力无限公司', '07572817654', '广东省xx市xx区');
INSERT INTO `company` VALUES ('X1Tov7xU', 'yyy公司', '07571111111', '广东省xx市xx区');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `no` char(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '部门编号',
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `company_id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司编号',
  PRIMARY KEY (`no`) USING BTREE,
  INDEX `company_id`(`company_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('01', '计信系', NULL);
INSERT INTO `department` VALUES ('02', '会计系', NULL);
INSERT INTO `department` VALUES ('03', '经济系', NULL);
INSERT INTO `department` VALUES ('04', '财政系', NULL);
INSERT INTO `department` VALUES ('05', '金融系', NULL);

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate`  (
  `id` char(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '职工编号',
  `old_evaluate` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '过往雇主评价',
  `old_works` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '就职经历',
  `self_evaluate` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '自我评价',
  `hr_evaluate` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'HR评价',
  `self_score` int UNSIGNED NULL DEFAULT 0 COMMENT '自我评分',
  `hr_score` int UNSIGNED NULL DEFAULT 0 COMMENT 'HR评分',
  `old_score` int UNSIGNED NULL DEFAULT 0 COMMENT '过往评分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('1111111', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真\r\rtest\rtest\rtest', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师\r\n2010年1月20日-2013年3月15日 阿里巴巴 c++全栈师', '工作环境好一些。自我感觉良好', 'test', 80, 90, 80);
INSERT INTO `evaluate` VALUES ('1111112', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', NULL, 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111113', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真\n', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师\n', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111114', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111115', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真\rtest', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', 20, 0, 0);
INSERT INTO `evaluate` VALUES ('1111116', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111117', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水平有待提升', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111118', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '希望工作轻松一些，工作态度认真，责任感强。', '业务水平很棒', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111119', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '可以接受加班。', '人机交往能力强', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111120', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真\n', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师\n', '工作态度认真，责任感强。', '工作态度一般', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111121', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '工作态度良好', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111122', ' 2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', ' 工作态度认真，责任感强。', ' 业务水水平高，交际能力强。', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111123', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111124', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111125', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', ' 工作态度认真，责任感强。', ' 业务水水平高，交际能力强。', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111126', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111127', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111128', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111129', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('1111130', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', 0, 0, 0);
INSERT INTO `evaluate` VALUES ('role', NULL, NULL, NULL, NULL, 0, 0, 0);
INSERT INTO `evaluate` VALUES ('role1', NULL, NULL, NULL, NULL, 0, 0, 0);

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `id` char(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '编号',
  `name` char(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` char(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `department` char(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所在部门（编号）',
  `birth` date NULL DEFAULT NULL COMMENT '出生日期',
  `salary` decimal(7, 2) NULL DEFAULT NULL COMMENT '基本工资',
  `perks` decimal(7, 2) NULL DEFAULT NULL COMMENT '岗位津贴',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `department`(`department`) USING BTREE,
  CONSTRAINT `department` FOREIGN KEY (`department`) REFERENCES `department` (`no`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1111111', '高乐音', '男', '01', '1988-06-21', 4210.00, 1830.00);
INSERT INTO `staff` VALUES ('1111112', '石初曼', '女', '05', '1967-05-17', 2310.00, 1830.00);
INSERT INTO `staff` VALUES ('1111113', '高欣瑶', '女', '02', '1988-04-09', 5000.00, 2000.00);
INSERT INTO `staff` VALUES ('1111114', '陆雨信', '男', '03', '1991-09-13', 2110.00, 2410.00);
INSERT INTO `staff` VALUES ('1111115', '白香彤', '女', NULL, '2000-10-12', NULL, NULL);
INSERT INTO `staff` VALUES ('1111116', '向玉宇', '男', '01', '1989-04-09', 6300.00, 1200.00);
INSERT INTO `staff` VALUES ('1111117', '林东卉', '女', '02', '1996-04-09', 4500.00, 3200.00);
INSERT INTO `staff` VALUES ('1111118', '孔弘济', '男', '03', '1999-04-09', 2500.00, 2300.00);
INSERT INTO `staff` VALUES ('1111119', '刘如松', '女', '04', '1986-04-09', 4600.00, 3600.00);
INSERT INTO `staff` VALUES ('1111120', '杜立强', '男', '05', '1998-04-09', 8200.00, 1400.00);
INSERT INTO `staff` VALUES ('1111121', '张元彤', '女', '01', '1995-04-09', 5200.00, 2500.00);
INSERT INTO `staff` VALUES ('1111122', '万明辉', '男', '01', '1926-02-02', 3500.00, 2300.00);
INSERT INTO `staff` VALUES ('1111123', '邱迎海', '男', '02', '1994-06-16', 6240.00, 2520.00);
INSERT INTO `staff` VALUES ('1111124', '刘晗灵', '女', '05', '1997-07-18', 3600.00, 2500.00);
INSERT INTO `staff` VALUES ('1111125', '黄士极', '男', '01', '2000-02-29', 8850.00, 6220.00);
INSERT INTO `staff` VALUES ('1111126', '金阳', '女', '04', '1998-05-16', 2000.00, 1234.00);
INSERT INTO `staff` VALUES ('1111127', '杜立强', '男', '03', '1995-03-21', 3240.00, 2230.00);
INSERT INTO `staff` VALUES ('1111128', '刘如松', '男', '02', '2001-04-19', 6210.00, 2130.00);
INSERT INTO `staff` VALUES ('1111129', '金丹琴', '女', '01', '1992-05-20', 3800.00, 1200.00);
INSERT INTO `staff` VALUES ('1111130', '石楚曼', '女', '04', '1995-03-17', 9500.00, 2300.00);
INSERT INTO `staff` VALUES ('role', '罗xx', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for takeoff
-- ----------------------------
DROP TABLE IF EXISTS `takeoff`;
CREATE TABLE `takeoff`  (
  `id` char(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编号',
  `type` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请假类型',
  `reg_time` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `back_time` datetime NULL DEFAULT NULL COMMENT '返回时间',
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请假原因',
  `hr_check` int NULL DEFAULT 0 COMMENT 'hr批准',
  `hr_msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'hr留言',
  `leader_check` int NULL DEFAULT 0 COMMENT '领导批准',
  `leader_msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '领导留言',
  `uuid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一识别码',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of takeoff
-- ----------------------------
INSERT INTO `takeoff` VALUES ('1111111', '病假', '2023-02-24 22:15:00', '2023-02-25 22:15:00', '感冒头疼', 0, NULL, 0, NULL, '81ae59a7a4ec47cc8ef1492e95b2d957');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` char(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `usertype` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `nickname` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `company_id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所属组织编号',
  `email` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(13) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `secrecy` tinyint(1) NULL DEFAULT 0 COMMENT '是否公开(1保密，0公开)',
  PRIMARY KEY (`username`) USING BTREE,
  INDEX `company_id`(`company_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1111111', '42f992e41a2f1492d1c1adad83afb4a6', 'staff', '1111111', 'X1Tov7xU', '1819849032@qq.com', '1589874552601', 1);
INSERT INTO `users` VALUES ('1111112', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111113', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111114', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111115', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, NULL, '987654321@gmail.com', '135877402', 1);
INSERT INTO `users` VALUES ('1111116', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111117', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111118', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111119', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111120', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111121', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111122', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111123', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111124', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111125', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111126', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111127', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111128', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111129', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111130', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('123456', '8184a5fe3bd3a16d072cfc6bcceab2cf', 'hr', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('7895002', '42f992e41a2f1492d1c1adad83afb4a6', 'staff', NULL, NULL, NULL, NULL, 0);
INSERT INTO `users` VALUES ('admin', '42f992e41a2f1492d1c1adad83afb4a6', 'admin', NULL, NULL, NULL, NULL, 0);
INSERT INTO `users` VALUES ('role', '32bf3a7374966e09681e3bd729c2b033', 'staff', NULL, NULL, '1819849032@qq.com', '13450785335', 1);
INSERT INTO `users` VALUES ('test', '5a0ebe476f44cfdf16667228bd2d9457', 'leader', NULL, '3Wp621SL', NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
