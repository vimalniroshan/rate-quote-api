package com.nmi.api.rate.models;

public class MasterPolicyNumber {
    //TODO add validator
    private String customerNumber;
    private String branchNumber;

    public MasterPolicyNumber(String masterPolicyNumber) {
        String[] mp = masterPolicyNumber.split("-");
        this.customerNumber = mp[0];
        this.branchNumber = mp[1];
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
    }
}
