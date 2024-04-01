package com.lms.api.pojoPayloads;

import java.util.List;

public class PutRoleProgramBatchByUserId_pojo {
    private int programId;
    private String roleId;
    public List<UserRoleProgramBatch> userRoleProgramBatches;

    // Constructors (you can add more if needed)
    public PutRoleProgramBatchByUserId_pojo() {
    }

    public PutRoleProgramBatchByUserId_pojo(int programId, String roleId, List<UserRoleProgramBatch> userRoleProgramBatches) {
        this.programId = programId;
        this.roleId = roleId;
        this.userRoleProgramBatches = userRoleProgramBatches;
    }

    // Getter and Setter methods
    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<UserRoleProgramBatch> getUserRoleProgramBatches() {
        return userRoleProgramBatches;
    }

    public void setUserRoleProgramBatches(List<UserRoleProgramBatch> userRoleProgramBatches) {
        this.userRoleProgramBatches = userRoleProgramBatches;
    }

    // Inner class for UserRoleProgramBatch
    public static class UserRoleProgramBatch {
        public int batchId;
        public String userRoleProgramBatchStatus;

        // Getter and Setter methods for UserRoleProgramBatch
        // (you can add more if needed)

        public int getBatchId() {
            return batchId;
        }

        public void setBatchId(int batchId) {
            this.batchId = batchId;
        }

        public String getUserRoleProgramBatchStatus() {
            return userRoleProgramBatchStatus;
        }

        public void setUserRoleProgramBatchStatus(String userRoleProgramBatchStatus) {
            this.userRoleProgramBatchStatus = userRoleProgramBatchStatus;
        }
    }
}


