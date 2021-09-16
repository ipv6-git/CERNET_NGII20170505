package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweTeachingBuildingFloorMapper;
import com.flyt.fwe.domain.FweTeachingBuildingFloor;
import com.flyt.fwe.service.IFweTeachingBuildingFloorService;
import com.flyt.common.core.text.Convert;

/**
 * 教学楼楼层 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweTeachingBuildingFloorServiceImpl implements IFweTeachingBuildingFloorService 
{
	@Autowired
	private FweTeachingBuildingFloorMapper fweTeachingBuildingFloorMapper;

	/**
     * 查询教学楼楼层信息
     * 
     * @param id 教学楼楼层ID
     * @return 教学楼楼层信息
     */
    @Override
	public FweTeachingBuildingFloor selectFweTeachingBuildingFloorById(Long id)
	{
	    return fweTeachingBuildingFloorMapper.selectFweTeachingBuildingFloorById(id);
	}
	
	/**
     * 查询教学楼楼层列表
     * 
     * @param fweTeachingBuildingFloor 教学楼楼层信息
     * @return 教学楼楼层集合
     */
	@Override
	public List<FweTeachingBuildingFloor> selectFweTeachingBuildingFloorList(FweTeachingBuildingFloor fweTeachingBuildingFloor)
	{
	    return fweTeachingBuildingFloorMapper.selectFweTeachingBuildingFloorList(fweTeachingBuildingFloor);
	}
	
    /**
     * 新增教学楼楼层
     * 
     * @param fweTeachingBuildingFloor 教学楼楼层信息
     * @return 结果
     */
	@Override
	public int insertFweTeachingBuildingFloor(FweTeachingBuildingFloor fweTeachingBuildingFloor)
	{
	    return fweTeachingBuildingFloorMapper.insertFweTeachingBuildingFloor(fweTeachingBuildingFloor);
	}
	
	/**
     * 修改教学楼楼层
     * 
     * @param fweTeachingBuildingFloor 教学楼楼层信息
     * @return 结果
     */
	@Override
	public int updateFweTeachingBuildingFloor(FweTeachingBuildingFloor fweTeachingBuildingFloor)
	{
	    return fweTeachingBuildingFloorMapper.updateFweTeachingBuildingFloor(fweTeachingBuildingFloor);
	}

	/**
     * 删除教学楼楼层对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweTeachingBuildingFloorByIds(String ids)
	{
		return fweTeachingBuildingFloorMapper.deleteFweTeachingBuildingFloorByIds(Convert.toStrArray(ids));
	}
	
}
