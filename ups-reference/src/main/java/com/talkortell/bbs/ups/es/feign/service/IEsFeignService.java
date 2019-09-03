package com.talkortell.bbs.ups.es.feign.service;

import java.util.List;

import com.talkortell.bbs.ups.es.feign.req.FeignQueryMatchNameRequest;

public interface IEsFeignService {
	public List<String> queryMatchNameList(FeignQueryMatchNameRequest feignQueryMatchNameRequest);
}
