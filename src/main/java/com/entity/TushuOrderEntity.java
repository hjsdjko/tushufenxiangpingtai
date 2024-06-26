package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 图书借阅
 *
 * @author 
 * @email
 */
@TableName("tushu_order")
public class TushuOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TushuOrderEntity() {

	}

	public TushuOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 借阅编号
     */
    @ColumnInfo(comment="借阅编号",type="varchar(200)")
    @TableField(value = "tushu_order_uuid_number")

    private String tushuOrderUuidNumber;


    /**
     * 收货地址
     */
    @ColumnInfo(comment="收货地址",type="int(11)")
    @TableField(value = "address_id")

    private Integer addressId;


    /**
     * 图书
     */
    @ColumnInfo(comment="图书",type="int(11)")
    @TableField(value = "tushu_id")

    private Integer tushuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预计归还时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预计归还时间",type="timestamp")
    @TableField(value = "tushu_order_time")

    private Date tushuOrderTime;


    /**
     * 快递公司
     */
    @ColumnInfo(comment="快递公司",type="varchar(200)")
    @TableField(value = "tushu_order_courier_name")

    private String tushuOrderCourierName;


    /**
     * 快递单号
     */
    @ColumnInfo(comment="快递单号",type="varchar(200)")
    @TableField(value = "tushu_order_courier_number")

    private String tushuOrderCourierNumber;


    /**
     * 借阅类型
     */
    @ColumnInfo(comment="借阅类型",type="int(11)")
    @TableField(value = "tushu_order_types")

    private Integer tushuOrderTypes;


    /**
     * 申请借阅时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请借阅时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 审核状态
     */
    @ColumnInfo(comment="审核状态",type="int(11)")
    @TableField(value = "tushu_order_yesno_types")

    private Integer tushuOrderYesnoTypes;


    /**
     * 回复
     */
    @ColumnInfo(comment="回复",type="longtext")
    @TableField(value = "tushu_order_yesno_text")

    private String tushuOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "tushu_order_shenhe_time")

    private Date tushuOrderShenheTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：借阅编号
	 */
    public String getTushuOrderUuidNumber() {
        return tushuOrderUuidNumber;
    }
    /**
	 * 设置：借阅编号
	 */

    public void setTushuOrderUuidNumber(String tushuOrderUuidNumber) {
        this.tushuOrderUuidNumber = tushuOrderUuidNumber;
    }
    /**
	 * 获取：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }
    /**
	 * 设置：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 获取：图书
	 */
    public Integer getTushuId() {
        return tushuId;
    }
    /**
	 * 设置：图书
	 */

    public void setTushuId(Integer tushuId) {
        this.tushuId = tushuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预计归还时间
	 */
    public Date getTushuOrderTime() {
        return tushuOrderTime;
    }
    /**
	 * 设置：预计归还时间
	 */

    public void setTushuOrderTime(Date tushuOrderTime) {
        this.tushuOrderTime = tushuOrderTime;
    }
    /**
	 * 获取：快递公司
	 */
    public String getTushuOrderCourierName() {
        return tushuOrderCourierName;
    }
    /**
	 * 设置：快递公司
	 */

    public void setTushuOrderCourierName(String tushuOrderCourierName) {
        this.tushuOrderCourierName = tushuOrderCourierName;
    }
    /**
	 * 获取：快递单号
	 */
    public String getTushuOrderCourierNumber() {
        return tushuOrderCourierNumber;
    }
    /**
	 * 设置：快递单号
	 */

    public void setTushuOrderCourierNumber(String tushuOrderCourierNumber) {
        this.tushuOrderCourierNumber = tushuOrderCourierNumber;
    }
    /**
	 * 获取：借阅类型
	 */
    public Integer getTushuOrderTypes() {
        return tushuOrderTypes;
    }
    /**
	 * 设置：借阅类型
	 */

    public void setTushuOrderTypes(Integer tushuOrderTypes) {
        this.tushuOrderTypes = tushuOrderTypes;
    }
    /**
	 * 获取：申请借阅时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：申请借阅时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getTushuOrderYesnoTypes() {
        return tushuOrderYesnoTypes;
    }
    /**
	 * 设置：审核状态
	 */

    public void setTushuOrderYesnoTypes(Integer tushuOrderYesnoTypes) {
        this.tushuOrderYesnoTypes = tushuOrderYesnoTypes;
    }
    /**
	 * 获取：回复
	 */
    public String getTushuOrderYesnoText() {
        return tushuOrderYesnoText;
    }
    /**
	 * 设置：回复
	 */

    public void setTushuOrderYesnoText(String tushuOrderYesnoText) {
        this.tushuOrderYesnoText = tushuOrderYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getTushuOrderShenheTime() {
        return tushuOrderShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setTushuOrderShenheTime(Date tushuOrderShenheTime) {
        this.tushuOrderShenheTime = tushuOrderShenheTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TushuOrder{" +
            ", id=" + id +
            ", tushuOrderUuidNumber=" + tushuOrderUuidNumber +
            ", addressId=" + addressId +
            ", tushuId=" + tushuId +
            ", yonghuId=" + yonghuId +
            ", tushuOrderTime=" + DateUtil.convertString(tushuOrderTime,"yyyy-MM-dd") +
            ", tushuOrderCourierName=" + tushuOrderCourierName +
            ", tushuOrderCourierNumber=" + tushuOrderCourierNumber +
            ", tushuOrderTypes=" + tushuOrderTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", tushuOrderYesnoTypes=" + tushuOrderYesnoTypes +
            ", tushuOrderYesnoText=" + tushuOrderYesnoText +
            ", tushuOrderShenheTime=" + DateUtil.convertString(tushuOrderShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
