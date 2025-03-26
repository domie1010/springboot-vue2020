package com.entity.view;

import com.entity.YundongleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 运动类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
@TableName("yundongleixing")
public class YundongleixingView  extends YundongleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YundongleixingView(){
	}
 
 	public YundongleixingView(YundongleixingEntity yundongleixingEntity){
 	try {
			BeanUtils.copyProperties(this, yundongleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
