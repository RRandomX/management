package org.csu.management.controller;

import org.csu.management.domain.Account;
import org.csu.management.domain.Product;
import org.csu.management.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"account","myList","authenticated"})
@RequestMapping("/account/")
public class AccountController {
    @Autowired
    private AccountService accountService;

//    @GetMapping("account")
//    public String account(){return "/account/account";};

    @PostMapping("signon")
    public String signon(String username,String password,Model model){
        Account account = accountService.getAccount(username, password);

        if (account == null) {
            String msg = "Invalid username or password.  Signon failed.";
            model.addAttribute("msg", msg);
            return "../static/index";
        } else {
            account.setPassword(null);
            //List<Product> myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
            boolean authenticated = true;
            model.addAttribute("account", account);
            //model.addAttribute("myList", myList);
            model.addAttribute("authenticated", authenticated);
            return "catalog/main";
        }
    }
    @GetMapping("editAccountForm")//点击用户管理时的时候
    public String editAccountForm(@SessionAttribute("account") Account account , Model model) {
        model.addAttribute("account", account);
//        model.addAttribute("LANGUAGE_LIST", LANGUAGE_LIST);
//        model.addAttribute("CATEGORY_LIST", CATEGORY_LIST);
        return "account/account";
    }
    @PostMapping("editAccount")//这个是点击修改account后点击save account information时的跳转
    public String editAccount(Account account, String repeatedPassword, Model model) {
        if (account.getPassword() == null || account.getPassword().length() == 0 || repeatedPassword == null || repeatedPassword.length() == 0) {
            String msg = "密码不能为空";
            model.addAttribute("msg", msg);
            return "account/account";
        } else if (!account.getPassword().equals(repeatedPassword)) {
            String msg = "两次密码不一致";
            model.addAttribute("msg", msg);
            return "account/account";
        } else {
            accountService.updateAccount(account);
            account = accountService.getAccount(account.getUsername());
            //List<Product> myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
            boolean authenticated = true;
            model.addAttribute("account", account);
            //model.addAttribute("myList", myList);
            model.addAttribute("authenticated", authenticated);
            String msg = "修改成功";
            model.addAttribute("msg", msg);
            return "account/account";
            //return "redirect:/catalog/index";
        }
    }
}
