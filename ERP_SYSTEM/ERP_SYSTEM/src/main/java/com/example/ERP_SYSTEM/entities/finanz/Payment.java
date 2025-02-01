package com.example.ERP_SYSTEM.entities.finanz;


import com.example.ERP_SYSTEM.entities.Rechnung.rechnung;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Entity
@Table(name ="payments")
public class Payment {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;

      @ManyToMany
      @JoinColumn(name = "invoice_id" ,columnDefinition = "id")
      private rechnung invoice;
      @Column(name="payment_date", nullable = false)
      private Data paymentDate;

      @Column(name = "amount",nullable = false)
      private double amount ;

      @Column(name = "payment_method", nullable = false,length = 255)
      private  String paymentMethod;
      @Column(name="status" , nullable = false)
      private  String status;

    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = true)
    private transaction transaction; // Verknüpfung zur Transaktion

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private account account; // Verknüpfung zum Buchhaltungskonto

    public Payment(rechnung invoice, Data paymentDate, double amount, String paymentMethod, String status, com.example.ERP_SYSTEM.entities.finanz.transaction transaction, com.example.ERP_SYSTEM.entities.finanz.account account) {
        this.invoice = invoice;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.transaction = transaction;
        this.account = account;
    }

    public Payment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public rechnung getInvoice() {
        return invoice;
    }

    public void setInvoice(rechnung invoice) {
        this.invoice = invoice;
    }

    public Data getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Data paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(transaction transaction) {
        this.transaction = transaction;
    }

    public account getAccount() {
        return account;
    }

    public void setAccount(account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", invoice=" + invoice +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                ", transaction=" + transaction +
                ", account=" + account +
                '}';
    }
}
