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

 Date: 04/11/2020 18:00:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `parent_id` int(12) DEFAULT NULL,
  `level` int(2) DEFAULT NULL,
  `hide_flg` int(1) DEFAULT 0,
  `state` int(3) DEFAULT 1,
  `create_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建用户',
  `create_datetime` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新用户',
  `update_datetime` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_info
-- ----------------------------
INSERT INTO `menu_info` VALUES (1, '系统管理', '', 0, 1, 0, 1, NULL, '2020-09-14 10:00:42', NULL, '2020-11-04 17:39:48');
INSERT INTO `menu_info` VALUES (2, '用户管理', '/user/list', 1, 2, 0, 1, NULL, '2020-09-14 09:19:34', NULL, '2020-11-04 14:33:28');
INSERT INTO `menu_info` VALUES (3, '菜单管理', '/menu/list', 1, 2, 0, 1, NULL, '2020-09-14 09:19:34', NULL, '2020-11-04 14:33:30');
INSERT INTO `menu_info` VALUES (15, '未命名', NULL, 0, 1, 0, 1, NULL, '2020-11-04 16:10:49', NULL, NULL);
INSERT INTO `menu_info` VALUES (16, '未命名', NULL, 15, 2, 0, 1, NULL, '2020-11-04 16:10:58', NULL, NULL);

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `role_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色编号',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色名称',
  `state` int(3) DEFAULT NULL COMMENT '状态',
  `create_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建用户',
  `create_datetime` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新用户',
  `update_datetime` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('ADMIN', '管理员', 1, NULL, '2020-10-30 16:34:59', NULL, '2020-11-02 17:16:12');
INSERT INTO `role_info` VALUES ('R001', '普通用户', 1, NULL, '2020-10-30 16:31:12', NULL, '2020-11-02 17:16:14');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `menu_id` int(12) NOT NULL,
  `state` int(3) DEFAULT 1,
  `create_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建用户',
  `create_datetime` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新用户',
  `update_datetime` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 'R001', 1, 1, NULL, '2019-09-12 15:52:24', NULL, '2020-11-04 16:20:32');
INSERT INTO `role_menu` VALUES (2, 'R001', 2, 1, NULL, '2019-09-12 15:52:24', NULL, '2020-11-04 16:21:01');
INSERT INTO `role_menu` VALUES (3, 'R001', 3, 1, NULL, '2020-11-04 16:21:30', NULL, NULL);

-- ----------------------------
-- Table structure for role_url
-- ----------------------------
DROP TABLE IF EXISTS `role_url`;
CREATE TABLE `role_url`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `state` int(3) DEFAULT 1,
  `create_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建用户',
  `create_datetime` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新用户',
  `update_datetime` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_role_1`(`role_id`, `url`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_url
-- ----------------------------
INSERT INTO `role_url` VALUES (1, 'R001', '/user/list', 1, NULL, '2020-11-03 17:28:55', NULL, NULL);
INSERT INTO `role_url` VALUES (2, 'R001', '/user/list/query', 1, NULL, '2020-11-03 17:29:08', NULL, NULL);
INSERT INTO `role_url` VALUES (3, 'R001', '/user/detail/new', 1, NULL, '2020-11-03 17:29:20', NULL, NULL);
INSERT INTO `role_url` VALUES (4, 'R001', '/user/detail/new/submit', 1, NULL, '2020-11-03 17:29:31', NULL, NULL);
INSERT INTO `role_url` VALUES (5, 'R001', '/user/detail/check', 1, NULL, '2020-11-03 17:29:39', NULL, NULL);
INSERT INTO `role_url` VALUES (6, 'R001', '/user/detail/edit', 1, NULL, '2020-11-03 17:29:47', NULL, NULL);
INSERT INTO `role_url` VALUES (7, 'R001', '/user/detail/edit/submit', 1, NULL, '2020-11-03 17:29:57', NULL, NULL);
INSERT INTO `role_url` VALUES (8, 'R001', '/user/list/del/submit', 1, NULL, '2020-11-03 17:30:05', NULL, NULL);
INSERT INTO `role_url` VALUES (9, 'R001', '/menu/list/query', 1, NULL, '2020-11-03 17:30:10', NULL, NULL);
INSERT INTO `role_url` VALUES (10, 'R001', '/menu/list', 1, NULL, '2020-11-03 18:05:37', NULL, NULL);
INSERT INTO `role_url` VALUES (11, 'R001', '/menu/detail/edit', 1, NULL, '2020-11-04 09:18:27', NULL, NULL);
INSERT INTO `role_url` VALUES (12, 'R001', '/menu/detail/edit/submit', 1, NULL, '2020-11-04 09:18:39', NULL, NULL);
INSERT INTO `role_url` VALUES (13, 'R001', '/menu/detail/new/submit', 1, NULL, '2020-11-04 15:16:50', NULL, '2020-11-04 15:17:22');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户编号',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名称',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
  `state` int(3) DEFAULT 1 COMMENT '状态',
  `create_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建用户',
  `create_datetime` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新用户',
  `update_datetime` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('U000001', 'ceshi2221122', 'a87fdcec6ad026d253b2a45a800a7e569bbff6c6', 1, NULL, '2019-09-12 15:50:40', NULL, '2020-11-02 17:16:38');
INSERT INTO `user_info` VALUES ('U000002', 'ceshi02', NULL, 1, NULL, '2020-07-14 13:38:35', NULL, '2020-11-02 17:16:38');
INSERT INTO `user_info` VALUES ('U000003', 'ceshi03', NULL, 1, NULL, '2020-07-14 13:39:29', NULL, '2020-11-02 17:16:38');
INSERT INTO `user_info` VALUES ('U000004', 'ceshi04', NULL, 1, NULL, '2020-07-14 13:39:39', NULL, '2020-11-02 17:16:38');
INSERT INTO `user_info` VALUES ('U000005', 'ceshi05', NULL, 1, NULL, '2020-07-14 13:39:52', NULL, '2020-11-02 17:16:38');
INSERT INTO `user_info` VALUES ('U000006', 'ceshi06', NULL, 1, NULL, '2020-07-14 13:40:15', NULL, '2020-11-02 17:16:38');
INSERT INTO `user_info` VALUES ('U000007', 'ceshi07', NULL, 1, NULL, '2020-07-14 13:40:35', NULL, '2020-11-02 17:16:38');
INSERT INTO `user_info` VALUES ('U000008', 'ceshi08', NULL, 1, NULL, '2020-07-14 13:40:45', NULL, '2020-11-02 17:16:38');
INSERT INTO `user_info` VALUES ('U000009', 'ceshi09', NULL, 1, NULL, '2020-07-14 13:40:58', NULL, '2020-11-02 17:16:38');
INSERT INTO `user_info` VALUES ('U000010', 'ceshi10', NULL, 1, NULL, '2020-07-14 13:41:08', NULL, '2020-11-02 17:16:38');
INSERT INTO `user_info` VALUES ('U000011', 'ceshi11', NULL, 1, NULL, '2020-07-14 13:41:15', NULL, '2020-11-02 17:16:38');
INSERT INTO `user_info` VALUES ('U000012', 'ceshi12', NULL, 1, NULL, '2020-07-14 13:41:23', NULL, '2020-11-02 17:16:38');
INSERT INTO `user_info` VALUES ('U000013', 'ceshi13', NULL, 1, NULL, '2020-07-14 13:41:31', NULL, '2020-11-02 17:16:38');
INSERT INTO `user_info` VALUES ('U000014', 'ceshi14', NULL, 1, NULL, '2020-07-14 13:41:39', NULL, '2020-11-02 17:16:38');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `state` int(3) DEFAULT 1 COMMENT '状态',
  `create_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建用户',
  `create_datetime` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新用户',
  `update_datetime` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_role_1`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 'U000001', 'R001', 1, NULL, '2020-11-02 17:24:49', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
