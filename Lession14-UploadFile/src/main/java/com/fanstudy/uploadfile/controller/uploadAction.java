package com.fanstudy.uploadfile.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class uploadAction {
    @PostMapping("/files")
    public String upload(HttpServletRequest request) {
        try {
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                //配置文件的写入地点
                part.write(fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/index.html";
    }

    private String extractFileName(Part part) {
        String header = part.getHeader("content-disposition");
        System.out.println(header);
        String[] split = header.split(";");
        for (String s : split) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
