package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Repositories;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.ReceiptType.Type;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    Receipt save(Receipt receipt);
    void delete(Receipt receipt);

    Optional<Receipt> findById(long id);

    List<Receipt> findAll();

    @Modifying
    @Transactional
    @Query("Update Receipt set Amount = :amount, Type = :type where Id = :id") //Hér kæmi SQL update skipun fyrir breytingar á receipt
    void change(@Param("amount") double amount, @Param("type") Type type, @Param("id") long id);

    @Query(value = "Select * From Receipt Where User_id = :user_id", nativeQuery = true)
    List<Receipt> getUsersReceipts(@Param("user_id") long userId);

    @Query(value = "Select * From Receipt Where id = :Rid", nativeQuery = true)
    Receipt getReceipt(@Param("Rid") long Rid);

    @Query(value = "Select * From Receipt Where User_id = :user_id And Date >= :from And Date <= :to", nativeQuery = true)
    List<Receipt> getReceiptsOfMonth(@Param("user_id") long user_id, @Param("from") String from, @Param("to") String to);

}
