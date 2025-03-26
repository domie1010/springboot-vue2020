package com.dao;

import com.entity.JianshenjihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianshenjihuaVO;
import com.entity.view.JianshenjihuaView;


/**
 * 健身计划
 * 
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
public interface JianshenjihuaDao extends BaseMapper<JianshenjihuaEntity> {
	
	List<JianshenjihuaVO> selectListVO(@Param("ew") Wrapper<JianshenjihuaEntity> wrapper);
	
	JianshenjihuaVO selectVO(@Param("ew") Wrapper<JianshenjihuaEntity> wrapper);
	
	List<JianshenjihuaView> selectListView(@Param("ew") Wrapper<JianshenjihuaEntity> wrapper);

	List<JianshenjihuaView> selectListView(Pagination page,@Param("ew") Wrapper<JianshenjihuaEntity> wrapper);

	
	JianshenjihuaView selectView(@Param("ew") Wrapper<JianshenjihuaEntity> wrapper);
	

}
