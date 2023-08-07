package com.example.mpdemo.service.impl;

import com.example.mpdemo.entity.DO.EmpIdApproverDO;
import com.example.mpdemo.dao.EmpIdApproverDao;
import com.example.mpdemo.entity.VO.EmpIdApproverVO;
import com.example.mpdemo.service.EmpIdApproverService;
import com.example.mpdemo.util.ResponseData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;


/**
 * @author 刘伟
 * @program: mpdemo
 * @description: 工号牌审批人控制器
 * @date 2023-05-11 10:20:53
 */
//@RestController
//@RequestMapping("/appr")
@Service
//@Transactional
public class EmpIdApproverImpl implements EmpIdApproverService {

    @Resource
//    @Autowired
    private EmpIdApproverDao empIdApproverDao;

    @Override
    public ResponseData selectById(EmpIdApproverVO empIdApproverVO) throws Exception {
        return ResponseData.success(empIdApproverDao.selectById(empIdApproverVO.getApprId()));
    }


    @Override
    public ResponseData selectAll() throws Exception{
        return ResponseData.success(empIdApproverDao.selectAll());
    }

    @Override
    public ResponseData insertAppr(EmpIdApproverVO empIdApproverVO) throws Exception {

        EmpIdApproverDO empIdApproverDO = EmpIdApproverDO.builder()
                .apprId(empIdApproverVO.getApprId())
                .apprDep(empIdApproverVO.getApprDep())
                .apprName(empIdApproverVO.getApprName())
                .build();
        int n = empIdApproverDao.insert(empIdApproverDO);
        if(n > 0){
            return ResponseData.success("审批人信息录入成功！");
        }else{
            return ResponseData.error("审批人信息录入异常！");
        }
    }

    @Override
    public ResponseData selectAllByPage(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<EmpIdApproverDO> empIdApproverDOS = empIdApproverDao.selectAll();
        PageInfo<EmpIdApproverDO> empIdApproverDOPageInfo = new PageInfo<>(empIdApproverDOS);
        return ResponseData.success(empIdApproverDOPageInfo);
    }





}
