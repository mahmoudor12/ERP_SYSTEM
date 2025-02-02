package com.example.ERP_SYSTEM.entities.Finanz;


import jakarta.persistence.*;

@Entity
@Table(name="account")
public class account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_number", nullable = false, length = 50)
    private String accountNumber;
    @Column(name = "account_accountType", nullable = false, length = 255)
    private  String accountType;
    @Column(name = "account_balance", nullable = false, length = 250)
    private Double balance;
    @Column(name = "currency", nullable = false, length = 250)
    private String currency;
    @Column(name = "account_Holder", nullable = false, length = 250)
    private  String accountHolder;
    @Column(name = "account_BankName", nullable = false, length = 250)
    private String bankName;
    @Column(name = "account_iban", nullable = false, length = 250)
    private String iban;

    public account() {
    }

    public account(String accountNumber, String accountType, Double balance, String currency, String accountHolder, String bankName, String iban) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.currency = currency;
        this.accountHolder = accountHolder;
        this.bankName = bankName;
        this.iban = iban;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                ", bankName='" + bankName + '\'' +
                ", iban='" + iban + '\'' +
                '}';
    }
}
