package com.flyt.fwe.service;

import com.flyt.fwe.domain.FweStudentWhiteList;
import java.util.List;

/**
 * 缺课白名单 服务层
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public interface IFweStudentWhiteListService 
{
	/**
     * 查询缺课白名单信息
     * 
     * @param id 缺课白名单ID
     * @return 缺课白名单信息
     */
	public FweStudentWhiteList selectFweStudentWhiteListById(Long id);
	
	/**
     * 查询缺课白名单列表
     * 
     * @param fweStudentWhiteList 缺课白名单信息
     * @return 缺课白名单集合
     */
	public List<FweStudentWhiteList> selectFweStudentWhiteListList(FweStudentWhiteList fweStudentWhiteList);
	
	/**
     * 新增缺课白名单
     * 
     * @param fweStudentWhiteList 缺课白名单信息
     * @return 结果
     */
	public int insertFweStudentWhiteList(FweStudentWhiteList fweStudentWhiteList);
	
	/**
     * 修改缺课白名单
     * 
     * @param fweStudentWhiteList 缺课白名单信息
     * @return 结果
     */
	public int updateFweStudentWhiteList(FweStudentWhiteList fweStudentWhiteList);
		
	/**
     * 删除缺课白名单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFweStudentWhiteListByIds(String ids);
	
}
