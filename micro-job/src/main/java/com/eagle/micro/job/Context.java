package com.eagle.micro.job;

import java.util.List;

import javax.annotation.PostConstruct;

import org.quartz.SchedulerException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.eagle.micro.job.manager.JobManager;
import com.eagle.micro.job.mapper.ConfMapper;
import com.eagle.micro.model.job.QrtzJob;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Context implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Autowired
	private ConfMapper confMapper;

	@PostConstruct
	public void initJobs() {
		log.info("初始化系统调度...");
		QrtzJob param = new QrtzJob();
		param.setEnabled(1);
		List<QrtzJob> jobs = confMapper.query(param);
		for (QrtzJob job : jobs) {
			JobManager jobManager = applicationContext.getBean(job.getJobManagerClass(), JobManager.class);
			try {
				jobManager.scheduleJob(job);
			} catch (SchedulerException e) {
				log.error("调度【" + job.getConfName() + "】初始化失败！", e);
			}
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
