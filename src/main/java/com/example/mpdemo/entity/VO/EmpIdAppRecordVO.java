package com.example.mpdemo.entity.VO;

import lombok.Builder;
import lombok.Data;

/**
 * @author 刘伟
 * @program: mpdemo
 * @description: 工号牌申请记录vo
 * @date 2023-05-10 16:25:29
 */
@Data
@Builder
public class EmpIdAppRecordVO {

    /**
     * 机构名称
     */
    private String depName;

    /**
     * 申请人姓名
     */
    private String applicant;

    /**
     * 申请人工号
     */
    private String applicantId;

    /**
     * 姓名
     */
    private String ename;

    /**
     * 工号
     */
    private String employeeId;

//    /**
//     * 工作平台图片路径
//     */
//    private String imgPath1;
//
//    /**
//     * 内管平台图片路径
//     */
//    private String imgPath2;

    /**
     * 工作平台图片路径
     */
    private String imgPath1;

    /**
     * 内管平台图片路径
     */
    private String imgPath2;


    /**
     * 申请时间
     */
    private String appTime;

    /**
     * 申请原因
     */
    private String appReason;

//    /**
//     * 申请状态
//     * 枚举类型： 0-审批中； 1-驳回； 2-打印中； 3-完成
//     */
//    private String appStatus;
//
//    /**
//     * 更新时间
//     */
//    private String updateTime;

    /**
     * 一级审批人工号
     */
    private String l1ApprId;
}
