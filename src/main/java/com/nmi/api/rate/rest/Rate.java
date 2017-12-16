package com.nmi.api.rate.rest;

import com.nmi.api.rate.models.RateRequest;
import com.nmi.api.rate.models.RatesResponse;
import com.nmi.api.rate.models.MasterPolicyNumber;
import com.nmi.api.rate.utils.RateResponseBuilder;
import com.nmi.api.rate.validator.SourceTransactionIdFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("rate")
public class Rate {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findRate(@Valid @NotNull RateRequest rateRequest,
                             @Valid @SourceTransactionIdFormat @QueryParam("sourceTransactionId") String sourceTransactionId) {

        RatesResponse response = new RateResponseBuilder(rateRequest, sourceTransactionId)
                                        .getCounty(() -> new Object())
                                        .build();

        return Response.ok(response).build();
    }

    @Path("{masterPolicyNumber}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findRate(@Valid @NotNull RateRequest rateRequest,
                             @Valid @PathParam("masterPolicyNumber") MasterPolicyNumber masterPolicyNumber,
                             @Valid @SourceTransactionIdFormat @QueryParam("sourceTransactionId") String sourceTransactionId) {
        RatesResponse response = new RateResponseBuilder(rateRequest, sourceTransactionId)
                .getCounty(() -> new Object())
                .getMasterPolicyInfo(() -> new Object())
                .build();

        return Response.ok(response).build();
    }

}
