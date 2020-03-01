package com.eagle.micro.job.detail;

import com.eagle.micro.job.mapper.ProcMapper;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public class ProcCallJobDetail extends QuartzJobBean {

	@Autowired
	private ProcMapper mapper;

	private String procName;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		try {
			mapper.call(procName);
			log.info("存储过程调度【" + procName + "】成功");
		} catch (Exception e) {
			log.warn("存储过程调度【" + procName + "】异常！", e);
		}
	}

}
