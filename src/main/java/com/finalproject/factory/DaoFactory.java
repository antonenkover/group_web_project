package com.finalproject.factory;

import com.finalproject.dao.*;
import com.finalproject.entity.UserCreditAccountData;
import com.finalproject.enums.DaoType;

import java.util.HashMap;
import java.util.Map;

public class DaoFactory {
    private static Map<DaoType, EntityDao> daoMap = new HashMap<>();

    static {
        daoMap.put(DaoType.USER, new UserDao());
        daoMap.put(DaoType.CREDITACCOUNT, new CreditAccountDao());
        daoMap.put(DaoType.DEBITACCOUNT, new DebitAccountDao());
        daoMap.put(DaoType.USERCREDITACCOUNTINFO, new UserCreditAccountDataDao());
    }

    private DaoFactory() {
    }

    public static EntityDao getEntityDao(DaoType daoType) {
        EntityDao entityDao = daoMap.get(daoType);
        if (entityDao != null) {
            return entityDao;
        }
        throw new RuntimeException("Dao with current dao type do not exist: " + daoType.name());
    }
}
