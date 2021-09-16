package com.flyt.fwe.mapper;

import com.flyt.fwe.domain.FweMajor;
import java.util.List;	

/**
 * 专业 数据层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface FweMajorMapper 
{
	/**
     * 查询专业信息
     * 
     * @param id 专业ID
     * @return 专业信息
     */
	public FweMajor selectFweMajorById(Long id);
	
	/**
     * 查询专业列表
     * 
     * @param fweMajor 专业信息
     * @return 专业集合
     */
	public List<FweMajor> selectFweMajorList(FweMajor fweMajor);
	
	/**
     * 新增专业
     * 
     * @param fweMajor 专业信息
     * @return 结果
     */
	public int insertFweMajor(FweMajor fweMajor);
	
	/**
     * 修改专业
     * 
     * @param fweMajor 专业信息
     * @return 结果
     */
	public int updateFweMajor(FweMajor fweMajor);
	
	/**
     * 删除专业
     * 
     * @param id 专业ID
     * @return 结果
     */
	public int deleteFweMajorById(Long id);
	
	/**
     * 批量删除专业
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweMajorByIds(String[] ids);
	
}