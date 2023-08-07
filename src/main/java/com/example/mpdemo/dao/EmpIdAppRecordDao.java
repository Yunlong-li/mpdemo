package com.example.mpdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.entity.DO.EmpIdAppRecordDO;
import com.example.mpdemo.entity.DO.EmpIdApproverDO;
import com.example.mpdemo.entity.VO.EmpIdAppRecordVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
//@Repository
public interface EmpIdAppRecordDao extends BaseMapper<EmpIdAppRecordDO> {

    /**
    * @Description: 根据申请人工号查询申请记录
    * @Param:
    * @return:
    * @Date: 2023/5/11
    */
    @Select("select * from EMP_ID_APP_RECORD where APPLICANTID = #{applicantId}")
    List<EmpIdAppRecordDO> selectById(String applicantId);

    /**
    * @Description: 查询全部申请记录
    * @Param:
    * @return:
    * @Date: 2023/5/11
    */
    @Select("select * from EMP_ID_APP_RECORD")
    List<EmpIdAppRecordDO> selectAll();


    /**
    * @Description: 新增申请记录
    * @Param:
    * @return:
    * @Date: 2023/5/11
    */
    @Insert("insert into EMP_ID_APP_RECORD (depName, applicant, applicantId, ename, employeeId, imgPath1, " +
            "imgPath2, appTime, appReason, appStatus, updateTime, l1ApprId, apprComment) " +
            "values (#{depName}, #{applicant}, #{applicantId}, #{ename}, #{employeeId}, #{imgPath1}, " +
            "#{imgPath2}, #{appTime}, #{appReason}, #{appStatus}, #{updateTime}, #{l1ApprId}, #{apprComment})")
    int insert(EmpIdAppRecordDO empIdAppRecordDO);
}
