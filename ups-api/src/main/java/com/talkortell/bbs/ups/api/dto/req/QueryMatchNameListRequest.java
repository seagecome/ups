package com.talkortell.bbs.ups.api.dto.req;

import com.talkortell.bbs.base.common.req.BasePaginationRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryMatchNameListRequest extends BasePaginationRequest {

	private static final long serialVersionUID = -3395314348720394889L;
	private String searchParam;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryMatchNameListRequest [");
		if (searchParam != null)
			builder.append("searchParam=").append(searchParam);
		builder.append("]");
		return builder.toString();
	}
}
