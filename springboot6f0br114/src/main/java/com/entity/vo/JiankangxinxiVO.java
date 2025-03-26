package com.entity.vo;

import com.entity.JiankangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 健康信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
public class JiankangxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 昵称
	 */
	
	private String nicheng;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 年龄
	 */
	
	private String nianling;
		
	/**
	 * 身高(cm)
	 */
	
	private Double shengao;
		
	/**
	 * 体重(kg)
	 */
	
	private Double tizhong;
		
	/**
	 * 腰围(cm)
	 */
	
	private Double yaowei;
		
	/**
	 * 体脂率(%)
	 */
	
	private Double tizhilv;
		
	/**
	 * 心率(次/分钟)
	 */
	
	private Double xinlv;
		
	/**
	 * 空腹血糖(mmol/L)
	 */
	
	private Double kongfuxuetang;
		
	/**
	 * 记录时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jilushijian;
				
	
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
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：年龄
	 */
	 
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
				
	
	/**
	 * 设置：身高(cm)
	 */
	 
	public void setShengao(Double shengao) {
		this.shengao = shengao;
	}
	
	/**
	 * 获取：身高(cm)
	 */
	public Double getShengao() {
		return shengao;
	}
				
	
	/**
	 * 设置：体重(kg)
	 */
	 
	public void setTizhong(Double tizhong) {
		this.tizhong = tizhong;
	}
	
	/**
	 * 获取：体重(kg)
	 */
	public Double getTizhong() {
		return tizhong;
	}
				
	
	/**
	 * 设置：腰围(cm)
	 */
	 
	public void setYaowei(Double yaowei) {
		this.yaowei = yaowei;
	}
	
	/**
	 * 获取：腰围(cm)
	 */
	public Double getYaowei() {
		return yaowei;
	}
				
	
	/**
	 * 设置：体脂率(%)
	 */
	 
	public void setTizhilv(Double tizhilv) {
		this.tizhilv = tizhilv;
	}
	
	/**
	 * 获取：体脂率(%)
	 */
	public Double getTizhilv() {
		return tizhilv;
	}
				
	
	/**
	 * 设置：心率(次/分钟)
	 */
	 
	public void setXinlv(Double xinlv) {
		this.xinlv = xinlv;
	}
	
	/**
	 * 获取：心率(次/分钟)
	 */
	public Double getXinlv() {
		return xinlv;
	}
				
	
	/**
	 * 设置：空腹血糖(mmol/L)
	 */
	 
	public void setKongfuxuetang(Double kongfuxuetang) {
		this.kongfuxuetang = kongfuxuetang;
	}
	
	/**
	 * 获取：空腹血糖(mmol/L)
	 */
	public Double getKongfuxuetang() {
		return kongfuxuetang;
	}
				
	
	/**
	 * 设置：记录时间
	 */
	 
	public void setJilushijian(Date jilushijian) {
		this.jilushijian = jilushijian;
	}
	
	/**
	 * 获取：记录时间
	 */
	public Date getJilushijian() {
		return jilushijian;
	}
			
}
