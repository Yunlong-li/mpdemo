package com.example.mpdemo.service;

import com.example.mpdemo.entity.VO.EmpIdAppRecordVO;
import com.example.mpdemo.util.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @Description: 工号牌申请接口服务
* @Param: 
* @return:
* @Date: 2023/5/11
*/
//@Transactional
@Service
@Transactional
public interface EmpIdAppRecordService {

    /**
     * @Description: 通过申请人工号查询记录
     * @Param:
     * @return:
     * @Date: 2023/5/11
     */
    ResponseData selectById(EmpIdAppRecordVO empIdAppRecordVO) throws Exception;

    /**
     * @Description: 查询所有申请记录
     * @Param:
     * @return:
     * @Date: 2023/5/11
     */
    ResponseData selectAll() throws Exception;

    /**
     * @Description: 添加申请记录
     * @Param:
     * @return:
     * @Date: 2023/5/11
     */
    ResponseData insertApp(EmpIdAppRecordVO empIdAppRecordVO) throws Exception;



}
