package com.example.demo.param.valid;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

import static com.example.demo.param.valid.Constant.ERROR_CODE;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/15 16:22
 * @Description: 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if(ex instanceof MethodArgumentNotValidException){
            String message = ((MethodArgumentNotValidException) ex).getFieldErrors().stream().map(v -> v.getField()+":"+v.getDefaultMessage()).collect(Collectors.joining(";"));
            JSONObject obj = new JSONObject();
            obj.put("status",ERROR_CODE);
            obj.put("error",status.getReasonPhrase());
            obj.put("message",message);
            obj.put("path",((NativeWebRequest) request).getNativeRequest(HttpServletRequest.class).getRequestURI());
            body = obj;
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleClientException(ClientException ex, NativeWebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
        return handleExceptionInternal(ex, null, headers, status, request);
    }





}
