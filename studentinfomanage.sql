/*
Navicat MySQL Data Transfer

Source Server         : mySQL
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : studentinfomanage

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-07-03 13:36:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `courseName` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `position` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `score` float(11,0) NOT NULL,
  `teacher` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('C0001', 'java', '励志402', '3', '许晴媛');
INSERT INTO `course` VALUES ('C0002', 'javaee', '励志410', '3', '何田中');
INSERT INTO `course` VALUES ('C0003', 'php', '励志403', '3', '严格');

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage` (
  `manageId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `managePassword` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `manageName` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `manageAuthority` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`manageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES ('1', '1', '1', '管理员');
INSERT INTO `manage` VALUES ('2', '2', '2', '教师');
INSERT INTO `manage` VALUES ('3', '3', '3', '教师');
INSERT INTO `manage` VALUES ('5', '5', '5', '教师');
INSERT INTO `manage` VALUES ('6', '666', '6', '教师');
INSERT INTO `manage` VALUES ('7', '7', '7', '教师');

-- ----------------------------
-- Table structure for selectcourse
-- ----------------------------
DROP TABLE IF EXISTS `selectcourse`;
CREATE TABLE `selectcourse` (
  `studentId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `courseId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `selectDate` date NOT NULL,
  PRIMARY KEY (`studentId`,`courseId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `courseId` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE,
  CONSTRAINT `studentId` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of selectcourse
-- ----------------------------
INSERT INTO `selectcourse` VALUES ('1', 'C0001', '2017-07-02');
INSERT INTO `selectcourse` VALUES ('1', 'C0002', '2017-07-02');
INSERT INTO `selectcourse` VALUES ('1408190203', 'C0001', '2017-07-03');
INSERT INTO `selectcourse` VALUES ('1408190203', 'C0002', '2017-07-03');
INSERT INTO `selectcourse` VALUES ('1408190203', 'C0003', '2017-07-03');
INSERT INTO `selectcourse` VALUES ('3', 'C0001', '2017-07-02');
INSERT INTO `selectcourse` VALUES ('3', 'C0002', '2017-07-02');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `studentName` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `phoneId` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1 ', '女', '2017-04-22', '17859901732', '123');
INSERT INTO `student` VALUES ('1408190203', '王企航', '男', '1996-10-04', '17859901691', '123');
INSERT INTO `student` VALUES ('1408190204', '陈嘉劲', '男', '1996-05-05', '17859901478', '123');
INSERT INTO `student` VALUES ('1408190205', '邓思远', '男', '1996-05-09', '17859901732', '123');
INSERT INTO `student` VALUES ('1408190206', '梁辉荣', '男', '1996-05-23', '17859901612', '123456');
INSERT INTO `student` VALUES ('1408190241', '吴锦其', '男', '1995-01-18', '17859901732', '123');
INSERT INTO `student` VALUES ('1408190248', '徐湘峰', '女', '1997-02-18', '15159692682', '123');
INSERT INTO `student` VALUES ('2', '2', '男', '2017-07-11', '12345678901', '123');
INSERT INTO `student` VALUES ('3', '1 ', '女', '1996-01-01', '17859901732', '123');
INSERT INTO `student` VALUES ('6', '6', '男', '1994-07-13', '12345678901', '1123');
