package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;

import java.util.ArrayList;
import java.util.List;

public interface ReceiptService {
    Receipt add(Receipt receipt);
    void delete(Receipt receipt);
    Receipt change(Receipt receipt);
    List<Receipt> getReceipts(User u);

    Receipt getReceiptById(long id);

    ArrayList<Receipt> getReceiptsByMonth(User u, String month);
}
