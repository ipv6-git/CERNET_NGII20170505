package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweCurriculumMapper;
import com.flyt.fwe.domain.FweCurriculum;
import com.flyt.fwe.service.IFweCurriculumService;
import com.flyt.common.core.text.Convert;

/**
 * 开设课程 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweCurriculumServiceImpl implements IFweCurriculumService 
{
	@Autowired
	private FweCurriculumMapper fweCurriculumMapper;

	/**
     * 查询开设课程信息
     * 
     * @param id 开设课程ID
     * @return 开设课程信息
     */
    @Override
	public FweCurriculum selectFweCurriculumById(Long id)
	{
	    return fweCurriculumMapper.selectFweCurriculumById(id);
	}
	
	/**
     * 查询开设课程列表
     * 
     * @param fweCurriculum 开设课程信息
     * @return 开设课程集合
     */
	@Override
	public List<FweCurriculum> selectFweCurriculumList(FweCurriculum fweCurriculum)
	{
	    return fweCurriculumMapper.selectFweCurriculumList(fweCurriculum);
	}
	
    /**
     * 新增开设课程
     * 
     * @param fweCurriculum 开设课程信息
     * @return 结果
     */
	@Override
	public int insertFweCurriculum(FweCurriculum fweCurriculum)
	{
	    return fweCurriculumMapper.insertFweCurriculum(fweCurriculum);
	}
	
	/**
     * 修改开设课程
     * 
     * @param fweCurriculum 开设课程信息
     * @return 结果
     */
	@Override
	public int updateFweCurriculum(FweCurriculum fweCurriculum)
	{
	    return fweCurriculumMapper.updateFweCurriculum(fweCurriculum);
	}

	/**
     * 删除开设课程对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweCurriculumByIds(String ids)
	{
		return fweCurriculumMapper.deleteFweCurriculumByIds(Convert.toStrArray(ids));
	}
	
}
