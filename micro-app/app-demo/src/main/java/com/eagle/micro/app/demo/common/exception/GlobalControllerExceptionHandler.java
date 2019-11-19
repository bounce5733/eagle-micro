package com.eagle.micro.app.demo.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

/**
 * 公共异常错误
 * 
 * @author jiangyonghua
 * @date 2019年11月15日
 */
@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

	/**
	 * 参数检查异常
	 * 
	 * @param request HttpServletRequest
	 * @param e       MethodArgumentNotValidException
	 * @return UserExceptionResponse
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public UserExceptionResponse handleException(HttpServletRequest request, MethodArgumentNotValidException e) {
		String message = String.join(", ", e.getBindingResult().getFieldErrors().stream()
				.map(item -> item.getField() + " is required").collect(Collectors.toList()));
		log.error("MethodArgumentNOtValid error: " + message);
		return new UserExceptionResponse(ErrorCode.PARAMETER_ERROR);
	}

	/**
	 * UserException异常
	 * 
	 * @param request HttpServletRequest
	 * @param e       UserException
	 * @return UserExceptionResponse
	 */
	@ExceptionHandler(UserException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public UserExceptionResponse handleErrorCodeException(HttpServletRequest request, UserException e) {
		log.error("User Exception: ", e);
		return new UserExceptionResponse(e.getErrorCode());
	}

	/**
	 * 其他异常
	 * 
	 * @param request HttpServletRequest
	 * @param e       Exception
	 * @return UserExceptionResponse
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public UserExceptionResponse handlerException(HttpServletRequest request, Exception e) {
		log.error("internal error: ", e);
		return new UserExceptionResponse(ErrorCode.INTERNAL_SERVER_ERROR);
	}
}
