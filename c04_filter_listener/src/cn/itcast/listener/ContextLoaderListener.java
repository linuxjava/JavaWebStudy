package cn.itcast.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /**
     * 容器被创建时调用
     *
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized");
        ServletContext servletContext = servletContextEvent.getServletContext();
        String appConfig = servletContext.getInitParameter("contextConfig");
        String configFilePath = servletContext.getRealPath(appConfig);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(configFilePath);
            System.out.println(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 容器正常退出时被调用
     *
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed");
    }
}
