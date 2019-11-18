package com.eagle.micro.job.detail;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 接口调度job
 * 
 * @author jiangyonghua
 * @date 2019年10月14日
 */
@Slf4j
@Setter
public class RestCallJobDetail extends QuartzJobBean {

	@Autowired
	private RestTemplate restTemplate;

	private String url;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		boolean success = true;
		try {
			ResponseEntity<Object> res = restTemplate.getForEntity(url, Object.class);
			success = res.getStatusCode() == HttpStatus.OK;
			log.info("接口调度【" + url + "】响应码【" + res.getStatusCodeValue() + "】");
		} catch (Exception e) {
			log.warn("接口调度【" + url + "】异常！", e);
			success = false;
		}
		if (!success) {
			log.warn("接口调度【" + url + "】异常！");
		}
	}

}
