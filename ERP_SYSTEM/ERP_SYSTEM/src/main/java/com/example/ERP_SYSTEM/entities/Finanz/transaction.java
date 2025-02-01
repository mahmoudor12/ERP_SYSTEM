package com.example.ERP_SYSTEM.entities.Finanz;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate; // Datum der Transaktion

    @Column(name = "amount", nullable = false)
    private BigDecimal amount; // Betrag der Transaktion

    @Column(name = "status", nullable = false, length = 50)
    private String status; // Status der Transaktion (z.B. "Completed", "Failed")

    @Column(name = "payment_method", nullable = false, length = 50)
    private String paymentMethod; // Zahlungsmethode (z.B. Kreditkarte, Banküberweisung, PayPal)


    @Column(name = "currency", nullable = false, length = 3)
    private String currency; // Währung der Transaktion (z.B. EUR, USD)
    @ManyToOne
    @JoinColumn(name = "sender_account_id", nullable = false)
    private account senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiver_account_id", nullable = false)
    private account receiverAccount;

    public transaction() {
    }

    public transaction(LocalDate transactionDate, BigDecimal amount, String status, String paymentMethod, String currency, account senderAccount, account receiverAccount) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.currency = currency;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    @Override
    public String toString() {
        return "transaction{" +
                "id=" + id +
                ", transactionDate=" + transactionDate +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", currency='" + currency + '\'' +
                ", senderAccount=" + senderAccount +
                ", receiverAccount=" + receiverAccount +
                '}';
    }
}
