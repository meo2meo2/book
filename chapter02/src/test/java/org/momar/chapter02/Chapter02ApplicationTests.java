package org.momar.chapter02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.testng.Assert.assertEquals;


public class Chapter02ApplicationTests {

    @Test
    public void testHelloWorld() {
        Greeter greeter = new HelloWorldGreeter();
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try(PrintStream ps = new PrintStream(out, true,StandardCharsets.UTF_8)) {
            greeter.setPrintStream(ps);
            greeter.greet();

        }
        String data = out.toString(StandardCharsets.UTF_8);
        Assert.assertEquals(data,"Hello World");

    }

    @Test
    public void testHelloWorldWithApplicationContext()
    {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Greeter greeter = (Greeter) ctx.getBean("helloGreeter");
        ByteArrayOutputStream out = ctx.getBean("baos",ByteArrayOutputStream.class);
        greeter.greet();
        String data = out.toString(StandardCharsets.UTF_8);
        assertEquals(data,"Hello World");
    }

}
