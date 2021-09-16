package com.flyt.fwe.mapper;

import com.flyt.fwe.domain.FweCurriculum;
import java.util.List;	

/**
 * 开设课程 数据层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface FweCurriculumMapper 
{
	/**
     * 查询开设课程信息
     * 
     * @param id 开设课程ID
     * @return 开设课程信息
     */
	public FweCurriculum selectFweCurriculumById(Long id);
	
	/**
     * 查询开设课程列表
     * 
     * @param fweCurriculum 开设课程信息
     * @return 开设课程集合
     */
	public List<FweCurriculum> selectFweCurriculumList(FweCurriculum fweCurriculum);
	
	/**
     * 新增开设课程
     * 
     * @param fweCurriculum 开设课程信息
     * @return 结果
     */
	public int insertFweCurriculum(FweCurriculum fweCurriculum);
	
	/**
     * 修改开设课程
     * 
     * @param fweCurriculum 开设课程信息
     * @return 结果
     */
	public int updateFweCurriculum(FweCurriculum fweCurriculum);
	
	/**
     * 删除开设课程
     * 
     * @param id 开设课程ID
     * @return 结果
     */
	public int deleteFweCurriculumById(Long id);
	
	/**
     * 批量删除开设课程
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweCurriculumByIds(String[] ids);
	
}