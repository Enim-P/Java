/*
 Navicat Premium Dump SQL

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 80039 (8.0.39)
 Source Host           : localhost:3306
 Source Schema         : myschool

 Target Server Type    : MySQL
 Target Server Version : 80039 (8.0.39)
 File Encoding         : 65001

 Date: 28/09/2025 16:35:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP DATABASE IF EXISTS `myschool`;
CREATE DATABASE IF NOT EXISTS `myschool`;
USE `myschool`;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `loginId` varchar(50) NOT NULL,
  `loginPwd` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `photo` varchar(200) DEFAULT NULL,
  `inDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` (`id`, `loginId`, `loginPwd`, `name`, `sex`, `phone`, `type`, `photo`, `inDate`) VALUES (1, 'admin', '74ce4a21f159e81638334cbe243cd2cf', '赵露思', '女', '12222222222', '管理员', 'https://web-bing.oss-cn-hangzhou.aliyuncs.com/a5229c2b-95dd-4756-b814-59351064c4fe.jpg', '2024-08-27 14:00:02');
COMMIT;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gradeId` int NOT NULL AUTO_INCREMENT,
  `gradeName` varchar(50) NOT NULL,
  PRIMARY KEY (`gradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of grade
-- ----------------------------
BEGIN;
INSERT INTO `grade` (`gradeId`, `gradeName`) VALUES (1, '大一');
INSERT INTO `grade` (`gradeId`, `gradeName`) VALUES (2, '大二');
INSERT INTO `grade` (`gradeId`, `gradeName`) VALUES (3, '大三');
COMMIT;

-- ----------------------------
-- Table structure for operate_log
-- ----------------------------
DROP TABLE IF EXISTS `operate_log`;
CREATE TABLE `operate_log` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `operate_user` int unsigned DEFAULT NULL COMMENT '操作人ID',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `class_name` varchar(100) DEFAULT NULL COMMENT '操作的类名',
  `method_name` varchar(100) DEFAULT NULL COMMENT '操作的方法名',
  `method_params` varchar(1000) DEFAULT NULL COMMENT '方法参数',
  `return_value` varchar(2000) DEFAULT NULL COMMENT '返回值',
  `cost_time` bigint DEFAULT NULL COMMENT '方法执行耗时，单位:ms',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='操作日志表';

-- ----------------------------
-- Records of operate_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `resultId` int NOT NULL AUTO_INCREMENT,
  `studentNo` varchar(50) NOT NULL,
  `subjectId` int NOT NULL DEFAULT '0',
  `studentResult` int DEFAULT '0',
  `examDate` datetime NOT NULL,
  PRIMARY KEY (`resultId`),
  KEY `fk_result_subject` (`subjectId`),
  KEY `fk_result_student` (`studentNo`),
  KEY `ResultId` (`resultId`),
  CONSTRAINT `fk_result_student` FOREIGN KEY (`studentNo`) REFERENCES `student` (`studentNo`),
  CONSTRAINT `fk_result_subject` FOREIGN KEY (`subjectId`) REFERENCES `subject` (`subjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of result
-- ----------------------------
BEGIN;
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (1, 'S2102002', 3, 90, '2009-12-13 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (2, 'S2102003', 3, 100, '2009-12-13 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (3, 'S2102004', 3, 79, '2009-12-13 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (4, 'S2102005', 3, 80, '2009-12-13 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (5, 'S2102006', 3, 61, '2009-12-13 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (6, 'S2102007', 3, 82, '2009-12-13 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (7, 'S2102008', 3, 35, '2009-12-13 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (8, 'S2102009', 3, 64, '2009-12-13 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (9, 'S2102010', 3, 65, '2009-12-13 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (10, 'S1101001', 1, 80, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (11, 'S1101002', 1, 61, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (12, 'S1101003', 1, 82, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (13, 'S1101004', 1, 55, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (14, 'S1101005', 1, 64, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (15, 'S1101006', 1, 65, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (16, 'S1101007', 1, 88, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (17, 'S1101008', 1, 67, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (18, 'S1101009', 1, 68, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (19, 'S1101010', 1, 44, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (20, 'S1101012', 1, 71, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (21, 'S1101013', 1, 44, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (22, 'S1101015', 1, 86, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (23, 'S1101016', 1, 75, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (24, 'S1101017', 1, 76, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (25, 'S1101018', 1, 90, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (26, 'S1101019', 1, 100, '2010-01-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (27, 'S1101001', 2, 80, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (28, 'S1101002', 2, 61, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (29, 'S1101003', 2, 82, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (30, 'S1101004', 2, 35, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (31, 'S1101005', 2, 64, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (32, 'S1101006', 2, 65, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (33, 'S1101007', 2, 88, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (34, 'S1101009', 2, 68, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (35, 'S1101010', 2, 44, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (36, 'S1101011', 2, 75, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (37, 'S1101012', 2, 71, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (38, 'S1101013', 2, 44, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (39, 'S1101015', 2, 86, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (40, 'S1101016', 2, 75, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (41, 'S1101017', 2, 38, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (42, 'S1101018', 2, 90, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (43, 'S1101019', 2, 100, '2010-02-15 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (44, 'S1101011', 1, 68, '2010-02-01 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (45, 'S1101014', 1, 75, '2010-02-01 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (46, 'S1101008', 2, 45, '2010-03-01 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (47, 'S1101014', 2, 60, '2010-03-01 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (48, 'S2102001', 8, 100, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (49, 'S2102002', 8, 55, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (50, 'S2102003', 8, 60, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (51, 'S2102004', 8, 70, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (52, 'S2102005', 8, 85, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (53, 'S2102006', 8, 88, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (54, 'S2102007', 8, 95, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (55, 'S2102008', 8, 44, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (56, 'S2102009', 8, 68, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (57, 'S2102010', 8, 88, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (58, 'S2102011', 8, 88, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (59, 'S1101001', 3, 88, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (60, 'S1101002', 3, 50, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (61, 'S1101003', 3, 44, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (62, 'S1101004', 3, 77, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (63, 'S1101005', 3, 75, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (64, 'S1101006', 3, 63, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (65, 'S1101007', 3, 15, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (66, 'S1101008', 3, 55, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (67, 'S1101009', 3, 69, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (68, 'S1101010', 3, 90, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (69, 'S1101011', 3, 95, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (70, 'S1101001', 4, 100, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (71, 'S1101002', 4, 60, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (72, 'S1101003', 4, 65, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (73, 'S1101004', 4, 77, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (74, 'S1101005', 4, 75, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (75, 'S1101006', 4, 63, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (76, 'S1101007', 4, 45, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (77, 'S1101008', 4, 55, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (78, 'S1101009', 4, 69, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (79, 'S1101010', 4, 90, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (80, 'S1101011', 4, 100, '2010-03-22 00:00:00');
INSERT INTO `result` (`resultId`, `studentNo`, `subjectId`, `studentResult`, `examDate`) VALUES (81, 'S1101001', 1, 33, '2024-09-02 16:00:00');
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentNo` varchar(16) NOT NULL,
  `loginPwd` varchar(20) NOT NULL,
  `studentName` varchar(50) NOT NULL,
  `sex` char(2) NOT NULL DEFAULT 'M',
  `gradeId` int DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `bornDate` datetime DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `identityCard` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`studentNo`),
  KEY `fk_student_grade` (`gradeId`),
  CONSTRAINT `fk_student_grade` FOREIGN KEY (`gradeId`) REFERENCES `grade` (`gradeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101001', '228996248', '姚恒', '男', 1, '123456789', '南京中博软件学院', '1991-09-01 00:00:00', 'yaoheng@qq.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101002', '228996249', '王明', '女', 1, '987654321', '南京中博软件学院', '1992-09-01 00:00:00', 'wangming@qq.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101003', '228996250', '杨长旺', '男', 1, '1234565412', '南京中博软件学院', '1993-09-01 00:00:00', 'yangzhangwang@qq.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101004', '228996251', '白燕', '男', 1, '676151367', '北京什刹海体校', '1990-09-01 00:00:00', 'cxmnnrhfn@sjsam.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101005', '228996252', '夏一桐', '男', 1, '397739963', '北京市朝阳区大屯', '1989-09-12 00:00:00', 'npgiygxox@ootml.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101006', '228996253', '欧阳燕飞', '男', 1, '13512345678', '河南省南阳市', '1987-06-19 00:00:00', 'dkwkiqbrj@yrkro.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101007', '228996254', '孟祥亚', '男', 1, '13512345679', '河南省洛阳市涧西区', '1993-02-22 00:00:00', 'gekdinmky@ijisq.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101008', '228996257', '凌洋', '女', 1, '15812345680', '湖南省长沙', '1989-11-30 00:00:00', 'NULL', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101009', '228996259', '杨阳', '男', 1, '13512345681', '上海市长虹区', '1989-01-19 00:00:00', 'NULL', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101010', '228996263', '方晴', '男', 1, '13412345682', '山东省聊城市', '1990-07-12 00:00:00', 'NULL', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101011', '228996267', '圆荷', '女', 1, '13512344483', '河北省石家庄', '1989-03-16 00:00:00', 'idfwxlbjr@bkxko.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101012', '228996270', '崔今生', '女', 1, '13512345684', '河北省邯郸市', '1990-01-05 00:00:00', 'qrakldetd@ogtso.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101013', '228996271', '姜北', '男', 1, '578346237', '', '1990-01-25 00:00:00', 'soppebati@hwxpo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101014', '228996273', '姜丫丫', '男', 1, '926457035', '北京市朝阳区慧忠里', '1992-06-24 00:00:00', 'rfkhgcxhy@oomkw.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101015', '228996274', '孙河', '男', 1, '895684949', '北京市通州区', '1990-06-25 00:00:00', 'kdaqojpjj@olmcy.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101016', '228996275', '王可', '男', 1, '328884827', '北京市石景山', '1990-06-26 00:00:00', 'bojzfsixf@qjwgw.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101017', '228996276', '赵七', '女', 1, '511686053', '北京市海淀区中关村', '1985-06-27 00:00:00', 'ltshcitdp@qdpeh.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101018', '228996279', '买燕', '男', 1, '155426854', '河南省周口', '1990-06-28 00:00:00', 'rmpnhbiop@mwrom.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S1101019', '228996281', '冯征', '男', 1, '436987577', '湖北省襄樊', '1987-06-29 00:00:00', 'mdokehdic@omcte.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102001', '228996284', '包卫丽', '女', 2, '13875940258', '湖州德清', '1990-07-01 00:00:00', 'sakuralove2829@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102002', '228996285', '吴可鹏', '男', 2, '13875940259', '', '1991-07-02 00:00:00', 'peggyonhkhk@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102003', '228996287', '於炉冰', '男', 2, '13875940260', '', '1990-07-03 00:00:00', 'yyyyyyyyyyu@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102004', '228996290', '朱月清', '女', 2, '13875940261', '衢州开化', '1990-07-04 00:00:00', 'yinyin01094@yahoo.com.hk', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102005', '228996291', '赵献星', '男', 2, '13875940262', '杭州建德', '1989-11-30 00:00:00', 'ada19262002@hotmail.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102006', '228996292', '吴宝玉', '女', 2, '13875940263', '湖州埭溪', '1986-12-01 00:00:00', 'NULL', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102007', '228996293', '胡梦秋', '女', 2, '13875940264', '杭州临安', '1989-12-02 00:00:00', 'bobo_lok13@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102008', '228996302', '吴春红', '女', 2, '13875940265', '金华金东区', '1989-12-03 00:00:00', 'yintakli@yahoo.com.hk', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102009', '228996304', '张文俊', '男', 2, '13974807750', '绍兴上虞', '1992-12-04 00:00:00', 'natalielam01098@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102010', '228996305', '乐晓燕', '男', 2, '13007426477', '台州三门', '1989-12-05 00:00:00', 'NULL', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102011', '228996307', '裴珍', '男', 2, '13873140386', '北京大兴区', '1989-09-18 00:00:00', 'lingling52030996@hotmail.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102012', '228996308', '周巧飞', '男', 2, '13107428484', '', '1989-09-19 00:00:00', 'yuenfunki@yahoo.com.hk', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102013', '228996309', '王晓文', '男', 2, '13574220088', '杭州建德', '1992-09-20 00:00:00', 'kykwok9@hotmail.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102014', '228996312', '卢凤华', '女', 2, '13574220089', '衢州开化', '1989-09-21 00:00:00', 'sulia123@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102015', '228996316', '胡灵', '女', 2, '13574220090', '台州天台', '1989-09-22 00:00:00', 'chankwaiching@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102016', '228996317', '盛立', '男', 2, '13574220091', '安徽阜阳', '1989-09-23 00:00:00', 'yankchan2004@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102017', '228996318', '吴孝红', '男', 2, '13678945617', '黑龙江哈尔滨', '1989-09-24 00:00:00', 'ayako04620@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102018', '228996323', '曾飞燕', '男', 2, '13678945618', '杭州临安', '1993-09-25 00:00:00', 'ayako04620@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102019', '228996324', '陈科', '男', 2, '13678945619', '新疆乌鲁木齐', '1989-06-12 00:00:00', 'NULL', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('S2102020', '228996325', '严丽丽', '男', 2, '13678945620', '新疆伊宁', '1990-05-04 00:00:00', 'phoebe_swy@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003001', '228996326', '孙瑞晨', '男', 3, '13574220096', '金华兰溪', '1989-05-04 00:00:00', 'faat11@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003002', '228996327', '黄金宵', '男', 3, '13574220097', '绍兴诸暨', '1989-01-24 00:00:00', 'NULL', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003003', '228996329', '陈婷婷', '男', 3, '13574220098', '衢州常山', '1989-04-07 00:00:00', 'mandylau1986@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003004', '228996334', '章巧丹', '女', 3, '13174220099', '宁波宁海', '1989-06-09 00:00:00', 'NULL', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003005', '228996340', '刘丽云 ', '女', 3, '13174220100', '', '1988-11-12 00:00:00', 'raymondchoi04@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003006', '228996341', '丁 亮', '男', 3, '13174220101', '嘉兴嘉善', '1989-01-13 00:00:00', 'tlh10202003@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003007', '228996342', '李明华', '女', 3, '13574220102', '金华兰溪', '1988-03-19 00:00:00', 'mimichoi276@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003008', '228996343', ' 金 晶', '男', 3, '13574220103', '', '1988-03-20 00:00:00', 'mapdhhljp@ncqfg.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003009', '228996346', '张世庆', '男', 3, '13574220104', '湖州双林', '1990-03-21 00:00:00', 'godspnrel@eblox.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003010', '228996348', '方汝滔', '男', 3, '13574220105', '衢州常山', '1988-03-22 00:00:00', 'wieiowzmq@jplop.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003011', '228996349', '王 波', '男', 3, '13574220106', '北京朝阳区', '1988-03-23 00:00:00', 'wengsanc14l@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003012', '228996351', '颜俊俊', '男', 3, '13374220107', '衢州龙游', '1988-03-24 00:00:00', 'wengsanc15l@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003013', '228996352', '刘雪琼', '女', 3, '13374220108', '绍兴嵊州', '1989-06-26 00:00:00', 'wengsanc16l@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003014', '228996353', '胡晓奕', '女', 3, '13374220109', '', '1989-09-23 00:00:00', 'wengsanc17l@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003015', '228996357', '王莉莉', '女', 3, '13374220110', '湖州杨家埠', '1989-11-07 00:00:00', 'NULL', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003016', '228996362', '金辉', '男', 3, '13574220111', '台州温岭', '1989-04-24 00:00:00', 'wengsanc19l@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003017', '228996364', '郑峰', '男', 3, '13574220112', '北京海淀区', '1989-09-24 00:00:00', 'wengsanc20l@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003018', '228996365', '何国英', '男', 3, '13574220113', '台州温岭', '1988-03-01 00:00:00', 'NULL', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003019', '228996370', '方振', '男', 3, '13574220114', '台州三门', '1989-11-29 00:00:00', 'wengsanc22l@yahoo.com', 'NUll');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('Y21003020', '228996371', '雷应飞', '男', 3, '13574220115', '湖州吴兴区', '1989-01-16 00:00:00', 'wengsanc23l@yahoo.com', 'NULL');
INSERT INTO `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) VALUES ('﻿S1101003', '228996247', '凌辉', '女', 1, '353149818', '北京市海淀区成府路', '1993-04-04 00:00:00', 'eepispykh@oitbl.com', 'NUll');
COMMIT;

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subjectId` int NOT NULL AUTO_INCREMENT,
  `subjectName` varchar(50) NOT NULL DEFAULT '',
  `classHour` int DEFAULT '0',
  `gradeId` int NOT NULL,
  PRIMARY KEY (`subjectId`),
  KEY `fk_subject_grade` (`gradeId`),
  CONSTRAINT `fk_subject_grade` FOREIGN KEY (`gradeId`) REFERENCES `grade` (`gradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of subject
-- ----------------------------
BEGIN;
INSERT INTO `subject` (`subjectId`, `subjectName`, `classHour`, `gradeId`) VALUES (1, '使用C#语言开发数据库应用系统', 36, 1);
INSERT INTO `subject` (`subjectId`, `subjectName`, `classHour`, `gradeId`) VALUES (2, '深入.NET平台和C#编程', 76, 2);
INSERT INTO `subject` (`subjectId`, `subjectName`, `classHour`, `gradeId`) VALUES (3, '设计MySchool数据库', 42, 2);
INSERT INTO `subject` (`subjectId`, `subjectName`, `classHour`, `gradeId`) VALUES (4, '基于.NET平台的软件系统分层开发', 44, 2);
INSERT INTO `subject` (`subjectId`, `subjectName`, `classHour`, `gradeId`) VALUES (5, '面向对象程序设计', 59, 2);
INSERT INTO `subject` (`subjectId`, `subjectName`, `classHour`, `gradeId`) VALUES (6, '使用JavaScript增强交互效果', 40, 2);
INSERT INTO `subject` (`subjectId`, `subjectName`, `classHour`, `gradeId`) VALUES (7, '使用Java EE技术开发新闻发布系统', 55, 2);
INSERT INTO `subject` (`subjectId`, `subjectName`, `classHour`, `gradeId`) VALUES (8, '使用ASP.NET技术开发网上书店', 86, 3);
INSERT INTO `subject` (`subjectId`, `subjectName`, `classHour`, `gradeId`) VALUES (9, '开发基于Ajax和控件技术的Web应用系统', 60, 3);
INSERT INTO `subject` (`subjectId`, `subjectName`, `classHour`, `gradeId`) VALUES (10, '使用Java框架技术开发网上信息发布系统', 52, 3);
INSERT INTO `subject` (`subjectId`, `subjectName`, `classHour`, `gradeId`) VALUES (11, '使用Java企业级技术开发企业应用', 68, 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
