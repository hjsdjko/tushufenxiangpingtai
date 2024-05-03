package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.TushuCommentbackEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 图书评价
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("tushu_commentback")
public class TushuCommentbackView extends TushuCommentbackEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 图书
					 
		/**
		* 图书 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer tushuYonghuId;
		/**
		* 图书名称
		*/

		@ColumnInfo(comment="图书名称",type="varchar(200)")
		private String tushuName;
		/**
		* 出版社
		*/

		@ColumnInfo(comment="出版社",type="varchar(200)")
		private String tushuChubanshe;
		/**
		* 图书编号
		*/

		@ColumnInfo(comment="图书编号",type="varchar(200)")
		private String tushuUuidNumber;
		/**
		* 图书照片
		*/

		@ColumnInfo(comment="图书照片",type="varchar(200)")
		private String tushuPhoto;
		/**
		* 现在位置
		*/

		@ColumnInfo(comment="现在位置",type="varchar(200)")
		private String tushuAddress;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 图书类型
		*/
		@ColumnInfo(comment="图书类型",type="int(11)")
		private Integer tushuTypes;
			/**
			* 图书类型的值
			*/
			@ColumnInfo(comment="图书类型的字典表值",type="varchar(200)")
			private String tushuValue;
		/**
		* 图书热度
		*/

		@ColumnInfo(comment="图书热度",type="int(11)")
		private Integer tushuClicknum;
		/**
		* 图书介绍
		*/

		@ColumnInfo(comment="图书介绍",type="longtext")
		private String tushuContent;
		/**
		* 图书状态
		*/
		@ColumnInfo(comment="图书状态",type="int(11)")
		private Integer tushuZhuangtaiTypes;
			/**
			* 图书状态的值
			*/
			@ColumnInfo(comment="图书状态的字典表值",type="varchar(200)")
			private String tushuZhuangtaiValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer tushuDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public TushuCommentbackView() {

	}

	public TushuCommentbackView(TushuCommentbackEntity tushuCommentbackEntity) {
		try {
			BeanUtils.copyProperties(this, tushuCommentbackEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 图书
		/**
		* 获取：图书 的 用户
		*/
		public Integer getTushuYonghuId() {
			return tushuYonghuId;
		}
		/**
		* 设置：图书 的 用户
		*/
		public void setTushuYonghuId(Integer tushuYonghuId) {
			this.tushuYonghuId = tushuYonghuId;
		}

		/**
		* 获取： 图书名称
		*/
		public String getTushuName() {
			return tushuName;
		}
		/**
		* 设置： 图书名称
		*/
		public void setTushuName(String tushuName) {
			this.tushuName = tushuName;
		}

		/**
		* 获取： 出版社
		*/
		public String getTushuChubanshe() {
			return tushuChubanshe;
		}
		/**
		* 设置： 出版社
		*/
		public void setTushuChubanshe(String tushuChubanshe) {
			this.tushuChubanshe = tushuChubanshe;
		}

		/**
		* 获取： 图书编号
		*/
		public String getTushuUuidNumber() {
			return tushuUuidNumber;
		}
		/**
		* 设置： 图书编号
		*/
		public void setTushuUuidNumber(String tushuUuidNumber) {
			this.tushuUuidNumber = tushuUuidNumber;
		}

		/**
		* 获取： 图书照片
		*/
		public String getTushuPhoto() {
			return tushuPhoto;
		}
		/**
		* 设置： 图书照片
		*/
		public void setTushuPhoto(String tushuPhoto) {
			this.tushuPhoto = tushuPhoto;
		}

		/**
		* 获取： 现在位置
		*/
		public String getTushuAddress() {
			return tushuAddress;
		}
		/**
		* 设置： 现在位置
		*/
		public void setTushuAddress(String tushuAddress) {
			this.tushuAddress = tushuAddress;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 图书类型
		*/
		public Integer getTushuTypes() {
			return tushuTypes;
		}
		/**
		* 设置： 图书类型
		*/
		public void setTushuTypes(Integer tushuTypes) {
			this.tushuTypes = tushuTypes;
		}


			/**
			* 获取： 图书类型的值
			*/
			public String getTushuValue() {
				return tushuValue;
			}
			/**
			* 设置： 图书类型的值
			*/
			public void setTushuValue(String tushuValue) {
				this.tushuValue = tushuValue;
			}

		/**
		* 获取： 图书热度
		*/
		public Integer getTushuClicknum() {
			return tushuClicknum;
		}
		/**
		* 设置： 图书热度
		*/
		public void setTushuClicknum(Integer tushuClicknum) {
			this.tushuClicknum = tushuClicknum;
		}

		/**
		* 获取： 图书介绍
		*/
		public String getTushuContent() {
			return tushuContent;
		}
		/**
		* 设置： 图书介绍
		*/
		public void setTushuContent(String tushuContent) {
			this.tushuContent = tushuContent;
		}
		/**
		* 获取： 图书状态
		*/
		public Integer getTushuZhuangtaiTypes() {
			return tushuZhuangtaiTypes;
		}
		/**
		* 设置： 图书状态
		*/
		public void setTushuZhuangtaiTypes(Integer tushuZhuangtaiTypes) {
			this.tushuZhuangtaiTypes = tushuZhuangtaiTypes;
		}


			/**
			* 获取： 图书状态的值
			*/
			public String getTushuZhuangtaiValue() {
				return tushuZhuangtaiValue;
			}
			/**
			* 设置： 图书状态的值
			*/
			public void setTushuZhuangtaiValue(String tushuZhuangtaiValue) {
				this.tushuZhuangtaiValue = tushuZhuangtaiValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getTushuDelete() {
			return tushuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setTushuDelete(Integer tushuDelete) {
			this.tushuDelete = tushuDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "TushuCommentbackView{" +
			", tushuName=" + tushuName +
			", tushuChubanshe=" + tushuChubanshe +
			", tushuUuidNumber=" + tushuUuidNumber +
			", tushuPhoto=" + tushuPhoto +
			", tushuAddress=" + tushuAddress +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", tushuClicknum=" + tushuClicknum +
			", tushuContent=" + tushuContent +
			", tushuDelete=" + tushuDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
