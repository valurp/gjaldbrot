package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.ReceiptHost;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;

import java.util.List;

public interface ReceiptService {
    Receipt add(Receipt receipt);
    void delete(Receipt receipt);
    void change(Receipt oldReceipt, ReceiptHost newReceipt);
    List<Receipt> getReceipts(User u);

    Receipt getReceiptById(long id);
}
