package com.example.mpdemo.service.impl;

import com.example.mpdemo.dao.EmpIdAppRecordDao;
import com.example.mpdemo.service.EmpIdAppRecordService;
import com.example.mpdemo.entity.DO.EmpIdAppRecordDO;
import com.example.mpdemo.entity.VO.EmpIdAppRecordVO;
import com.example.mpdemo.util.ResponseData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 刘伟
 * @program: mpdemo
 * @description: 工牌申请控制器
 * @date 2023-05-10 17:47:34
 */
@Service
//@Transactional
public class EmpIdAppRecordImpl implements EmpIdAppRecordService {
    @Resource
//    @Autowired
    private EmpIdAppRecordDao empIdAppRecordDao;
    

    @Override
    public ResponseData selectById(EmpIdAppRecordVO empIdAppRecordVO) throws Exception {
        return ResponseData.success(empIdAppRecordDao.selectById(empIdAppRecordVO.getApplicantId()));
    }
    

    @Override
    public ResponseData selectAll() throws Exception{
        return ResponseData.success(empIdAppRecordDao.selectAll());
    }

    @Override
    public ResponseData insertApp(EmpIdAppRecordVO empIdAppRecordVO) throws Exception {

        EmpIdAppRecordDO empIdAppRecordDo = EmpIdAppRecordDO.builder()
                .depName(empIdAppRecordVO.getDepName())
                .applicant(empIdAppRecordVO.getApplicant())
                .applicantId(empIdAppRecordVO.getApplicantId())
                .ename(empIdAppRecordVO.getEname())
                .employeeId(empIdAppRecordVO.getEmployeeId())
                .imgPath1(empIdAppRecordVO.getImgPath1())
                .imgPath2(empIdAppRecordVO.getImgPath2())
                .appTime(empIdAppRecordVO.getAppTime())
                .appReason(empIdAppRecordVO.getAppReason())
                .appStatus("0")
                .updateTime(null)
                .l1ApprId(empIdAppRecordVO.getL1ApprId())
                .apprComment(null)
                .build();
        int n = empIdAppRecordDao.insert(empIdAppRecordDo);
        if(n > 0){
            return ResponseData.success("审批人信息录入成功！");
        }else{
            return ResponseData.error("审批人信息录入异常！");
        }
    }


}
