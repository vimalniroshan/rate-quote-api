package com.nmi.api.rate.models;

import com.nmi.api.rate.constants.ErrorCodeConstants;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

public class RatesRequest {
    public enum OccupancyType {PRIMARY_RESIDENCE, SECOND_HOME, INVESTMENT_PROPERTY;}
    public enum LoanType {ARM, FIXED;}
    public enum LoanPurpose {PURCHASE, REFINANCE_CASH_OUT, REFINANCE_RATE_TERM, CONSTRUCTION_TO_PERM_REFINANCE, CONSTRUCTION_TO_PERM_CASH_OUT, CONSTRUCTION_TO_PERM_PURCHASE};
    public enum PropertyType {SINGLE_FAMILY_DETACHED, SINGLE_FAMILY_ATTACHED, PUD_TOWNHOME_ATTACHED, PUD_SFR_DETACHED, CONDO_LOW_RISE, CONDO_HIGH_RISE, CONDO_MID_RISE, SITE_CONDO, MULTI_FAMILY_UNIT, COOPERATIVE, MANUFACTURED_HOUSING;}
    public enum State {AL, AK, AZ, AR, CA, CO, CT, DE, FL, GA, HI, ID, IL, IN, IA, KS, KY, LA, ME, MD, MA, MI, MN, MS, MO, MT, NE, NV, NH, NJ, NM, NY, NC, ND, OH, OK, OR, PA, RI, SC, SD, TN, TX, UT, VT, VA, WA, WV, WI, WY;}

    @NotNull(message = ErrorCodeConstants.COVERAGE_PERCENT_REQUIRED)
    @Max(value = 1)
    private BigDecimal coveragePercent;
    @NotNull(message = ErrorCodeConstants.OCCUPANCY_TYPE)
    private OccupancyType occupancyType;
    @NotNull(message = ErrorCodeConstants.LOAN_TYPE_REQUIRED)
    private LoanType loanType;

    private Integer firstAdjustmentMonths;
    @NotNull(message = ErrorCodeConstants.AMORTIZATION_TERM_REQUIRED)
    @Min(value = 60, message = ErrorCodeConstants.INVALID_AMORTIZATIONTERM)
    @Max(value = 480, message = ErrorCodeConstants.INVALID_AMORTIZATIONTERM)
    private Integer amortizationTerm;
    private Boolean constructionToPerm = false;
    private Boolean temporaryBuyDownIdentifier = false;
    private Boolean relocationLoanInd = false;
    @Min(value = 600, message = ErrorCodeConstants.LOAN_LEVEL_CREDITSCORE_RANGE)
    @Max(value = 900, message = ErrorCodeConstants.LOAN_LEVEL_CREDITSCORE_RANGE)
    private Integer loanLevelCreditScore;
    @NotNull(message = ErrorCodeConstants.DTI_REQUIRED)
    private BigDecimal debtToIncomeRatio;
    @NotNull(message = ErrorCodeConstants.LTV_REQUIRED)
    @Max(value = 1, message = ErrorCodeConstants.LTV_VALUE_INVALID)
    private BigDecimal ltv;
    @NotNull(message = ErrorCodeConstants.BASE_LOAN_AMOUNT_REQUIRED)
    @Min(value = 1, message = ErrorCodeConstants.BASE_LOAN_AMOUNT_REQUIRED)
    private BigDecimal baseLoanAmount;
    @NotNull(message = ErrorCodeConstants.LOAN_PURPOSE_REQUIRED)
    private LoanPurpose loanPurpose;

    @NotNull(message = ErrorCodeConstants.PROPERTY_TYPE_REQUIRED)
    private PropertyType propertyType;
    @NotNull(message = ErrorCodeConstants.NO_OF_UNITS_REQUIRED)
    private Integer financedNoOfUnits = 1;
    @NotNull(message = ErrorCodeConstants.POSTAL_CODE_REQUIRED)
    @Size(min = 5, message = ErrorCodeConstants.ZIPCODE_INVALID)
    private String propertyZipCode;
    @NotNull(message = ErrorCodeConstants.SATE_CODE_REQUIRED)
    private State propertyState;
    private String propertyCity;
    private String propertyStreet;

    private List<Borrower> borrowers;


    public BigDecimal getCoveragePercent() {
        return coveragePercent;
    }

    public void setCoveragePercent(BigDecimal coveragePercent) {
        this.coveragePercent = coveragePercent;
    }

    public OccupancyType getOccupancyType() {
        return occupancyType;
    }

    public void setOccupancyType(OccupancyType occupancyType) {
        this.occupancyType = occupancyType;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public Integer getFirstAdjustmentMonths() {
        return firstAdjustmentMonths;
    }

    public void setFirstAdjustmentMonths(Integer firstAdjustmentMonths) {
        this.firstAdjustmentMonths = firstAdjustmentMonths;
    }

    public Integer getAmortizationTerm() {
        return amortizationTerm;
    }

    public void setAmortizationTerm(Integer amortizationTerm) {
        this.amortizationTerm = amortizationTerm;
    }

    public Boolean getConstructionToPerm() {
        return constructionToPerm;
    }

    public void setConstructionToPerm(Boolean constructionToPerm) {
        this.constructionToPerm = constructionToPerm;
    }

    public Boolean getTemporaryBuyDownIdentifier() {
        return temporaryBuyDownIdentifier;
    }

    public void setTemporaryBuyDownIdentifier(Boolean temporaryBuyDownIdentifier) {
        this.temporaryBuyDownIdentifier = temporaryBuyDownIdentifier;
    }

    public Boolean getRelocationLoanInd() {
        return relocationLoanInd;
    }

    public void setRelocationLoanInd(Boolean relocationLoanInd) {
        this.relocationLoanInd = relocationLoanInd;
    }

    public Integer getLoanLevelCreditScore() {
        return loanLevelCreditScore;
    }

    public void setLoanLevelCreditScore(Integer loanLevelCreditScore) {
        this.loanLevelCreditScore = loanLevelCreditScore;
    }

    public BigDecimal getDebtToIncomeRatio() {
        return debtToIncomeRatio;
    }

    public void setDebtToIncomeRatio(BigDecimal debtToIncomeRatio) {
        this.debtToIncomeRatio = debtToIncomeRatio;
    }

    public BigDecimal getLtv() {
        return ltv;
    }

    public void setLtv(BigDecimal ltv) {
        this.ltv = ltv;
    }

    public BigDecimal getBaseLoanAmount() {
        return baseLoanAmount;
    }

    public void setBaseLoanAmount(BigDecimal baseLoanAmount) {
        this.baseLoanAmount = baseLoanAmount;
    }

    public LoanPurpose getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(LoanPurpose loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getFinancedNoOfUnits() {
        return financedNoOfUnits;
    }

    public void setFinancedNoOfUnits(Integer financedNoOfUnits) {
        this.financedNoOfUnits = financedNoOfUnits;
    }

    public String getPropertyZipCode() {
        return propertyZipCode;
    }

    public void setPropertyZipCode(String propertyZipCode) {
        this.propertyZipCode = propertyZipCode;
    }

    public State getPropertyState() {
        return propertyState;
    }

    public void setPropertyState(State propertyState) {
        this.propertyState = propertyState;
    }

    public String getPropertyCity() {
        return propertyCity;
    }

    public void setPropertyCity(String propertyCity) {
        this.propertyCity = propertyCity;
    }

    public String getPropertyStreet() {
        return propertyStreet;
    }

    public void setPropertyStreet(String propertyStreet) {
        this.propertyStreet = propertyStreet;
    }

    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    public static class Borrower {
        private List<CreditScore> creditScores;

        public List<CreditScore> getCreditScores() {
            return creditScores;
        }

        public void setCreditScores(List<CreditScore> creditScores) {
            this.creditScores = creditScores;
        }

        public static class CreditScore {
            private boolean nonTraditionalCreditIndicator = false;
            @NotNull(message = ErrorCodeConstants.CREDITSCORE_VALUE_REQUIRED)
            @Min(value = 600, message = ErrorCodeConstants.CREDITSCORE_RANGE)
            @Max(value = 900, message = ErrorCodeConstants.CREDITSCORE_RANGE)
            private Integer creditScore;

            public boolean isNonTraditionalCreditIndicator() {
                return nonTraditionalCreditIndicator;
            }

            public void setNonTraditionalCreditIndicator(boolean nonTraditionalCreditIndicator) {
                this.nonTraditionalCreditIndicator = nonTraditionalCreditIndicator;
            }

            public Integer getCreditScore() {
                return creditScore;
            }

            public void setCreditScore(Integer creditScore) {
                this.creditScore = creditScore;
            }
        }
    }

}
