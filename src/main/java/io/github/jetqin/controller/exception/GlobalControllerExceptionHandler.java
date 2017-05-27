/** 
 * Project Name:demo-auth 
 * File Name:GlobalControllerExceptionHandler.java 
 * Package Name:io.github.jetqin.controller.exception
 * Date:May 27, 20175:34:07 PM 
 * Copyright (c) 2017, jetq All Rights Reserved. 
 * 
 */
package io.github.jetqin.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/** 
 * ClassName: GlobalControllerExceptionHandler  
 * 
 * @author jet 
 * @version Configuration Framework 1.0
 * @since JDK 1.7 
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler
{
//    @ExceptionHandler(value = { Exception.class })
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ApiErrorResponse unknownException(Exception ex, WebRequest req) {
//        return new ApiErrorResponse(...);
//    }
}
