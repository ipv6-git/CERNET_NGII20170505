package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweCollegeMapper;
import com.flyt.fwe.domain.FweCollege;
import com.flyt.fwe.service.IFweCollegeService;
import com.flyt.common.core.text.Convert;

/**
 * 学院 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweCollegeServiceImpl implements IFweCollegeService 
{
	@Autowired
	private FweCollegeMapper fweCollegeMapper;

	/**
     * 查询学院信息
     * 
     * @param id 学院ID
     * @return 学院信息
     */
    @Override
	public FweCollege selectFweCollegeById(Long id)
	{
	    return fweCollegeMapper.selectFweCollegeById(id);
	}
	
	/**
     * 查询学院列表
     * 
     * @param fweCollege 学院信息
     * @return 学院集合
     */
	@Override
	public List<FweCollege> selectFweCollegeList(FweCollege fweCollege)
	{
	    return fweCollegeMapper.selectFweCollegeList(fweCollege);
	}
	
    /**
     * 新增学院
     * 
     * @param fweCollege 学院信息
     * @return 结果
     */
	@Override
	public int insertFweCollege(FweCollege fweCollege)
	{
	    return fweCollegeMapper.insertFweCollege(fweCollege);
	}
	
	/**
     * 修改学院
     * 
     * @param fweCollege 学院信息
     * @return 结果
     */
	@Override
	public int updateFweCollege(FweCollege fweCollege)
	{
	    return fweCollegeMapper.updateFweCollege(fweCollege);
	}

	/**
     * 删除学院对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweCollegeByIds(String ids)
	{
		return fweCollegeMapper.deleteFweCollegeByIds(Convert.toStrArray(ids));
	}
	
}
