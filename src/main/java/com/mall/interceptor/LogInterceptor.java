/*
 * Copyright 2016 uncle5.com All right reserved. This software is the
 * confidential and proprietary information of uncle5.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with uncle5.com .
 */
package com.mall.interceptor;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * controller 日志拦截器
 * 
 * @author jjs 2016年10月14日 下午2:38:29
 */
public class LogInterceptor implements MethodInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            long startTime = System.currentTimeMillis();
            Object obj = invocation.proceed();
            if (logger.isInfoEnabled()) {
                long endTime = System.currentTimeMillis();
                logger.info("method={}, ElapsedTime={}ms.",
                        new Object[] { getControllerInfo(invocation), (endTime - startTime) });
                logger.info("Args={}, Result={}, ElapsedTime={}ms.",
                        new Object[] { Arrays.toString(invocation.getArguments()), obj });
            }
            return obj;
        } catch (Exception e) {
            logger.error("method={}, Args={}, Exception={}.",
                    new Object[] { getControllerInfo(invocation), Arrays.toString(invocation.getArguments()), e });
            throw e;
        }
    }

    /**
     * 获取controller方法信息
     * 
     * @param invocation
     * @return
     */
    private String getControllerInfo(MethodInvocation invocation) {
        StringBuilder sb = new StringBuilder();
        sb.append(invocation.getThis().getClass().getSimpleName());
        sb.append("#");
        sb.append(invocation.getMethod().getName());
        return sb.toString();
    }
}
