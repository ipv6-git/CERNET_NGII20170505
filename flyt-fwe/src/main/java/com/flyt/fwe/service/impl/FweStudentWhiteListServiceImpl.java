package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweStudentWhiteListMapper;
import com.flyt.fwe.domain.FweStudentWhiteList;
import com.flyt.fwe.service.IFweStudentWhiteListService;
import com.flyt.common.core.text.Convert;

/**
 * 缺课白名单 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweStudentWhiteListServiceImpl implements IFweStudentWhiteListService 
{
	@Autowired
	private FweStudentWhiteListMapper fweStudentWhiteListMapper;

	/**
     * 查询缺课白名单信息
     * 
     * @param id 缺课白名单ID
     * @return 缺课白名单信息
     */
    @Override
	public FweStudentWhiteList selectFweStudentWhiteListById(Long id)
	{
	    return fweStudentWhiteListMapper.selectFweStudentWhiteListById(id);
	}
	
	/**
     * 查询缺课白名单列表
     * 
     * @param fweStudentWhiteList 缺课白名单信息
     * @return 缺课白名单集合
     */
	@Override
	public List<FweStudentWhiteList> selectFweStudentWhiteListList(FweStudentWhiteList fweStudentWhiteList)
	{
	    return fweStudentWhiteListMapper.selectFweStudentWhiteListList(fweStudentWhiteList);
	}
	
    /**
     * 新增缺课白名单
     * 
     * @param fweStudentWhiteList 缺课白名单信息
     * @return 结果
     */
	@Override
	public int insertFweStudentWhiteList(FweStudentWhiteList fweStudentWhiteList)
	{
	    return fweStudentWhiteListMapper.insertFweStudentWhiteList(fweStudentWhiteList);
	}
	
	/**
     * 修改缺课白名单
     * 
     * @param fweStudentWhiteList 缺课白名单信息
     * @return 结果
     */
	@Override
	public int updateFweStudentWhiteList(FweStudentWhiteList fweStudentWhiteList)
	{
	    return fweStudentWhiteListMapper.updateFweStudentWhiteList(fweStudentWhiteList);
	}

	/**
     * 删除缺课白名单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweStudentWhiteListByIds(String ids)
	{
		return fweStudentWhiteListMapper.deleteFweStudentWhiteListByIds(Convert.toStrArray(ids));
	}
	
}
