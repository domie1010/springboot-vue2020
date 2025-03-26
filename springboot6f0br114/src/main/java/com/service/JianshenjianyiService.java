package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianshenjianyiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianshenjianyiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianshenjianyiView;


/**
 * 健身建议
 *
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
public interface JianshenjianyiService extends IService<JianshenjianyiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianshenjianyiVO> selectListVO(Wrapper<JianshenjianyiEntity> wrapper);
   	
   	JianshenjianyiVO selectVO(@Param("ew") Wrapper<JianshenjianyiEntity> wrapper);
   	
   	List<JianshenjianyiView> selectListView(Wrapper<JianshenjianyiEntity> wrapper);
   	
   	JianshenjianyiView selectView(@Param("ew") Wrapper<JianshenjianyiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianshenjianyiEntity> wrapper);

   	

}

