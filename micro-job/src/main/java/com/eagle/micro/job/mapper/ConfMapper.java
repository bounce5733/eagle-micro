package com.eagle.micro.job.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eagle.micro.model.job.QrtzJob;


public interface ConfMapper {

	public QrtzJob get(@Param("id") String id);

	public List<QrtzJob> query(QrtzJob job);

	public void save(QrtzJob job);

	public void update(QrtzJob job);

	public void remove(@Param("id") String id);

	public void enable(@Param("id") String id, @Param("flag") int flag);
}
