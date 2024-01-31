package com.usermanagement.UserManagement.wallet;

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
}
