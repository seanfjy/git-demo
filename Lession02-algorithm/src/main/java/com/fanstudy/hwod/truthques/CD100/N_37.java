package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 手机App防沉迷系统
 */
public class N_37 {

    static class App {

        // App名称
        String name;
        // 优先级
        int priority;

        // 起始时间 分钟数
        int startTime;

        // 结束时间 分钟数
        int endTime;

        public App(String name, int priority, int startTime, int endTime) {
            this.name = name;
            this.priority = priority;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<App> apps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            apps.add(new App(in.next(), in.nextInt(), convert(in.next()), convert(in.next())));
        }
        int queryTime = convert(in.next());
        System.out.println(getResult(apps, queryTime));
    }

    private static String getResult(ArrayList<App> apps, int queryTime) {
        // 记录已注册的app
        ArrayList<App> registered = new ArrayList<>();

        apps.sort((a, b) -> b.priority - a.priority);

        outer:
        for (App app : apps) {
            if (app.startTime >= app.endTime) {
                continue;
            }
            for (App register : registered) {
                if (hasInterSection(app, register)) {
                    continue outer;
                }
            }
            registered.add(app);
        }
        String ans = "NA";
        for (App app : registered) {
            if (queryTime >= app.startTime && queryTime < app.endTime) {
                ans = app.name;
                break;
            }
        }
        return ans;

    }

    // 判断两个范围是否有交集
    private static boolean hasInterSection(App app1, App app2) {
        int s1 = app1.startTime, e1 = app1.endTime;
        int s2 = app2.startTime, e2 = app2.endTime;
        return !(e1 <= s2 || s1 >= e2);

    }

    private static int convert(String time) {
        String[] split = time.split(":");
        String hours = split[0];
        String minutes = split[1];
        return Integer.parseInt(hours) * 60 + Integer.parseInt(minutes);
    }
}
