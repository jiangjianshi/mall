package com.mall.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalExceptionResolver implements HandlerExceptionResolver {
    
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);
    
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        boolean isAjaxRequest = isAjaxRequest(request);
        if (isAjaxRequest) {
            //处理ajax请求
//            handleAjaxRequestException(response, ex);
            return null;
        } else {
            //显示统一错误页面
            ModelAndView mav = new ModelAndView("error.html");
            mav.addObject("errorType", "系统异常");
            mav.addObject("errorDesc", ex.getMessage());
//            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * 处理ajax异常
     * @param response
     * @param ex
     */
//    private void handleAjaxRequestException(HttpServletResponse response, Exception ex) {
//        JsonResult<Void> jsonResult = null;
//        try {
//            response.setHeader("Content-type", "application/json;charset=UTF-8");
//            response.setCharacterEncoding("UTF-8");
//            PrintWriter outer = response.getWriter();
//            if (ex instanceof ChannelCrmException) {
//                ChannelCrmException ccx = (ChannelCrmException) ex;
//                jsonResult = JsonResult.fail(ccx.getCode(), ccx.getMessage());
//            } else {
//                jsonResult = JsonResult.fail(ErrorCodeEnum.UNKNOWN_EXCEPTION.getCode(), "服务暂时不可用");
//            }
//            outer.println(gson.toJson(jsonResult));
//            outer.flush();
//        } catch (Exception e) {
//            GlobalHandlerExceptionResolver.log.error("ajax异常处理发生异常，囧!", e);
//        }
//    }

    /**
     * 判断是否是ajax请求
     * @param request
     * @return
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        boolean isAjax = (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
        return isAjax;
    }
}
