package com.fanstudy.exceptionhandler.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ControllerAdvice @RestControllerAdvice
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // 定义方法处理 数学异常

    /**
     * @ExceptionHandler 指定处理异常的方法
     */
    // @ExceptionHandler({ArithmeticException.class})
    // public String handlerArithmeticException(ArithmeticException e, Model model){
    // String message = e.getMessage();
    // model.addAttribute("error",message);
    // return "exp"; //就是视图
    // }

    @ExceptionHandler({ArithmeticException.class})
    @ResponseBody
    Map<String, Object> handlerArithmeticException(ArithmeticException e) {

        Map<String, Object> error = new HashMap<>();
        error.put("error", e.getMessage());
        error.put("tips", "被除数不能为零");

        return error;
    }

    // 处理JSR303验证参数异常
//    @ExceptionHandler({BindException.class})
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Map<String, Object> handlerJSR303Exception(BindException e) {
        System.out.println("======JSR303=====");
        Map<String, Object> map = new HashMap<>();
        BindingResult result = e.getBindingResult();
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (int i = 0; i < errors.size(); i++) {
                FieldError fieldError = errors.get(i);
                map.put(i + "-" + fieldError.getField(), fieldError.getDefaultMessage());
            }
        }
        return map;
    }
}
