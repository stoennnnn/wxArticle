/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : wxarticle

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-02-14 17:03:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wechat_account
-- ----------------------------
DROP TABLE IF EXISTS `wechat_account`;
CREATE TABLE `wechat_account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_nickname` varchar(64) NOT NULL COMMENT '公众号名称',
  `account_number` varchar(64) NOT NULL COMMENT '微信号',
  `account_desc` varchar(512) DEFAULT NULL COMMENT '公众号介绍',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of wechat_account
-- ----------------------------
INSERT INTO `wechat_account` VALUES ('1', 'java团长', 'aa123', '测试', '2019-02-11 15:33:00', '2019-02-11 15:33:00');

-- ----------------------------
-- Table structure for wechat_article
-- ----------------------------
DROP TABLE IF EXISTS `wechat_article`;
CREATE TABLE `wechat_article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) DEFAULT NULL COMMENT '公众号id',
  `article_title` varchar(256) NOT NULL COMMENT '标题',
  `article_digest` varchar(256) DEFAULT NULL COMMENT '摘要',
  `article_content_url` varchar(512) DEFAULT NULL COMMENT '内容url',
  `article_cover_url` varchar(512) DEFAULT NULL COMMENT '封面url',
  `article_datetime` bigint(20) NOT NULL COMMENT '发行时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`article_id`),
  KEY `a_account_id` (`account_id`),
  KEY `a_article_title` (`article_title`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of wechat_article
-- ----------------------------
INSERT INTO `wechat_article` VALUES ('1', '1', '我们都来学java', 'java学习公众号', 'www.baidu.com', 'www.baidu.com', '19700118000000', '2019-02-11 16:40:32', '2019-02-11 16:40:32');
INSERT INTO `wechat_article` VALUES ('2', '1', '我', '爱', 'www.baidu.com', 'www.baidu.com', '20190213144039', '2019-02-13 14:40:33', '2019-02-13 14:40:39');
