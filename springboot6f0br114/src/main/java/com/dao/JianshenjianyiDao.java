package com.dao;

import com.entity.JianshenjianyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianshenjianyiVO;
import com.entity.view.JianshenjianyiView;


/**
 * 健身建议
 * 
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
public interface JianshenjianyiDao extends BaseMapper<JianshenjianyiEntity> {
	
	List<JianshenjianyiVO> selectListVO(@Param("ew") Wrapper<JianshenjianyiEntity> wrapper);
	
	JianshenjianyiVO selectVO(@Param("ew") Wrapper<JianshenjianyiEntity> wrapper);
	
	List<JianshenjianyiView> selectListView(@Param("ew") Wrapper<JianshenjianyiEntity> wrapper);

	List<JianshenjianyiView> selectListView(Pagination page,@Param("ew") Wrapper<JianshenjianyiEntity> wrapper);

	
	JianshenjianyiView selectView(@Param("ew") Wrapper<JianshenjianyiEntity> wrapper);
	

}
