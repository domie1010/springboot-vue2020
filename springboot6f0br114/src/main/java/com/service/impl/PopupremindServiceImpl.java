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


import com.dao.PopupremindDao;
import com.entity.PopupremindEntity;
import com.service.PopupremindService;
import com.entity.vo.PopupremindVO;
import com.entity.view.PopupremindView;

@Service("popupremindService")
public class PopupremindServiceImpl extends ServiceImpl<PopupremindDao, PopupremindEntity> implements PopupremindService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PopupremindEntity> page = this.selectPage(
                new Query<PopupremindEntity>(params).getPage(),
                new EntityWrapper<PopupremindEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PopupremindEntity> wrapper) {
		  Page<PopupremindView> page =new Query<PopupremindView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PopupremindVO> selectListVO(Wrapper<PopupremindEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PopupremindVO selectVO(Wrapper<PopupremindEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PopupremindView> selectListView(Wrapper<PopupremindEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PopupremindView selectView(Wrapper<PopupremindEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
