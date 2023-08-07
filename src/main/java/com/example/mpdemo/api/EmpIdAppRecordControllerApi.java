package com.example.mpdemo.api;

import com.example.mpdemo.entity.VO.EmpIdAppRecordVO;
import com.example.mpdemo.service.EmpIdAppRecordService;
import com.example.mpdemo.util.ResponseData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 刘伟
 * @program: mpdemo
 * @description: 工号牌申请api
 * @date 2023-05-11 10:58:54
 */

@RestController
@RequestMapping("/app")
public class EmpIdAppRecordControllerApi {

    @Resource
    private EmpIdAppRecordService empIdAppRecordService;

    /**
     * @Description: 通过申请人工号查询记录
     * @Param:
     * @return:
     * @Date: 2023/5/11
     */
    @GetMapping("/getById")
    public ResponseData find(EmpIdAppRecordVO empIdAppRecordVO) throws Exception{
        return empIdAppRecordService.selectById(empIdAppRecordVO);
    }

    /**
     * @Description: 查询所有申请记录q
     * @Param:
     * @return:
     * @Date: 2023/5/11
     */
    @GetMapping("/getAll")
    public ResponseData findAll() throws Exception{
        return empIdAppRecordService.selectAll();
    }

    @PostMapping("/insertApp")
    public ResponseData insertApp(EmpIdAppRecordVO empIdAppRecordVO) throws Exception{
        return empIdAppRecordService.insertApp(empIdAppRecordVO);
    };
}
