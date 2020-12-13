package com.finalproject.web.command;

import com.finalproject.dao.EntityDao;
import com.finalproject.dao.UserDao;
import com.finalproject.entity.CreditAccount;
import com.finalproject.entity.DebitAccount;
import com.finalproject.entity.User;
import com.finalproject.enums.DaoType;
import com.finalproject.factory.DaoFactory;
import com.finalproject.factory.ServiceFactory;
import com.finalproject.service.ValidationService;
import com.finalproject.web.data.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.finalproject.constants.PageUrlConstants.*;

public class CreateCreditAccountCommand extends MultiCommand {
    private static final Logger LOG = Logger.getLogger(CreateAccountCommand.class);
        private EntityDao<CreditAccount> creditAccountEntityDao;
    private EntityDao<DebitAccount> debitAccountEntityDao;

    public CreateCreditAccountCommand() {
        this.creditAccountEntityDao = DaoFactory.getEntityDao(DaoType.CREDITACCOUNT);
        this.debitAccountEntityDao = DaoFactory.getEntityDao(DaoType.DEBITACCOUNT);
    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        return new Page(CREATE_CREDIT_ACCOUNT, true);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        String creditLimt = request.getParameter("credLim");
        String percentage = request.getParameter("perc");
        String startingDate = request.getParameter("begin");
        String duration = request.getParameter("duration");
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        CreditAccount creditAccount = registerCreditAccount(user, 0, Integer.parseInt(creditLimt), 0, Integer.parseInt(percentage), 1, startingDate, startingDate, Integer.parseInt(duration));
        return new Page(ACCOUNT_INFO, true);
    }


    public CreditAccount registerCreditAccount(User currentUser, int balance, int creditLimit, int debt,
                                               int percentage, int creditRate, String depositStart,
                                               String depositEnd, int depositDuration) {
        CreditAccount creditAccount = new CreditAccount("REVIEWING", balance, creditLimit, debt, percentage, creditRate, depositStart, depositEnd, depositDuration, currentUser.getAccountId());
       creditAccountEntityDao.create(creditAccount);
        return creditAccount;
    }
}
