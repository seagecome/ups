package com.talkortell.bbs.ups.api;

public enum RespCodeEnum {
	ACCESS_SUCCESS(200, "�ɹ�"),
	ILLEGAL_PARAMS(400, "�����������"),
	AUTH_FAIL(401, "������Ҫ�����֤"),
	ACCESS_FORBIDDEN(403, "���󱻽�ֹ"),
	NOT_EXIST(404, "��Դ�Ҳ���"),
	ACCESS_FAIL(500, "�������ڲ�����");
	
	private int code;
	private String desc;
	
	private RespCodeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static String getDescByCode(int code) {
		for(RespCodeEnum rce : RespCodeEnum.values()) {
			if(rce.getCode() == code) {
				return rce.getDesc();
			}
		}
		return "";
	}
}
