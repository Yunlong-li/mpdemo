package com.example.mpdemo.entity.VO;

import lombok.Builder;
import lombok.Data;

/**
 * @author 刘伟
 * @program: mpdemo
 * @description: 审批人表VO
 * @date 2023-05-11 15:30:04
 */
@Data
@Builder
public class EmpIdApproverVO {
    /**
     * 主键
     * 审批人工号
     */
    private String apprId;


    /**
     * 审批人姓名
     */
    private String apprName;

    /**
     * 审批人机构名称
     */
    private String apprDep;
}
