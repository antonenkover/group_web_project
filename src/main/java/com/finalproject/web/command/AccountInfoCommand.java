package com.finalproject.web.command;

import com.finalproject.dao.EntityDao;
import com.finalproject.entity.CreditAccount;
import com.finalproject.entity.DebitAccount;
import com.finalproject.entity.User;
import com.finalproject.enums.DaoType;
import com.finalproject.factory.DaoFactory;
import com.finalproject.service.AccountService;
import com.finalproject.web.data.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

import static com.finalproject.constants.PageUrlConstants.ACCOUNT_INFO;
import static com.finalproject.constants.PageUrlConstants.MANAGE_ACCOUNTS;


public class AccountInfoCommand implements Command {
    private static final Logger LOG = Logger.getLogger(AccountInfoCommand.class);
    AccountService accountService;
    private EntityDao<CreditAccount> creditAccountEntityDao;
    private EntityDao<DebitAccount> debitAccountEntityDao;


    public AccountInfoCommand() {
        this.creditAccountEntityDao = DaoFactory.getEntityDao(DaoType.CREDITACCOUNT);
        this.debitAccountEntityDao = DaoFactory.getEntityDao(DaoType.DEBITACCOUNT);
    }


    @Override
    public Page perform(HttpServletRequest request) {
        System.out.println("Me "  + request.getParameter("cake"));
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        int accountId = user.getAccountId();
        LOG.info("User in session IS " + user + "account id = " + accountId);
        List<CreditAccount> cl = creditAccountEntityDao.getAll().stream().filter(c -> c.getAccountId() == accountId).collect(Collectors.toList());
        List<DebitAccount> dl = debitAccountEntityDao.getAll().stream().filter(c -> c.getAccountId() == accountId).collect(Collectors.toList());
        request.setAttribute("acc", cl);
        request.setAttribute("debit_acc", dl);
        return new Page(ACCOUNT_INFO);
    }

//    public void setUserDao(EntityDao creditAccountEntityDao) {
//        this.creditAccountEntityDao = creditAccountEntityDao;
//    }
}
