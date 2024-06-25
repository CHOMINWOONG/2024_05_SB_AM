package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.BeforActionInterceptor;
import com.example.demo.interceptor.NeedLoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private BeforActionInterceptor beforActionInterceptor;
	private NeedLoginInterceptor needLoginInterceptor;

	public WebConfig(BeforActionInterceptor beforActionInterceptor, NeedLoginInterceptor needLoginInterceptor) {
		this.beforActionInterceptor = beforActionInterceptor;
		this.needLoginInterceptor = needLoginInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(beforActionInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**");
		
		registry.addInterceptor(beforActionInterceptor).addPathPatterns("/usr/article/write")
		.excludePathPatterns("/usr/article/doWrite").excludePathPatterns("/usr/article/modify")
		.excludePathPatterns("/usr/article/doModify").excludePathPatterns("/usr/article/doDelete")
		.excludePathPatterns("/usr/article/doLogout");
	}
}