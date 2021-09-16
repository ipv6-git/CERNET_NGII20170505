package com.flyt.fwe.mapper;

import com.flyt.fwe.domain.FweStudent;
import java.util.List;	

/**
 * 学生 数据层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface FweStudentMapper 
{
	/**
     * 查询学生信息
     * 
     * @param id 学生ID
     * @return 学生信息
     */
	public FweStudent selectFweStudentById(Long id);
	
	/**
     * 查询学生列表
     * 
     * @param fweStudent 学生信息
     * @return 学生集合
     */
	public List<FweStudent> selectFweStudentList(FweStudent fweStudent);
	
	/**
     * 新增学生
     * 
     * @param fweStudent 学生信息
     * @return 结果
     */
	public int insertFweStudent(FweStudent fweStudent);
	
	/**
     * 修改学生
     * 
     * @param fweStudent 学生信息
     * @return 结果
     */
	public int updateFweStudent(FweStudent fweStudent);
	
	/**
     * 删除学生
     * 
     * @param id 学生ID
     * @return 结果
     */
	public int deleteFweStudentById(Long id);
	
	/**
     * 批量删除学生
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweStudentByIds(String[] ids);
	
}