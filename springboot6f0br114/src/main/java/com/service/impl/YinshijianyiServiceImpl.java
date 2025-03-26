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


import com.dao.YinshijianyiDao;
import com.entity.YinshijianyiEntity;
import com.service.YinshijianyiService;
import com.entity.vo.YinshijianyiVO;
import com.entity.view.YinshijianyiView;

@Service("yinshijianyiService")
public class YinshijianyiServiceImpl extends ServiceImpl<YinshijianyiDao, YinshijianyiEntity> implements YinshijianyiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinshijianyiEntity> page = this.selectPage(
                new Query<YinshijianyiEntity>(params).getPage(),
                new EntityWrapper<YinshijianyiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinshijianyiEntity> wrapper) {
		  Page<YinshijianyiView> page =new Query<YinshijianyiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YinshijianyiVO> selectListVO(Wrapper<YinshijianyiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YinshijianyiVO selectVO(Wrapper<YinshijianyiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YinshijianyiView> selectListView(Wrapper<YinshijianyiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinshijianyiView selectView(Wrapper<YinshijianyiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
