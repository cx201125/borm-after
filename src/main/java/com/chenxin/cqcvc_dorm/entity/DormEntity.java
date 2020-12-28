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
 * @date 2020-12-22 22:07:07
 */
@Data
@TableName("dorm")
public class DormEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 宿舍id
	 */
	@TableId
	private Long dormId;
	/**
	 * 楼层
	 */
	private Integer floor;
	/**
	 * 门牌号
	 */
	private Integer houNum;
	/**
	 * 床位数量
	 */
	private Integer bedCount;
	/**
	 * 是否用于入住学生（0:是，1:否）
	 */
	private Integer isReside;
	/**
	 * 描述
	 */
	private String dormDescribe;
	/**
	 * 宿舍楼id
	 */
	private Integer dormBuildId;

}
