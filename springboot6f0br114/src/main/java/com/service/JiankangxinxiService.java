package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiankangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiankangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiankangxinxiView;


/**
 * 健康信息
 *
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
public interface JiankangxinxiService extends IService<JiankangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangxinxiVO> selectListVO(Wrapper<JiankangxinxiEntity> wrapper);
   	
   	JiankangxinxiVO selectVO(@Param("ew") Wrapper<JiankangxinxiEntity> wrapper);
   	
   	List<JiankangxinxiView> selectListView(Wrapper<JiankangxinxiEntity> wrapper);
   	
   	JiankangxinxiView selectView(@Param("ew") Wrapper<JiankangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangxinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JiankangxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JiankangxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JiankangxinxiEntity> wrapper);



}

