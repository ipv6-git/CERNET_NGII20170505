package com.flyt.fwe.mapper;

import com.flyt.fwe.domain.FweClass;
import java.util.List;	

/**
 * 班级 数据层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface FweClassMapper 
{
	/**
     * 查询班级信息
     * 
     * @param id 班级ID
     * @return 班级信息
     */
	public FweClass selectFweClassById(Long id);
	
	/**
     * 查询班级列表
     * 
     * @param fweClass 班级信息
     * @return 班级集合
     */
	public List<FweClass> selectFweClassList(FweClass fweClass);
	
	/**
     * 新增班级
     * 
     * @param fweClass 班级信息
     * @return 结果
     */
	public int insertFweClass(FweClass fweClass);
	
	/**
     * 修改班级
     * 
     * @param fweClass 班级信息
     * @return 结果
     */
	public int updateFweClass(FweClass fweClass);
	
	/**
     * 删除班级
     * 
     * @param id 班级ID
     * @return 结果
     */
	public int deleteFweClassById(Long id);
	
	/**
     * 批量删除班级
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweClassByIds(String[] ids);
	
}