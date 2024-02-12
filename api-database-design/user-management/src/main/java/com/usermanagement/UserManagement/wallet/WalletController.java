package com.usermanagement.UserManagement.wallet;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {
    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService){
        this.walletService = walletService;
    }

    @GetMapping("/api/wallets")
    public List<Wallet> getWallets() {
        return walletService.getWallets();
    }

    @GetMapping("/api/wallets/{id}")
    public Wallet getWalletById(@PathVariable Integer id) {
        return walletService.getWalletById(id);
    }

    @PostMapping("/api/wallets")
    public Wallet createWallet(@Validated @RequestBody WalletRequest request) throws Exception {
        // if (request.walletName() == null || request.walletName().trim().isEmpty()) {
        //    throw new Exception("wallet name is empty");
        // }
        return walletService.createWallet(request);
    }

    @PutMapping("/api/wallets/{id}")
    public Wallet updateWalletById(@PathVariable Integer id, @Validated @RequestBody WalletRequest request) throws Exception{
        return walletService.updateWalletById(id, request);
    }

    @DeleteMapping("/api/wallets/{id}")
    public String deleteWalletById(@PathVariable Integer id) {
        walletService.deleteWalletById(id);
        return "wallet id " + id + " was deleted";
    }

    @PutMapping("/api/wallets/active")
    public String activeAllWallet() {
        walletService.activeAllWallet();
        return "all wallet is already active";
    }

    @DeleteMapping("/api/wallets/delete3")
    public String deleteWalletByIdBelow3() {
        walletService.deleteWalletByIdBelow3();
        return "already delete wallet that id below 3";
    }
}

record WalletRequest(
        int walletId,
        @NotNull @Size(min = 3, max = 20)
        String walletName,
        @NotNull @Email(message = "email should be valid")
        String email
) {}
