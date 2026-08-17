package com.itheima.rumen10;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private Account loginAccount;

    // 启动atm系统 展示欢迎
    public void start() {
        while (true) {
            System.out.println("欢迎使用ATM系统");
            System.out.println("1. 登录");
            System.out.println("2. 注册");
            System.out.println("请选择：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    login();
                    break;
                case 2:
                    createAccount();
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
    }
    // 登录
    private void login() {
        System.out.println("---登录---");
        if (accounts.size() == 0){
            System.out.println("没有账户，请先注册");
            return;
        }

        while (true) {
            System.out.println("请输入卡号：");
            String cardId = sc.next();
            Account acc = getAccountByCardId(cardId);
            if (acc == null) {
                System.out.println("卡号不存在");
            }else{
                while (true) {
                    System.out.println("请输入密码：");
                    String password = sc.next();
                    if (acc.getPassword().equals(password)) {
                        loginAccount = acc;
                        System.out.println("恭喜您："+acc.getUsername()+"登录成功，您的卡号是："+acc.getCardId());
                        showMainMenu();
                        return;
                    } else {
                        System.out.println("密码错误");
                    }
                }
            }
        }

    }

    // 展示登陆后的操作页面
    private void showMainMenu() {
        while (true) {
            System.out.println("你可以选择如下功能进行账户处理：");
            System.out.println("1. 查询余额");
            System.out.println("2. 存钱");
            System.out.println("3. 取钱");
            System.out.println("4. 转账");
            System.out.println("5. 密码修改");
            System.out.println("6. 退出登录");
            System.out.println("7. 注销当前账户");
            System.out.println("请选择：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    showLoginAccountInfo();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    transferMoney();
                    break;
                case 5:
                    changePassword();
                    return;
                case 6:
                    System.out.println(loginAccount.getUsername() + "退出登录成功");
                    loginAccount = null;
                    return;
                case 7:
                    if(deleteAccount()) return;
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
    }

    // 修改密码
    private void changePassword() {
        System.out.println("---修改密码---");

        while (true) {
            System.out.println("请输入旧密码：");
            String oldPassword = sc.next();
            if (loginAccount.getPassword().equals(oldPassword)) {
                while (true) {
                    System.out.println("请输入新密码：");
                    String newPassword = sc.next();
                    System.out.println("请输入确认密码：");
                    String confirmPassword = sc.next();
                    if (newPassword.equals(confirmPassword)) {
                        loginAccount.setPassword(newPassword);
                        System.out.println("密码修改成功");
                        return;
                    }else{
                        System.out.println("两次密码输入不一致，请重新输入");
                    }
                }

            } else {
                System.out.println("旧密码输入有误");
            }
        }
    }

    // 注销当前账户
    private boolean deleteAccount() {
        System.out.println("---进行销户操作---");

        System.out.println("请问您确认小虎吗？ y/n");
        String command = sc.next();
        switch (command) {
            case "y":
                if (loginAccount.getMoney() == 0) {
                    accounts.remove(loginAccount);
                    System.out.println("销户成功");
                    return true;
                }else{
                    System.out.println("账户余额还有钱，请先取钱再销户");
                    return false;
                }
            case "n":
                System.out.println("销户取消");
                return false;
            default:
                System.out.println("输入有误");
                return false;
        }
    }

    // 转账
    private void transferMoney() {
        System.out.println("---转账---");

        if (accounts.size() <2){
            System.out.println("当前系统账户数量不足，无法转账");
            return;
        }
        if (loginAccount.getMoney() == 0) {
            System.out.println("账户余额不足," + loginAccount.getMoney() + "元，无法转账");
            return;
        }

        while (true) {
            System.out.println("请输入对方的卡号：");
            String cardId = sc.next();
            Account acc = getAccountByCardId(cardId);
            if (acc == null) {
                System.out.println("卡号不存在");
            }else {
                String name = "*"+ acc.getUsername().substring(1);
                System.out.println("请输入["+name + "的姓氏");
                String lastName = sc.next();
                if (acc.getUsername().startsWith(lastName)) {
                    System.out.println("请输入转账的金额：");
                    double money = sc.nextDouble();
                    if (money > loginAccount.getMoney()) {
                        System.out.println("余额不足,账户余额是：" + loginAccount.getMoney());
                    } else {
                        loginAccount.setMoney(loginAccount.getMoney() - money);
                        acc.setMoney(acc.getMoney() + money);
                        System.out.println("恭喜您，转账"+ money +"成功，当前账户余额为：" + loginAccount.getMoney());
                        return; //直接跳出方法
                    }
                } else {
                    System.out.println("输入的姓氏有误");
                }

                break;
            }
        }


    }

    // 取钱
    private void withdrawMoney() {
        System.out.println("---取钱---");
        while (true) {
            System.out.println("请输入取钱的金额：");
            double money = sc.nextDouble();

            if (money > loginAccount.getMoney()) {
                System.out.println("余额不足,账户余额是：" + loginAccount.getMoney());
            } else if (money > loginAccount.getLimit()) {
                System.out.println("取现金额超出取现额度"+loginAccount.getLimit());
            } else {
                loginAccount.setMoney(loginAccount.getMoney() - money);
                System.out.println("恭喜您，取钱"+ money +"成功，当前账户余额为：" + loginAccount.getMoney());
                break;
            }
        }
    }

    // 存钱
    private void depositMoney() {
        System.out.println("---存钱---");
        System.out.println("请输入存入的金额：");
        double money = sc.nextDouble();

        loginAccount.setMoney(loginAccount.getMoney() + money);
        System.out.println("恭喜您，存钱"+ money +"成功，当前账户余额为：" + loginAccount.getMoney());
    }

    // 展示当前登录的账户信息
    private void showLoginAccountInfo() {
        System.out.println("当前登录账户信息：");
        System.out.println("账户卡号：" + loginAccount.getCardId());
        System.out.println("账户名称：" + loginAccount.getUsername());
        System.out.println("账户性别：" + loginAccount.getSex());
        System.out.println("账户余额：" + loginAccount.getMoney());
        System.out.println("账户取现额度：" + loginAccount.getLimit());
    }


    // 注册
    private void createAccount() {
        // 1 创建账户对象
        Account acc = new Account();

        // 2 输入账户信息
        System.out.println("---注册---");
        System.out.println("请输入账户名称：");
        String username = sc.next();
        acc.setUsername(username);

        while (true) {
            System.out.println("请输入您的性别");
            char sex = sc.next().charAt(0);
            if (sex == '男' || sex == '女') {
                acc.setSex(sex);
                break;
            } else {
                System.out.println("输入有误");
            }
        }

        while (true) {
            System.out.println("请输入账户密码：");
            String passWord = sc.next();
            System.out.println("请输入确认的密码：");
            String okPassWord = sc.next();
            if (passWord.equals(okPassWord)){
                acc.setPassword(passWord);
                break;
            }else {
                System.out.println("两次输入的密码不一致");
            }
        }

        System.out.println("请您输入您的取现额度");
        double limit = sc.nextDouble();
        acc.setLimit(limit);

        // 我们需要为这个账户生成一个卡号 自动生成 8位数字 不能与其他账户的卡号重复
        String newCardId = createCardId();
        acc.setCardId(newCardId);

        // 3 添加账户到集合
        accounts.add(acc);
        System.out.println("恭喜您："+acc.getUsername()+"注册成功; 您的卡号是："+acc.getCardId());

    }

    // 返回一个8位数字的卡号 而且这个卡号 不能与其他账户的卡号重复
    private String createCardId() {
        String cardId = "";

        Random r = new Random();
        for (int i = 0; i < 8; i++) {
            int data = r.nextInt(10);
            cardId += data;
        }

        Account acc = getAccountByCardId(cardId);
        if (acc != null) {
            // 说明卡号重复了
            return createCardId();
        }

        return cardId;
    }

    // 根据卡号查账户对象
    private Account getAccountByCardId(String cardId) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getCardId().equals(cardId)) {
                return acc;
            }
        }
        return null;
    }
}
