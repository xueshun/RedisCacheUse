package com.xue.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xue.redis.dao.TbUseMapper;
import com.xue.redis.entity.TbUse;

@Service
public class TbUseService {
	
	@Autowired
	private TbUseMapper useMapper;
	
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	@Cacheable(value = "TbUseService.getUseById",key = "'TbUseService.getUseById'+#id")//增加redis缓存
	public TbUse getUseById(Integer id){
		return useMapper.selectByPrimaryKey(id);
	}
}
