package cn.itcast;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        InputStream resourceAsStream = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String host = properties.getProperty("host");
        String port = properties.getProperty("port");
        String maxTotal = properties.getProperty("maxTotal");
        String maxIdle = properties.getProperty("maxIdle");

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        if (StringUtils.isNumeric(maxTotal)) {
            jedisPoolConfig.setMaxTotal(Integer.valueOf(maxTotal));
        }
        if (StringUtils.isNumeric(maxIdle)) {
            jedisPoolConfig.setMaxIdle(Integer.valueOf(maxIdle));
        }

        jedisPool = new JedisPool(jedisPoolConfig, host, Integer.valueOf(port));
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
