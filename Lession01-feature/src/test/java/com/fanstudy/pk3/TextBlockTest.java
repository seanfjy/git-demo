package com.fanstudy.pk3;

import com.fanstudy.pk1.Student;
import org.junit.Test;

public class TextBlockTest {
    @Test
    public void test01() {
        // 文本块
        String s1 = """
            hello world
            """;
        // String s2 = """lisi""";
        String s2 = """
            lisi
            """;
        String s3 = """
            select * from
            table where
            the_state = '0'
            """;
    }

    @Test
    public void test02() {
        String s = """
                hello,
                apple,
                end
                """;
        System.out.println(s);
        String indent = s.indent(5);
        System.out.println(indent);

    }

    @Test
    public void test03() {
        String info = """
                Name:%s,
                Phone:%s,
                Age:%d
                """.formatted("lisi","13488888888",50);
        System.out.println(info);
    }

    @Test
    public void test04() {
        String info = """
                spring boot 是一个快速开发的框架\
                是\"Spring\"家族的一个成员
                """;
        System.out.println(info);
    }

    @Test
    public void test05() {
        var s = new StringBuilder();
        var he = new Student(2,"lihua");
    }
}
