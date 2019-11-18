package com.eagle.micro.app.demo.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.debug("Injecting apx into StringContextUtil:" + applicationContext);
		if (SpringContextUtil.applicationContext != null) {
			log.warn("Original apx will be override:" + applicationContext);
		}

		SpringContextUtil.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		assertContextInjected();
		return applicationContext;
	}

	public static <T> T getBean(Class<T> requiredType) {
		assertContextInjected();
		return applicationContext.getBean(requiredType);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		assertContextInjected();
		return (T) applicationContext.getBean(beanName);
	}

	private static void assertContextInjected() {
		if (applicationContext == null) {
			throw new IllegalStateException("Application have not been injected.");
		}
	}

}