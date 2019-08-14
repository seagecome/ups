package com.talkortell.bbs.ups.api.dto.req;

import com.talkortell.bbs.base.common.req.BaseRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryUserFullInfoRequest extends BaseRequest {

	private static final long serialVersionUID = -5529528753384365423L;

	private String loginAccount;
	private String userEmail;
	private String userMobile;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryUserInfoRequest [");
		if (loginAccount != null)
			builder.append("loginAccount=").append(loginAccount).append(", ");
		if (userEmail != null)
			builder.append("userEmail=").append(userEmail).append(", ");
		if (userMobile != null)
			builder.append("userMobile=").append(userMobile);
		builder.append("]");
		return builder.toString();
	}
}
