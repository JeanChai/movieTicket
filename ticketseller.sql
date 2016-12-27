/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : ticketseller

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2016-12-26 18:57:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `Mid` varchar(255) NOT NULL,
  `Mname` varchar(30) DEFAULT NULL,
  `Mintro` varchar(255) DEFAULT NULL,
  `Mdate` date DEFAULT NULL,
  `Mprice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('1', '你的名字', '一部日本动漫', '2016-12-20', '55.00');
INSERT INTO `movie` VALUES ('2', '摆渡人', '张嘉佳执导', '2016-12-23', '70.00');
INSERT INTO `movie` VALUES ('3', '血战钢锯岭', '改编二战真实故事', '2016-12-08', '50.00');

-- ----------------------------
-- Table structure for perchase
-- ----------------------------
DROP TABLE IF EXISTS `perchase`;
CREATE TABLE `perchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Uid` varchar(30) DEFAULT NULL,
  `Mid` varchar(30) DEFAULT NULL,
  `Pseat` varchar(30) DEFAULT NULL,
  `Pdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of perchase
-- ----------------------------
INSERT INTO `perchase` VALUES ('10', 'user', '3', '1', '2016-12-23');
INSERT INTO `perchase` VALUES ('12', 'user', '3', '4', '2016-12-23');
INSERT INTO `perchase` VALUES ('14', 'admin', '1', '1', '2016-12-25');
INSERT INTO `perchase` VALUES ('16', 'admin', '2', '4', '2016-12-25');
INSERT INTO `perchase` VALUES ('17', 'admin', '2', '15', '2016-12-25');
INSERT INTO `perchase` VALUES ('18', 'admin', '3', '19', '2016-12-25');
INSERT INTO `perchase` VALUES ('19', 'admin', '3', '17', '2016-12-25');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Uid` varchar(30) NOT NULL,
  `Upassword` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', '3');
INSERT INTO `user` VALUES ('admin', 'admin');
INSERT INTO `user` VALUES ('user', 'user');
