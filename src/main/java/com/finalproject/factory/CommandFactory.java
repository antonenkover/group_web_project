package com.finalproject.factory;

import com.finalproject.web.command.*;

import java.util.HashMap;
import java.util.Map;


public class CommandFactory {

    private static Map<String, Command> getCommandMap = new HashMap<>();
    private static Map<String, Command> postCommandMap = new HashMap<>();
    private static Command defaultCommand = new NotFoundCommand();

    static {
        getCommandMap.put("/", new HomePageCommand());
        getCommandMap.put("/logout", new LogoutCommand());
        getCommandMap.put("/registration", new RegistrationCommand());
        getCommandMap.put("/language", new LanguageCommand());
        getCommandMap.put("/contact", new ContactCommand());
        getCommandMap.put("/account", new AccountCommand());
        getCommandMap.put("/account_info", new AccountInfoCommand());
        getCommandMap.put("/admin_account_info", new AdminCommand());
        getCommandMap.put("/create_account", new CreateAccountCommand());
        getCommandMap.put("/create_debit_account", new CreateDebitAccountCommand());
        getCommandMap.put("/create_credit_account", new CreateCreditAccountCommand());
        getCommandMap.put("/reset_password", new ResetPasswordCommand());
        getCommandMap.put("/manage_accounts", new ManageAccountsCommand());

        postCommandMap.put("/", new HomePageCommand());
        postCommandMap.put("/registration", new RegistrationCommand());
        postCommandMap.put("/login", new LoginCommand());
        postCommandMap.put("/create_account", new CreateAccountCommand());
        postCommandMap.put("/create_debit_account", new CreateDebitAccountCommand());
        postCommandMap.put("/create_credit_account", new CreateCreditAccountCommand());
        postCommandMap.put("/reset_password", new ResetPasswordCommand());
        postCommandMap.put("/manage_accounts", new ManageAccountsCommand());
    }

    private CommandFactory() {
    }

    public static Command getCommand(String path, String type) {
        return "GET".equals(type)
                ? getCommand(path)
                : postCommand(path);
    }

    private static Command getCommand(String path) {
        return getCommandMap.getOrDefault(path, defaultCommand);
    }

    private static Command postCommand(String path) {
        return postCommandMap.getOrDefault(path, defaultCommand);
    }
}
