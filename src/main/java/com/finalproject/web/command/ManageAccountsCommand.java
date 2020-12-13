package com.finalproject.web.command;

import com.finalproject.dao.EntityDao;
import com.finalproject.entity.DebitAccount;
import com.finalproject.entity.User;
import com.finalproject.enums.DaoType;
import com.finalproject.factory.DaoFactory;
import com.finalproject.web.data.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static com.finalproject.constants.PageUrlConstants.*;

public class ManageAccountsCommand extends MultiCommand {
    private EntityDao<DebitAccount> debitAccountEntityDao;
    @Override
    protected Page performGet(HttpServletRequest request) {
        return new Page(MANAGE_ACCOUNTS, true);
    }

    public ManageAccountsCommand() {
        this.debitAccountEntityDao = DaoFactory.getEntityDao(DaoType.DEBITACCOUNT);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        String action = request.getParameter("yesno");
        System.out.println(request.getParameter("yesno"));
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        DebitAccount debitAccount = debitAccountEntityDao.getById(accountId, true);
        System.out.println(debitAccount.toString());
        if (action.equals("yes")) {
            debitAccountEntityDao.remove(debitAccount);
        }
        else if (action.equals("no")) {
            int balance = Integer.parseInt(request.getParameter("balance"));
            int debitRate = Integer.parseInt(request.getParameter("deb_rate"));
            int depositedSum = Integer.parseInt( request.getParameter("dep_sum"));
            int duration = Integer.parseInt(request.getParameter("duration"));
            debitAccount.setBalance(balance);
            debitAccount.setDebitRate(debitRate);
            debitAccount.setDepositDuration(duration);
            debitAccount.setDepositedSum(depositedSum);
            debitAccountEntityDao.update(debitAccount);
        }
        return new Page(ACCOUNT_INFO, true);
    }
}
