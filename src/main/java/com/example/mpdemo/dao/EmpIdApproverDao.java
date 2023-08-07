package com.example.mpdemo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.entity.DO.EmpIdApproverDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
//@Repository
public interface EmpIdApproverDao extends BaseMapper<EmpIdApproverDO> {
    
    /**
    * @Description: 根据审批人工号查询审批人信息
    * @Param: 审批人工号
    * @return:  审批人信息
    * @Date: 2023/8/1
    */
    @Select("select * from EMP_ID_APPROVER where apprid = #{apprid}")
    List<EmpIdApproverDO> selectById(String apprid);

    /**
    * @Description: 查询全部审批人员信息
    * @Param: 
    * @return: 
    * @Date: 2023/8/1
    */
    @Select("select * from EMP_ID_APPROVER")
    List<EmpIdApproverDO> selectAll();
    
    /**
    * @Description: 新增审批人员信息
    * @Param: 
    * @return: 
    * @Date: 2023/8/1
    */
    @Insert("insert into EMP_ID_APPROVER (apprId, apprDep, apprName) " +
            "values (#{apprId}, #{apprDep}, #{apprName})")
    int insert(EmpIdApproverDO empIdApproverDO);
}
