package com.talkortell.bbs.domain.mysql.ups;

import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "user_oper_info")
public class UserOperInfo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 基础表主键
     */
    @Column(name = "user_key")
    private Long userKey;

    /**
     * 用户邮箱
     */
    @Column(name = "user_email")
    private String userEmail;

    /**
     * 用户手机号
     */
    @Column(name = "user_mobile")
    private String userMobile;

    /**
     * 用户生日
     */
    @Column(name = "user_birth")
    private Date userBirth;

    /**
     * 用户性别：M-男；F-女
     */
    @Column(name = "user_sex")
    private String userSex;

    /**
     * 用户头像地址
     */
    @Column(name = "user_icon")
    private String userIcon;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 个性签名
     */
    @Column(name = "sign_content")
    private String signContent;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userKey=").append(userKey);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userMobile=").append(userMobile);
        sb.append(", userBirth=").append(userBirth);
        sb.append(", userSex=").append(userSex);
        sb.append(", userIcon=").append(userIcon);
        sb.append(", nickName=").append(nickName);
        sb.append(", signContent=").append(signContent);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}