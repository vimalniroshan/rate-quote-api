package com.nmi.api.rate.utils;

import com.nmi.api.rate.models.RateRequest;
import com.nmi.api.rate.models.RatesRequest;
import com.nmi.api.rate.models.RatesResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.Supplier;

public class RateResponseBuilder {
    private RatesRequest rateRequest;
    private String sourceTransactionId;

    private boolean allProducts = false;

    private Future<?> zipCodeLookup;
    private Future<?> mpLookup;

    public RateResponseBuilder(final RateRequest rateRequest, final String sourceTransactionId) {
        this.rateRequest = rateRequest;
        this.sourceTransactionId = sourceTransactionId;
    }

    public RateResponseBuilder(final RatesRequest ratesRequest, final String sourceTransactionId) {
        this.rateRequest = ratesRequest;
        this.sourceTransactionId = sourceTransactionId;
        this.allProducts = true;
    }

    public RateResponseBuilder getCounty(Supplier<?> supplier) {
        Future<?> zipCodeLookup = new FutureTask<Object>(()->supplier.get());
        return this;
    }

    public RateResponseBuilder getMasterPolicyInfo(Supplier<?> supplier) {
        Future<?> mpLookup = new FutureTask<Object>(()->supplier.get());
        return this;
    }

    public RatesResponse build() {
        //Do execute FutureTasks
        // if zipCodeLookup not null get it
        // if mpLookup is not null get it
        // if allProducts prepare request for all products
        // call drools for pricing
        // Build response object

        List<RatesResponse.Result.Product> products = new ArrayList <>();


        RatesResponse.Result.Product p1 = new RatesResponse.Result.Product();
        p1.setProductDescription("BPMI Single Non Refundable");
        p1.setPremiumPlan(RateRequest.PremiumPlan.SINGLE);
        p1.setRenewalOption(RateRequest.RenewalOption.CONSTANT);
        p1.setPaidBy(RateRequest.PaidBy.BORROWER);
        p1.setRefundType(RateRequest.RefundType.NON_REFUNDABLE);

        RatesResponse.Result.Product.PremiumPeriod p1pp1 = new RatesResponse.Result.Product.PremiumPeriod();
        p1pp1.setPeriodType(RatesResponse.Result.Product.PremiumPeriod.PeriodType.UPFRONT);
        p1pp1.setPremiumRateDurationMonths(200);
        p1pp1.setPremiumRate(new BigDecimal("0.0149"));
        //p1pp1.setBaseRate(null);
        p1pp1.setBlendedPremiumAndTaxRate(new BigDecimal("0.015168"));
        p1pp1.setPremiumAmount(new BigDecimal("4723.30"));
        p1pp1.setBlendedPremiumTaxAmount(new BigDecimal("4808.32"));

        p1.setPremiumPeriods(Arrays.asList(p1pp1));

        RatesResponse.Result.Product.Tax tax1 = new RatesResponse.Result.Product.Tax();
        tax1.setTaxingAuthority("State of Kentucky");
        tax1.setTaxRate(new BigDecimal("0.018"));
        tax1.setTaxAmount(new BigDecimal("85.02"));

        RatesResponse.Result.Product.Tax tax2 = new RatesResponse.Result.Product.Tax();
        tax2.setTaxingAuthority("Combined State, County and Municipal Tax");
        tax2.setTaxRate(new BigDecimal("0.018"));
        tax2.setTaxAmount(new BigDecimal("85.02"));

        p1.setTexes(Arrays.asList(tax1, tax2));

        products.add(p1);

        if(allProducts) {
            RatesResponse.Result.Product p2 = new RatesResponse.Result.Product();
            p2.setProductDescription("LPMI Single Non Refundable");
            p2.setPremiumPlan(RateRequest.PremiumPlan.SINGLE);
            p2.setRenewalOption(RateRequest.RenewalOption.CONSTANT);
            p2.setPaidBy(RateRequest.PaidBy.LENDER);
            p2.setRefundType(RateRequest.RefundType.NON_REFUNDABLE);

            RatesResponse.Result.Product.PremiumPeriod p2pp1 = new RatesResponse.Result.Product.PremiumPeriod();
            p2pp1.setPeriodType(RatesResponse.Result.Product.PremiumPeriod.PeriodType.UPFRONT);
            p2pp1.setPremiumRateDurationMonths(12);
            p2pp1.setPremiumRate(new BigDecimal("0.019"));
            //p2pp1.setBaseRate(null);
            p2pp1.setBlendedPremiumAndTaxRate(new BigDecimal("0.019342"));
            p2pp1.setPremiumAmount(new BigDecimal("6023.30"));
            p2pp1.setBlendedPremiumTaxAmount(new BigDecimal("6131.41"));

            p2.setPremiumPeriods(Arrays.asList(p2pp1));

            RatesResponse.Result.Product.Tax p2Tax1 = new RatesResponse.Result.Product.Tax();
            p2Tax1.setTaxingAuthority("State of Kentucky");
            p2Tax1.setTaxRate(new BigDecimal("0.018"));
            p2Tax1.setTaxAmount(new BigDecimal("108.41"));

            RatesResponse.Result.Product.Tax p2Tax2 = new RatesResponse.Result.Product.Tax();
            p2Tax2.setTaxingAuthority("Combined State, County and Municipal Tax");
            p2Tax2.setTaxRate(new BigDecimal("0.018"));
            p2Tax2.setTaxAmount(new BigDecimal("108.41"));

            p2.setTexes(Arrays.asList(p2Tax1, p2Tax2));

            products.add(p2);
        }
        RatesResponse r = new RatesResponse();
        r.setTransactionId(this.toString());
        r.setSourceTransactionId(sourceTransactionId);
        r.setResult(new RatesResponse.Result());

        r.getResult().setProducts(products);

        return r;
    }
}
