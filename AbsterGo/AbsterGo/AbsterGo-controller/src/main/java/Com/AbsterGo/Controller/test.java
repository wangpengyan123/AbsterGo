package Com.AbsterGo.Controller;

import org.AbsterGo.redis.service.redisService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring-mvc.xml");
        context.start();
        redisService demoService = (redisService) context.getBean("redisService"); // 获取远程服务代理
        String hello = demoService.set("test","value");// 执行远程方法
        System.out.println(hello);    
	}
}
