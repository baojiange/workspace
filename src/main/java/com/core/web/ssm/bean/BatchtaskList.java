package com.core.web.ssm.bean;

import java.util.Date;

public class BatchtaskList {
    private Long id;

    private String runBatchDate;

    private String runJobId;

    private String runStartMode;

    private String runStatus;

    private Date runBeginDate;

    private Date runEndDate;

    private String runDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRunBatchDate() {
        return runBatchDate;
    }

    public void setRunBatchDate(String runBatchDate) {
        this.runBatchDate = runBatchDate == null ? null : runBatchDate.trim();
    }

    public String getRunJobId() {
        return runJobId;
    }

    public void setRunJobId(String runJobId) {
        this.runJobId = runJobId == null ? null : runJobId.trim();
    }

    public String getRunStartMode() {
        return runStartMode;
    }

    public void setRunStartMode(String runStartMode) {
        this.runStartMode = runStartMode == null ? null : runStartMode.trim();
    }

    public String getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus == null ? null : runStatus.trim();
    }

    public Date getRunBeginDate() {
        return runBeginDate;
    }

    public void setRunBeginDate(Date runBeginDate) {
        this.runBeginDate = runBeginDate;
    }

    public Date getRunEndDate() {
        return runEndDate;
    }

    public void setRunEndDate(Date runEndDate) {
        this.runEndDate = runEndDate;
    }

    public String getRunDesc() {
        return runDesc;
    }

    public void setRunDesc(String runDesc) {
        this.runDesc = runDesc == null ? null : runDesc.trim();
    }
}