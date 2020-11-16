package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.Implementations;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Repositories.ReceiptRepository;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptServiceImplementation implements ReceiptService {
    ReceiptRepository repository;

    @Autowired
    public ReceiptServiceImplementation(ReceiptRepository repository) {
        this.repository = repository;
    }

    @Override
    public Receipt add(Receipt receipt) {
        return repository.save(receipt);
    }

    @Override
    public void delete(Receipt receipt) {
        repository.delete(receipt);
    }
    public Receipt change(Receipt receipt){
        return repository.change(receipt.getAmount(), receipt.getType(), receipt.getId());
    }

    public List<Receipt> getReceipts(User u) {
        return repository.getUsersReceipts(u.getId());
    }

    public Receipt getReceiptById(long id) {
        return repository.getReceipt(id);
    }

    public ArrayList<Receipt> getReceiptsByMonth(User u, String month){
        //month : yyyy-MM -> yyyy-MM-dd-
        String from = month+"-01 00:00:00.0";
        String to = month+"-30 00:00:00.0";

        return (ArrayList<Receipt>) repository.getReceiptsOfMonth(u.getId(), from, to);
    }
}
