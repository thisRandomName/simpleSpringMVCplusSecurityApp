CREATE DATABASE  IF NOT EXISTS `mvc_app` ;
USE `mvc_app`;

CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sso_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sso_id` (`sso_id`)
) ;



INSERT INTO `app_user` VALUES (1,'admin','admin','Geia','Sou','abc@xyz.com','Active'),(2,'user','user','Kali','Mera','zxw@xyz.com','Active'),(3,'teacher','teacher','Kai','Touxronou','klm@xyz.com','Active');

CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL ,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
);

INSERT INTO `user_profile` VALUES (2,'ADMIN'),(3,'TEACHER'),(1,'USER');

CREATE TABLE `app_user_user_profile` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`user_profile_id`),
  CONSTRAINT `FK_APP_USER` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`)
) ;


INSERT INTO `app_user_user_profile` VALUES (1,2),(2,1),(3,3);

CREATE TABLE `app_courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course` varchar(45) NOT NULL,
  `course_level` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ;

INSERT INTO `app_courses` VALUES (1,'course1','first'),(2,'course2','second'),(3,'course3','third');


