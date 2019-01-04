/*
Navicat MySQL Data Transfer

Source Server         : mysql-local
Source Server Version : 50611
Source Host           : 127.0.0.1:3306
Source Database       : ajaxserver

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2019-01-02 11:00:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE,
  KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('4028947667729c8b016772b225990028', 'addr', '5', 'devil13th12341234', null, null);
INSERT INTO `person` VALUES ('4028947667729c8b016772b237f50029', '0.20901718449657936', '5', 'devil13th', '2018-12-03', null);
INSERT INTO `person` VALUES ('4028947667729c8b016772b23b92002a', '0.1648732752508476', '5', 'devil13th', '2018-12-03', null);
INSERT INTO `person` VALUES ('4028947667729c8b016772b23e80002b', '0.26352111773870834', '5', 'devil13th', '2018-12-03', null);
INSERT INTO `person` VALUES ('4028947667729c8b016772b4606f002c', '0.5127302304254452', '5', 'devil13th', '2018-12-03', null);
INSERT INTO `person` VALUES ('4028947667729c8b016772b49912002d', '0.44416648870193376', '5', 'devil13th', '2018-12-03', null);
INSERT INTO `person` VALUES ('402894766772a6d6016772b232f20036', '0.46223387346762856', '5', 'devil13th', '2018-12-03', null);
INSERT INTO `person` VALUES ('402894766772a6d6016772b236240037', '0.6517409317387283', '5', 'devil13th', '2018-12-03', null);
INSERT INTO `person` VALUES ('402894766772a6d6016772b23d0f0039', '0.8121829387032191', '5', 'devil13th', '2018-12-03', null);
INSERT INTO `person` VALUES ('402894766772a6d6016772b2400d003a', '0.7596013632924692', '5', 'devil13th', '2018-12-03', null);
INSERT INTO `person` VALUES ('402894766772a6d6016772b2416e003b', '0.9598730278325638', '5', 'devil13th', '2018-12-03', null);
INSERT INTO `person` VALUES ('402894766772a6d6016772b465a1003c', '0.48589978906346', '5', 'devil13th', '2018-12-03', null);
INSERT INTO `person` VALUES ('402894766772a6d6016772b494e4003d', '0.9602757158017433', '5', 'devil13th', '2018-12-03', null);
INSERT INTO `person` VALUES ('40289476678290840167829099f30000', 'addr', '5', 'new Person', null, null);
INSERT INTO `person` VALUES ('402894766782914f01678291654e0000', 'addr', '5', 'new Person', null, null);

-- ----------------------------
-- Table structure for `sys_org`
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `org_id` varchar(32) NOT NULL,
  `org_code` varchar(32) DEFAULT NULL,
  `org_tree_code` varchar(200) DEFAULT NULL,
  `org_name` varchar(200) DEFAULT NULL,
  `org_is_leaf` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES ('1', 'TJ', 'root.00001', '天津分社', '1');
INSERT INTO `sys_org` VALUES ('2', 'SH', 'root.00002', '上海分社', '1');
INSERT INTO `sys_org` VALUES ('3', 'WH', 'root.00003', '武汉分社', '1');
INSERT INTO `sys_org` VALUES ('4', 'CQ', 'root.00004', '重庆分社', '1');
INSERT INTO `sys_org` VALUES ('5', 'DL', 'root.00005', '大连分社', '1');
INSERT INTO `sys_org` VALUES ('6', 'FZ', 'root.00006', '福州分社', '1');
INSERT INTO `sys_org` VALUES ('7', 'GZ', 'root.00007', '广州分社', '1');
INSERT INTO `sys_org` VALUES ('8', 'JS', 'root.00008', '江苏分社', '1');
INSERT INTO `sys_org` VALUES ('9', 'ZB', 'root.00009', '北京总部', '1');

-- ----------------------------
-- Table structure for `sys_user`
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
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e1ff0008', '111', null, 'devil13th_7@dev.org.cn', '13401020304', '2014-06-19', null, '8');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e2080009', 'devil13th_8', null, 'devil13th_8@dev.org.cn', '13401020304', '2014-06-27', null, '2');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e210000a', 'devil13th_9', null, 'devil13th_9@dev.org.cn', '13401020304', '2014-06-27', null, '3');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e218000b', 'devil13th_10', null, 'devil13th_10@dev.org.cn', '13401020304', '2014-06-27', null, '4');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e22d000c', 'devil13th_11', '1', 'devil13th_11@dev.org.cn', '13401020304', '2014-06-28', '1', '5');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e249000d', 'devil13th_12', '0', 'devil13th_12@dev.org.cn', '13401020304', '2014-06-28', '1', '6');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e252000e', 'devil13th_13', '1', 'devil13th_13@dev.org.cn', '13401020304', '2014-06-28', '1', '7');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e25f000f', 'devil13th_14', '0', 'devil13th_14@dev.org.cn', '13401020304', '2014-06-28', '1', '8');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e26d0010', 'devil13th_15', '1', 'devil13th_15@dev.org.cn', '13401020304', '2014-06-28', '1', '9');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e28d0011', 'devil13th_16', '0', 'devil13th_16@dev.org.cn', '13401020304', '2014-06-28', '1', '1');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e2940012', 'devil13th_17', '1', 'devil13th_17@dev.org.cn', '13401020304', '2014-06-28', '1', '2');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e29c0013', 'devil13th_18', '0', 'devil13th_18@dev.org.cn', '13401020304', '2014-06-28', '1', '3');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e2a80014', 'devil13th_19', '1', 'devil13th_19@dev.org.cn', '13401020304', '2014-06-28', '1', '4');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e2b50015', 'devil13th_20', '0', 'devil13th_20@dev.org.cn', '13401020304', '2014-06-28', '1', '5');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e2c20016', 'devil13th_21', '1', 'devil13th_21@dev.org.cn', '13401020304', '2014-06-28', '1', '6');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e2e00017', 'devil13th_22', '0', 'devil13th_22@dev.org.cn', '13401020304', '2014-06-28', '1', '7');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e2e90018', 'devil13th_23', '1', 'devil13th_23@dev.org.cn', '13401020304', '2014-06-28', '1', '8');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e2f00019', 'devil13th_24', '0', 'devil13th_24@dev.org.cn', '13401020304', '2014-06-28', '1', '9');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e30b001a', 'devil13th_25', '1', 'devil13th_25@dev.org.cn', '13401020304', '2014-06-28', '1', '1');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e314001b', 'devil13th_26', '0', 'devil13th_26@dev.org.cn', '13401020304', '2014-06-28', '0', '2');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e320001c', 'devil13th_27', '1', 'devil13th_27@dev.org.cn', '13401020304', '2014-06-28', '1', '3');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e338001d', 'devil13th_28', '0', 'devil13th_28@dev.org.cn', '13401020304', '2014-06-28', '1', '4');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e346001e', 'devil13th_29', '1', 'devil13th_29@dev.org.cn', '13401020304', '2014-06-28', '1', '5');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e351001f', 'devil13th_30', '0', 'devil13th_30@dev.org.cn', '13401020304', '2014-06-28', '1', '6');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e3590020', 'devil13th_31', '1', 'devil13th_31@dev.org.cn', '13401020304', '2014-06-28', '1', '7');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e3660021', 'devil13th_32', '0', 'devil13th_32@dev.org.cn', '13401020304', '2014-06-28', '1', '8');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e3780022', 'devil13th_33', '1', 'devil13th_33@dev.org.cn', '13401020304', '2014-06-28', '1', '9');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e3870023', 'devil13th_34', '0', 'devil13th_34@dev.org.cn', '13401020304', '2014-06-28', '1', '9');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e3920024', 'devil13th_35', '1', 'devil13th_35@dev.org.cn', '13401020304', '2014-06-28', '1', '8');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e3b60025', 'devil13th_36', '0', 'devil13th_36@dev.org.cn', '13401020304', '2014-06-28', '1', '7');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e3c70026', 'devil13th_37', null, 'devil13th_37@dev.org.cn', '13401020304', '2014-06-27', null, '6');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e3dd0027', 'devil13th_38', '0', 'devil13th_38@dev.org.cn', '13401020304', '2014-06-28', '1', '5');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e3f70028', 'devil13th_39', '1', 'devil13th_39@dev.org.cn', '13401020304', '2014-06-28', '1', '4');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e40b0029', 'devil13th_40', '0', 'devil13th_40@dev.org.cn', '13401020304', '2014-06-28', '1', '3');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e413002a', 'devil13th_41', '1', 'devil13th_41@dev.org.cn', '13401020304', '2014-06-28', '1', '2');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e41f002b', 'devil13th_42', '0', 'devil13th_42@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e427002c', 'devil13th_43', '1', 'devil13th_43@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e42e002d', 'devil13th_44', '0', 'devil13th_44@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e436002e', 'devil13th_45', '1', 'devil13th_45@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e43d002f', 'devil13th_46', '0', 'devil13th_46@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e4470030', 'devil13th_47', '1', 'devil13th_47@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e44e0031', 'devil13th_48', '0', 'devil13th_48@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e4550032', 'devil13th_49', '1', 'devil13th_49@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e45f0033', 'devil13th_50', '0', 'devil13th_50@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e4670034', 'devil13th_51', '1', 'devil13th_51@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e46f0035', 'devil13th_52', '0', 'devil13th_52@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e4750036', 'devil13th_53', '1', 'devil13th_53@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e4800037', 'devil13th_54', '0', 'devil13th_54@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e4870038', 'devil13th_55', '1', 'devil13th_55@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e48c0039', 'devil13th_56', '0', 'devil13th_56@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e4ae003a', 'devil13th_57', '1', 'devil13th_57@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e4c9003b', 'devil13th_58', '0', 'devil13th_58@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e4df003c', 'devil13th_59', '1', 'devil13th_59@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e4f9003d', 'devil13th_60', '0', 'devil13th_60@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e502003e', 'devil13th_61', '1', 'devil13th_61@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e50f003f', 'devil13th_62', '0', 'devil13th_62@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e5170040', 'devil13th_63', '1', 'devil13th_63@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e5330041', 'devil13th_64', '0', 'devil13th_64@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e5410042', 'devil13th_65', '1', 'devil13th_65@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e54f0043', 'devil13th_66', '0', 'devil13th_66@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e5580044', 'devil13th_67', '1', 'devil13th_67@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e55f0045', 'devil13th_68', '0', 'devil13th_68@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e56c0046', 'devil13th_69', '1', 'devil13th_69@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e119dc0146e119e5780047', 'devil13th_70', '0', 'devil13th_70@dev.org.cn', '13401020304', '2014-06-28', '1', 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e139fa0146e13a4e840001', null, null, null, null, null, null, 'SH');
INSERT INTO `sys_user` VALUES ('402881e846e139fa0146e13ca9730002', '2', '1', null, null, '2014-06-02', '1', 'SH');
INSERT INTO `sys_user` VALUES ('40288c7466849700016684aceb600000', 'aaabb', null, 'ccc@ea.com', 'bbb', '2018-10-26', null, '2');
INSERT INTO `sys_user` VALUES ('4028901864ef65e60164ef6b05120000', 'aaa', '1', 'aaa@ccc.com', '1234', null, '1', '5');
INSERT INTO `sys_user` VALUES ('4028901864ef6bd80164ef6c424f0000', 'aaa', '1', 'aaa@ccc.com', '1234', '2015-01-01', '1', '5');
INSERT INTO `sys_user` VALUES ('4028901864ef6bd80164ef6d0ea50001', 'aaa', '1', 'aaa@ccc.com', '1234', '2015-01-01', '1', '5');
INSERT INTO `sys_user` VALUES ('4028901864ef6daa0164ef6ef96f0000', 'aaa222', '1', 'aaa@ccc.com', '1234', '2015-01-01', '1', '5');
INSERT INTO `sys_user` VALUES ('4028901864f37a130164f37dd3530000', 'a3a2a', '1', 'aaa@ccc.com', '1234', '2015-01-01', '1', '5');
INSERT INTO `sys_user` VALUES ('40289018650fb9a401651c7b156a0000', '3333', null, '22@163.com', '1234', '2018-07-31', null, 'BJ');
INSERT INTO `sys_user` VALUES ('40289018650fb9a401651c7e19dc0001', '333', null, '44@163.com', '2352352', '2018-08-08', null, 'BJ');
INSERT INTO `sys_user` VALUES ('40289018650fb9a401651c7f0e4a0002', 'bbbbCCCCC', null, '22@163.com', '2352352', '2018-08-07', null, 'BJ');
INSERT INTO `sys_user` VALUES ('40289018650fb9a401651c824ff40003', '444', null, '22@163.com', '333', '2018-08-07', null, 'BJ');
INSERT INTO `sys_user` VALUES ('40289018650fb9a401651c8323fb0004', '3332', null, '22@163.com', '1234', '2018-08-07', null, 'BJ');
INSERT INTO `sys_user` VALUES ('40289018650fb9a401651c878a380005', '44', null, '22@163.com', '2352352', '2018-08-09', null, 'BJ');
INSERT INTO `sys_user` VALUES ('40289018650fb9a401651c88d46f0006', '22', null, '22@163.com', '2352352', '2018-08-01', null, 'BJ');
INSERT INTO `sys_user` VALUES ('40289018650fb9a401651c8cd33f0007', '3', null, '44@163.com', '1234', '2018-08-15', null, 'BJ');
INSERT INTO `sys_user` VALUES ('40289018650fb9a401651c8cfba00008', '11', null, '44@163.com', '1234', '2018-08-08', null, 'BJ');
INSERT INTO `sys_user` VALUES ('40289018650fb9a401651c8e3f760009', 'zzz', null, '22@163.com', '33', '2018-08-06', null, 'BJ');
INSERT INTO `sys_user` VALUES ('40289018650fb9a401651c9012e5000a', '33334', null, '44@163.com', '222', '2018-08-07', null, 'BJ');
INSERT INTO `sys_user` VALUES ('40289018651cb69901651d22261c0000', 'bbccaa', null, '22@163.com', '1234', '2018-08-06', null, '1');
INSERT INTO `sys_user` VALUES ('40289018651cb69901651d22a5300001', 'bababa', null, 'bab@163.com', '3333', '2018-08-06', null, 'BJ');
INSERT INTO `sys_user` VALUES ('40289018651cb69901651d22dc230002', 'ccaaddbb', null, '22@163.com', '222', '2018-08-06', null, 'BJ');
INSERT INTO `sys_user` VALUES ('4028901865366efa01653725a96d0000', 'aa', null, '22@163.com', 'e33', '2018-08-07', null, '1');
INSERT INTO `sys_user` VALUES ('4028901865366efa0165373708b60001', '张三', null, 'zhangsan@163.com', '138119999999', '2018-08-29', null, '6');

-- ----------------------------
-- Table structure for `transaction_test`
-- ----------------------------
DROP TABLE IF EXISTS `transaction_test`;
CREATE TABLE `transaction_test` (
  `id` varchar(60) NOT NULL DEFAULT '',
  `ct` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transaction_test
-- ----------------------------
INSERT INTO `transaction_test` VALUES ('1', '1', '3', '1');
INSERT INTO `transaction_test` VALUES ('2', '2', '2', '2');
