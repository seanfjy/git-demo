package com.fanstudy.pd.exp;

import java.net.URI;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

//自定义异常类,让springMvc 的异常处理器使用
public class IsbnNotFoundException extends ErrorResponseException {
    public IsbnNotFoundException(HttpStatus status, String detail) {
        super(status, createProblemDetail(status,detail), null);
    }

    private static ProblemDetail createProblemDetail(HttpStatus status,String detail) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setType(URI.create("api/probs/not-found"));
        problemDetail.setDetail(detail);
        problemDetail.setTitle("图书异常");
        problemDetail.setProperty("严重程度","低");
        problemDetail.setProperty("时间", LocalDateTime.now());
        return problemDetail;
    }
}
