package com.nmi.api.rate.models;


import com.nmi.api.rate.constants.ErrorCodeConstants;
import javax.validation.constraints.NotNull;

public class RateRequest extends RatesRequest {

	public enum PremiumPlan {STANDARD_MONTHLY, MONTHLY_ADVANTAGE, ANNUAL, SINGLE;}
	public enum RenewalOption {CONSTANT, AMORTIZING;}
	public enum PaidBy {BORROWER, LENDER;}
	public enum RefundType {NON_REFUNDABLE, REFUNDABLE;}


    @NotNull(message = ErrorCodeConstants.PREMIUM_PLANTYPE_REQUIRED)
	private PremiumPlan premiumPlan;
    @NotNull(message = ErrorCodeConstants.RENEWAL_OPTION_REQUIRED)
	private RenewalOption renewalOption;
    @NotNull(message = ErrorCodeConstants.PAID_TYPE_REQUIRED)
	private PaidBy paidBy;
    @NotNull(message = ErrorCodeConstants.REFUND_TYPE_REQUIRED)
	private RefundType refundType;

    public PremiumPlan getPremiumPlan() {
        return premiumPlan;
    }

    public void setPremiumPlan(PremiumPlan premiumPlan) {
        this.premiumPlan = premiumPlan;
    }

    public RenewalOption getRenewalOption() {
        return renewalOption;
    }

    public void setRenewalOption(RenewalOption renewalOption) {
        this.renewalOption = renewalOption;
    }

    public PaidBy getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(PaidBy paidBy) {
        this.paidBy = paidBy;
    }

    public RefundType getRefundType() {
        return refundType;
    }

    public void setRefundType(RefundType refundType) {
        this.refundType = refundType;
    }
}


