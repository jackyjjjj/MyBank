/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : mybankdb

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 07/06/2024 09:03:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account_info
-- ----------------------------
DROP TABLE IF EXISTS `account_info`;
CREATE TABLE `account_info`  (
  `accountId` int(0) NOT NULL AUTO_INCREMENT,
  `accountType` int(0) NOT NULL DEFAULT 0,
  `accountNumber` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `balance` decimal(12, 2) NOT NULL,
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `isValid` int(0) NOT NULL DEFAULT 0,
  `quota` int(0) NOT NULL DEFAULT 0,
  `staffId` int(0) NOT NULL,
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `userId` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`accountId`) USING BTREE,
  UNIQUE INDEX `accountNumber`(`accountNumber`) USING BTREE,
  INDEX `fk_account_info_staff`(`staffId`) USING BTREE,
  INDEX `fk_accountType_info_staff`(`accountType`) USING BTREE,
  INDEX `fk_isValid_account_dicItem`(`isValid`) USING BTREE,
  INDEX `fk_quota_dicItem`(`quota`) USING BTREE,
  INDEX `fk_userId`(`userId`) USING BTREE,
  CONSTRAINT `fk_account_info_staff` FOREIGN KEY (`staffId`) REFERENCES `staff` (`staffId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_accountType_info_staff` FOREIGN KEY (`accountType`) REFERENCES `dicitem` (`dicItemCode`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_isValid_account_dicItem` FOREIGN KEY (`isValid`) REFERENCES `dicitem` (`dicItemCode`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_quota_dicItem` FOREIGN KEY (`quota`) REFERENCES `dicitem` (`dicItemCode`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account_info
-- ----------------------------
INSERT INTO `account_info` VALUES (1, 1, '1111111111111111', 0.00, '2024-06-06 11:49:05', '2024-06-06 20:30:21', 0, 1, 1, '123456', 1);
INSERT INTO `account_info` VALUES (2, 1, '2222222222222222', 0.00, '2024-06-06 12:29:05', '2024-06-06 20:30:21', 1, 1, 1, '423424', 2);
INSERT INTO `account_info` VALUES (3, 3, '3333333333333333', 0.00, '2024-06-06 12:32:32', '2024-06-06 20:30:21', 1, 1, 1, '', NULL);
INSERT INTO `account_info` VALUES (5, 1, '4444444444444444', 0.00, '2024-06-06 18:21:44', '2024-06-06 20:30:21', 1, 1, 1, '', NULL);

-- ----------------------------
-- Table structure for dicitem
-- ----------------------------
DROP TABLE IF EXISTS `dicitem`;
CREATE TABLE `dicitem`  (
  `dicItemId` int(0) NOT NULL AUTO_INCREMENT,
  `dicTypeCode` int(0) NULL DEFAULT NULL,
  `dicItemCode` int(0) NULL DEFAULT NULL,
  `dicItemName` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dicItemId`) USING BTREE,
  INDEX `fk_dicItem_dicType`(`dicTypeCode`) USING BTREE,
  INDEX `dicItemCode`(`dicItemCode`) USING BTREE,
  CONSTRAINT `fk_dicItem_dicType` FOREIGN KEY (`dicTypeCode`) REFERENCES `dictype` (`dicTypeCode`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dicitem
-- ----------------------------
INSERT INTO `dicitem` VALUES (1, 1, 1, '账户有效');
INSERT INTO `dicitem` VALUES (2, 1, 0, '账户注销，逻辑删除');
INSERT INTO `dicitem` VALUES (3, 2, 1, '借记卡');
INSERT INTO `dicitem` VALUES (4, 2, 2, '信用卡');
INSERT INTO `dicitem` VALUES (5, 3, 1, '有效用户');
INSERT INTO `dicitem` VALUES (6, 3, 0, '用户注销，逻辑删除');
INSERT INTO `dicitem` VALUES (7, 4, 1, '转账');
INSERT INTO `dicitem` VALUES (8, 4, 2, '存款');
INSERT INTO `dicitem` VALUES (9, 5, 1, '10000');
INSERT INTO `dicitem` VALUES (10, 5, 2, '20000');
INSERT INTO `dicitem` VALUES (11, 5, 3, '50000');

-- ----------------------------
-- Table structure for dictype
-- ----------------------------
DROP TABLE IF EXISTS `dictype`;
CREATE TABLE `dictype`  (
  `dicTypeId` int(0) NOT NULL AUTO_INCREMENT,
  `dicTypeCode` int(0) NOT NULL,
  `dicTypeName` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`dicTypeId`) USING BTREE,
  UNIQUE INDEX `dicTypeCode`(`dicTypeCode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dictype
-- ----------------------------
INSERT INTO `dictype` VALUES (1, 1, '账户状态');
INSERT INTO `dictype` VALUES (2, 2, '账户类型');
INSERT INTO `dictype` VALUES (3, 3, '用户状态');
INSERT INTO `dictype` VALUES (4, 4, '交易类型');
INSERT INTO `dictype` VALUES (5, 5, '额度');

-- ----------------------------
-- Table structure for phone_password
-- ----------------------------
DROP TABLE IF EXISTS `phone_password`;
CREATE TABLE `phone_password`  (
  `passwordId` int(0) NOT NULL AUTO_INCREMENT,
  `phoneNumber` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`passwordId`) USING BTREE,
  UNIQUE INDEX `phoneNumber`(`phoneNumber`) USING BTREE,
  CONSTRAINT `fk_password_info_user_info` FOREIGN KEY (`phoneNumber`) REFERENCES `user_info` (`phoneNumber`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phone_password
-- ----------------------------

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `staffId` int(0) NOT NULL AUTO_INCREMENT,
  `staffName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`staffId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, '一号职员');

-- ----------------------------
-- Table structure for transaction_record
-- ----------------------------
DROP TABLE IF EXISTS `transaction_record`;
CREATE TABLE `transaction_record`  (
  `transactionId` int(0) NOT NULL AUTO_INCREMENT,
  `accountId` int(0) NOT NULL,
  `transactionType` int(0) NOT NULL DEFAULT 0,
  `transactionAmount` decimal(10, 2) NOT NULL,
  `transactionTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `transferToAccountId` int(0) NOT NULL,
  PRIMARY KEY (`transactionId`) USING BTREE,
  INDEX `fk_transaction_record_account_info`(`accountId`) USING BTREE,
  INDEX `fk_transaction_record_transfer_account_info`(`transferToAccountId`) USING BTREE,
  INDEX `fk_transactionType_dicItem`(`transactionType`) USING BTREE,
  CONSTRAINT `fk_transaction_record_account_info` FOREIGN KEY (`accountId`) REFERENCES `account_info` (`accountId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_transaction_record_transfer_account_info` FOREIGN KEY (`transferToAccountId`) REFERENCES `account_info` (`accountId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_transactionType_dicItem` FOREIGN KEY (`transactionType`) REFERENCES `dicitem` (`dicItemCode`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transaction_record
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `userId` int(0) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` int(0) NOT NULL DEFAULT 0,
  `identityNumber` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `phoneNumber` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `isValid` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE INDEX `identityNumber`(`identityNumber`) USING BTREE,
  UNIQUE INDEX `phoneNumber`(`phoneNumber`) USING BTREE,
  INDEX `fk_isValid_dicItem`(`isValid`) USING BTREE,
  CONSTRAINT `fk_isValid_dicItem` FOREIGN KEY (`isValid`) REFERENCES `dicitem` (`dicItemCode`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '张三', 0, '511322200011112222', '19949494949', '123456@qq.com', '2024-06-06 19:21:24', '2024-06-06 19:21:24', 1);
INSERT INTO `user_info` VALUES (2, '李四', 1, '321222200311219366', '18723459876', 'qwerty@gmail.com', '2024-06-06 19:23:12', '2024-06-06 19:23:12', 1);

SET FOREIGN_KEY_CHECKS = 1;
