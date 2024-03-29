package com.usermanagement.UserManagement.wallet;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Wallet w SET w.active = TRUE")
    void setAllWalletActive();

    @Modifying
    @Transactional
    @Query("DELETE FROM Wallet w WHERE w.id < 3")
    void deleteWalletByIdBelow3();
}
