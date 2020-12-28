package com.chenxin.cqcvc_dorm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenxin
 * @email 2543139363@qq.com
 * @date 2020-12-22 19:45:30
 */
@Data
@TableName("dorm_build")
public class DormBuildEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 宿舍楼id
	 */
	@TableId
	private Integer dbId;
	/**
	 * 宿舍楼名称
	 */
	private String dbName;
	/**
	 * 宿舍楼描述
	 */
	private String dbDescribe;
	/**
	 * 宿舍楼楼层数
	 */
	private Integer dbCount;

}
