package com.eagle.micro.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 统一异常处理器，不要在业务代码中捕获异常，全部交由@ControllerAdvice处理
 * 
 * @author jiangyonghua
 * @date 2019年10月14日
 */
@Slf4j
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class WebExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> Exception(Exception e) {
		log.error(e.getMessage(), e);
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
