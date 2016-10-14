/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : dictionary

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-10-14 17:00:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dict_city
-- ----------------------------
DROP TABLE IF EXISTS `dict_city`;
CREATE TABLE `dict_city` (
  `cd` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '城市CD',
  `state_cd` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '国家CD',
  `province_cd` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省份CD',
  `desc` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '城市',
  `is_del` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT 'N' COMMENT '是否删除，Y：已删除，N：未删除(默认)',
  `created_by` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `updated_by` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `create_time` bigint(15) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(15) DEFAULT NULL COMMENT '最后一次更新时间',
  `version` bigint(15) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='城市维护表';

-- ----------------------------
-- Table structure for dict_data
-- ----------------------------
DROP TABLE IF EXISTS `dict_data`;
CREATE TABLE `dict_data` (
  `cd` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典编码',
  `desc` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典释义',
  `dict_type_cd` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典类型CD',
  `created_by` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `updated_by` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `create_time` bigint(15) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(15) DEFAULT NULL COMMENT '最近一次更新时间',
  `is_del` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT 'N' COMMENT '是否删除，Y：已删除，N：未删除(默认)',
  `version` bigint(15) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`cd`,`dict_type_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='字典数据维护表';

-- ----------------------------
-- Table structure for dict_district
-- ----------------------------
DROP TABLE IF EXISTS `dict_district`;
CREATE TABLE `dict_district` (
  `cd` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '区域CD',
  `state_cd` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '国家CD',
  `province_cd` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省份CD',
  `city_cd` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '城市CD',
  `desc` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `created_by` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `updated_by` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `create_time` bigint(15) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(15) DEFAULT NULL COMMENT '最近一次更新时间',
  `is_del` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT 'N' COMMENT '是否删除，Y：已删除，N：未删除(默认)',
  `version` bigint(15) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='区域维护表';

-- ----------------------------
-- Table structure for dict_province
-- ----------------------------
DROP TABLE IF EXISTS `dict_province`;
CREATE TABLE `dict_province` (
  `cd` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '省份CD',
  `state_cd` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '国家CD',
  `desc` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省份',
  `is_del` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT 'N' COMMENT '是否删除，Y：已删除，N：未删除(默认)',
  `created_by` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `updated_by` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `create_time` bigint(15) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(15) DEFAULT NULL COMMENT '最后一次更新时间',
  `version` bigint(15) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='省份维护表';

-- ----------------------------
-- Table structure for dict_state
-- ----------------------------
DROP TABLE IF EXISTS `dict_state`;
CREATE TABLE `dict_state` (
  `cd` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '国家CD',
  `desc` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '国家',
  `is_del` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT 'N' COMMENT '是否删除，Y：已删除，N：未删除(默认)',
  `created_by` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `updated_by` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `create_time` bigint(15) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(15) DEFAULT NULL COMMENT '最后一次更新时间',
  `version` bigint(15) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='国家表';

-- ----------------------------
-- Table structure for dict_type
-- ----------------------------
DROP TABLE IF EXISTS `dict_type`;
CREATE TABLE `dict_type` (
  `cd` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典类型CD',
  `desc` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典类型描述',
  `created_by` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `updated_by` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `create_time` bigint(15) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(15) DEFAULT NULL COMMENT '最近一次更新时间',
  `is_del` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT 'N' COMMENT '是否删除，Y：已删除，N：未删除(默认)',
  `version` bigint(15) DEFAULT '0' COMMENT '版本号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='字典类型维护表';
