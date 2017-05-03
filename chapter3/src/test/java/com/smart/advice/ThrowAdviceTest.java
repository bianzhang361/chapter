package com.smart.advice;

import com.smart.domain.ViewSpace;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/5/3.
 */
public class ThrowAdviceTest {
    @Test
    public void testAdvice() {
        String  configPath = "com/smart/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ViewSpaceService viewSpaceService = (ViewSpaceService) ctx.getBean("viewSpaceService");

        try {
            boolean bool = viewSpaceService.deleteViewSpace(1);
            System.out.println(bool);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            viewSpaceService.updateViewSpace(new ViewSpace());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
