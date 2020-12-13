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

import static com.finalproject.constants.PageUrlConstants.ACCOUNT_INFO;
import static com.finalproject.constants.PageUrlConstants.CREATE_ACCOUNT;

public class CreateAccountCommand extends MultiCommand {
    private static final Logger LOG = Logger.getLogger(CreateAccountCommand.class);
        private EntityDao<CreditAccount> creditAccountEntityDao;
    private EntityDao<DebitAccount> debitAccountEntityDao;

    public CreateAccountCommand() {
        this.creditAccountEntityDao = DaoFactory.getEntityDao(DaoType.CREDITACCOUNT);
        this.debitAccountEntityDao = DaoFactory.getEntityDao(DaoType.DEBITACCOUNT);
    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        return new Page(CREATE_ACCOUNT, true);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        String debitRate = request.getParameter("deb_rate");
        String depositedSum = request.getParameter("dep_sum");
        String startingDate = request.getParameter("start_date");
        System.out.println(startingDate);
        String depositDuration = request.getParameter("dep_dur");
        Calendar calendar = new GregorianCalendar(2017, Calendar.JANUARY , 25);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = null;
        try {
            endDate = dateFormat.parse(startingDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LOG.info("end date HERE = " + endDate);
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        assert endDate != null;
        DebitAccount debitAccount = registerDebitAccount(user, 0, Integer.parseInt(debitRate), Integer.parseInt(depositedSum), startingDate, endDate.toString(), Integer.parseInt(depositDuration));
        return new Page("/", true);
    }

    public DebitAccount registerDebitAccount(User currentUser, int balance, int debitRate, int depositedSum, String depositStart, String depositEnd, int depositDuration) {
        DebitAccount debitAccount = new DebitAccount(balance, debitRate, depositedSum, depositStart, depositEnd, depositDuration, currentUser.getAccountId());
        debitAccountEntityDao.create(debitAccount);
        return debitAccount;
    }
}
