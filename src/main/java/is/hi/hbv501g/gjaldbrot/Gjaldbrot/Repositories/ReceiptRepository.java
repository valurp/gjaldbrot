package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Repositories;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    Receipt save(Receipt receipt);
    void delete(Receipt receipt);
}
