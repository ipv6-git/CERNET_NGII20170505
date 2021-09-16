package com.flyt.fwe.mapper;

import com.flyt.fwe.domain.FweCollege;
import java.util.List;	

/**
 * 学院 数据层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface FweCollegeMapper 
{
	/**
     * 查询学院信息
     * 
     * @param id 学院ID
     * @return 学院信息
     */
	public FweCollege selectFweCollegeById(Long id);
	
	/**
     * 查询学院列表
     * 
     * @param fweCollege 学院信息
     * @return 学院集合
     */
	public List<FweCollege> selectFweCollegeList(FweCollege fweCollege);
	
	/**
     * 新增学院
     * 
     * @param fweCollege 学院信息
     * @return 结果
     */
	public int insertFweCollege(FweCollege fweCollege);
	
	/**
     * 修改学院
     * 
     * @param fweCollege 学院信息
     * @return 结果
     */
	public int updateFweCollege(FweCollege fweCollege);
	
	/**
     * 删除学院
     * 
     * @param id 学院ID
     * @return 结果
     */
	public int deleteFweCollegeById(Long id);
	
	/**
     * 批量删除学院
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweCollegeByIds(String[] ids);
	
}