package com.atguigu.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

public class JedisTest {
    /**
     * JedisConnectionException: java.net.SocketTimeoutException:
     *      错误排查：
     *             1.1  检查reids是否启动
     *                  xhsell中： ps -aux|grep redis
     *             1.2 检查虚拟机防火墙是否关闭
     *             1.3 redis保护模式必须关闭
     *                  vim  /myredis/redis.conf
     *                  69行 ， 注释bind 127.0.0.1
     *                  88行，protected-mode yes改为no
     *                  重启redis服务
     */
    public static void main(String[] args) {
        //java代码连接reids步骤
        //1、获取连接
        Jedis jedis = new Jedis("106.15.225.103", 6379);
        //System.out.println("jedis = " + jedis);
        //2、使用连接对象发送命令操作redis
        String ping = jedis.ping();
        System.out.println("ping = " + ping);

       //使用redis保存图书的销量数据，可以查询图书的销量排行榜
      /* jedis.zadd("top",1,"lol");
       jedis.zadd("top",20,"cf");
       jedis.zadd("top",50,"csgo");
       jedis.zadd("top",15,"飞车");
       jedis.zadd("top",100,"红警");
       jedis.zadd("top",88,"吃鸡");

       //查询前3名
        Set<String> top = jedis.zrevrange("top", 0, 2);

        //查询前3名+销量
        Set<Tuple> top1 = jedis.zrevrangeWithScores("top", 0, 2);

        //可删除top
        //jedis.del("top");

        //遍历前3名
        for (String s : top) {
            System.out.println("s = " + s);
        }

        //查询前3名+销量
        for (Tuple tuple : top1) {
            System.out.println("tuple = " + tuple.getScore()+"----"+tuple.getElement());
        }

*/

        //3、关闭连接
        jedis.close();
    }
}
