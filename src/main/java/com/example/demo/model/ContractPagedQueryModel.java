package com.example.demo.model;

import java.util.List;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/8 5:00 PM
 * @Version 1.0
 */
public class ContractPagedQueryModel extends ToString {

    /*
     * 估值创建时间
     */
    private String riskTimeStart;

    private String riskTimeEnd;

    /**
     * TASK创建时间
     */
    private String gmtCreateStart;

    private String gmtCreateEnd;

    /**
     * 决策引擎结果状态
     */
    private String engineResult;


    /**
     * 风控结果状态
     */
    private String riskResult;

    /**
     * 处理状态  未处理/已处理
     */
    private String processStatus;

    private List<String> processStatusList;

    /*
    产品编号
     */
    private String productCode;

    /**
     * 估值ID
     */
    private String contractId;

    /**
     * 任务id
     */
    private String taskId;

    /**
     * 应用id
     */
    private String appId;
    /**
     * 用户id
     */
    private String appUserId;

    private String pageNumber;
    private String pageSize;

    private String sortBy;

    public String getRiskTimeStart() {
        return riskTimeStart;
    }

    public void setRiskTimeStart(String riskTimeStart) {
        this.riskTimeStart = riskTimeStart;
    }

    public String getRiskTimeEnd() {
        return riskTimeEnd;
    }

    public void setRiskTimeEnd(String riskTimeEnd) {
        this.riskTimeEnd = riskTimeEnd;
    }

    public String getGmtCreateStart() {
        return gmtCreateStart;
    }

    public void setGmtCreateStart(String gmtCreateStart) {
        this.gmtCreateStart = gmtCreateStart;
    }

    public String getGmtCreateEnd() {
        return gmtCreateEnd;
    }

    public void setGmtCreateEnd(String gmtCreateEnd) {
        this.gmtCreateEnd = gmtCreateEnd;
    }

    public String getEngineResult() {
        return engineResult;
    }

    public void setEngineResult(String engineResult) {
        this.engineResult = engineResult;
    }

    public String getRiskResult() {
        return riskResult;
    }

    public void setRiskResult(String riskResult) {
        this.riskResult = riskResult;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public List<String> getProcessStatusList() {
        return processStatusList;
    }

    public void setProcessStatusList(List<String> processStatusList) {
        this.processStatusList = processStatusList;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }


}
