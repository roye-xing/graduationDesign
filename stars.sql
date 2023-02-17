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

 Date: 18/02/2023 00:03:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for checkb
-- ----------------------------
DROP TABLE IF EXISTS `checkb`;
CREATE TABLE `checkb`  (
  `bh` char(7) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '编号',
  `xm` char(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `xb` char(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `bm` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `csrq` datetime NULL DEFAULT NULL COMMENT '出生日期',
  `jbgz` decimal(7, 2) NULL DEFAULT NULL COMMENT '基本工资',
  `gwjt` decimal(7, 2) NULL DEFAULT NULL COMMENT '岗位津贴',
  `gwpj` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '过往雇主评价',
  `jzjl` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '就职经历',
  `zwpj` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '自我评价\r\n',
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `usertype` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`bh`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公司编号(6位UUID码)',
  `name` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司名称',
  `tel` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司电话',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司地址',
  `edit_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('3Wp621SL', '广东潜力无限公司', '07572817654', '广东省xx市xx区', NULL);
INSERT INTO `company` VALUES ('X1Tov7xU', 'xxx公司', '07571111111', '广东省xx市xx区', NULL);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `no` char(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '部门编号',
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `company_id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司编号',
  PRIMARY KEY (`no`) USING BTREE,
  INDEX `company_id`(`company_id`) USING BTREE,
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
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
  `id` char(7) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '职工编号',
  `old_evaluate` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '过往雇主评价',
  `old_works` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '就职经历',
  `self_evaluate` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '自我评价',
  `hr_evaluate` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'HR评价',
  `self_score` int NULL DEFAULT NULL COMMENT '自我评分',
  `hr_score` int NULL DEFAULT NULL COMMENT 'HR评分',
  `old_score` int NULL DEFAULT NULL COMMENT '过往评分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('1111111', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真\r\rtest\rtest\rtest', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师\r\n2010年1月20日-2013年3月15日 阿里巴巴 c++全栈师', '工作环境好一些。自我感觉良好', 'test', 80, 90, 80);
INSERT INTO `evaluate` VALUES ('1111112', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', NULL, NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111113', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真\n', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师\n', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111114', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111115', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真\rtest', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111116', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111117', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水平有待提升', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111118', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '希望工作轻松一些，工作态度认真，责任感强。', '业务水平很棒', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111119', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '可以接受加班。', '人机交往能力强', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111120', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真\n', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师\n', '工作态度认真，责任感强。', '工作态度一般', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111121', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '工作态度良好', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111122', ' 2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', ' 工作态度认真，责任感强。', ' 业务水水平高，交际能力强。', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111123', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111124', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111125', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', ' 工作态度认真，责任感强。', ' 业务水水平高，交际能力强。', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111126', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111127', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111128', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111129', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', NULL, NULL, NULL);
INSERT INTO `evaluate` VALUES ('1111130', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师 工作优异 态度认真', '2010年1月20日-2013年3月15日 阿里巴巴 Java全栈师', '工作态度认真，责任感强。', '业务水水平高，交际能力强。', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `id` char(7) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '编号',
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
INSERT INTO `staff` VALUES ('1111111', '高乐音', '男', NULL, '1988-06-21', NULL, NULL);
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
INSERT INTO `staff` VALUES ('1233333', '及其五', '男', '02', '2000-05-05', 2000.00, 1100.00);

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
  INDEX `company_id`(`company_id`) USING BTREE,
  CONSTRAINT `company_id` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1111111', '1819849032', 'staff', '1111111', 'X1Tov7xU', '1819849032@qq.com', '1589874552601', 1);
INSERT INTO `users` VALUES ('1111112', '202cb962ac59075b964b07152d234b70', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111113', '202cb962ac59075b964b07152d234b70', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111114', '202cb962ac59075b964b07152d234b70', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111115', '123', 'staff', NULL, NULL, '987654321@gmail.com', '135877402', 1);
INSERT INTO `users` VALUES ('1111116', '202cb962ac59075b964b07152d234b70', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111117', '202cb962ac59075b964b07152d234b70', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111118', '202cb962ac59075b964b07152d234b70', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111119', '202cb962ac59075b964b07152d234b70', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111120', '202cb962ac59075b964b07152d234b70', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111121', '202cb962ac59075b964b07152d234b70', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111122', '202cb962ac59075b964b07152d234b70', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111123', '202cb962ac59075b964b07152d234b70', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111124', '202cb962ac59075b964b07152d234b70', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111125', '202cb962ac59075b964b07152d234b70', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111126', '202cb962ac59075b964b07152d234b70', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111127', '202cb962ac59075b964b07152d234b70', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111128', '202cb962ac59075b964b07152d234b70', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111129', '202cb962ac59075b964b07152d234b70', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1111130', '202cb962ac59075b964b07152d234b70', 'staff', NULL, 'X1Tov7xU', NULL, NULL, 1);
INSERT INTO `users` VALUES ('1233333', '123', 'staff', NULL, NULL, '123456789@gmail.com', '1572204893', 0);
INSERT INTO `users` VALUES ('123456', '123', 'staff', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('lingdao', '827ccb0eea8a706c4c34a16891f84e7b', 'leader', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('test', 'test', 'leader', NULL, '3Wp621SL', NULL, NULL, 1);
INSERT INTO `users` VALUES ('woshihr', '827ccb0eea8a706c4c34a16891f84e7b', 'HR', NULL, NULL, NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
