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


import com.dao.JianshenjianyiDao;
import com.entity.JianshenjianyiEntity;
import com.service.JianshenjianyiService;
import com.entity.vo.JianshenjianyiVO;
import com.entity.view.JianshenjianyiView;

@Service("jianshenjianyiService")
public class JianshenjianyiServiceImpl extends ServiceImpl<JianshenjianyiDao, JianshenjianyiEntity> implements JianshenjianyiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianshenjianyiEntity> page = this.selectPage(
                new Query<JianshenjianyiEntity>(params).getPage(),
                new EntityWrapper<JianshenjianyiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianshenjianyiEntity> wrapper) {
		  Page<JianshenjianyiView> page =new Query<JianshenjianyiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JianshenjianyiVO> selectListVO(Wrapper<JianshenjianyiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianshenjianyiVO selectVO(Wrapper<JianshenjianyiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianshenjianyiView> selectListView(Wrapper<JianshenjianyiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianshenjianyiView selectView(Wrapper<JianshenjianyiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
