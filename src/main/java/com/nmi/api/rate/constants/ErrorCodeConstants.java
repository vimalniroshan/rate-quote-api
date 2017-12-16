/*******************************************************************************
 * This [document] [material] [information] [program] contains trade secrets or otherwise confidential information owned by National MI. It
 * may not be reproduced, published or disclosed to others without National MI's authorization. Access to and use of this information is
 * strictly limited and controlled by National MI.
 *******************************************************************************/
/**
 * 
 */

package com.nmi.api.rate.constants;

/**
 * @author golak.patra
 */
public interface ErrorCodeConstants {

    String PREMIUM_PLANTYPE_REQUIRED = "{premium.plantype.required}";
    String RENEWAL_OPTION_REQUIRED = "{renewal.option.required}";
    String REFUND_TYPE_REQUIRED = "{refund.type.required}";
    String PAID_TYPE_REQUIRED = "{paid.type.required}";
    String POSTAL_CODE_REQUIRED = "{postal.code.required}";
    String SATE_CODE_REQUIRED = "{state.code.required}";
    String PROPERTY_TYPE_REQUIRED = "{proprty.type.required}";
    String NO_OF_UNITS_REQUIRED = "{number.of.units.required}";
    String OCCUPANCY_TYPE = "{occupancy.type.required}";
    String AMORTIZATION_TERM_REQUIRED = "{amortizationTerm.required}";
    String LTV_REQUIRED = "{ltv.ratio.required}";
    String LTV_VALUE_INVALID = "{ltv.ratio.required}";
    String BASE_LOAN_AMOUNT_REQUIRED = "{base.loan.amount.required}";
    String CREDITSCORE_VALUE_REQUIRED = "{creditscore.value.required}";
    String CREDITSCORE_RANGE = "{creditscore.value.invalid}";
    String LOAN_LEVEL_CREDITSCORE_RANGE = "{creditscore.value.invalid}";
    String COVERAGE_PERCENT_REQUIRED = "{coverage.percent.required}";
    String LOAN_PURPOSE_REQUIRED = "{loan.purpose.required}";
    String LOAN_TYPE_REQUIRED = "{loan.type.required}";
    String INVALID_AMORTIZATIONTERM = "{invalid.amortizationterm}";

    String ZIPCODE_INVALID = "{zipcode.minimum.five.digit.required}";
    String DTI_REQUIRED = "{dti.ratio.required}";
}
