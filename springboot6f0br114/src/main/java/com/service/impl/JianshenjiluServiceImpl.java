package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JianshenjiluDao;
import com.entity.JianshenjiluEntity;
import com.service.JianshenjiluService;
import com.entity.vo.JianshenjiluVO;
import com.entity.view.JianshenjiluView;

@Service("jianshenjiluService")
public class JianshenjiluServiceImpl extends ServiceImpl<JianshenjiluDao, JianshenjiluEntity> implements JianshenjiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianshenjiluEntity> page = this.selectPage(
                new Query<JianshenjiluEntity>(params).getPage(),
                new EntityWrapper<JianshenjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianshenjiluEntity> wrapper) {
		  Page<JianshenjiluView> page =new Query<JianshenjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JianshenjiluVO> selectListVO(Wrapper<JianshenjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianshenjiluVO selectVO(Wrapper<JianshenjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianshenjiluView> selectListView(Wrapper<JianshenjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianshenjiluView selectView(Wrapper<JianshenjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JianshenjiluEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JianshenjiluEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JianshenjiluEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
