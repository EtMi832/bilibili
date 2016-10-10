/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1 docker
Source Server Version : 50714
Source Host           : 127.0.0.1:3306
Source Database       : bilibili

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-10-08 17:50:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_avplay
-- ----------------------------
DROP TABLE IF EXISTS `b_avplay`;
CREATE TABLE `b_avplay` (
  `avid` int(10) unsigned NOT NULL COMMENT 'avid',
  `view` int(10) unsigned zerofill DEFAULT NULL COMMENT '浏览数',
  `danmuku` int(10) unsigned zerofill DEFAULT NULL COMMENT '弹幕数',
  `reply` int(10) unsigned zerofill DEFAULT NULL,
  `favorite` int(10) unsigned zerofill DEFAULT NULL,
  `coin` int(10) unsigned zerofill DEFAULT NULL,
  `share` int(10) unsigned zerofill DEFAULT NULL,
  `now_rank` int(10) unsigned zerofill DEFAULT NULL,
  `his_rank` int(10) unsigned zerofill DEFAULT NULL,
  `updatetime` bigint(20) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`avid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
