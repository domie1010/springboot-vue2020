package com.entity.view;

import com.entity.YinshijianyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 饮食建议
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
@TableName("yinshijianyi")
public class YinshijianyiView  extends YinshijianyiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YinshijianyiView(){
	}
 
 	public YinshijianyiView(YinshijianyiEntity yinshijianyiEntity){
 	try {
			BeanUtils.copyProperties(this, yinshijianyiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
