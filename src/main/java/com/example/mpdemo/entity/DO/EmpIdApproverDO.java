package com.example.mpdemo.entity.DO;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

/**
 * @author 刘伟
 * @program: mpdemo
 * @description: 工号牌审批人
 * @date 2023-05-11 09:58:33
 */
@Data
@Builder
public class EmpIdApproverDO {

    /**
     * 主键
     * 审批人工号
     */
//    @TableId
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
