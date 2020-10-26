package zy.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 登录账号
 * </p>
 *
 * @author zy
 * @since 2020-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ShareSysAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账号id
     */
    @TableId("ACCOUNT_ID")
    private String accountId;

    /**
     * 账号(工卡号)
     */
    @TableField("ACCOUNT")
    private String account;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 密码盐
     */
    @TableField("SALT")
    private String salt;

    /**
     * 用户信息id
     */
    @TableField("INFO_ID")
    private String infoId;

    /**
     * 公司id
     */
    @TableField("COMPANY_ID")
    private String companyId;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField("CREATE_USER")
    private String createUser;

    /**
     * 修改时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    @TableField("UPDATE_USER")
    private String updateUser;

    /**
     * 状态(1:启用  2:禁用)
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 删除标记(Y:已删除 N:未删除)
     */
    @TableField("DEL_FLAG")
    private String delFlag;

    /**
     * 账户标记(1:普通账户 2:供应商账户)
     */
    @TableField("TYPE")
    private String type;

    /**
     * 微信ID
     */
    @TableField("OPEN_ID")
    private String openId;

    @TableField("VERSION")
    private Long version;

    /**
     * 最后登录时间
     */
    @TableField("LOGIN_TIME")
    private LocalDateTime loginTime;


}
