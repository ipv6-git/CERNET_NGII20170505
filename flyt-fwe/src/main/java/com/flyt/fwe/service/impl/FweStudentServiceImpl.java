package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweStudentMapper;
import com.flyt.fwe.domain.FweStudent;
import com.flyt.fwe.service.IFweStudentService;
import com.flyt.common.core.text.Convert;

/**
 * 学生 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweStudentServiceImpl implements IFweStudentService 
{
	@Autowired
	private FweStudentMapper fweStudentMapper;

	/**
     * 查询学生信息
     * 
     * @param id 学生ID
     * @return 学生信息
     */
    @Override
	public FweStudent selectFweStudentById(Long id)
	{
	    return fweStudentMapper.selectFweStudentById(id);
	}
	
	/**
     * 查询学生列表
     * 
     * @param fweStudent 学生信息
     * @return 学生集合
     */
	@Override
	public List<FweStudent> selectFweStudentList(FweStudent fweStudent)
	{
	    return fweStudentMapper.selectFweStudentList(fweStudent);
	}
	
    /**
     * 新增学生
     * 
     * @param fweStudent 学生信息
     * @return 结果
     */
	@Override
	public int insertFweStudent(FweStudent fweStudent)
	{
	    return fweStudentMapper.insertFweStudent(fweStudent);
	}
	
	/**
     * 修改学生
     * 
     * @param fweStudent 学生信息
     * @return 结果
     */
	@Override
	public int updateFweStudent(FweStudent fweStudent)
	{
	    return fweStudentMapper.updateFweStudent(fweStudent);
	}

	/**
     * 删除学生对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweStudentByIds(String ids)
	{
		return fweStudentMapper.deleteFweStudentByIds(Convert.toStrArray(ids));
	}
	
}
