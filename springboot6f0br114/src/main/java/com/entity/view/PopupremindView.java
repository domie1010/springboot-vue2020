package com.entity.view;

import com.entity.PopupremindEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 弹窗提醒
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-10 22:44:18
 */
@TableName("popupremind")
public class PopupremindView  extends PopupremindEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PopupremindView(){
	}
 
 	public PopupremindView(PopupremindEntity popupremindEntity){
 	try {
			BeanUtils.copyProperties(this, popupremindEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
