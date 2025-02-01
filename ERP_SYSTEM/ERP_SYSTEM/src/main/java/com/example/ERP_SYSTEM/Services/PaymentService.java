package com.example.ERP_SYSTEM.Services;


//package com.example.ERP.services;

import com.example.ERP_SYSTEM.entities.Finanz.Payment;
import com.example.ERP_SYSTEM.Repo.PaymentRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    // Zahlung erstellen
    public void createPayment(Payment payment) {
        paymentRepo.save(payment);
    }

    // Zahlung anhand der ID abrufen
    public Payment getPayment(Integer id) {
        return paymentRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Payment with ID " + id + " not found."));
    }

    // Alle Zahlungen abrufen
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    // Zahlung löschen
    public void deletePayment(Integer id) {
        if (paymentRepo.existsById(id)) {
            paymentRepo.deleteById(id);
        } else {
            throw new EntityNotFoundException("Payment with ID " + id + " not found.");
        }
    }

    // Zahlung aktualisieren
    public void updatePayment(Integer id, Payment updatedPayment) {
        Payment existingPayment = paymentRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Payment with ID " + id + " not found."));

        existingPayment.setAmount(updatedPayment.getAmount());
        existingPayment.setPaymentDate(updatedPayment.getPaymentDate());
        existingPayment.setPaymentMethod(updatedPayment.getPaymentMethod());
        existingPayment.setAccount(updatedPayment.getAccount());
        existingPayment.setInvoice(updatedPayment.getInvoice());
        existingPayment.setTransaction(updatedPayment.getTransaction());

        paymentRepo.save(existingPayment);
    }
}
