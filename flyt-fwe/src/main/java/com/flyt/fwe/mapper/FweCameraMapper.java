package com.flyt.fwe.mapper;

import com.flyt.fwe.domain.FweCamera;
import java.util.List;	

/**
 * 摄像机 数据层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface FweCameraMapper 
{
	/**
     * 查询摄像机信息
     * 
     * @param id 摄像机ID
     * @return 摄像机信息
     */
	public FweCamera selectFweCameraById(Long id);
	
	/**
     * 查询摄像机列表
     * 
     * @param fweCamera 摄像机信息
     * @return 摄像机集合
     */
	public List<FweCamera> selectFweCameraList(FweCamera fweCamera);
	
	/**
     * 新增摄像机
     * 
     * @param fweCamera 摄像机信息
     * @return 结果
     */
	public int insertFweCamera(FweCamera fweCamera);
	
	/**
     * 修改摄像机
     * 
     * @param fweCamera 摄像机信息
     * @return 结果
     */
	public int updateFweCamera(FweCamera fweCamera);
	
	/**
     * 删除摄像机
     * 
     * @param id 摄像机ID
     * @return 结果
     */
	public int deleteFweCameraById(Long id);
	
	/**
     * 批量删除摄像机
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweCameraByIds(String[] ids);
	
}