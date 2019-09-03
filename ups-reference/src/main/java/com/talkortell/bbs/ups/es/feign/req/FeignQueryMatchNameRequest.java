package com.talkortell.bbs.ups.es.feign.req;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeignQueryMatchNameRequest implements Serializable {

	private static final long serialVersionUID = -3329143229664233399L;
	private String searchParam;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FeignQueryMatchNameRequest [");
		if (searchParam != null)
			builder.append("searchParam=").append(searchParam);
		builder.append("]");
		return builder.toString();
	}
}
