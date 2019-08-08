package com.talkortell.bbs.domain.mysql.ups;

import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "user_base_info")
public class UserBaseInfo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 登录账号
     */
    @Column(name = "login_account")
    private String loginAccount;

    /**
     * 登录密码
     */
    @Column(name = "login_password")
    private String loginPassword;

    /**
     * 用户状态:N-正常;L-锁定;C-销户
     */
    @Column(name = "user_state")
    private String userState;

    /**
     * 登录错误次数
     */
    @Column(name = "login_error_count")
    private Integer loginErrorCount;

    /**
     * 最近登录时间
     */
    @Column(name = "latest_login_time")
    private Date latestLoginTime;

    /**
     * 删除标志
     */
    @Column(name = "delete_flag")
    private Boolean deleteFlag;

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
        sb.append(", loginAccount=").append(loginAccount);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", userState=").append(userState);
        sb.append(", loginErrorCount=").append(loginErrorCount);
        sb.append(", latestLoginTime=").append(latestLoginTime);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}