package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Repositories;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.ReceiptType.Type;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    Receipt save(Receipt receipt);
    void delete(Receipt receipt);

    @Modifying
    @Query("Update Receipt set Amount = :amount, Type = :type where Id = :id") //Hér kæmi SQL update skipun fyrir breytingar á receipt
    Receipt change(@Param("amount") double amount, @Param("type") Type type, @Param("id") long id);

    @Query(value = "Select * From Receipt Where User_id = :user_id", nativeQuery = true)
    List<Receipt> getUsersReceipts(@Param("user_id") long userId);

}
