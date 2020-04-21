package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class) //跟main里的配置一样 它为配置类
class CommunityApplicationTests implements ApplicationContextAware {//哪个类想要容器就实现这个类
	private ApplicationContext applicationContext;
	/*@Test
	void contextLoads() {

	}*/

	@Override
	//传入的这个参数就是spring容器
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);

		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);//从容器中获取这个类型的bean
		System.out.println(alphaDao.select());

		alphaDao = applicationContext.getBean("alphaHello",AlphaDao.class);
		System.out.println(alphaDao.select());
	}

	@Test
	public void testBeanManagement(){
		AlphaService alphaService = applicationContext.getBean(AlphaService.class); //bean只被实例化一次
		//默认在spring容器中是单例  要想不是单例 就要在类前加上注解@Scope("prototype") 这样每次都创建一个新的实例 默认是"singleton"
		System.out.println(alphaService);
	}

	@Test
	public void testBeanConfig(){
		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	//直接用
	/*@Autowired//给当前的bean注入 加在一个属性前
	private AlphaDao alphaDao;//这句话意思就是容器把AlphaDao注入给这个属性*/

	//想用不是那个优先级的
	@Autowired
	@Qualifier("alphaHello")
	private  AlphaDao alphaDao;

	@Test
	public void testDI(){
		System.out.println(alphaDao);
	}


}
