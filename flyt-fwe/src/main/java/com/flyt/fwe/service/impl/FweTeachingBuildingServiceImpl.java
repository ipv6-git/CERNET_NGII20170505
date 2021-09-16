package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweTeachingBuildingMapper;
import com.flyt.fwe.domain.FweTeachingBuilding;
import com.flyt.fwe.service.IFweTeachingBuildingService;
import com.flyt.common.core.text.Convert;

/**
 * 教学楼 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweTeachingBuildingServiceImpl implements IFweTeachingBuildingService 
{
	@Autowired
	private FweTeachingBuildingMapper fweTeachingBuildingMapper;

	/**
     * 查询教学楼信息
     * 
     * @param id 教学楼ID
     * @return 教学楼信息
     */
    @Override
	public FweTeachingBuilding selectFweTeachingBuildingById(Long id)
	{
	    return fweTeachingBuildingMapper.selectFweTeachingBuildingById(id);
	}
	
	/**
     * 查询教学楼列表
     * 
     * @param fweTeachingBuilding 教学楼信息
     * @return 教学楼集合
     */
	@Override
	public List<FweTeachingBuilding> selectFweTeachingBuildingList(FweTeachingBuilding fweTeachingBuilding)
	{
	    return fweTeachingBuildingMapper.selectFweTeachingBuildingList(fweTeachingBuilding);
	}
	
    /**
     * 新增教学楼
     * 
     * @param fweTeachingBuilding 教学楼信息
     * @return 结果
     */
	@Override
	public int insertFweTeachingBuilding(FweTeachingBuilding fweTeachingBuilding)
	{
	    return fweTeachingBuildingMapper.insertFweTeachingBuilding(fweTeachingBuilding);
	}
	
	/**
     * 修改教学楼
     * 
     * @param fweTeachingBuilding 教学楼信息
     * @return 结果
     */
	@Override
	public int updateFweTeachingBuilding(FweTeachingBuilding fweTeachingBuilding)
	{
	    return fweTeachingBuildingMapper.updateFweTeachingBuilding(fweTeachingBuilding);
	}

	/**
     * 删除教学楼对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweTeachingBuildingByIds(String ids)
	{
		return fweTeachingBuildingMapper.deleteFweTeachingBuildingByIds(Convert.toStrArray(ids));
	}
	
}
