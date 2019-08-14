package com.talkortell.bbs.ups.api.dto.req;

import com.talkortell.bbs.base.common.req.BaseRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryUserFullInfoByUserIdRequest extends BaseRequest {

	private static final long serialVersionUID = 6682290567723752856L;
	private String userId;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryUserFullInfoByUserIdRequest [");
		if (userId != null)
			builder.append("userId=").append(userId);
		builder.append("]");
		return builder.toString();
	}
}
