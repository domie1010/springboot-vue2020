package com.entity.vo;

import com.entity.JianshenjihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 健身计划
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
public class JianshenjihuaVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 昵称
	 */
	
	private String nicheng;
		
	/**
	 * 计划名称
	 */
	
	private String jihuamingcheng;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 训练目标
	 */
	
	private String xunlianmubiao;
		
	/**
	 * 训练频率
	 */
	
	private String xunlianpinlv;
		
	/**
	 * 具体安排
	 */
	
	private String jutianpai;
		
	/**
	 * 创建时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chuangjianshijian;
				
	
	/**
	 * 设置：昵称
	 */
	 
	public void setNicheng(String nicheng) {
		this.nicheng = nicheng;
	}
	
	/**
	 * 获取：昵称
	 */
	public String getNicheng() {
		return nicheng;
	}
				
	
	/**
	 * 设置：计划名称
	 */
	 
	public void setJihuamingcheng(String jihuamingcheng) {
		this.jihuamingcheng = jihuamingcheng;
	}
	
	/**
	 * 获取：计划名称
	 */
	public String getJihuamingcheng() {
		return jihuamingcheng;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：训练目标
	 */
	 
	public void setXunlianmubiao(String xunlianmubiao) {
		this.xunlianmubiao = xunlianmubiao;
	}
	
	/**
	 * 获取：训练目标
	 */
	public String getXunlianmubiao() {
		return xunlianmubiao;
	}
				
	
	/**
	 * 设置：训练频率
	 */
	 
	public void setXunlianpinlv(String xunlianpinlv) {
		this.xunlianpinlv = xunlianpinlv;
	}
	
	/**
	 * 获取：训练频率
	 */
	public String getXunlianpinlv() {
		return xunlianpinlv;
	}
				
	
	/**
	 * 设置：具体安排
	 */
	 
	public void setJutianpai(String jutianpai) {
		this.jutianpai = jutianpai;
	}
	
	/**
	 * 获取：具体安排
	 */
	public String getJutianpai() {
		return jutianpai;
	}
				
	
	/**
	 * 设置：创建时间
	 */
	 
	public void setChuangjianshijian(Date chuangjianshijian) {
		this.chuangjianshijian = chuangjianshijian;
	}
	
	/**
	 * 获取：创建时间
	 */
	public Date getChuangjianshijian() {
		return chuangjianshijian;
	}
			
}
