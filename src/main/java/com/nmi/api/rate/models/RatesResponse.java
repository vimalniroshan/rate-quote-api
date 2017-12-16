package com.nmi.api.rate.models;

import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.util.List;

public class RatesResponse {

    private String transactionId;
    private String sourceTransactionId;
    private Result result;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSourceTransactionId() {
        return sourceTransactionId;
    }

    public void setSourceTransactionId(String sourceTransactionId) {
        this.sourceTransactionId = sourceTransactionId;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        private List<Product> products;

        public List <Product> getProducts() {
            return products;
        }

        public void setProducts(final List <Product> products) {
            this.products = products;
        }

        public static class Product {
            private String productDescription;
            private RateRequest.PremiumPlan premiumPlan;
            private RateRequest.RenewalOption renewalOption;
            private RateRequest.PaidBy paidBy;
            private RateRequest.RefundType refundType;
            private List<PremiumPeriod> premiumPeriods;
            private List<Tax> texes;

            public String getProductDescription() {
                return productDescription;
            }

            public void setProductDescription(String productDescription) {
                this.productDescription = productDescription;
            }

            public RateRequest.PremiumPlan getPremiumPlan() {
                return premiumPlan;
            }

            public void setPremiumPlan(RateRequest.PremiumPlan premiumPlan) {
                this.premiumPlan = premiumPlan;
            }

            public RateRequest.RenewalOption getRenewalOption() {
                return renewalOption;
            }

            public void setRenewalOption(RateRequest.RenewalOption renewalOption) {
                this.renewalOption = renewalOption;
            }

            public RateRequest.PaidBy getPaidBy() {
                return paidBy;
            }

            public void setPaidBy(RateRequest.PaidBy paidBy) {
                this.paidBy = paidBy;
            }

            public RateRequest.RefundType getRefundType() {
                return refundType;
            }

            public void setRefundType(RateRequest.RefundType refundType) {
                this.refundType = refundType;
            }

            public List<PremiumPeriod> getPremiumPeriods() {
                return premiumPeriods;
            }

            public void setPremiumPeriods(List<PremiumPeriod> premiumPeriods) {
                this.premiumPeriods = premiumPeriods;
            }

            public List<Tax> getTexes() {
                return texes;
            }

            public void setTexes(List<Tax> texes) {
                this.texes = texes;
            }

            public static class PremiumPeriod {
                public enum PeriodType {UPFRONT, RENEWAL_1, RENEWAL_2;}

                private PeriodType periodType;
                @Max(360)
                private Integer premiumRateDurationMonths;
                private BigDecimal premiumRate;
                private BigDecimal baseRate;
                private BigDecimal blendedPremiumAndTaxRate;
                private BigDecimal premiumAmount;
                private BigDecimal blendedPremiumTaxAmount;

                public PeriodType getPeriodType() {
                    return periodType;
                }

                public void setPeriodType(PeriodType periodType) {
                    this.periodType = periodType;
                }

                public Integer getPremiumRateDurationMonths() {
                    return premiumRateDurationMonths;
                }

                public void setPremiumRateDurationMonths(Integer premiumRateDurationMonths) {
                    this.premiumRateDurationMonths = premiumRateDurationMonths;
                }

                public BigDecimal getPremiumRate() {
                    return premiumRate;
                }

                public void setPremiumRate(BigDecimal premiumRate) {
                    this.premiumRate = premiumRate;
                }

                public BigDecimal getBaseRate() {
                    return baseRate;
                }

                public void setBaseRate(BigDecimal baseRate) {
                    this.baseRate = baseRate;
                }

                public BigDecimal getBlendedPremiumAndTaxRate() {
                    return blendedPremiumAndTaxRate;
                }

                public void setBlendedPremiumAndTaxRate(BigDecimal blendedPremiumAndTaxRate) {
                    this.blendedPremiumAndTaxRate = blendedPremiumAndTaxRate;
                }

                public BigDecimal getPremiumAmount() {
                    return premiumAmount;
                }

                public void setPremiumAmount(BigDecimal premiumAmount) {
                    this.premiumAmount = premiumAmount;
                }

                public BigDecimal getBlendedPremiumTaxAmount() {
                    return blendedPremiumTaxAmount;
                }

                public void setBlendedPremiumTaxAmount(BigDecimal blendedPremiumTaxAmount) {
                    this.blendedPremiumTaxAmount = blendedPremiumTaxAmount;
                }
            }

            public static class Tax {
                private String taxingAuthority;
                private BigDecimal taxRate;
                private BigDecimal taxAmount;

                public String getTaxingAuthority() {
                    return taxingAuthority;
                }

                public void setTaxingAuthority(String taxingAuthority) {
                    this.taxingAuthority = taxingAuthority;
                }

                public BigDecimal getTaxRate() {
                    return taxRate;
                }

                public void setTaxRate(BigDecimal taxRate) {
                    this.taxRate = taxRate;
                }

                public BigDecimal getTaxAmount() {
                    return taxAmount;
                }

                public void setTaxAmount(BigDecimal taxAmount) {
                    this.taxAmount = taxAmount;
                }
            }
        }
    }
}
