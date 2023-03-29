package com.fanstudy.mvc.formatter;

import com.fanstudy.mvc.model.DeviceInfo;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Locale;
import java.util.StringJoiner;

public class DeviceFormatter implements Formatter<DeviceInfo> {

    // text 表示请求参数的值
    @Override
    public DeviceInfo parse(String text, Locale locale) throws ParseException {
        DeviceInfo deviceInfo = null;
        if (StringUtils.hasLength(text)) {
            String[] items = text.split(";");
            deviceInfo = new DeviceInfo();
            deviceInfo.setItem1(items[0].trim());
            deviceInfo.setItem2(items[1].trim());
            deviceInfo.setItem3(items[2].trim());
            deviceInfo.setItem4(items[3].trim());
            deviceInfo.setItem5(items[4].trim());
        }
        return deviceInfo;
    }

    @Override
    public String print(DeviceInfo object, Locale locale) {
        StringJoiner stringJoiner = new StringJoiner("#");
        stringJoiner.add(object.getItem1()).add(object.getItem2()).add(object.getItem3()).add(object.getItem4())
            .add(object.getItem5());
        return stringJoiner.toString();
    }
}
