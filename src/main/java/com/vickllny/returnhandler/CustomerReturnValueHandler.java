package com.vickllny.returnhandler;

import com.vickllny.returnhandler.annotation.PlanInfoAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.servlet.http.HttpServletRequest;


public class CustomerReturnValueHandler implements HandlerMethodReturnValueHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerReturnValueHandler.class);

    private RequestResponseBodyMethodProcessor target;

    public CustomerReturnValueHandler(RequestResponseBodyMethodProcessor target) {
        this.target = target;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return (AnnotationUtils.findAnnotation(returnType.getContainingClass(), PlanInfoAction.class) != null ||
                returnType.getMethodAnnotation(PlanInfoAction.class) != null) && returnType.getMethodAnnotation(ResponseBody.class) != null;
    }

    @Override
    public void handleReturnValue(@Nullable Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        LOGGER.info("Object============="+String.valueOf(o));
        LOGGER.info("ParameterName============="+methodParameter.getParameterName());
        HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();
        if(request != null){
            LOGGER.info("url==="+request.getRequestURL().toString());
        }
        target.handleReturnValue(o,methodParameter,modelAndViewContainer,nativeWebRequest);
    }

}
