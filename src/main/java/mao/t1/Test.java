package mao.t1;

import mao.Account;

/**
 * Project name(项目名称)：java并发编程_取款问题无锁实现
 * Package(包名): mao.t1
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/7
 * Time(创建时间)： 10:25
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    /**
     * @param args 参数
     */
    public static void main(String[] args)
    {
        Account.start(new AccountUnsafe(10000));
    }
}
