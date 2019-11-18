package com.eagle.micro.job.manager;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Component;

import com.eagle.micro.job.detail.ProcCallJobDetail;
import com.eagle.micro.model.job.QrtzJob;

import lombok.extern.slf4j.Slf4j;

/**
 * 储存过程调度job管理器
 * 
 * @author jiangyonghua
 * @date 2019年10月14日
 */
@Component
@Slf4j
public class RestCallJobManager extends JobManager {

	private static final String PARAM_KEY = "procName";

	@Override
	public void scheduleJob(QrtzJob job) throws SchedulerException {
		JobKey jobKey = new JobKey(job.getJobName(), job.getJobGroup());
		// 检查是否存在
		if (!scheduler.checkExists(jobKey)) {
			// 启动job
			JobDetail jobDetail = JobBuilder.newJob(ProcCallJobDetail.class).withIdentity(jobKey)
					.usingJobData(PARAM_KEY, job.getJobDataMap().get(PARAM_KEY)).storeDurably().build();
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCron());
			TriggerKey triggerKey = new TriggerKey(job.getTriggerName(), job.getTriggerGroup());
			CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(scheduleBuilder)
					.build();
			scheduler.scheduleJob(jobDetail, cronTrigger);
			log.warn("创建存储过程【" + job.getJobDataMap().get(PARAM_KEY) + "】调度job");
		}

	}

}
