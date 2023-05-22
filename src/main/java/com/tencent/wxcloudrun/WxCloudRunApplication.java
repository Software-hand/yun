/**
 * 微信云函数入口类
 */
package com.tencent.wxcloudrun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

// 扫描 MyBatis Mapper 接口
@MapperScan(basePackages = {"com.tencent.wxcloudrun.dao"})

public class WxCloudRunApplication {

  public static void main(String[] args) {
    SpringApplication.run(WxCloudRunApplication.class, args);
  }

}