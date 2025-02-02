package com.example.ERP_SYSTEM.entities.Finanz;


import com.example.ERP_SYSTEM.entities.Rechnung.rechnung;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name ="payments")
public class Payment {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;

    @ManyToMany
    @JoinTable(name = "order_invoice",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "invoice_id", referencedColumnName = "id"))
    private List<rechnung> invoices;

    @Column(name="payment_date", nullable = false)
      private LocalDate paymentDate;

      @Column(name = "amount",nullable = false)
      private double amount ;

      @Column(name = "payment_method", nullable = false,length = 255)
      private  String paymentMethod;
      @Column(name="status" , nullable = false)
      private  String status;

    @ManyToOne
    @JoinColumn(name = "transaction_id",referencedColumnName = "id")
    private transaction transaction; // Verknüpfung zur Transaktion

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private account account; // Verknüpfung zum Buchhaltungskonto

    public Payment(List<rechnung> invoice, LocalDate paymentDate, double amount, String paymentMethod, String status, com.example.ERP_SYSTEM.entities.Finanz.transaction transaction, com.example.ERP_SYSTEM.entities.Finanz.account account) {
        this.invoices = invoice;
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

    public List<rechnung> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<rechnung> invoices) {
        this.invoices = invoices;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
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
                ", invoice=" + invoices +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                ", transaction=" + transaction +
                ", account=" + account +
                '}';
    }
}
