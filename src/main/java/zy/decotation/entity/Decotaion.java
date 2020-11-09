package zy.decotation.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;

/**
* <p>
* 装饰表
* </p>
*
* @author zy
* @since 2020-11-09
*/
public class Decotaion implements Serializable {

    /**
    * 装饰id
    */
    @TableId("DECORATION_ID")
    private Long decorationId;

    /**
    * 装饰名称
    */
    @TableField("DECORATION_NAME")
    private String decorationName;

    /**
    * 排序
    */
    @TableField("SORT")
    private Integer sort;

    /**
    * 装饰单价
    */
    @TableField("DECORATION_PRICE")
    private BigDecimal decorationPrice;

    /**
    * 装饰数量
    */
    @TableField("DECORATION_NUMBER")
    private BigDecimal decorationNumber;

    /**
    * 装饰总价
    */
    @TableField("DECORATION_TOTAL")
    private BigDecimal decorationTotal;

    /**
    * 父级id
    */
    @TableField("PARENT_ID")
    private Long parentId;

    /**
    * 创建人
    */
    @TableField(value = "CREATE_USER", fill = FieldFill.INSERT)
    private Long createUser;

    /**
    * 更新人
    */
    @TableField(value = "UPDATE_USER", fill = FieldFill.UPDATE)
    private Long updateUser;

    /**
    * 创建时间
    */
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;

    /**
    * 更新时间
    */
    @TableField(value = "UPDATE_TIME", fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
    * 逻辑删除标志，Y已删除，N未删除
    */
    @TableField(value = "DEL_FLAG", fill = FieldFill.INSERT)
    private String delFlag;
}
