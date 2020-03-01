package com.eagle.micro.job.service;

import java.util.Objects;

import com.eagle.micro.job.manager.JobManager;
import com.eagle.micro.job.mapper.ConfMapper;
import com.eagle.micro.util.IdUtil;
import org.quartz.SchedulerException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.eagle.micro.model.job.JobEnum;
import com.eagle.micro.model.job.QrtzJob;

@Service
public class ConfService implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Autowired
	private ConfMapper mapper;

	@Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void save(QrtzJob job) throws SchedulerException {
		job.setId(IdUtil.uuid());
		for (JobEnum jobEnum : JobEnum.values()) {
			if (jobEnum.getManagerClass().equalsIgnoreCase(job.getJobManagerClass())) {
				job.setJobName(jobEnum.getJobName());
				job.setJobGroup(jobEnum.getJobGroup());
				job.setTriggerName(jobEnum.getTriggerName());
				job.setTriggerGroup(jobEnum.getTriggerGroup());
				job.setJobManagerClass(jobEnum.getManagerClass());
			}
		}
		mapper.save(job);
		JobManager jobManager = applicationContext.getBean(job.getJobManagerClass(), JobManager.class);
		jobManager.scheduleJob(job);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void update(QrtzJob job) throws SchedulerException {
		QrtzJob oldjob = mapper.get(job.getId());
		if (Objects.isNull(oldjob)) {
			throw new RuntimeException("获取不到原job信息id【" + job.getId() + "】");
		}
		if (!job.getCron().contentEquals(oldjob.getCron()) || !job.getJobData().contentEquals(oldjob.getJobData())) {
			JobManager jobManager = applicationContext.getBean(job.getJobManagerClass(), JobManager.class);
			jobManager.removeJob(job);
			jobManager.scheduleJob(job);
		}
		// 更新job信息
		mapper.update(job);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void remove(String id) throws SchedulerException {
		QrtzJob job = mapper.get(id);
		if (Objects.isNull(id)) {
			throw new RuntimeException("获取不到原job信息id【" + id + "】");
		}
		mapper.remove(id);
		JobManager jobManager = applicationContext.getBean(job.getJobManagerClass(), JobManager.class);
		jobManager.removeJob(job);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void enable(String id, int flag) throws SchedulerException {
		QrtzJob job = mapper.get(id);
		if(Objects.isNull(id)) {
			throw new RuntimeException("获取不到原job信息id【" + id + "】");
		}
		mapper.enable(id, flag);
		JobManager jobManager = applicationContext.getBean(job.getJobManagerClass(),JobManager.class);
		if(flag == 1) {
			jobManager.scheduleJob(job);
		}else {
			jobManager.removeJob(job);
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
