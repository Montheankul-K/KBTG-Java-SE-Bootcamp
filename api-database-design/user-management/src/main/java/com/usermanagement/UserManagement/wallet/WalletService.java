package com.usermanagement.UserManagement.wallet;

import com.usermanagement.UserManagement.exception.DataExistException;
import com.usermanagement.UserManagement.exception.NotFoundException;
import com.usermanagement.UserManagement.mail.MailService;
import com.usermanagement.UserManagement.profile.Profile;
import com.usermanagement.UserManagement.profile.ProfileRepository;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class WalletService {
    // List<Wallet> wallets = new ArrayList<>(
    //        List.of(
    //               new Wallet(1,"wallet1", "wallet1@gmail.com"),
    //               new Wallet(2,"wallet2", "wallet2@gmail.com")
    //        )
    // );

    private final MailService mailService;
    private final WalletRepository walletRepository;
    private final ProfileRepository profileRepository;

    public WalletService(@Qualifier("googleMail") MailService mailService, WalletRepository walletRepository, ProfileRepository profileRepository) {
        this.mailService = mailService;
        this.walletRepository = walletRepository;
        this.profileRepository = profileRepository;
    }

    public List<Wallet> getWallets() {
        // try {
        //     callNormalService();
        // } catch (Exception e) {
        //     throw new InternalServiceException("internal service exception with Normal service");
        // }
        List<Wallet> walletList = walletRepository.findAll();
        return walletList;
        // return wallets;
    }

    @Transactional
    public Wallet createWallet(WalletRequest request) throws Exception {
        // Optional<Integer> maxWalletId = wallets.stream().map(Wallet::getWalletId).max(Integer::compareTo);
        // int nextWalletId = maxWalletId.orElse(0) + 1;
        // boolean emailExists = wallets.stream().anyMatch(wallet -> wallet.getEmail().equalsIgnoreCase(request.email()));
        // if (emailExists) {
        //     throw new DataExistException("email is already exist");
        // }
        // Wallet wallet = new Wallet(nextWalletId, request.walletName(), request.email());
        // wallets.add(wallet);
        // mailService.sendEmail("admin@google.com","wallet created");
        // return wallet;

        // other solution
        // wallets.stream().filter(wallet -> wallet.getEmail().equals(request.email())).findFirst().ifPresent(wallet -> {
        //     throw new DataExistException("email is already exist");
        // } );
        Optional<Profile> optionalProfile = profileRepository.findByEmail(request.email());
        Profile profile;
        if (optionalProfile.isPresent()) {
            profile = optionalProfile.get();
        } else {
            profile = new Profile();
            profile.setName("someone");
            profile.setEmail(request.email());
            profileRepository.save(profile);
        }

        Wallet wallet = new Wallet();
        wallet.setWalletName(request.walletName());
        wallet.setActive(true);
        wallet.setProfile(profile);
        walletRepository.save(wallet);
        return wallet;
    }

    public Wallet getWalletById(Integer id) {
        // return wallets.stream().filter(wallet -> wallet.getWalletId() == id)
        //        .findFirst()
                  // if not found throw exception
        //        .orElseThrow(() -> new NotFoundException("wallet not found by id " + id));
        return null;
    }

    public Wallet updateWalletById(Integer id, WalletRequest request) throws BadRequestException {
        // Optional<Wallet> wallet = wallets.stream().filter(w -> w.getWalletId() == id).findFirst();
        // if (wallet.isPresent()) {
        //     Wallet w = wallet.get();
        //     w.setWalletName(request.walletName());
        //     return w;
        // }

        // other solution
        // for (Wallet wallet: wallets) {
        //    if (wallet.getWalletId() == id) {
        //        wallet.setWalletName(request.walletName());
        //        return wallet;
        //    }
        // }

        Optional<Wallet> optionalWallet = walletRepository.findById(Long.valueOf(id)); // cast int to long
        if(optionalWallet.isEmpty()) {
            throw new BadRequestException("invalid wallet id");
        }
        Wallet wallet = optionalWallet.get();
        wallet.setWalletName(request.walletName());
        walletRepository.save(wallet);
        return wallet;
    }

    public void deleteWalletById(Integer id) {
        // wallets.removeIf(wallet -> wallet.getWalletId() == id);

        walletRepository.deleteById(Long.valueOf(id));
    }

    public void activeAllWallet() {
        walletRepository.setAllWalletActive();
    }

    public void deleteWalletByIdBelow3() {
        walletRepository.deleteWalletByIdBelow3();
    }

    private void callNormalService() {
        throw new RuntimeException();
    }
}



