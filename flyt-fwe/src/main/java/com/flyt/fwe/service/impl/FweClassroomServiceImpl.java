package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweClassroomMapper;
import com.flyt.fwe.domain.FweClassroom;
import com.flyt.fwe.service.IFweClassroomService;
import com.flyt.common.core.text.Convert;

/**
 * 教室 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweClassroomServiceImpl implements IFweClassroomService 
{
	@Autowired
	private FweClassroomMapper fweClassroomMapper;

	/**
     * 查询教室信息
     * 
     * @param id 教室ID
     * @return 教室信息
     */
    @Override
	public FweClassroom selectFweClassroomById(Long id)
	{
	    return fweClassroomMapper.selectFweClassroomById(id);
	}
	
	/**
     * 查询教室列表
     * 
     * @param fweClassroom 教室信息
     * @return 教室集合
     */
	@Override
	public List<FweClassroom> selectFweClassroomList(FweClassroom fweClassroom)
	{
	    return fweClassroomMapper.selectFweClassroomList(fweClassroom);
	}
	
    /**
     * 新增教室
     * 
     * @param fweClassroom 教室信息
     * @return 结果
     */
	@Override
	public int insertFweClassroom(FweClassroom fweClassroom)
	{
	    return fweClassroomMapper.insertFweClassroom(fweClassroom);
	}
	
	/**
     * 修改教室
     * 
     * @param fweClassroom 教室信息
     * @return 结果
     */
	@Override
	public int updateFweClassroom(FweClassroom fweClassroom)
	{
	    return fweClassroomMapper.updateFweClassroom(fweClassroom);
	}

	/**
     * 删除教室对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweClassroomByIds(String ids)
	{
		return fweClassroomMapper.deleteFweClassroomByIds(Convert.toStrArray(ids));
	}
	
}
