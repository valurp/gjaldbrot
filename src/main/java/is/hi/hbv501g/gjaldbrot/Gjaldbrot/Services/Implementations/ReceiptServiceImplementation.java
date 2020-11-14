package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.Implementations;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.ReceiptHost;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Repositories.ReceiptRepository;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void change(Receipt oldReceipt, ReceiptHost newReceipt){
        repository.change(newReceipt.getAmount(), oldReceipt.getType(),oldReceipt.getId());
    }

    public List<Receipt> getReceipts(User u) {
        return repository.getUsersReceipts(u.getId());
    }

    public Receipt getReceiptById(long id) {
        return repository.getReceipt(id);
    }
}
