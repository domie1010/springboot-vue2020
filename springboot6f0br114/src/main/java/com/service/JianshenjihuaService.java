package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianshenjihuaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianshenjihuaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianshenjihuaView;


/**
 * 健身计划
 *
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
public interface JianshenjihuaService extends IService<JianshenjihuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianshenjihuaVO> selectListVO(Wrapper<JianshenjihuaEntity> wrapper);
   	
   	JianshenjihuaVO selectVO(@Param("ew") Wrapper<JianshenjihuaEntity> wrapper);
   	
   	List<JianshenjihuaView> selectListView(Wrapper<JianshenjihuaEntity> wrapper);
   	
   	JianshenjihuaView selectView(@Param("ew") Wrapper<JianshenjihuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianshenjihuaEntity> wrapper);

   	

}

