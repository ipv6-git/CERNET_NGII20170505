package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweMajorMapper;
import com.flyt.fwe.domain.FweMajor;
import com.flyt.fwe.service.IFweMajorService;
import com.flyt.common.core.text.Convert;

/**
 * 专业 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweMajorServiceImpl implements IFweMajorService 
{
	@Autowired
	private FweMajorMapper fweMajorMapper;

	/**
     * 查询专业信息
     * 
     * @param id 专业ID
     * @return 专业信息
     */
    @Override
	public FweMajor selectFweMajorById(Long id)
	{
	    return fweMajorMapper.selectFweMajorById(id);
	}
	
	/**
     * 查询专业列表
     * 
     * @param fweMajor 专业信息
     * @return 专业集合
     */
	@Override
	public List<FweMajor> selectFweMajorList(FweMajor fweMajor)
	{
	    return fweMajorMapper.selectFweMajorList(fweMajor);
	}
	
    /**
     * 新增专业
     * 
     * @param fweMajor 专业信息
     * @return 结果
     */
	@Override
	public int insertFweMajor(FweMajor fweMajor)
	{
	    return fweMajorMapper.insertFweMajor(fweMajor);
	}
	
	/**
     * 修改专业
     * 
     * @param fweMajor 专业信息
     * @return 结果
     */
	@Override
	public int updateFweMajor(FweMajor fweMajor)
	{
	    return fweMajorMapper.updateFweMajor(fweMajor);
	}

	/**
     * 删除专业对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweMajorByIds(String ids)
	{
		return fweMajorMapper.deleteFweMajorByIds(Convert.toStrArray(ids));
	}
	
}
