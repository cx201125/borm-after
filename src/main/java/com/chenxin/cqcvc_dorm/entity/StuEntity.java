package com.chenxin.cqcvc_dorm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenxin
 * @email 2543139363@qq.com
 * @date 2020-12-24 22:05:47
 */
@Data
@TableName("stu")
public class StuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long stuId;
	/**
	 * 学号
	 */
	private String stuNum;
	/**
	 * 学生姓名
	 */
	private String stuName;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 系部
	 */
	private String department;
	/**
	 * 年级
	 */
	private String grade;
	/**
	 * 班级
	 */
	private String stuClass;
	/**
	 * 宿舍id
	 */
	private Long dormId;
	/**
	 * 0:删除，1：不删除
	 */
	@TableLogic(value = "0",delval = "1")
	private Integer disable;

}
