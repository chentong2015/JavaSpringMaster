package tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class MyTomcat {

    // 自定义tomcat启动方法，设置接受请求的路径和端口
    public static void run() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        try {
            tomcat.addWebapp("/", "D:\\");
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException ex) {
            ex.printStackTrace();
        }
    }
}
