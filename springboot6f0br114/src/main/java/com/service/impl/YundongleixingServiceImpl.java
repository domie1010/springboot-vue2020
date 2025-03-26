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


import com.dao.YundongleixingDao;
import com.entity.YundongleixingEntity;
import com.service.YundongleixingService;
import com.entity.vo.YundongleixingVO;
import com.entity.view.YundongleixingView;

@Service("yundongleixingService")
public class YundongleixingServiceImpl extends ServiceImpl<YundongleixingDao, YundongleixingEntity> implements YundongleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YundongleixingEntity> page = this.selectPage(
                new Query<YundongleixingEntity>(params).getPage(),
                new EntityWrapper<YundongleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YundongleixingEntity> wrapper) {
		  Page<YundongleixingView> page =new Query<YundongleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YundongleixingVO> selectListVO(Wrapper<YundongleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YundongleixingVO selectVO(Wrapper<YundongleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YundongleixingView> selectListView(Wrapper<YundongleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YundongleixingView selectView(Wrapper<YundongleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
