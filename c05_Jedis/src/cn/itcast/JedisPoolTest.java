package cn.itcast;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisPoolTest {
    @Test
    public void jedisPoolTest() {
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("name", "李四");
        System.out.println(jedis.get("name"));

        jedis.close();
    }
}
