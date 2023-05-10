package com.example.mpdemo.mapper;

import com.example.mpdemo.entity.User;
import org.apache.ibatis.annotations.Select;

public interface EmpIdAppRecordMapper {

    @Select("SELECT * FROM EMP_ID_APP_RECORD WHERE APPLICANTID = #{ }")
    User selectById(int id);
}
