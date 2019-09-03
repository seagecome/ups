package com.talkortell.bbs.web.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.talkortell.bbs.base.common.resp.BasePaginationResponse;
import com.talkortell.bbs.base.common.service.ServiceHandler;
import com.talkortell.bbs.base.utils.BeanCopyUtil;
import com.talkortell.bbs.ups.api.IEsOuterService;
import com.talkortell.bbs.ups.api.dto.req.QueryMatchNameListRequest;
import com.talkortell.bbs.ups.es.feign.req.FeignQueryMatchNameRequest;
import com.talkortell.bbs.ups.es.feign.service.IEsFeignService;

@RestController
public class EsOuterServiceImpl implements IEsOuterService {

	@Autowired
	private IEsFeignService esFeignService;
	
	@Override
	public BasePaginationResponse<String> queryMatchName(QueryMatchNameListRequest queryMatchNameListRequest) {
		return ServiceHandler.callList(queryMatchNameListRequest, null, String.class, (req, page) -> {
			FeignQueryMatchNameRequest feignQueryMatchNameRequest = BeanCopyUtil.copy(queryMatchNameListRequest, FeignQueryMatchNameRequest.class);
			return esFeignService.queryMatchNameList(feignQueryMatchNameRequest);
		});
	}

}
