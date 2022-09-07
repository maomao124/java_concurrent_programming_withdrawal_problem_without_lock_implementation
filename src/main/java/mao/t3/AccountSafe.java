package mao.t3;

import mao.Account;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Project name(项目名称)：java并发编程_取款问题无锁实现
 * Package(包名): mao.t3
 * Class(类名): AccountSafe
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/7
 * Time(创建时间)： 10:49
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class AccountSafe implements Account
{
    private final AtomicInteger balance;

    public AccountSafe(Integer balance)
    {
        this.balance = new AtomicInteger(balance);
    }


    @Override
    public Integer getBalance()
    {
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount)
    {
        while (true)
        {
            int prev = balance.get();
            int next = prev - amount;
            if (balance.compareAndSet(prev, next))
            {
                break;
            }
        }
        //或者
        //balance.addAndGet(-1 * amount);
    }
}
