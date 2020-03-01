package com.eagle.micro.job.rest;

import java.util.List;

import com.eagle.micro.util.EncryptUtil;
import com.eagle.micro.job.mapper.ConfMapper;
import com.eagle.micro.job.mapper.ProcMapper;
import org.quartz.CronExpression;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eagle.micro.job.service.ConfService;
import com.eagle.micro.model.job.QrtzJob;

@RestController
@RequestMapping("conf")
public class ConfRest {

	@Autowired
	private ConfMapper confMapper;

	@Autowired
	private ProcMapper procMapper;

	@Autowired
	private ConfService confService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/query")
	public ResponseEntity<List<QrtzJob>> query(@RequestBody QrtzJob job) {
		return new ResponseEntity<List<QrtzJob>>(confMapper.query(job), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody QrtzJob job) throws SchedulerException {
		confService.save(job);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/execute/rest/{url}")
	public ResponseEntity<Boolean> executeRestCall(@PathVariable("url") String url) {
		boolean pass = true;
		try {
			ResponseEntity<Object> res = restTemplate.getForEntity(EncryptUtil.base64Decode(url), Object.class);
			pass = res.getStatusCode() == HttpStatus.OK;
		} catch (Exception e) {
			pass = false;
		}
		return new ResponseEntity<Boolean>(pass, HttpStatus.OK);
	}

	@GetMapping("/execute/proc/{procName}")
	public ResponseEntity<Boolean> executeProcCall(@PathVariable("procName") String procName) {
		boolean pass = true;
		try {
			procMapper.call(EncryptUtil.base64Decode(procName));
		} catch (Exception e) {
			pass = false;
		}
		return new ResponseEntity<Boolean>(pass, HttpStatus.OK);
	}

	@GetMapping("/validate/cron/{cron}")
	public ResponseEntity<Boolean> validateCron(@PathVariable("cron") String cron) {
		boolean pass = true;
		try {
			CronExpression.validateExpression(EncryptUtil.base64Decode(cron));
		} catch (Exception e) {
			pass = false;
		}
		return new ResponseEntity<Boolean>(pass, HttpStatus.OK);
	}

	@PatchMapping("/{id}/{flag}")
	public ResponseEntity<Object> update(@RequestBody QrtzJob job) throws SchedulerException {
		confService.update(job);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/{id}/{flag}")
	public ResponseEntity<Object> enable(@PathVariable("id") String id, @PathVariable("flag") int flag)
			throws SchedulerException {
		confService.enable(id, flag);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> remove(@PathVariable("id") String id) throws SchedulerException {
		confService.remove(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
