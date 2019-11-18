package com.eagle.micro.model.job;

import java.util.Map;

import com.google.gson.Gson;

import lombok.Data;

@Data
public class QrtzJob {

	private String id;

	private String confName; // 配置名称

	private String jobName; // quartz用

	private String jobGroup; // quartz用

	private String triggerName; // quartz用

	private String triggerGroup; // quartz用

	private String cron; // cron表达式

	private Integer enabled; // 是否开启0|1

	private String jobData; // quartz调度参数，map类型，json存储

	private String jobManagerClass; // 任务执行类

	@SuppressWarnings("unchecked")
	public Map<String, String> getJobDataMap() {
		return new Gson().fromJson(jobData, Map.class);
	}
}