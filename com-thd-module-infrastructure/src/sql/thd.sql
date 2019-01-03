/*
Navicat MySQL Data Transfer

Source Server         : mysql-local
Source Server Version : 50611
Source Host           : 127.0.0.1:3306
Source Database       : thd

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2019-01-02 16:27:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_dic_pub`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dic_pub`;
CREATE TABLE `sys_dic_pub` (
  `dic_classify` varchar(50) DEFAULT NULL COMMENT '字典分类',
  `dic_name` varchar(50) DEFAULT NULL COMMENT '字典名称',
  `dic_id` varchar(50) NOT NULL COMMENT '字典标识',
  `dic_desc` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dic_pub
-- ----------------------------
INSERT INTO `sys_dic_pub` VALUES ('backlog_sys', 'A6建造222', '40289476680da39d01680da53af00000', 'A6建造子系统');
INSERT INTO `sys_dic_pub` VALUES ('backlog_sys', 'A6建造1', 'A6', 'A6建造子系统');
INSERT INTO `sys_dic_pub` VALUES ('backlog_type', '待开发落实', 'codeingtodo', '待办工作类型');
INSERT INTO `sys_dic_pub` VALUES ('note_type', '数据库变更', 'dbchange', '数据库变更');
INSERT INTO `sys_dic_pub` VALUES ('post', '软件设计工程师', 'DESIGNER', '软件设计工程师');
INSERT INTO `sys_dic_pub` VALUES ('post', '软件开发工程师', 'DEVELOPER', '软件开发工程师');
INSERT INTO `sys_dic_pub` VALUES ('meeting_type', '非正式讨论', 'discuss', '非正式讨论');
INSERT INTO `sys_dic_pub` VALUES ('backlog_sys', 'EFORM', 'EFORM', 'EFORM');
INSERT INTO `sys_dic_pub` VALUES ('task_status', '完成', 'FINISHED', '任务状态');
INSERT INTO `sys_dic_pub` VALUES ('task_status', '正在进行', 'GOING', '任务状态');
INSERT INTO `sys_dic_pub` VALUES ('module_classify', '知识积累', 'KNOWLEDGE', '知识积累');
INSERT INTO `sys_dic_pub` VALUES ('post_level', '高级', 'L', '高级');
INSERT INTO `sys_dic_pub` VALUES ('backlog_type', '遗留备忘', 'leaveover', '待办工作类型');
INSERT INTO `sys_dic_pub` VALUES ('backlog_type', '日志', 'log', '待办工作类型');
INSERT INTO `sys_dic_pub` VALUES ('post_level', '中级', 'M', '中级');
INSERT INTO `sys_dic_pub` VALUES ('note_type', '里程碑', 'milepost', '里程碑');
INSERT INTO `sys_dic_pub` VALUES ('note_type', '普通记事', 'normal', '普通记事');
INSERT INTO `sys_dic_pub` VALUES ('meeting_type', '一般会议', 'normalmeeting', '一般会议');
INSERT INTO `sys_dic_pub` VALUES ('backlog_type', '记事', 'note', '待办工作类型');
INSERT INTO `sys_dic_pub` VALUES ('backlog_sys', 'other', 'other', '其他任务');
INSERT INTO `sys_dic_pub` VALUES ('backlog_type', '工作计划', 'plan', '待办工作类型');
INSERT INTO `sys_dic_pub` VALUES ('backlog_sys', 'PMP', 'PMP', '上海管理平台PMP');
INSERT INTO `sys_dic_pub` VALUES ('post', '项目经理', 'PROJECT MANAGER', '项目经理');
INSERT INTO `sys_dic_pub` VALUES ('project_phase', '设计阶段', 'PRO_DESSIGN', '设计阶段');
INSERT INTO `sys_dic_pub` VALUES ('project_phase', '监控阶段', 'PRO_MONITORING', '监控阶段');
INSERT INTO `sys_dic_pub` VALUES ('project_phase', '执行阶段', 'PRO_PERFORM', '执行阶段');
INSERT INTO `sys_dic_pub` VALUES ('project_phase', '计划阶段', 'PRO_PLAN', '计划阶段');
INSERT INTO `sys_dic_pub` VALUES ('project_phase', '需求阶段', 'PRO_REQ', '需求阶段');
INSERT INTO `sys_dic_pub` VALUES ('project_phase', '总结阶段', 'PRO_SUMMARY', '总结阶段');
INSERT INTO `sys_dic_pub` VALUES ('project_phase', '测试阶段', 'PRO_TEST', '测试阶段');
INSERT INTO `sys_dic_pub` VALUES ('module_classify', '公共模块/方法', 'PUB_MODULE', '公共模块');
INSERT INTO `sys_dic_pub` VALUES ('meeting_type', '质量分析会', 'quality', '质量分析会');
INSERT INTO `sys_dic_pub` VALUES ('post', '需求分析工程师', 'REQUIRER', '需求分析工程师');
INSERT INTO `sys_dic_pub` VALUES ('meeting_type', '评审会/里程碑会议', 'review', '评审会/里程碑会议');
INSERT INTO `sys_dic_pub` VALUES ('post_level', '初级', 'S', '初级');
INSERT INTO `sys_dic_pub` VALUES ('note_type', '特殊问题', 'special_problem', '特殊问题-项目中遇到的开发相关问题');
INSERT INTO `sys_dic_pub` VALUES ('backlog_sys', 'SSMIS2015-A1', 'SSMIS2015', 'SSMIS2015-A1');
INSERT INTO `sys_dic_pub` VALUES ('module_classify', '标准代码', 'STANDAR_CODE', '标准代码');
INSERT INTO `sys_dic_pub` VALUES ('post', '软件测试工程师', 'TESTER', '软件测试工程师');
INSERT INTO `sys_dic_pub` VALUES ('backlog_type', '待办', 'todo', '待办工作类型');
INSERT INTO `sys_dic_pub` VALUES ('task_status', '未开始', 'UNSTART', '未开始');
INSERT INTO `sys_dic_pub` VALUES ('meeting_type', '周/月例会', 'weekmonth', '周/月例会');
INSERT INTO `sys_dic_pub` VALUES ('post_level', '入门级', 'XS', '入门级');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(50) NOT NULL COMMENT '用户ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `user_account` varchar(50) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `company_name` varchar(200) DEFAULT NULL COMMENT '所在公司',
  `user_mail` varchar(100) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('anfeng', '安峰', 'anfeng', '123456', 'CCSE', 'anfeng@ccsit.cn');
INSERT INTO `sys_user` VALUES ('baigl', '柏贵雷', 'baigl', '123456', 'WSST', 'baigl@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('bjli', '李博佳', 'bjli', '132456', 'CCSE', 'bjli@ccsit.cn');
INSERT INTO `sys_user` VALUES ('bjyi', '易邦金', 'bjyi', '123456', '数字天堂', 'bjyi@aa.com');
INSERT INTO `sys_user` VALUES ('chongw', '卫冲', 'cwei', '123456', 'CCSE', 'cwei@ccsit.cn');
INSERT INTO `sys_user` VALUES ('cwsha', '沙长伟', 'cwsha', '123456', 'CCSE', 'cwsha@ccsit.cn');
INSERT INTO `sys_user` VALUES ('cwyin', '尹长伟', 'cwyin', '123456', 'WSST', 'cwyin@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('duweifeng', '杜伟峰', 'duweifeng', '123456', 'WSST', 'duweifeng@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('dxwang', '王东新', 'dxwang', '123456', 'CCSE', 'dxwang@ccsit.cn');
INSERT INTO `sys_user` VALUES ('dxzhang', '张东雪', 'dxzhang', '123456', 'WSST', 'dxzhang@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('fjxin', '辛凤杰', 'fjxin', '123456', 'CCSE', 'fjxin@ccsit.cn');
INSERT INTO `sys_user` VALUES ('gaoyk', '高言开', 'gaoyk', '123456', 'WSST', 'gaoyk@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('gcun', '郭存', 'gcun', '1', 'CCSE', 'gcun@ccs.org.cn');
INSERT INTO `sys_user` VALUES ('gqzhang', '张国强', 'gqzhang', '123456', '数字天堂', 'gqzhang@aa.com');
INSERT INTO `sys_user` VALUES ('jbzhang', '张继彪', 'jbzhang', '123456', 'CCSE', 'jbzhang@ccs.org.cn');
INSERT INTO `sys_user` VALUES ('jcui', '崔健', 'jcui', '123456', 'WSST', 'jcui@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('jic', '冀存', 'jic', '123456', 'WSST', 'jic@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('jwang', '王娟', 'jwang', '123456', 'WSST', 'jwang@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('jxu', '徐洁', 'jxu', '123456', 'CCSE', 'jxu@ccsit.cn');
INSERT INTO `sys_user` VALUES ('jzhang', '张健', 'jzhang', '123456', 'WSST', 'jzhang@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('jzhou', '周健', 'jzhou', '123456', '数字天堂', 'jzhou@aa.com');
INSERT INTO `sys_user` VALUES ('kliu', '刘坤', 'kliu', '123456', 'WSST', 'kliu@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('kzhang', '张蔻', 'kzhang', '123456', 'CCSE', 'kzhang@ccsit.cn');
INSERT INTO `sys_user` VALUES ('lbshang', '商雷博', 'lbshang', '123456', 'CCSE', 'lbshang@ccsit.cn');
INSERT INTO `sys_user` VALUES ('liuf', '刘菲', 'liuf', '123456', 'WSST', 'liuf@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('liulu', '刘璐', 'liulu', '123456', 'CCSE', 'liulu@ccsit.cn');
INSERT INTO `sys_user` VALUES ('lwang', '王磊', 'lwang', 'ssmis', 'CCSE', 'lwang@ccsit.cn');
INSERT INTO `sys_user` VALUES ('mxzou', '邹梦雪', 'mxzou', '123456', 'WSST', 'mxzou@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('mzuo', '左旻', 'mzuo', '1', 'CCSE', 'mzuo@ccsit.cn');
INSERT INTO `sys_user` VALUES ('panx', '潘星', 'panx', '123456', 'WSST', 'panx@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('qjzhou', '周青俊', 'qjzhou', '1', 'CCSE', 'qjzhou@ccsit.cn');
INSERT INTO `sys_user` VALUES ('rbyu', '于润博', 'rbyu', '123456', 'WSST', 'rbyu@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('rkhao', '郝荣凯', 'rkhao', '123456', 'CCSE', 'rkhao@ccsit.cn');
INSERT INTO `sys_user` VALUES ('rrmeng', '孟荣荣', 'rrmeng', '123456', 'CCSE', 'rrmeng@ccsit.cn');
INSERT INTO `sys_user` VALUES ('sfli', '李帅飞', 'sfli', '123456', 'CCSE', 'sfli@ccsit.cn');
INSERT INTO `sys_user` VALUES ('stding', '丁松涛', 'stding', '123456', '数字天堂', 'stding@aa.com');
INSERT INTO `sys_user` VALUES ('szhang', '张爽', 'szhang', '123456', 'WSST', 'szhang@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('wangsongbo', '王松波', 'wangsongbo', '123456', 'CCSE', 'wangsongbo@ccsit.cn');
INSERT INTO `sys_user` VALUES ('wangy', '王悦', 'wangy', '123456', 'WSST', 'wangy@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('wcwang', '王文超', 'wcwang', '123456', 'CCSE', 'wcwang@ccsit.cn');
INSERT INTO `sys_user` VALUES ('wenx', '温煦', 'wenx', '123456', 'WSST', 'wenx@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('wstian', '田卫松', 'wstian', '123456', 'WSST', 'wstian@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('wuxd', '吴旭东', 'wuxd', '123456', 'WSST', 'wuxd@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('wuyy', '吴艳艳', 'wuyy', '123456', 'WSST', 'wuyy@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('wuzn', '吴珍妮', 'wuzn', '123456', 'WSST', 'wuzn@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('wzsu', '苏文忠', 'wzsu', '123456', 'CCSE', 'wzsu@ccsit.cn');
INSERT INTO `sys_user` VALUES ('xczhang', '张信超', 'xczhang', '123456', 'WSST', 'xczhang@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('xtyin', '尹鑫堂', 'xtyin', '123456', 'CCSE', 'xtyin@ccsit.cn');
INSERT INTO `sys_user` VALUES ('xufeng', '徐锋', 'xufeng', '123456', 'CCSE', 'fxu@ccsit.cn');
INSERT INTO `sys_user` VALUES ('xyqi', '齐心月', 'xyqi', '123456', 'WSST', 'xyqi@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('ycai', '蔡颖', 'ycai', '123456', 'CCSE', 'ycai@ccsit.c');
INSERT INTO `sys_user` VALUES ('ygzhao', '赵勇刚', 'ygzhao', '123456', 'CCSE', 'ygzhao@ccs.org.cn');
INSERT INTO `sys_user` VALUES ('yhuang', '黄勇', 'yhuang', '123456', 'CCSE', 'yhuang@ccsit.cn');
INSERT INTO `sys_user` VALUES ('yinfs', '殷福帅', 'yinfs', '123456', 'WSST', 'yinfs@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('yjmao', '毛勇进', 'yjmao', '123456', 'CCSE', 'yjmao@ccs.org.cn');
INSERT INTO `sys_user` VALUES ('yli', '李岩', 'yli', '123456', 'WSST', 'yli@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('ynzhang', '张莹男', 'ynzhang', '123456', 'WSST', 'ynzhang@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('ywliu', '刘彦文', 'ywliu', 'l123iu', 'CCSE', 'ywliu@ccsit.cn');
INSERT INTO `sys_user` VALUES ('yyzhang', '张媛媛', 'yyzhang', '1', 'CCSE', 'yyzhang@ccsit.cn');
INSERT INTO `sys_user` VALUES ('yzhang', '张洋', 'yzhang', '123456', 'CCSE', 'yzhang@ccsit.cn');
INSERT INTO `sys_user` VALUES ('zfkang', '康志峰', 'zfkang', '123456', '数字天堂', 'zfkang@aa.com');
INSERT INTO `sys_user` VALUES ('zhangsan', '张三', 'zhangsan', '123456', 'CCSE', 'zhangsan@ccsit.cn');
INSERT INTO `sys_user` VALUES ('zhanzq', '战召权', 'zhanzq', '123456', 'WSST', 'zhanzq@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('zhaop', '赵鹏', 'zhaop', '123456', 'WSST', 'zhaop@dlhzxt.com');
INSERT INTO `sys_user` VALUES ('zhaoqing', '赵清', 'zhaoqing', '123456', 'CCSE', 'zhaoqing@ccsit.cn');
INSERT INTO `sys_user` VALUES ('zyhan', '韩志远', 'zyhan', '123456', 'CCSE', 'zyhan@ccsit.cn');
INSERT INTO `sys_user` VALUES ('zyu', '于泽', 'zyu', '123456', 'CCSE', 'zyu@ccsit.cn');
