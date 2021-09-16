package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweCameraMapper;
import com.flyt.fwe.domain.FweCamera;
import com.flyt.fwe.service.IFweCameraService;
import com.flyt.common.core.text.Convert;

/**
 * 摄像机 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweCameraServiceImpl implements IFweCameraService 
{
	@Autowired
	private FweCameraMapper fweCameraMapper;

	/**
     * 查询摄像机信息
     * 
     * @param id 摄像机ID
     * @return 摄像机信息
     */
    @Override
	public FweCamera selectFweCameraById(Long id)
	{
	    return fweCameraMapper.selectFweCameraById(id);
	}
	
	/**
     * 查询摄像机列表
     * 
     * @param fweCamera 摄像机信息
     * @return 摄像机集合
     */
	@Override
	public List<FweCamera> selectFweCameraList(FweCamera fweCamera)
	{
	    return fweCameraMapper.selectFweCameraList(fweCamera);
	}
	
    /**
     * 新增摄像机
     * 
     * @param fweCamera 摄像机信息
     * @return 结果
     */
	@Override
	public int insertFweCamera(FweCamera fweCamera)
	{
	    return fweCameraMapper.insertFweCamera(fweCamera);
	}
	
	/**
     * 修改摄像机
     * 
     * @param fweCamera 摄像机信息
     * @return 结果
     */
	@Override
	public int updateFweCamera(FweCamera fweCamera)
	{
	    return fweCameraMapper.updateFweCamera(fweCamera);
	}

	/**
     * 删除摄像机对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweCameraByIds(String ids)
	{
		return fweCameraMapper.deleteFweCameraByIds(Convert.toStrArray(ids));
	}
	
}
