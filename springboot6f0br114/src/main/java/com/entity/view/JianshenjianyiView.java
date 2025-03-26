package com.entity.view;

import com.entity.JianshenjianyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 健身建议
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
@TableName("jianshenjianyi")
public class JianshenjianyiView  extends JianshenjianyiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JianshenjianyiView(){
	}
 
 	public JianshenjianyiView(JianshenjianyiEntity jianshenjianyiEntity){
 	try {
			BeanUtils.copyProperties(this, jianshenjianyiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
