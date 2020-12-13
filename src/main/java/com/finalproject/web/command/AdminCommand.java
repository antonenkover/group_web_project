package com.finalproject.web.command;

import com.finalproject.dao.EntityDao;
import com.finalproject.dao.UserDao;
import com.finalproject.entity.CreditAccount;
import com.finalproject.entity.DebitAccount;
import com.finalproject.entity.User;
import com.finalproject.entity.UserCreditAccountData;
import com.finalproject.enums.DaoType;
import com.finalproject.factory.DaoFactory;
import com.finalproject.service.AccountService;
import com.finalproject.web.data.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.finalproject.constants.PageUrlConstants.ACCOUNT_INFO;
import static com.finalproject.constants.PageUrlConstants.ADMIN_ACCOUNT_INFO;

public class AdminCommand implements Command {

    private static final Logger LOG = Logger.getLogger(AdminCommand.class);
    private EntityDao<UserCreditAccountData> userCreditAccountDataEntityDao;

    public AdminCommand() {
        this.userCreditAccountDataEntityDao = DaoFactory.getEntityDao(DaoType.USERCREDITACCOUNTINFO);
    }

    @Override
    public Page perform(HttpServletRequest request) {
        List<UserCreditAccountData> userList = userCreditAccountDataEntityDao.getAll();
        request.setAttribute("users", userList);
        return new Page(ADMIN_ACCOUNT_INFO);
    }
}
