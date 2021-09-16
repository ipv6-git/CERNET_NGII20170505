package com.flyt.fwe.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flyt.fwe.mapper.FweCampusMapper;
import com.flyt.fwe.domain.FweCampus;
import com.flyt.fwe.service.IFweCampusService;
import com.flyt.common.core.text.Convert;

/**
 * 校区 服务层实现
 * 
 * @author Wwang
 * @date 2019-06-17
 */
@Service
public class FweCampusServiceImpl implements IFweCampusService 
{
	@Autowired
	private FweCampusMapper fweCampusMapper;

	/**
     * 查询校区信息
     * 
     * @param id 校区ID
     * @return 校区信息
     */
    @Override
	public FweCampus selectFweCampusById(Long id)
	{
	    return fweCampusMapper.selectFweCampusById(id);
	}
	
	/**
     * 查询校区列表
     * 
     * @param fweCampus 校区信息
     * @return 校区集合
     */
	@Override
	public List<FweCampus> selectFweCampusList(FweCampus fweCampus)
	{
	    return fweCampusMapper.selectFweCampusList(fweCampus);
	}
	
    /**
     * 新增校区
     * 
     * @param fweCampus 校区信息
     * @return 结果
     */
	@Override
	public int insertFweCampus(FweCampus fweCampus)
	{
	    return fweCampusMapper.insertFweCampus(fweCampus);
	}
	
	/**
     * 修改校区
     * 
     * @param fweCampus 校区信息
     * @return 结果
     */
	@Override
	public int updateFweCampus(FweCampus fweCampus)
	{
	    return fweCampusMapper.updateFweCampus(fweCampus);
	}

	/**
     * 删除校区对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFweCampusByIds(String ids)
	{
		return fweCampusMapper.deleteFweCampusByIds(Convert.toStrArray(ids));
	}
	
}
