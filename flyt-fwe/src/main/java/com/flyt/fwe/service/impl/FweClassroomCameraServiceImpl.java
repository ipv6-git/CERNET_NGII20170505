package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweClassroomCameraMapper;
import com.flyt.fwe.domain.FweClassroomCamera;
import com.flyt.fwe.service.IFweClassroomCameraService;
import com.flyt.common.core.text.Convert;

/**
 * 教室摄像机 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweClassroomCameraServiceImpl implements IFweClassroomCameraService 
{
	@Autowired
	private FweClassroomCameraMapper fweClassroomCameraMapper;

	/**
     * 查询教室摄像机信息
     * 
     * @param id 教室摄像机ID
     * @return 教室摄像机信息
     */
    @Override
	public FweClassroomCamera selectFweClassroomCameraById(Long id)
	{
	    return fweClassroomCameraMapper.selectFweClassroomCameraById(id);
	}
	
	/**
     * 查询教室摄像机列表
     * 
     * @param fweClassroomCamera 教室摄像机信息
     * @return 教室摄像机集合
     */
	@Override
	public List<FweClassroomCamera> selectFweClassroomCameraList(FweClassroomCamera fweClassroomCamera)
	{
	    return fweClassroomCameraMapper.selectFweClassroomCameraList(fweClassroomCamera);
	}
	
    /**
     * 新增教室摄像机
     * 
     * @param fweClassroomCamera 教室摄像机信息
     * @return 结果
     */
	@Override
	public int insertFweClassroomCamera(FweClassroomCamera fweClassroomCamera)
	{
	    return fweClassroomCameraMapper.insertFweClassroomCamera(fweClassroomCamera);
	}
	
	/**
     * 修改教室摄像机
     * 
     * @param fweClassroomCamera 教室摄像机信息
     * @return 结果
     */
	@Override
	public int updateFweClassroomCamera(FweClassroomCamera fweClassroomCamera)
	{
	    return fweClassroomCameraMapper.updateFweClassroomCamera(fweClassroomCamera);
	}

	/**
     * 删除教室摄像机对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweClassroomCameraByIds(String ids)
	{
		return fweClassroomCameraMapper.deleteFweClassroomCameraByIds(Convert.toStrArray(ids));
	}
	
}
