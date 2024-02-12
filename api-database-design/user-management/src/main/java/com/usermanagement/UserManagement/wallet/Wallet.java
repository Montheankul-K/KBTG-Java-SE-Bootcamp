package com.usermanagement.UserManagement.wallet;

import com.usermanagement.UserManagement.profile.Profile;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    // set running number
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min = 3, max = 20)
    private String walletName;
    // private String email;
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "profile_email", referencedColumnName = "email")
    private Profile profile;

    // public Wallet(int walletId, String walletName, String email) {
    //    this.id = walletId;
    //    this.walletName = walletName;
    //    this.email = email;
    // }

    public Wallet() {}

    public int getWalletId() {
        return id;
    }

    public void setWalletId(int walletId) {
        this.id = walletId;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    // public String getEmail() { return email; }
    public Boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
