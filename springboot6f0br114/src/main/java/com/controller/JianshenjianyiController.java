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

import com.entity.JianshenjianyiEntity;
import com.entity.view.JianshenjianyiView;

import com.service.JianshenjianyiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 健身建议
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-10 22:44:17
 */
@RestController
@RequestMapping("/jianshenjianyi")
public class JianshenjianyiController {
    @Autowired
    private JianshenjianyiService jianshenjianyiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianshenjianyiEntity jianshenjianyi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jianshenjianyi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JianshenjianyiEntity> ew = new EntityWrapper<JianshenjianyiEntity>();

		PageUtils page = jianshenjianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenjianyi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianshenjianyiEntity jianshenjianyi, 
		HttpServletRequest request){
        EntityWrapper<JianshenjianyiEntity> ew = new EntityWrapper<JianshenjianyiEntity>();

		PageUtils page = jianshenjianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenjianyi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianshenjianyiEntity jianshenjianyi){
       	EntityWrapper<JianshenjianyiEntity> ew = new EntityWrapper<JianshenjianyiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianshenjianyi, "jianshenjianyi")); 
        return R.ok().put("data", jianshenjianyiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianshenjianyiEntity jianshenjianyi){
        EntityWrapper< JianshenjianyiEntity> ew = new EntityWrapper< JianshenjianyiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianshenjianyi, "jianshenjianyi")); 
		JianshenjianyiView jianshenjianyiView =  jianshenjianyiService.selectView(ew);
		return R.ok("查询健身建议成功").put("data", jianshenjianyiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianshenjianyiEntity jianshenjianyi = jianshenjianyiService.selectById(id);
        return R.ok().put("data", jianshenjianyi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianshenjianyiEntity jianshenjianyi = jianshenjianyiService.selectById(id);
        return R.ok().put("data", jianshenjianyi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianshenjianyiEntity jianshenjianyi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jianshenjianyi);
        jianshenjianyiService.insert(jianshenjianyi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianshenjianyiEntity jianshenjianyi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jianshenjianyi);
        jianshenjianyiService.insert(jianshenjianyi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianshenjianyiEntity jianshenjianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianshenjianyi);
        jianshenjianyiService.updateById(jianshenjianyi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianshenjianyiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
