package mao;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：java并发编程_取款问题无锁实现
 * Package(包名): mao
 * Interface(接口名): Account
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/7
 * Time(创建时间)： 10:27
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface Account
{
    /**
     * 获取余额
     *
     * @return {@link Integer}
     */
    Integer getBalance();

    /**
     * 取款
     *
     * @param amount amount
     */
    void withdraw(Integer amount);

    /**
     * 方法内会启动 1000 个线程，每个线程做 -10 元 的操作
     * 如果初始余额为 10000 那么正确的结果应当是 0
     */
    static void start(Account account)
    {
        List<Thread> threads = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++)
        {
            threads.add(new Thread(() ->
            {
                account.withdraw(10);
            }));
        }
        threads.forEach(Thread::start);
        threads.forEach(t ->
        {
            try
            {
                t.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println("剩余金额：" + account.getBalance());
        System.out.println("花费时间: " + (end - start) / 1000_000 + " ms");
    }
}
