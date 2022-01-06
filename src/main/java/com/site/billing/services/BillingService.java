package com.site.billing.services;

import com.site.billing.entity.BillingEntity;

public interface BillingService {

	BillingEntity saveAndPrintBill(BillingEntity billingEntity);
}
