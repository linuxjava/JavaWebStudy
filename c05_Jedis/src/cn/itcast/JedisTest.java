package cn.itcast;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {
    @Test
    public void jedisString(){
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("name", "李四");
        jedis.set("age", "20");

        System.out.println("name = " + jedis.get("name"));
        System.out.println("age = " + jedis.get("age"));

        jedis.del("name");
        System.out.println("name = " + jedis.get("name"));

        jedis.close();
    }

    @Test
    public void jedisHash(){
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.hset("myhash", "name", "张三");
        jedis.hset("myhash", "age", "20");

        System.out.println("name = " + jedis.hget("myhash", "name"));

        Map<String, String> myhash = jedis.hgetAll("myhash");
        System.out.println(myhash);

        jedis.hdel("myhash", "name");

        System.out.println("name = " + jedis.hget("myhash", "name"));

        jedis.close();
    }

    @Test
    public void jedisList(){
        Jedis jedis = new Jedis("localhost", 6379);
        //存储数据
        jedis.lpush("mylist", "a", "b", "c");
        jedis.rpush("mylist", "a", "b", "c");
        //获取数据
        System.out.println(jedis.lrange("mylist", 0, -1));
        //删除数据
        System.out.println(jedis.lpop("mylist"));
        System.out.println(jedis.rpop("mylist"));

        System.out.println(jedis.lrange("mylist", 0, -1));

        jedis.close();
    }

    @Test
    public void jedisSet(){
        Jedis jedis = new Jedis("localhost", 6379);

        jedis.sadd("myset", "java", "c++", "php");
        jedis.sadd("myset", "java");

        System.out.println(jedis.smembers("myset"));

        System.out.println(jedis.srem("myset", "c++"));

        System.out.println(jedis.smembers("myset"));

        jedis.close();
    }

    @Test
    public void jedisSortedSet(){
        Jedis jedis = new Jedis("localhost", 6379);

        jedis.zadd("mySortedSet", 3, "java");
        jedis.zadd("mySortedSet", 2, "c++");
        jedis.zadd("mySortedSet", 1, "php");

        System.out.println(jedis.zrange("mySortedSet", 0, -1));

        jedis.zrem("mySortedSet", "c++");
        jedis.zremrangeByScore("mySortedSet", 1, 2);

        System.out.println(jedis.zrange("mySortedSet", 0, -1));

        jedis.close();
    }
}
