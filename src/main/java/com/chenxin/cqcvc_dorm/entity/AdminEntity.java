package com.chenxin.cqcvc_dorm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * 
 * @author chenxin
 * @email 2543139363@qq.com
 * @date 2020-12-19 16:30:03
 */
@Data
@TableName("admin")
public class AdminEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 管理员id
	 */
	@TableId
	private Integer adminId;
	/**
	 * 管理员年龄
	 */
	private Integer adminAge;
	/**
	 * 管理员性别（1：男，1：女）
	 */
	private Integer adminSex;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 家庭地址
	 */
	private String homeAddr;
	/**
	 * 头像
	 */
	private String headPortrait;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	private Date createtime;
	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	private Date updatetime;
	/**
	 * 是否删除（0：是，1：否）
	 */
	private Integer disable;

}
