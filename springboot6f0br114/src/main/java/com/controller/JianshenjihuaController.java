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

import com.entity.JianshenjihuaEntity;
import com.entity.view.JianshenjihuaView;

import com.service.JianshenjihuaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 健身计划
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
@RestController
@RequestMapping("/jianshenjihua")
public class JianshenjihuaController {
    @Autowired
    private JianshenjihuaService jianshenjihuaService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianshenjihuaEntity jianshenjihua,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jianshenjihua.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JianshenjihuaEntity> ew = new EntityWrapper<JianshenjihuaEntity>();

		PageUtils page = jianshenjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenjihua), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianshenjihuaEntity jianshenjihua, 
		HttpServletRequest request){
        EntityWrapper<JianshenjihuaEntity> ew = new EntityWrapper<JianshenjihuaEntity>();

		PageUtils page = jianshenjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenjihua), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianshenjihuaEntity jianshenjihua){
       	EntityWrapper<JianshenjihuaEntity> ew = new EntityWrapper<JianshenjihuaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianshenjihua, "jianshenjihua")); 
        return R.ok().put("data", jianshenjihuaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianshenjihuaEntity jianshenjihua){
        EntityWrapper< JianshenjihuaEntity> ew = new EntityWrapper< JianshenjihuaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianshenjihua, "jianshenjihua")); 
		JianshenjihuaView jianshenjihuaView =  jianshenjihuaService.selectView(ew);
		return R.ok("查询健身计划成功").put("data", jianshenjihuaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianshenjihuaEntity jianshenjihua = jianshenjihuaService.selectById(id);
        return R.ok().put("data", jianshenjihua);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianshenjihuaEntity jianshenjihua = jianshenjihuaService.selectById(id);
        return R.ok().put("data", jianshenjihua);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianshenjihuaEntity jianshenjihua, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jianshenjihua);
        jianshenjihuaService.insert(jianshenjihua);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianshenjihuaEntity jianshenjihua, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jianshenjihua);
        jianshenjihuaService.insert(jianshenjihua);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianshenjihuaEntity jianshenjihua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianshenjihua);
        jianshenjihuaService.updateById(jianshenjihua);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianshenjihuaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
