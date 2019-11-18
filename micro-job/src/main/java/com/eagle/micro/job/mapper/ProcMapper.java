package com.eagle.micro.job.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * 存储过程调用
 * 
 * @author jiangyonghua
 * @date 2019年10月14日
 */
public interface ProcMapper {

	public void call(@Param("procName") String procName);
}
