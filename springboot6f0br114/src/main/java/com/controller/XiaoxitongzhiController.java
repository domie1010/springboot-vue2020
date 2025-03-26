package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XiaoxitongzhiEntity;
import com.entity.view.XiaoxitongzhiView;

import com.service.XiaoxitongzhiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 消息通知
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
@RestController
@RequestMapping("/xiaoxitongzhi")
public class XiaoxitongzhiController {
    @Autowired
    private XiaoxitongzhiService xiaoxitongzhiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaoxitongzhiEntity xiaoxitongzhi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xiaoxitongzhi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiaoxitongzhiEntity> ew = new EntityWrapper<XiaoxitongzhiEntity>();

		PageUtils page = xiaoxitongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoxitongzhi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaoxitongzhiEntity xiaoxitongzhi, 
		HttpServletRequest request){
        EntityWrapper<XiaoxitongzhiEntity> ew = new EntityWrapper<XiaoxitongzhiEntity>();

		PageUtils page = xiaoxitongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoxitongzhi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaoxitongzhiEntity xiaoxitongzhi){
       	EntityWrapper<XiaoxitongzhiEntity> ew = new EntityWrapper<XiaoxitongzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaoxitongzhi, "xiaoxitongzhi")); 
        return R.ok().put("data", xiaoxitongzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaoxitongzhiEntity xiaoxitongzhi){
        EntityWrapper< XiaoxitongzhiEntity> ew = new EntityWrapper< XiaoxitongzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaoxitongzhi, "xiaoxitongzhi")); 
		XiaoxitongzhiView xiaoxitongzhiView =  xiaoxitongzhiService.selectView(ew);
		return R.ok("查询消息通知成功").put("data", xiaoxitongzhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaoxitongzhiEntity xiaoxitongzhi = xiaoxitongzhiService.selectById(id);
        return R.ok().put("data", xiaoxitongzhi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaoxitongzhiEntity xiaoxitongzhi = xiaoxitongzhiService.selectById(id);
        return R.ok().put("data", xiaoxitongzhi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoxitongzhiEntity xiaoxitongzhi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xiaoxitongzhi);
        xiaoxitongzhiService.insert(xiaoxitongzhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaoxitongzhiEntity xiaoxitongzhi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xiaoxitongzhi);
        xiaoxitongzhiService.insert(xiaoxitongzhi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiaoxitongzhiEntity xiaoxitongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaoxitongzhi);
        xiaoxitongzhiService.updateById(xiaoxitongzhi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaoxitongzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
