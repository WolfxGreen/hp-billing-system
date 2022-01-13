package com.site.billing.services;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.site.billing.entity.BillingEntity;
import com.site.billing.repository.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {
	BillingRepository billingRepo;
	
	
	BillingEntity bill = null;

	public BillingServiceImpl(BillingRepository billingRepo) {
		this.billingRepo = billingRepo;
	}

	@Override
	public BillingEntity saveAndPrintBill(BillingEntity billingEntity) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();  
			String dateString = dtf.format(now);
			billingEntity.setAmount((String.format("%.2f",billingEntity.getPrice() * billingEntity.getQuantity())).toString());
			billingEntity.setDate(dateString);
			bill = billingRepo.save(billingEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bill;
	}

}
