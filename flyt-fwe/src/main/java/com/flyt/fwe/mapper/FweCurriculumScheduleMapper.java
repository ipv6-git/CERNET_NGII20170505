package com.flyt.fwe.mapper;

import com.flyt.fwe.domain.FweCurriculumSchedule;
import java.util.List;	

/**
 * 课程安排 数据层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface FweCurriculumScheduleMapper 
{
	/**
     * 查询课程安排信息
     * 
     * @param id 课程安排ID
     * @return 课程安排信息
     */
	public FweCurriculumSchedule selectFweCurriculumScheduleById(Long id);
	
	/**
     * 查询课程安排列表
     * 
     * @param fweCurriculumSchedule 课程安排信息
     * @return 课程安排集合
     */
	public List<FweCurriculumSchedule> selectFweCurriculumScheduleList(FweCurriculumSchedule fweCurriculumSchedule);
	
	/**
     * 新增课程安排
     * 
     * @param fweCurriculumSchedule 课程安排信息
     * @return 结果
     */
	public int insertFweCurriculumSchedule(FweCurriculumSchedule fweCurriculumSchedule);
	
	/**
     * 修改课程安排
     * 
     * @param fweCurriculumSchedule 课程安排信息
     * @return 结果
     */
	public int updateFweCurriculumSchedule(FweCurriculumSchedule fweCurriculumSchedule);
	
	/**
     * 删除课程安排
     * 
     * @param id 课程安排ID
     * @return 结果
     */
	public int deleteFweCurriculumScheduleById(Long id);
	
	/**
     * 批量删除课程安排
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweCurriculumScheduleByIds(String[] ids);
	
}