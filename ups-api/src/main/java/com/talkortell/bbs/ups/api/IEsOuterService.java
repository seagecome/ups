package com.talkortell.bbs.ups.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talkortell.bbs.base.common.resp.BasePaginationResponse;
import com.talkortell.bbs.ups.api.constant.ApiConstants;
import com.talkortell.bbs.ups.api.dto.req.QueryMatchNameListRequest;

@RequestMapping(ApiConstants.API_SERVICE_V1 + "/search")
public interface IEsOuterService {
	
	@PostMapping("/queryMatchName")
	BasePaginationResponse<String> queryMatchName(@RequestBody QueryMatchNameListRequest queryMatchNameListRequest);
}
