package com.dao;

import com.entity.YundongleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YundongleixingVO;
import com.entity.view.YundongleixingView;


/**
 * 运动类型
 * 
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
public interface YundongleixingDao extends BaseMapper<YundongleixingEntity> {
	
	List<YundongleixingVO> selectListVO(@Param("ew") Wrapper<YundongleixingEntity> wrapper);
	
	YundongleixingVO selectVO(@Param("ew") Wrapper<YundongleixingEntity> wrapper);
	
	List<YundongleixingView> selectListView(@Param("ew") Wrapper<YundongleixingEntity> wrapper);

	List<YundongleixingView> selectListView(Pagination page,@Param("ew") Wrapper<YundongleixingEntity> wrapper);

	
	YundongleixingView selectView(@Param("ew") Wrapper<YundongleixingEntity> wrapper);
	

}
