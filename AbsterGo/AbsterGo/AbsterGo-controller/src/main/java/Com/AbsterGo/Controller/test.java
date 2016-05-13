package Com.AbsterGo.Controller;

import org.AbsterGo.dao.userDao;
import org.AbsterGo.redis.service.redisService;
import org.AbsterGo.service.userService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring.xml");
        context.start();
        userService service=(userService) context.getBean("userService");
    
        redisService redis=(redisService) context.getBean("redisService");
        redis.set("name", "name");
	}
}
