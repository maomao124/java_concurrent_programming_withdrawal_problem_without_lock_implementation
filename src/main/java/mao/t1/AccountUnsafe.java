package mao.t1;

import mao.Account;

/**
 * Project name(项目名称)：java并发编程_取款问题无锁实现
 * Package(包名): mao.t1
 * Class(类名): AccountUnsafe
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/7
 * Time(创建时间)： 10:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */
public class AccountUnsafe implements Account
{
    private Integer balance;


    /**
     * Instantiates a new Account unsafe.
     *
     * @param balance the balance
     */
    public AccountUnsafe(Integer balance)
    {
        this.balance = balance;
    }


    @Override
    public Integer getBalance()
    {
        return balance;
    }

    @Override
    public void withdraw(Integer amount)
    {
        balance -= amount;
    }
}
