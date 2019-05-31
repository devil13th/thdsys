/*
Navicat MySQL Data Transfer

Source Server         : local-mysql
Source Server Version : 50611
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2019-05-31 08:55:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cash
-- ----------------------------
DROP TABLE IF EXISTS `cash`;
CREATE TABLE `cash` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cash1
-- ----------------------------
DROP TABLE IF EXISTS `cash1`;
CREATE TABLE `cash1` (
  `name` varchar(255) DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL,
  UNIQUE KEY `cash1_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cash2
-- ----------------------------
DROP TABLE IF EXISTS `cash2`;
CREATE TABLE `cash2` (
  `name` varchar(255) DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for index_class
-- ----------------------------
DROP TABLE IF EXISTS `index_class`;
CREATE TABLE `index_class` (
  `class_id` varchar(32) NOT NULL,
  `class_no` varchar(32) DEFAULT NULL,
  `class_name` varchar(32) DEFAULT NULL,
  `class_grade` int(11) DEFAULT NULL,
  `school_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for index_school
-- ----------------------------
DROP TABLE IF EXISTS `index_school`;
CREATE TABLE `index_school` (
  `school_id` varchar(32) NOT NULL,
  `school_no` varchar(32) DEFAULT NULL,
  `school_name` varchar(255) DEFAULT NULL,
  `school_area` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`school_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for index_student
-- ----------------------------
DROP TABLE IF EXISTS `index_student`;
CREATE TABLE `index_student` (
  `student_id` varchar(32) NOT NULL,
  `student_no` varchar(32) DEFAULT NULL,
  `student_name` varchar(32) DEFAULT NULL,
  `student_sex` int(4) DEFAULT NULL,
  `student_birthday` date DEFAULT NULL,
  `class_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `xyz` (`student_no`,`student_name`,`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mybatis_test
-- ----------------------------
DROP TABLE IF EXISTS `mybatis_test`;
CREATE TABLE `mybatis_test` (
  `name` varchar(255) NOT NULL,
  `money` decimal(10,0) DEFAULT NULL,
  `bir` date DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `mes` text,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(50) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_sex` int(11) DEFAULT NULL,
  `user_mail` varchar(100) DEFAULT NULL,
  `user_tel` varchar(50) DEFAULT NULL,
  `user_birthday` date DEFAULT NULL,
  `user_status` varchar(10) DEFAULT NULL,
  `org_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` char(32) NOT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for test_class
-- ----------------------------
DROP TABLE IF EXISTS `test_class`;
CREATE TABLE `test_class` (
  `class_id` varchar(32) NOT NULL,
  `class_name` varchar(32) DEFAULT NULL,
  `class_info` varchar(255) DEFAULT NULL,
  `class_grade` int(11) DEFAULT NULL,
  `class_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for test_user
-- ----------------------------
DROP TABLE IF EXISTS `test_user`;
CREATE TABLE `test_user` (
  `user_id` varchar(32) NOT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `mes` varchar(255) DEFAULT NULL,
  `class_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `xyz` (`user_name`,`age`,`class_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for test_user_info
-- ----------------------------
DROP TABLE IF EXISTS `test_user_info`;
CREATE TABLE `test_user_info` (
  `user_id` varchar(32) NOT NULL,
  `user_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for transaction_testa
-- ----------------------------
DROP TABLE IF EXISTS `transaction_testa`;
CREATE TABLE `transaction_testa` (
  `id` varchar(64) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for transaction_testb
-- ----------------------------
DROP TABLE IF EXISTS `transaction_testb`;
CREATE TABLE `transaction_testb` (
  `id` varchar(64) NOT NULL,
  `school` varchar(32) DEFAULT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
