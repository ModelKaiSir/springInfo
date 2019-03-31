package com.spring.locale;


import com.spring.i18n.Resources;
import org.testng.annotations.Test;

import java.text.MessageFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleTest {

    @Test
    public void msg(){
        MessageFormat format = new MessageFormat("{0,date,long}");
        Object[] params = {new Date()};
        System.out.println(format.format(params));
    }

    @Test
    public void hello(){
        System.out.println(Resources.class.getResource("resource_en_US.properties").getPath());
        Locale locale = Locale.US;
        ResourceBundle bundle = ResourceBundle.getBundle("com/spring/i18n/resource",locale);
        Object[] params = {"QiuKai",new GregorianCalendar().getTime()};
        if(null!=bundle){
            String common= bundle.getString("greeting.common");
            String morning= bundle.getString("greeting.morning");
            String afternoon= bundle.getString("greeting.afternoon");

            MessageFormat a = new MessageFormat(common,locale);
            MessageFormat b = new MessageFormat(morning,locale);
            MessageFormat c = new MessageFormat(afternoon,locale);

            System.out.println(a.format(params));
            System.out.println(b.format(params));
            System.out.println(c.format(params));
        }else{
            System.out.println("No Resource");
        }

    }

}
