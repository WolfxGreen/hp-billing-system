package com.site.billing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.site.billing.entity.BillingEntity;
import com.site.billing.services.BillingService;


@RestController
@RequestMapping("/api/billing")
public class BillingController {
	
	BillingService billingService;
	BillingEntity bill;
	
	
	public BillingController(BillingService billingService) {
		this.billingService = billingService;
	}


	@PostMapping
	private ResponseEntity<BillingEntity> saveBill(@RequestBody BillingEntity billing) {
		try {
			bill = billingService.saveAndPrintBill(billing);
			if (bill.getId()!=null) {
				return new ResponseEntity<>(bill, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(bill, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
