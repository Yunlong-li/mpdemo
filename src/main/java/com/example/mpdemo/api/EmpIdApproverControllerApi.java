package com.example.mpdemo.api;

import com.example.mpdemo.entity.VO.EmpIdApproverVO;
import com.example.mpdemo.service.EmpIdApproverService;
import com.example.mpdemo.util.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 刘伟
 * @program: mpdemo
 * @description: 审批人表api
 * @date 2023-05-11 15:35:42
 */
@RestController
@RequestMapping("/appr")
public class EmpIdApproverControllerApi {

    @Resource
    private EmpIdApproverService empIdApproverService;

    /**
     * @Description: 通过申请人工号查询记录
     * @Param:
     * @return:
     * @Date: 2023/5/11
     */
    @GetMapping("/getById")
    public ResponseData find(EmpIdApproverVO empIdApproverVO) throws Exception{
        return empIdApproverService.selectById(empIdApproverVO);
    }

    /**
     * @Description: 查询所有申请记录
     * @Param:
     * @return:
     * @Date: 2023/5/11
     */
    @GetMapping("/getAll")
    public ResponseData findAll() throws Exception{
        return empIdApproverService.selectAll();
    }

    /**
    * @Description: 新增审批人
    * @Param:
    * @return:
    * @Date: 2023/8/2
    */
    @PostMapping("/insertAppr")
    public ResponseData insertAppr(EmpIdApproverVO empIdApproverVO) throws Exception{
        return empIdApproverService.insertAppr(empIdApproverVO);
    };

    /**
    * @Description: 分页查询审批人信息
    * @Param:
    * @return:
    * @Date: 2023/8/2
    */
    @GetMapping("/getAllByPage")
    public ResponseData getAllByPage(Integer pageNum, Integer pageSize) throws Exception{
        return empIdApproverService.selectAllByPage(pageNum, pageSize);
    }



}
