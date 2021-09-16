package com.flyt.fwe.mapper;

import com.flyt.fwe.domain.FweStudentCurriculum;
import java.util.List;	

/**
 * 课程学生 数据层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface FweStudentCurriculumMapper 
{
	/**
     * 查询课程学生信息
     * 
     * @param id 课程学生ID
     * @return 课程学生信息
     */
	public FweStudentCurriculum selectFweStudentCurriculumById(Long id);
	
	/**
     * 查询课程学生列表
     * 
     * @param fweStudentCurriculum 课程学生信息
     * @return 课程学生集合
     */
	public List<FweStudentCurriculum> selectFweStudentCurriculumList(FweStudentCurriculum fweStudentCurriculum);
	
	/**
     * 新增课程学生
     * 
     * @param fweStudentCurriculum 课程学生信息
     * @return 结果
     */
	public int insertFweStudentCurriculum(FweStudentCurriculum fweStudentCurriculum);
	
	/**
     * 修改课程学生
     * 
     * @param fweStudentCurriculum 课程学生信息
     * @return 结果
     */
	public int updateFweStudentCurriculum(FweStudentCurriculum fweStudentCurriculum);
	
	/**
     * 删除课程学生
     * 
     * @param id 课程学生ID
     * @return 结果
     */
	public int deleteFweStudentCurriculumById(Long id);
	
	/**
     * 批量删除课程学生
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweStudentCurriculumByIds(String[] ids);
	
}