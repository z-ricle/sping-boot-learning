package org.ziyang.spring.exc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.ziyang.spring.pojo.ResponseResult;

@ControllerAdvice
public class DefaultExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler({ WebException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) // BAD_REQUEST
	public String conversionWebErrorHandler(Exception ex, Model model) {
		ResponseResult jr = new ResponseResult();
		WebException we = (WebException) ex;
		String tracerId = we.getTracerId();
		// 记录日志
		logger.error("tracerId:{}", tracerId);
		logger.error("错误异常捕获", ex);
		jr.setStatus(we.getStatus());
		jr.setMessage(we.getMessage());
		jr.setTracerId(tracerId);
		model.addAttribute("result", jr);
		return "error";
	}
	@ExceptionHandler({ JsonException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) // BAD_REQUEST
	@ResponseBody
	public ResponseResult conversionJsonErrorHandler(Exception ex) {
		ResponseResult jr = new ResponseResult();
		JsonException je = (JsonException) ex;
		String tracerId = je.getTracerId();
		// 记录日志
		logger.error("tracerId:{}", tracerId);
		logger.error("错误异常捕获", ex);
		jr.setStatus(je.getStatus());
		jr.setTracerId(tracerId);
		return jr;
	}
	
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) // BAD_REQUEST
	@ResponseBody
	public ResponseResult conversionErrorHandler(Exception ex) {
		ResponseResult jr = new ResponseResult();
		String tracerId = jr.getTracerId();
		// 记录日志
		logger.error("tracerId:{}", tracerId);
		logger.error("错误异常捕获", ex);
		jr.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		jr.setTracerId(tracerId);
		return jr;
	}
}
