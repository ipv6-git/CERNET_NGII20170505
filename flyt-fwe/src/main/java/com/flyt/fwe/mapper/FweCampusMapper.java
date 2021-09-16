package com.flyt.fwe.mapper;

import com.flyt.fwe.domain.FweCampus;
import java.util.List;	

/**
 * 校区 数据层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface FweCampusMapper 
{
	/**
     * 查询校区信息
     * 
     * @param id 校区ID
     * @return 校区信息
     */
	public FweCampus selectFweCampusById(Long id);
	
	/**
     * 查询校区列表
     * 
     * @param fweCampus 校区信息
     * @return 校区集合
     */
	public List<FweCampus> selectFweCampusList(FweCampus fweCampus);
	
	/**
     * 新增校区
     * 
     * @param fweCampus 校区信息
     * @return 结果
     */
	public int insertFweCampus(FweCampus fweCampus);
	
	/**
     * 修改校区
     * 
     * @param fweCampus 校区信息
     * @return 结果
     */
	public int updateFweCampus(FweCampus fweCampus);
	
	/**
     * 删除校区
     * 
     * @param id 校区ID
     * @return 结果
     */
	public int deleteFweCampusById(Long id);
	
	/**
     * 批量删除校区
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweCampusByIds(String[] ids);
	
}