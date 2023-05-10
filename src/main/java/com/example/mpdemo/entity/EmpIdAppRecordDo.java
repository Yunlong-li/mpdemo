package com.example.mpdemo.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author 刘伟
 * @program: mpdemo
 * @description: 工号牌申请记录
 * @date 2023-05-10 16:24:46
 */
@Data
@Builder
public class EmpIdAppRecordDo {

    /**
    * 主键（申请编号）
    */
    private int appId;

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
     * 内管平台图片路径
     */
    private String imgPath;

    /**
     * 申请时间
     */
    private String appTime;

    /**
     * 申请原因
     */
    private String appReason;

    /**
     * 申请状态
     * 枚举类型： 0-审批中； 1-驳回； 2-打印中； 3-完成
     */
    private String appStatus;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 一级审批人工号
     */
    private String l1ApprId;

    /**
     * 审批意见
     */
    private String apprComment;
}
