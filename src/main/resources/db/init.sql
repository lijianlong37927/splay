/*
 Navicat Premium Data Transfer

 Source Server         : localhost_qqouser
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3307
 Source Schema         : qqodb

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 30/10/2020 18:03:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info`  (
  `menu_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `parent_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `level` int(2) DEFAULT NULL,
  `hide_flg` int(1) DEFAULT NULL,
  `delete_flg` int(1) DEFAULT NULL,
  `create_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建用户',
  `create_datetime` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新用户',
  `update_datetime` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_info
-- ----------------------------
INSERT INTO `menu_info` VALUES ('M01', '系统管理', NULL, NULL, 1, 0, 0, NULL, '2020-09-14 10:00:42', NULL, '2020-09-15 10:22:37');
INSERT INTO `menu_info` VALUES ('M0101', '用户管理', '/user/list', 'M01', 2, 0, 0, NULL, '2020-09-14 09:19:34', NULL, '2020-10-30 09:17:51');

-- ----------------------------
-- Table structure for menu_url
-- ----------------------------
DROP TABLE IF EXISTS `menu_url`;
CREATE TABLE `menu_url`  (
  `menu_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `delete_flg` int(1) DEFAULT NULL,
  `create_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_datetime` datetime(0) DEFAULT NULL,
  `update_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `update_datetime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`menu_id`, `url`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_url
-- ----------------------------
INSERT INTO `menu_url` VALUES ('M0101', '/user/detail/check', 0, NULL, NULL, NULL, NULL);
INSERT INTO `menu_url` VALUES ('M0101', '/user/detail/del/submit', 0, NULL, NULL, NULL, NULL);
INSERT INTO `menu_url` VALUES ('M0101', '/user/detail/edit', 0, NULL, NULL, NULL, NULL);
INSERT INTO `menu_url` VALUES ('M0101', '/user/detail/edit/submit', 0, NULL, NULL, NULL, NULL);
INSERT INTO `menu_url` VALUES ('M0101', '/user/list', 0, NULL, NULL, NULL, NULL);
INSERT INTO `menu_url` VALUES ('M0101', '/user/list/query', 0, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `role_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色编号',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色名称',
  `status` int(3) DEFAULT NULL COMMENT '状态',
  `create_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建用户',
  `create_datetime` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新用户',
  `update_datetime` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('ADMIN', '管理员', 0, NULL, '2020-10-30 16:34:59', NULL, NULL);
INSERT INTO `role_info` VALUES ('R001', '普通用户', 0, NULL, '2020-10-30 16:31:12', NULL, NULL);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `menu_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `delete_flg` int(1) DEFAULT NULL,
  `create_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建用户',
  `create_datetime` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新用户',
  `update_datetime` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', 'R001', 'M0101', 0, NULL, '2019-09-12 15:52:24', NULL, '2020-09-14 11:46:39');
INSERT INTO `role_menu` VALUES ('2', 'R001', 'M01', 0, NULL, '2019-09-12 15:52:24', NULL, '2020-09-14 11:46:41');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户编号',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名称',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
  `status` int(3) DEFAULT NULL COMMENT '状态',
  `create_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建用户',
  `create_datetime` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新用户',
  `update_datetime` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('U000001', 'ceshi2221122', 'a87fdcec6ad026d253b2a45a800a7e569bbff6c6', 0, NULL, '2019-09-12 15:50:40', NULL, '2020-10-30 11:49:36');
INSERT INTO `user_info` VALUES ('U000002', 'ceshi02', NULL, 0, NULL, '2020-07-14 13:38:35', NULL, '2020-10-30 11:52:01');
INSERT INTO `user_info` VALUES ('U000003', 'ceshi03', NULL, 0, NULL, '2020-07-14 13:39:29', NULL, '2020-10-30 11:49:38');
INSERT INTO `user_info` VALUES ('U000004', 'ceshi04', NULL, 0, NULL, '2020-07-14 13:39:39', NULL, '2020-10-30 11:49:40');
INSERT INTO `user_info` VALUES ('U000005', 'ceshi05', NULL, 0, NULL, '2020-07-14 13:39:52', NULL, '2020-09-30 15:53:33');
INSERT INTO `user_info` VALUES ('U000006', 'ceshi06', NULL, 0, NULL, '2020-07-14 13:40:15', NULL, '2020-09-30 15:53:34');
INSERT INTO `user_info` VALUES ('U000007', 'ceshi07', NULL, 0, NULL, '2020-07-14 13:40:35', NULL, '2020-10-30 11:37:17');
INSERT INTO `user_info` VALUES ('U000008', 'ceshi08', NULL, 0, NULL, '2020-07-14 13:40:45', NULL, '2020-09-30 15:53:39');
INSERT INTO `user_info` VALUES ('U000009', 'ceshi09', NULL, 0, NULL, '2020-07-14 13:40:58', NULL, '2020-09-30 15:53:42');
INSERT INTO `user_info` VALUES ('U000010', 'ceshi10', NULL, 0, NULL, '2020-07-14 13:41:08', NULL, '2020-10-30 11:36:18');
INSERT INTO `user_info` VALUES ('U000011', 'ceshi11', NULL, 0, NULL, '2020-07-14 13:41:15', NULL, '2020-09-30 15:53:44');
INSERT INTO `user_info` VALUES ('U000012', 'ceshi12', NULL, 0, NULL, '2020-07-14 13:41:23', NULL, '2020-09-30 15:53:44');
INSERT INTO `user_info` VALUES ('U000013', 'ceshi13', NULL, 0, NULL, '2020-07-14 13:41:31', NULL, '2020-09-30 15:53:47');
INSERT INTO `user_info` VALUES ('U000014', 'ceshi14', NULL, 0, NULL, '2020-07-14 13:41:39', NULL, '2020-09-30 15:53:47');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `delete_flg` int(1) DEFAULT NULL,
  `create_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建用户',
  `create_datetime` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新用户',
  `update_datetime` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', 'U000001', 'R001', 0, NULL, '2019-09-12 15:51:50', NULL, '2020-09-14 11:46:46');

SET FOREIGN_KEY_CHECKS = 1;
