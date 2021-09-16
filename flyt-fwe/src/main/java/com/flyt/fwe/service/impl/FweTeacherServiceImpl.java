package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweTeacherMapper;
import com.flyt.fwe.domain.FweTeacher;
import com.flyt.fwe.service.IFweTeacherService;
import com.flyt.common.core.text.Convert;

/**
 * 教师 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweTeacherServiceImpl implements IFweTeacherService 
{
	@Autowired
	private FweTeacherMapper fweTeacherMapper;

	/**
     * 查询教师信息
     * 
     * @param id 教师ID
     * @return 教师信息
     */
    @Override
	public FweTeacher selectFweTeacherById(Long id)
	{
	    return fweTeacherMapper.selectFweTeacherById(id);
	}
	
	/**
     * 查询教师列表
     * 
     * @param fweTeacher 教师信息
     * @return 教师集合
     */
	@Override
	public List<FweTeacher> selectFweTeacherList(FweTeacher fweTeacher)
	{
	    return fweTeacherMapper.selectFweTeacherList(fweTeacher);
	}
	
    /**
     * 新增教师
     * 
     * @param fweTeacher 教师信息
     * @return 结果
     */
	@Override
	public int insertFweTeacher(FweTeacher fweTeacher)
	{
	    return fweTeacherMapper.insertFweTeacher(fweTeacher);
	}
	
	/**
     * 修改教师
     * 
     * @param fweTeacher 教师信息
     * @return 结果
     */
	@Override
	public int updateFweTeacher(FweTeacher fweTeacher)
	{
	    return fweTeacherMapper.updateFweTeacher(fweTeacher);
	}

	/**
     * 删除教师对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweTeacherByIds(String ids)
	{
		return fweTeacherMapper.deleteFweTeacherByIds(Convert.toStrArray(ids));
	}
	
}
