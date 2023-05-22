/**
 * ApiResponse类用于封装接口返回的数据
 */
package com.tencent.wxcloudrun.config;

import lombok.Data;

import java.util.HashMap;

@Data
public final class ApiResponse {

  private Integer code; // 接口返回的状态码
  private String errorMsg; // 接口返回的错误信息
  private Object data; // 接口返回的数据

  // 构造方法，用于初始化ApiResponse对象
  private ApiResponse(int code, String errorMsg, Object data) {
    this.code = code;
    this.errorMsg = errorMsg;
    this.data = data;
  }

  // 创建返回成功的ApiResponse对象
  public static ApiResponse ok() {
    return new ApiResponse(0, "", new HashMap<>());
  }

  // 创建返回成功的ApiResponse对象，并传入数据
  public static ApiResponse ok(Object data) {
    return new ApiResponse(0, "", data);
  }

  // 创建返回失败的ApiResponse对象，并传入错误信息
  public static ApiResponse error(String errorMsg) {
    return new ApiResponse(0, errorMsg, new HashMap<>());
  }
}