/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : 127.0.0.1:3306
 Source Schema         : websocket

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : 65001

 Date: 05/06/2020 11:52:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chatting_records
-- ----------------------------
DROP TABLE IF EXISTS `chatting_records`;
CREATE TABLE `chatting_records`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_Id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户信息',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `photo_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '聊天信息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chatting_records
-- ----------------------------
INSERT INTO `chatting_records` VALUES (8, '1', '123', '你好呀', '2020-05-13 14:44:01', '2020-05-13 14:44:01', NULL);
INSERT INTO `chatting_records` VALUES (9, '1', '123', '你是谁？', '2020-05-13 14:44:13', '2020-05-13 14:44:13', NULL);
INSERT INTO `chatting_records` VALUES (10, '1', '123', '在吗？', '2020-05-13 14:44:14', '2020-05-13 14:44:14', NULL);
INSERT INTO `chatting_records` VALUES (11, '2', 'chen', '嗯呢', '2020-05-13 14:44:35', '2020-05-13 14:44:35', NULL);
INSERT INTO `chatting_records` VALUES (13, '1', '123', 'yo', '2020-05-13 14:44:15', '2020-05-13 14:44:15', NULL);
INSERT INTO `chatting_records` VALUES (14, '1', '123', '你好', '2020-05-13 14:44:16', '2020-05-13 14:44:16', NULL);
INSERT INTO `chatting_records` VALUES (30, '2', 'chen', '你好呀！', '2020-05-13 14:44:36', '2020-05-13 14:44:36', NULL);
INSERT INTO `chatting_records` VALUES (31, '1', '123', '我很好！', '2020-05-13 14:44:17', '2020-05-13 14:44:17', NULL);
INSERT INTO `chatting_records` VALUES (32, '2', 'chen', '哈哈哈哈', '2020-05-13 14:44:37', '2020-05-13 14:44:37', NULL);
INSERT INTO `chatting_records` VALUES (33, '1', '123', '哇哈哈哈哈', '2020-05-13 14:44:18', '2020-05-13 14:44:18', NULL);
INSERT INTO `chatting_records` VALUES (34, '1', '123', 'asdf', '2020-05-13 14:44:18', '2020-05-13 14:44:18', NULL);
INSERT INTO `chatting_records` VALUES (35, '2', 'chen', '厉害 厉害', '2020-05-13 14:44:38', '2020-05-13 14:44:38', NULL);
INSERT INTO `chatting_records` VALUES (36, '2', '123', '哈哈', '2020-05-13 14:44:50', '2020-05-13 14:44:50', NULL);
INSERT INTO `chatting_records` VALUES (37, '1', 'chen', '你好！', '2020-05-13 14:44:43', '2020-05-13 14:44:43', NULL);
INSERT INTO `chatting_records` VALUES (38, '2', 'chen', '收到。', '2020-05-13 14:44:45', '2020-05-13 14:44:45', NULL);
INSERT INTO `chatting_records` VALUES (39, '1', '123', '前端框架用Vue？', '2020-05-13 14:44:21', '2020-05-13 14:44:21', NULL);
INSERT INTO `chatting_records` VALUES (40, '2', 'chen', '可以试试', '2020-05-13 14:44:46', '2020-05-13 14:44:46', NULL);
INSERT INTO `chatting_records` VALUES (41, '1', '123', '下版再加一些新的功能', '2020-05-13 14:44:23', '2020-05-13 14:44:23', NULL);
INSERT INTO `chatting_records` VALUES (42, '2', 'chen', 'okay', '2020-05-13 14:44:47', '2020-05-13 14:44:47', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `head_photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `enable` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '是否可用，0是注销，1是可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '123', '123', '2018-08-14 19:47:49', '2020-05-15 15:14:19', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', NULL, '1');
INSERT INTO `user` VALUES (2, '111', '123', '2018-08-20 16:31:49', '2020-05-15 15:14:21', 'https://goss.veer.com/creative/vcg/veer/800water/veer-151707721.jpg', NULL, '1');
INSERT INTO `user` VALUES (3, '测试', '123', '2020-05-15 15:20:34', '2020-05-15 16:39:36', 'https://b-ssl.duitang.com/uploads/item/201607/02/20160702122710_iRUXT.thumb.700_0.jpeg', NULL, '1');

SET FOREIGN_KEY_CHECKS = 1;
