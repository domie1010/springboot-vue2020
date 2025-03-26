package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YundongleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YundongleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YundongleixingView;


/**
 * 运动类型
 *
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
public interface YundongleixingService extends IService<YundongleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YundongleixingVO> selectListVO(Wrapper<YundongleixingEntity> wrapper);
   	
   	YundongleixingVO selectVO(@Param("ew") Wrapper<YundongleixingEntity> wrapper);
   	
   	List<YundongleixingView> selectListView(Wrapper<YundongleixingEntity> wrapper);
   	
   	YundongleixingView selectView(@Param("ew") Wrapper<YundongleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YundongleixingEntity> wrapper);

   	

}

