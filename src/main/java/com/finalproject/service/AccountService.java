package com.finalproject.service;

import com.finalproject.dao.EntityDao;
import com.finalproject.entity.CreditAccount;
import com.finalproject.enums.DaoType;
import com.finalproject.factory.DaoFactory;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class AccountService {
    private static final Logger LOG = Logger.getLogger(ValidationService.class);
    private EntityDao<CreditAccount> creditAccountEntityDao;

    public AccountService() {
        this.creditAccountEntityDao = DaoFactory.getEntityDao(DaoType.CREDITACCOUNT);
    }

    public Optional<CreditAccount> getUserCreditAccount(int accountId) {
        List<CreditAccount> creditList = creditAccountEntityDao.getAll();

        return creditList.stream().filter(c -> c.getAccountId() == accountId).findFirst();
    }
}
