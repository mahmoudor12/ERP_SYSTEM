package com.example.ERP_SYSTEM.Services;

import com.example.ERP_SYSTEM.Repo.RechnungRepo;
import com.example.ERP_SYSTEM.entities.Rechnung.rechnung;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechnungService {
       @Autowired
       RechnungRepo Rechnungrepo;
       public void createRechnung(rechnung rechnung){
           if (Rechnungrepo.existsById(rechnung.getId())){
               Rechnungrepo.save(rechnung);
           } else{
               throw new EntityNotFoundException("Rechnung with ID:" +rechnung.getId()+ "schon vorhandeln");
           }
       }
       public rechnung getRechnung(Integer id){
           return Rechnungrepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Rechnung with ID:" +id+ "schon vorhandeln"));
       }
       public List<rechnung> getAll(){
           return Rechnungrepo.findAll();
       }
       public void delete(Integer id){
           if(Rechnungrepo.existsById(id)){
               Rechnungrepo.deleteById(id);
           }
       }
       public void update(Integer id, rechnung rech){
           if (Rechnungrepo.existsById(id)){
               rechnung rech1 = Rechnungrepo.findById(id).orElseThrow();
               rech1.setDueDate(rech.getDueDate());
               rech1.setOrder(rech.getOrder());
               rech1.setStatus(rech.getStatus());
               rech1.setTotalAmount(rech.getTotalAmount());
               rech1.setInvoiceDate(rech.getInvoiceDate());
           }

       }
}
