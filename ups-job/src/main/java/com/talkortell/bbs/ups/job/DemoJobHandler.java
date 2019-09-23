package com.talkortell.bbs.ups.job;

import org.springframework.stereotype.Component;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@JobHandler(value="demoJobHandler")
public class DemoJobHandler extends IJobHandler {

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		log.info("===ups demoJobHandler start===");
		return ReturnT.SUCCESS;
	}

}
