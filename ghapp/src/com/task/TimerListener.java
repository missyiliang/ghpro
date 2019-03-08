package com.task;

import java.util.Calendar;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TimerListener implements ServletContextListener{
	private Timer timer = null;  
    
    @Override  
    public void contextInitialized(ServletContextEvent event) {  
        timer = new Timer(true);  
        event.getServletContext().log("photoManage������Ƭ������ʱ��������...................");  
       
        //����ִ��ʱ��
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//ÿ��
        //����ÿ���00:00:00ִ��
        calendar.set(year, month, day, 00, 00, 00);
        java.util.Date date = calendar.getTime();
        int period = 2*60*60 * 1000;
        //int period = 5 * 1000;
        //ÿ���dateʱ��ִ��TestTask��ÿ��2Сʱ�ظ�ִ��
        timer.schedule(new TestTask(), date, period);
        //ÿ���dateʱ��ִ��TestTask, ��ִ��һ��
        //timer.schedule(new TestTask(), date);
    }  
  
    @Override  
    public void contextDestroyed(ServletContextEvent event) {  
        if (timer != null) {  
            timer.cancel();  
            event.getServletContext().log("��ʱ������");
        }  
    }

}
