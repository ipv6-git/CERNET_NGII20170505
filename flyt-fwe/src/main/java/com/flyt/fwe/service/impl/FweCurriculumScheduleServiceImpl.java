package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweCurriculumScheduleMapper;
import com.flyt.fwe.domain.FweCurriculumSchedule;
import com.flyt.fwe.service.IFweCurriculumScheduleService;
import com.flyt.common.core.text.Convert;

/**
 * 课程安排 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweCurriculumScheduleServiceImpl implements IFweCurriculumScheduleService 
{
	@Autowired
	private FweCurriculumScheduleMapper fweCurriculumScheduleMapper;

	/**
     * 查询课程安排信息
     * 
     * @param id 课程安排ID
     * @return 课程安排信息
     */
    @Override
	public FweCurriculumSchedule selectFweCurriculumScheduleById(Long id)
	{
	    return fweCurriculumScheduleMapper.selectFweCurriculumScheduleById(id);
	}
	
	/**
     * 查询课程安排列表
     * 
     * @param fweCurriculumSchedule 课程安排信息
     * @return 课程安排集合
     */
	@Override
	public List<FweCurriculumSchedule> selectFweCurriculumScheduleList(FweCurriculumSchedule fweCurriculumSchedule)
	{
	    return fweCurriculumScheduleMapper.selectFweCurriculumScheduleList(fweCurriculumSchedule);
	}
	
    /**
     * 新增课程安排
     * 
     * @param fweCurriculumSchedule 课程安排信息
     * @return 结果
     */
	@Override
	public int insertFweCurriculumSchedule(FweCurriculumSchedule fweCurriculumSchedule)
	{
	    return fweCurriculumScheduleMapper.insertFweCurriculumSchedule(fweCurriculumSchedule);
	}
	
	/**
     * 修改课程安排
     * 
     * @param fweCurriculumSchedule 课程安排信息
     * @return 结果
     */
	@Override
	public int updateFweCurriculumSchedule(FweCurriculumSchedule fweCurriculumSchedule)
	{
	    return fweCurriculumScheduleMapper.updateFweCurriculumSchedule(fweCurriculumSchedule);
	}

	/**
     * 删除课程安排对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweCurriculumScheduleByIds(String ids)
	{
		return fweCurriculumScheduleMapper.deleteFweCurriculumScheduleByIds(Convert.toStrArray(ids));
	}
	
}
