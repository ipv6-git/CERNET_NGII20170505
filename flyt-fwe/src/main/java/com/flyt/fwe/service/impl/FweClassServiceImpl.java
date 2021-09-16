package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweClassMapper;
import com.flyt.fwe.domain.FweClass;
import com.flyt.fwe.service.IFweClassService;
import com.flyt.common.core.text.Convert;

/**
 * 班级 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweClassServiceImpl implements IFweClassService 
{
	@Autowired
	private FweClassMapper fweClassMapper;

	/**
     * 查询班级信息
     * 
     * @param id 班级ID
     * @return 班级信息
     */
    @Override
	public FweClass selectFweClassById(Long id)
	{
	    return fweClassMapper.selectFweClassById(id);
	}
	
	/**
     * 查询班级列表
     * 
     * @param fweClass 班级信息
     * @return 班级集合
     */
	@Override
	public List<FweClass> selectFweClassList(FweClass fweClass)
	{
	    return fweClassMapper.selectFweClassList(fweClass);
	}
	
    /**
     * 新增班级
     * 
     * @param fweClass 班级信息
     * @return 结果
     */
	@Override
	public int insertFweClass(FweClass fweClass)
	{
	    return fweClassMapper.insertFweClass(fweClass);
	}
	
	/**
     * 修改班级
     * 
     * @param fweClass 班级信息
     * @return 结果
     */
	@Override
	public int updateFweClass(FweClass fweClass)
	{
	    return fweClassMapper.updateFweClass(fweClass);
	}

	/**
     * 删除班级对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweClassByIds(String ids)
	{
		return fweClassMapper.deleteFweClassByIds(Convert.toStrArray(ids));
	}
	
}
