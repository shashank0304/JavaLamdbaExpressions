package streams.ch09;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankTransaction {

	private String accNumber;
	private BigDecimal amount;
	private LocalDate date;

	public BankTransaction(String accNo, BigDecimal amount, LocalDate date) {
		this.accNumber = accNo;
		this.amount = amount;
		this.date = date;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}

}
