package com.usermanagement.UserManagement.wallet;

import com.usermanagement.UserManagement.exception.DataExistException;
import com.usermanagement.UserManagement.exception.InternalServiceException;
import com.usermanagement.UserManagement.exception.NotFoundException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class WalletService {
    List<Wallet> wallets = new ArrayList<>(
            List.of(
                   new Wallet(1,"wallet1", "wallet1@gmail.com"),
                   new Wallet(2,"wallet2", "wallet2@gmail.com")
            )
    );

    public List<Wallet> getWallets() {
        // try {
        //     callNormalService();
        // } catch (Exception e) {
        //     throw new InternalServiceException("internal service exception with Normal service");
        // }
        return wallets;
    }

    public Wallet createWallet(WalletRequest request) {
        Optional<Integer> maxWalletId = wallets.stream().map(Wallet::getWalletId).max(Integer::compareTo);
        int nextWalletId = maxWalletId.orElse(0) + 1;
        boolean emailExists = wallets.stream().anyMatch(wallet -> wallet.getEmail().equalsIgnoreCase(request.email()));
        // wallets.stream().filter(wallet -> wallet.getEmail().equals(request.email())).findFirst().ifPresent(wallet -> {
        //     throw new DataExistException("email is already exist");
        // } );
        if (emailExists) {
            throw new DataExistException("email is already exist");
        }
        Wallet wallet = new Wallet(nextWalletId, request.walletName(), request.email());
        wallets.add(wallet);
        return wallet;
    }

    public Wallet getWalletById(Integer id) {
        return wallets.stream().filter(wallet -> wallet.getWalletId() == id)
                .findFirst()
                // if not found throw exception
                .orElseThrow(() -> new NotFoundException("wallet not found by id " + id));
    }

    private void callNormalService() {
        throw new RuntimeException();
    }
}

record WalletRequest(
        int walletId,
        @NotNull @Size(min = 3, max = 20)
        String walletName,
        @NotNull @Email(message = "email should be valid")
        String email) {}
class Wallet {
    private int walletId;
    private String walletName;
    private String email;

    public Wallet(int walletId, String walletName, String email){
        this.walletId = walletId;
        this.walletName = walletName;
        this.email = email;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public String getEmail() { return email; }
}
