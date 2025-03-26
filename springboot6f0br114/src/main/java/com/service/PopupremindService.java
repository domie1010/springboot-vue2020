package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PopupremindEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PopupremindVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PopupremindView;


/**
 * 弹窗提醒
 *
 * @author 
 * @email 
 * @date 2024-02-10 22:44:18
 */
public interface PopupremindService extends IService<PopupremindEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PopupremindVO> selectListVO(Wrapper<PopupremindEntity> wrapper);
   	
   	PopupremindVO selectVO(@Param("ew") Wrapper<PopupremindEntity> wrapper);
   	
   	List<PopupremindView> selectListView(Wrapper<PopupremindEntity> wrapper);
   	
   	PopupremindView selectView(@Param("ew") Wrapper<PopupremindEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PopupremindEntity> wrapper);

   	

}

