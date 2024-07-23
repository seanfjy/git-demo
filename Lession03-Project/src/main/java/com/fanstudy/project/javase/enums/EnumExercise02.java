package com.fanstudy.project.javase.enums;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class EnumExercise02 {
    public static void main(String[] args) {

        Arrays.stream(Week.values()).forEach(System.out::println);

    }
}

@Getter
@AllArgsConstructor
@ToString
enum Week {
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期日");

    private final String name;

}