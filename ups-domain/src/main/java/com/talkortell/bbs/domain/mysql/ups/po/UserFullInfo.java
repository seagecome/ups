package com.talkortell.bbs.domain.mysql.ups.po;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFullInfo {
	private Long userKey;
	private String userId;
    private String loginAccount;
    private String loginPassword;
    private String userState;
    private Integer loginErrorCount;
    private Date latestLoginTime;
    private String deleteFlag;
    private Long operKey;
    private String userEmail;
    private String userMobile;
    private Date userBirth;
    private String userSex;
    private String userIcon;
    private String nickName;
    private String signContent;
    private Date createTime;
    private Date updateTime;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserFullInfo [");
		if (userKey != null)
			builder.append("userKey=").append(userKey).append(", ");
		if (userId != null)
			builder.append("userId=").append(userId).append(", ");
		if (loginAccount != null)
			builder.append("loginAccount=").append(loginAccount).append(", ");
		if (loginPassword != null)
			builder.append("loginPassword=").append(loginPassword).append(", ");
		if (userState != null)
			builder.append("userState=").append(userState).append(", ");
		if (loginErrorCount != null)
			builder.append("loginErrorCount=").append(loginErrorCount).append(", ");
		if (latestLoginTime != null)
			builder.append("latestLoginTime=").append(latestLoginTime).append(", ");
		if (deleteFlag != null)
			builder.append("deleteFlag=").append(deleteFlag).append(", ");
		if (operKey != null)
			builder.append("operKey=").append(operKey).append(", ");
		if (userEmail != null)
			builder.append("userEmail=").append(userEmail).append(", ");
		if (userMobile != null)
			builder.append("userMobile=").append(userMobile).append(", ");
		if (userBirth != null)
			builder.append("userBirth=").append(userBirth).append(", ");
		if (userSex != null)
			builder.append("userSex=").append(userSex).append(", ");
		if (userIcon != null)
			builder.append("userIcon=").append(userIcon).append(", ");
		if (nickName != null)
			builder.append("nickName=").append(nickName).append(", ");
		if (signContent != null)
			builder.append("signContent=").append(signContent).append(", ");
		if (createTime != null)
			builder.append("createTime=").append(createTime).append(", ");
		if (updateTime != null)
			builder.append("updateTime=").append(updateTime);
		builder.append("]");
		return builder.toString();
	}
}
