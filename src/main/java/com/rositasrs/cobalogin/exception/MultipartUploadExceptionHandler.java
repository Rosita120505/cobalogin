package com.rositasrs.cobalogin.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class MultipartUploadExceptionHandler {

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public String handleFileUploadException(MaxUploadSizeExceededException exception, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
    return "File yang anda upload melebihi batas 500KB";
  }
}
