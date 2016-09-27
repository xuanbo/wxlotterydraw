/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : weixin

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-09-27 16:56:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_id` int(11) DEFAULT NULL COMMENT '抽奖规则id',
  `login_name` varchar(255) DEFAULT NULL COMMENT '参与抽奖的微信账号',
  `status` tinyint(1) DEFAULT NULL COMMENT '是否中奖',
  PRIMARY KEY (`id`),
  KEY `rule_id` (`rule_id`),
  CONSTRAINT `activity_ibfk_1` FOREIGN KEY (`rule_id`) REFERENCES `rule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) DEFAULT NULL COMMENT '管理员登录账号',
  `username` varchar(255) DEFAULT NULL COMMENT '管理员名称',
  `password` varchar(255) DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginName` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'xuanbo', '管理员', '123456');

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '抽奖名称',
  `description` varchar(255) DEFAULT NULL COMMENT '抽奖描述',
  `start_time` datetime DEFAULT NULL COMMENT '抽奖开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '抽奖截止时间',
  `max` int(11) DEFAULT NULL COMMENT '抽奖允许的最大人数',
  `picker_num` int(11) DEFAULT NULL COMMENT '抽奖中奖的人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rule
-- ----------------------------
INSERT INTO `rule` VALUES ('1', '第一次抽奖', '测试抽奖', '2016-09-27 08:21:15', '2016-09-28 08:20:02', '10', '2');
INSERT INTO `rule` VALUES ('2', '第二次抽奖', '测试抽奖2', '2016-09-27 16:20:48', '2016-09-28 16:20:51', '20', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) DEFAULT NULL COMMENT '微信账号',
  `username` varchar(255) DEFAULT NULL COMMENT '微信昵称',
  `tel` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginName` (`login_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
