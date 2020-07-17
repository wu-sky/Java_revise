package com;

import java.io.File;

/*
 *用户：sky-吴
 *日期：2019/9/25
 */
public class Test {


    public static void main(String[] args) {

        Object object=null;

        String str= (String) object;
        System.out.println(str);
                            //D:\java\codeLibraries\project\clouds_petrol_station\clouds-admin\target\classes\admin\download-templates
                         //D:\java\codeLibraries\project\clouds_petrol_station\clouds-admin\target\classes\admin\download-templates\memberDownloadData.xls
        String filepath="D:\\java\\codeLibraries\\project\\clouds_petrol_station\\clouds-admin\\target\\classes\\admin\\download-templates\\memberDownloadData.xls";
        File file=new File(filepath);
        System.out.println(
                file.exists()
        );



    }
}

/*
*       String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1 == s3);
        System.out.println(s1 == s3.intern());


        DROP TABLE IF EXISTS `t_system_info`;
CREATE TABLE `t_system_info`
(
  `id`            varchar(255) NOT NULL,
  `name`          varchar(64)  DEFAULT NULL COMMENT '系统名称',
  `logo_url`      varchar(255)  DEFAULT NULL COMMENT '加油站LOGO URL',
  `version`       varchar(16)  DEFAULT NULL COMMENT '版本号',
  `service_tel`   varchar(16)  DEFAULT NULL COMMENT '客服电话',
  `email`         varchar(64)  DEFAULT NULL COMMENT '邮箱',
  `created_time`  datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='系统信息表';

        */