package com.fanstudy.pd.handler;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fanstudy.pd.exp.BookNotFoundException;

//@RestControllerAdvice
public class GlobalExceptionHandler {

    /*   @ExceptionHandler({BookNotFoundException.class})
    public ProblemDetail handlerBookNotFoundException(BookNotFoundException e){
        // ProblemDetail
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
    
        //type 异常类型:是一个uri,uri找到解决问题的途径
        problemDetail.setType(URI.create("/api/probs/not-found"));
        problemDetail.setTitle("图书异常");
        problemDetail.setProperty("时间", Instant.now());
        problemDetail.setProperty("客服","www.baidu.com");
    
        return problemDetail;
    }*/

    @ExceptionHandler({BookNotFoundException.class})
    public ErrorResponse handlerException(BookNotFoundException e) {

        ErrorResponse error = new ErrorResponseException(HttpStatus.NOT_FOUND, e);
        ProblemDetail body = error.getBody();
        body.setType(URI.create("/api/probs/not-found"));
        body.setDetail(e.getMessage());
        body.setProperty("时间", Instant.now());
        body.setTitle("图书异常");
        return error;
    }
}
