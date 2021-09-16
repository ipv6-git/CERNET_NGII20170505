package com.flyt.fwe.service;

import com.flyt.fwe.domain.FweTeacher;
import java.util.List;

/**
 * 教师 服务层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface IFweTeacherService 
{
	/**
     * 查询教师信息
     * 
     * @param id 教师ID
     * @return 教师信息
     */
	public FweTeacher selectFweTeacherById(Long id);
	
	/**
     * 查询教师列表
     * 
     * @param fweTeacher 教师信息
     * @return 教师集合
     */
	public List<FweTeacher> selectFweTeacherList(FweTeacher fweTeacher);
	
	/**
     * 新增教师
     * 
     * @param fweTeacher 教师信息
     * @return 结果
     */
	public int insertFweTeacher(FweTeacher fweTeacher);
	
	/**
     * 修改教师
     * 
     * @param fweTeacher 教师信息
     * @return 结果
     */
	public int updateFweTeacher(FweTeacher fweTeacher);
		
	/**
     * 删除教师信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweTeacherByIds(String ids);
	
}
