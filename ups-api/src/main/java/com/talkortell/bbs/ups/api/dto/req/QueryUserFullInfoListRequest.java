package com.talkortell.bbs.ups.api.dto.req;

import java.util.List;

import com.talkortell.bbs.base.common.req.BasePaginationRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryUserFullInfoListRequest extends BasePaginationRequest {

	private static final long serialVersionUID = -5529528753384365423L;

	private List<String> userIds;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryUserFullInfoListRequest [");
		if (userIds != null)
			builder.append("userIds=").append(userIds);
		builder.append("]");
		return builder.toString();
	}
}
