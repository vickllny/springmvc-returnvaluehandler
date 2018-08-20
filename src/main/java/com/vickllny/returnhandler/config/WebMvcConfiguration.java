package com.vickllny.returnhandler.config;

import com.vickllny.returnhandler.CustomerReturnValueHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(new MediaType("text", "html", Charset.defaultCharset()));
        mediaTypes.add(new MediaType("application", "json", Charset.defaultCharset()));
        mediaTypes.add(new MediaType("text", "plain", Charset.defaultCharset()));
        stringHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        converters.add(stringHttpMessageConverter);
    }

}
