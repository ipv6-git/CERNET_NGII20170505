package com.flyt.fwe.mapper;

import com.flyt.fwe.domain.FweClassroomCamera;
import java.util.List;	

/**
 * 教室摄像机 数据层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface FweClassroomCameraMapper 
{
	/**
     * 查询教室摄像机信息
     * 
     * @param id 教室摄像机ID
     * @return 教室摄像机信息
     */
	public FweClassroomCamera selectFweClassroomCameraById(Long id);
	
	/**
     * 查询教室摄像机列表
     * 
     * @param fweClassroomCamera 教室摄像机信息
     * @return 教室摄像机集合
     */
	public List<FweClassroomCamera> selectFweClassroomCameraList(FweClassroomCamera fweClassroomCamera);
	
	/**
     * 新增教室摄像机
     * 
     * @param fweClassroomCamera 教室摄像机信息
     * @return 结果
     */
	public int insertFweClassroomCamera(FweClassroomCamera fweClassroomCamera);
	
	/**
     * 修改教室摄像机
     * 
     * @param fweClassroomCamera 教室摄像机信息
     * @return 结果
     */
	public int updateFweClassroomCamera(FweClassroomCamera fweClassroomCamera);
	
	/**
     * 删除教室摄像机
     * 
     * @param id 教室摄像机ID
     * @return 结果
     */
	public int deleteFweClassroomCameraById(Long id);
	
	/**
     * 批量删除教室摄像机
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweClassroomCameraByIds(String[] ids);
	
}