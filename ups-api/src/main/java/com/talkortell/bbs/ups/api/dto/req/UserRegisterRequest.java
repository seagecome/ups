package com.talkortell.bbs.ups.api.dto.req;

import com.talkortell.bbs.base.common.req.BaseRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest extends BaseRequest {

	private static final long serialVersionUID = 8229984778725528261L;

	private String userEmail;
	
	private String loginPassword;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserRegisterRequest [");
		if (userEmail != null)
			builder.append("userEmail=").append(userEmail).append(", ");
		if (loginPassword != null)
			builder.append("loginPassword=").append(loginPassword);
		builder.append("]");
		return builder.toString();
	}
	
}
