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
 * 图书
 *
 * @author 
 * @email
 */
@TableName("tushu")
public class TushuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TushuEntity() {

	}

	public TushuEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 图书名称
     */
    @ColumnInfo(comment="图书名称",type="varchar(200)")
    @TableField(value = "tushu_name")

    private String tushuName;


    /**
     * 出版社
     */
    @ColumnInfo(comment="出版社",type="varchar(200)")
    @TableField(value = "tushu_chubanshe")

    private String tushuChubanshe;


    /**
     * 图书编号
     */
    @ColumnInfo(comment="图书编号",type="varchar(200)")
    @TableField(value = "tushu_uuid_number")

    private String tushuUuidNumber;


    /**
     * 图书照片
     */
    @ColumnInfo(comment="图书照片",type="varchar(200)")
    @TableField(value = "tushu_photo")

    private String tushuPhoto;


    /**
     * 现在位置
     */
    @ColumnInfo(comment="现在位置",type="varchar(200)")
    @TableField(value = "tushu_address")

    private String tushuAddress;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 图书类型
     */
    @ColumnInfo(comment="图书类型",type="int(11)")
    @TableField(value = "tushu_types")

    private Integer tushuTypes;


    /**
     * 图书热度
     */
    @ColumnInfo(comment="图书热度",type="int(11)")
    @TableField(value = "tushu_clicknum")

    private Integer tushuClicknum;


    /**
     * 图书介绍
     */
    @ColumnInfo(comment="图书介绍",type="longtext")
    @TableField(value = "tushu_content")

    private String tushuContent;


    /**
     * 图书状态
     */
    @ColumnInfo(comment="图书状态",type="int(11)")
    @TableField(value = "tushu_zhuangtai_types")

    private Integer tushuZhuangtaiTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "tushu_delete")

    private Integer tushuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：图书名称
	 */
    public String getTushuName() {
        return tushuName;
    }
    /**
	 * 设置：图书名称
	 */

    public void setTushuName(String tushuName) {
        this.tushuName = tushuName;
    }
    /**
	 * 获取：出版社
	 */
    public String getTushuChubanshe() {
        return tushuChubanshe;
    }
    /**
	 * 设置：出版社
	 */

    public void setTushuChubanshe(String tushuChubanshe) {
        this.tushuChubanshe = tushuChubanshe;
    }
    /**
	 * 获取：图书编号
	 */
    public String getTushuUuidNumber() {
        return tushuUuidNumber;
    }
    /**
	 * 设置：图书编号
	 */

    public void setTushuUuidNumber(String tushuUuidNumber) {
        this.tushuUuidNumber = tushuUuidNumber;
    }
    /**
	 * 获取：图书照片
	 */
    public String getTushuPhoto() {
        return tushuPhoto;
    }
    /**
	 * 设置：图书照片
	 */

    public void setTushuPhoto(String tushuPhoto) {
        this.tushuPhoto = tushuPhoto;
    }
    /**
	 * 获取：现在位置
	 */
    public String getTushuAddress() {
        return tushuAddress;
    }
    /**
	 * 设置：现在位置
	 */

    public void setTushuAddress(String tushuAddress) {
        this.tushuAddress = tushuAddress;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：图书类型
	 */
    public Integer getTushuTypes() {
        return tushuTypes;
    }
    /**
	 * 设置：图书类型
	 */

    public void setTushuTypes(Integer tushuTypes) {
        this.tushuTypes = tushuTypes;
    }
    /**
	 * 获取：图书热度
	 */
    public Integer getTushuClicknum() {
        return tushuClicknum;
    }
    /**
	 * 设置：图书热度
	 */

    public void setTushuClicknum(Integer tushuClicknum) {
        this.tushuClicknum = tushuClicknum;
    }
    /**
	 * 获取：图书介绍
	 */
    public String getTushuContent() {
        return tushuContent;
    }
    /**
	 * 设置：图书介绍
	 */

    public void setTushuContent(String tushuContent) {
        this.tushuContent = tushuContent;
    }
    /**
	 * 获取：图书状态
	 */
    public Integer getTushuZhuangtaiTypes() {
        return tushuZhuangtaiTypes;
    }
    /**
	 * 设置：图书状态
	 */

    public void setTushuZhuangtaiTypes(Integer tushuZhuangtaiTypes) {
        this.tushuZhuangtaiTypes = tushuZhuangtaiTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getTushuDelete() {
        return tushuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setTushuDelete(Integer tushuDelete) {
        this.tushuDelete = tushuDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Tushu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", tushuName=" + tushuName +
            ", tushuChubanshe=" + tushuChubanshe +
            ", tushuUuidNumber=" + tushuUuidNumber +
            ", tushuPhoto=" + tushuPhoto +
            ", tushuAddress=" + tushuAddress +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", tushuTypes=" + tushuTypes +
            ", tushuClicknum=" + tushuClicknum +
            ", tushuContent=" + tushuContent +
            ", tushuZhuangtaiTypes=" + tushuZhuangtaiTypes +
            ", tushuDelete=" + tushuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
