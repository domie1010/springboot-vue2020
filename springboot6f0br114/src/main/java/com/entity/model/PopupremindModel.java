package com.entity.model;

import com.entity.PopupremindEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 弹窗提醒
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-02-10 22:44:18
 */
public class PopupremindModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 标题
	 */
	
	private String title;
		
	/**
	 * 类型
	 */
	
	private String type;
		
	/**
	 * 简介
	 */
	
	private String brief;
		
	/**
	 * 内容
	 */
	
	private String content;
		
	/**
	 * 提醒时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date remindtime;
				
	
	/**
	 * 设置：标题
	 */
	 
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
				
	
	/**
	 * 设置：类型
	 */
	 
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
				
	
	/**
	 * 设置：简介
	 */
	 
	public void setBrief(String brief) {
		this.brief = brief;
	}
	
	/**
	 * 获取：简介
	 */
	public String getBrief() {
		return brief;
	}
				
	
	/**
	 * 设置：内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
				
	
	/**
	 * 设置：提醒时间
	 */
	 
	public void setRemindtime(Date remindtime) {
		this.remindtime = remindtime;
	}
	
	/**
	 * 获取：提醒时间
	 */
	public Date getRemindtime() {
		return remindtime;
	}
			
}
