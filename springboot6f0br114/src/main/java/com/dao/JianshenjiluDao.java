package com.dao;

import com.entity.JianshenjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianshenjiluVO;
import com.entity.view.JianshenjiluView;


/**
 * 健身记录
 * 
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
public interface JianshenjiluDao extends BaseMapper<JianshenjiluEntity> {
	
	List<JianshenjiluVO> selectListVO(@Param("ew") Wrapper<JianshenjiluEntity> wrapper);
	
	JianshenjiluVO selectVO(@Param("ew") Wrapper<JianshenjiluEntity> wrapper);
	
	List<JianshenjiluView> selectListView(@Param("ew") Wrapper<JianshenjiluEntity> wrapper);

	List<JianshenjiluView> selectListView(Pagination page,@Param("ew") Wrapper<JianshenjiluEntity> wrapper);

	
	JianshenjiluView selectView(@Param("ew") Wrapper<JianshenjiluEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JianshenjiluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JianshenjiluEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JianshenjiluEntity> wrapper);



}
