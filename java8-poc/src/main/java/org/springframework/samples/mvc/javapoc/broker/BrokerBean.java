package org.springframework.samples.mvc.javapoc.broker;


import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class BrokerBean {
	
	@NotEmpty
	@Size(min=4,max=13)
	private String accountNo;
	
	private String brokers;
	

	public String getBrokers() {
		return brokers;
	}

	public void setBrokers(String brokers) {
		this.brokers = brokers;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

    @Override
	public String toString() {
		return "BrokerBean [accountNo=" + accountNo + "]";
	}

	
	

	
}
