package com.eagle.micro.job.manager;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;

import com.eagle.micro.model.job.QrtzJob;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class JobManager {

	@Autowired
	protected Scheduler scheduler;

	/**
	 * 添加并启动 job
	 * 
	 * @param job
	 * @throws SchedulerException
	 */
	public abstract void scheduleJob(QrtzJob job) throws SchedulerException;

	/**
	 * 移除调度
	 * 
	 * @param job
	 * @throws SchedulerException
	 */
	public void removeJob(QrtzJob job) throws SchedulerException {
		TriggerKey triggerKey = TriggerKey.triggerKey(job.getTriggerName(), job.getTriggerGroup());
		scheduler.pauseTrigger(triggerKey);
		scheduler.unscheduleJob(triggerKey);
		JobKey jobKey = new JobKey(job.getJobName(), job.getJobGroup());
		scheduler.deleteJob(jobKey);
		log.warn("删除调度job:JobName[" + job.getJobName() + ",JobGroup[" + job.getJobGroup() + "]");
	}
}
