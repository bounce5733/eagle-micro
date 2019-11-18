package com.eagle.micro.model.job;

import com.eagle.micro.util.IdUtil;

public enum JobEnum {

	RestCallJob("restCallJobManager"), ProcCallJob("procCallJobManager");

	private final String managerClass;

	private JobEnum(String managerClass) {
		this.managerClass = managerClass;
	}

	public String getManagerClass() {
		return managerClass;
	}

	public String getJobName() {
		return this.getJobName() + "_" + IdUtil.uuid();
	}

	public String getJobGroup() {
		return this.getJobName() + "Group";
	}

	public String getTriggerName() {
		return this.getJobName() + "Trigger" + "_" + IdUtil.uuid();
	}

	public String getTriggerGroup() {
		return this.name() + "TriggerGroup";
	}
}
