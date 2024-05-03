package com.entity.model;

import com.entity.TushuOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 图书借阅
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TushuOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 借阅编号
     */
    private String tushuOrderUuidNumber;


    /**
     * 收货地址
     */
    private Integer addressId;


    /**
     * 图书
     */
    private Integer tushuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预计归还时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date tushuOrderTime;


    /**
     * 快递公司
     */
    private String tushuOrderCourierName;


    /**
     * 快递单号
     */
    private String tushuOrderCourierNumber;


    /**
     * 借阅类型
     */
    private Integer tushuOrderTypes;


    /**
     * 申请借阅时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 审核状态
     */
    private Integer tushuOrderYesnoTypes;


    /**
     * 回复
     */
    private String tushuOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date tushuOrderShenheTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
