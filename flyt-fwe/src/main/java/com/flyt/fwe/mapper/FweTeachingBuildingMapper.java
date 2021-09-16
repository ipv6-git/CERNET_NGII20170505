package com.flyt.fwe.mapper;

import com.flyt.fwe.domain.FweTeachingBuilding;
import java.util.List;	

/**
 * 教学楼 数据层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface FweTeachingBuildingMapper 
{
	/**
     * 查询教学楼信息
     * 
     * @param id 教学楼ID
     * @return 教学楼信息
     */
	public FweTeachingBuilding selectFweTeachingBuildingById(Long id);
	
	/**
     * 查询教学楼列表
     * 
     * @param fweTeachingBuilding 教学楼信息
     * @return 教学楼集合
     */
	public List<FweTeachingBuilding> selectFweTeachingBuildingList(FweTeachingBuilding fweTeachingBuilding);
	
	/**
     * 新增教学楼
     * 
     * @param fweTeachingBuilding 教学楼信息
     * @return 结果
     */
	public int insertFweTeachingBuilding(FweTeachingBuilding fweTeachingBuilding);
	
	/**
     * 修改教学楼
     * 
     * @param fweTeachingBuilding 教学楼信息
     * @return 结果
     */
	public int updateFweTeachingBuilding(FweTeachingBuilding fweTeachingBuilding);
	
	/**
     * 删除教学楼
     * 
     * @param id 教学楼ID
     * @return 结果
     */
	public int deleteFweTeachingBuildingById(Long id);
	
	/**
     * 批量删除教学楼
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweTeachingBuildingByIds(String[] ids);
	
}