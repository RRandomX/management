package org.csu.management.persistence;

import org.csu.management.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    Account getAccountByUsername(String username);


    void updateAccount(Account account);

    //void updateProfile(Account account);

    void updateSignon(Account account);

    Account getAccountByUsernameAndPassword(Account account);
}
