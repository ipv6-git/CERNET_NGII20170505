package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweStudentCurriculumMapper;
import com.flyt.fwe.domain.FweStudentCurriculum;
import com.flyt.fwe.service.IFweStudentCurriculumService;
import com.flyt.common.core.text.Convert;

/**
 * 课程学生 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweStudentCurriculumServiceImpl implements IFweStudentCurriculumService 
{
	@Autowired
	private FweStudentCurriculumMapper fweStudentCurriculumMapper;

	/**
     * 查询课程学生信息
     * 
     * @param id 课程学生ID
     * @return 课程学生信息
     */
    @Override
	public FweStudentCurriculum selectFweStudentCurriculumById(Long id)
	{
	    return fweStudentCurriculumMapper.selectFweStudentCurriculumById(id);
	}
	
	/**
     * 查询课程学生列表
     * 
     * @param fweStudentCurriculum 课程学生信息
     * @return 课程学生集合
     */
	@Override
	public List<FweStudentCurriculum> selectFweStudentCurriculumList(FweStudentCurriculum fweStudentCurriculum)
	{
	    return fweStudentCurriculumMapper.selectFweStudentCurriculumList(fweStudentCurriculum);
	}
	
    /**
     * 新增课程学生
     * 
     * @param fweStudentCurriculum 课程学生信息
     * @return 结果
     */
	@Override
	public int insertFweStudentCurriculum(FweStudentCurriculum fweStudentCurriculum)
	{
	    return fweStudentCurriculumMapper.insertFweStudentCurriculum(fweStudentCurriculum);
	}
	
	/**
     * 修改课程学生
     * 
     * @param fweStudentCurriculum 课程学生信息
     * @return 结果
     */
	@Override
	public int updateFweStudentCurriculum(FweStudentCurriculum fweStudentCurriculum)
	{
	    return fweStudentCurriculumMapper.updateFweStudentCurriculum(fweStudentCurriculum);
	}

	/**
     * 删除课程学生对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweStudentCurriculumByIds(String ids)
	{
		return fweStudentCurriculumMapper.deleteFweStudentCurriculumByIds(Convert.toStrArray(ids));
	}
	
}
