package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.Implementations;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Repositories.ReceiptRepository;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
