package com.example.mpdemo.service;

import com.example.mpdemo.entity.VO.EmpIdApproverVO;
import com.example.mpdemo.util.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface EmpIdApproverService {
    /**
     * @Description: 通过申请人工号查询记录
     * @Param:
     * @return:
     * @Date: 2023/5/11
     */
    ResponseData selectById(EmpIdApproverVO empIdApproverVO) throws Exception;

    /**
     * @Description: 查询所有申请记录
     * @Param:
     * @return:
     * @Date: 2023/5/11
     */
    ResponseData selectAll() throws Exception;

    /**
     * @Description: 添加审批人
     * @Param:
     * @return:
     * @Date: 2023/5/11
     */
    ResponseData insertAppr(EmpIdApproverVO empIdApproverVO) throws Exception;

    /**
     * @Description: 分页查询
     * @Param:
     * @return:
     * @Date: 2023/8/2
     */
    ResponseData selectAllByPage(Integer pageNum, Integer pageSize) throws Exception;
}
