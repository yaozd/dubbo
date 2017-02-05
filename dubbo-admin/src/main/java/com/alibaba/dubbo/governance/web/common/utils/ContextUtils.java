package com.alibaba.dubbo.governance.web.common.utils;

import com.alibaba.dubbo.common.io.StreamUtils;

import java.util.Map;

/**
 * Created by yzd on 2017/2/4.
 * 服务分组(用group区分)后无法查询404的问题
 * HTTP Status 404:service-group/com.example.dubbo.service.inf.IProviderServiceInf:1.0.1/providers
 */
public class ContextUtils {

    public static void replaceServiceValue(Map<String, Object> context) {
        String service = (String) context.get("service");
        if (service != null) {
            service = service.replace("||", "/");
            context.put("service", service);
        }
    }
    public static void replaceContextValue(Map<String, Object> context, String key, String oldChar, String newChar) {
        String keyValue = (String) context.get(key);
        if (keyValue != null) {
            keyValue = keyValue.replace(oldChar, newChar);
            context.put(key, keyValue);
        }
    }

    public static void replaceKeywordValue(Map<String, Object> context) {
        String keyword = (String) context.get("keyword");
        if (keyword != null) {
            keyword = keyword.replace("/", "||");
            context.put("keyword", keyword);
        }
    }
}
