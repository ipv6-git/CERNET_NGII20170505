package com.flyt.fwe.mapper;

import com.flyt.fwe.domain.FweTeachingBuildingFloor;
import java.util.List;	

/**
 * 教学楼楼层 数据层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface FweTeachingBuildingFloorMapper 
{
	/**
     * 查询教学楼楼层信息
     * 
     * @param id 教学楼楼层ID
     * @return 教学楼楼层信息
     */
	public FweTeachingBuildingFloor selectFweTeachingBuildingFloorById(Long id);
	
	/**
     * 查询教学楼楼层列表
     * 
     * @param fweTeachingBuildingFloor 教学楼楼层信息
     * @return 教学楼楼层集合
     */
	public List<FweTeachingBuildingFloor> selectFweTeachingBuildingFloorList(FweTeachingBuildingFloor fweTeachingBuildingFloor);
	
	/**
     * 新增教学楼楼层
     * 
     * @param fweTeachingBuildingFloor 教学楼楼层信息
     * @return 结果
     */
	public int insertFweTeachingBuildingFloor(FweTeachingBuildingFloor fweTeachingBuildingFloor);
	
	/**
     * 修改教学楼楼层
     * 
     * @param fweTeachingBuildingFloor 教学楼楼层信息
     * @return 结果
     */
	public int updateFweTeachingBuildingFloor(FweTeachingBuildingFloor fweTeachingBuildingFloor);
	
	/**
     * 删除教学楼楼层
     * 
     * @param id 教学楼楼层ID
     * @return 结果
     */
	public int deleteFweTeachingBuildingFloorById(Long id);
	
	/**
     * 批量删除教学楼楼层
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweTeachingBuildingFloorByIds(String[] ids);
	
}