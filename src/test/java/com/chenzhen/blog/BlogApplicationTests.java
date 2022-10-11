package com.chenzhen.blog;

import com.chenzhen.blog.mapper.TypeMapper;
import com.chenzhen.blog.pojo.Mail;
import com.chenzhen.blog.pojo.Type;
import com.chenzhen.blog.util.MailUtil;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.DigestUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

@SpringBootTest
@EnableTransactionManagement
class BlogApplicationTests {

//    @Autowired
//    JavaMailSender javaMailSender;//邮件发送器
//
//    @Autowired
//    TypeMapper typeMapper;
//    @Autowired
//    private MailUtil mailUtil;
//
//    @Autowired
//    SpringTemplateEngine springTemplateEngine;//Spring 模板引擎
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Test
//    void contextLoads() {
////        String s = DigestUtils.md5DigestAsHex("wan1324520".getBytes());
////        System.out.println("s = " + s);
//
//
//        List<Type> typeList = typeMapper.selectList(null);//type中注入blogList
//    }
//
////        @Test
//        public void test4() throws MessagingException {
//            MimeMessage msg = javaMailSender.createMimeMessage();//构建邮件
//            MimeMessageHelper helper = new MimeMessageHelper(msg, true);//设置可选文本或添加内联元素或附件，
//
//            helper.setFrom("");//发件人
//            helper.setSentDate(new Date());//发送日期
//            helper.setSubject("这是测试主题（thymeleaf）");//发送主题
//            helper.setTo("");//收件人
//
//            Context context = new Context();//构建上下文环境
//            context.setVariable("");
//            context.setVariable("", 19);
//
//            String process = springTemplateEngine.process("table", context);//将模板解析成静态字符串
//            helper.setText(process,true);//内容是否设置成html,true代表是
//
//
//            javaMailSender.send(msg);//发送
//        }
//
//
//    class MThread implements Runnable{
//
//        //2.实现类去实现Runnable中的抽象方法:run()
//        @Override
//        public void run() {
//            for(int i = 0;i < 100;i++){
//                if(i % 2 == 0){
//                        System.out.println(Thread.currentThread().getName() + ":" + i);
//
//                    }
//                }
//            }
//        }
////        @Test
//        public void test5(){
//            //构建邮件内容对象
//            SimpleMailMessage msg = new SimpleMailMessage();
//            //邮件发送者
//            msg.setFrom("1583296383@qq.com");
//            //邮件接收者
//            msg.setTo("1583296383@qq.com");
//            //邮件主题
//            msg.setSubject("测试邮件主题");
//            //邮件正文
//            msg.setText("测试邮件内容");
//            //邮件发送时间
//            msg.setSentDate(new Date());
//            //邮件发送
//            javaMailSender.send(msg);
//
//        }
//
//
//
//    public void testThread(){
//       MThread m1 = new MThread();
//       //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
//       Thread t1 = new Thread(m1);
//       //5.通过Thread类的对象调用start():①启动线程 ②调用当前线程的run() --> 调用了Runnable类型的target的run()
//       t1.start();
//
//       //再启动一个线程，遍历100以内的偶数
//       Thread t2 = new Thread(m1);
//       t2.setName("线程2");
//       t2.start();
//
//       System.out.println("执行到这里了");
//       return;
//   }
//
////   @Test
////   @Cacheable("")
//   public void test3(){
//       String s = DigestUtils.md5DigestAsHex("123456".getBytes());
//        System.out.println("s = " + s);
//
//   }
//
////   @Test
//    public void test6(){
//
//
//           redisTemplate.opsForValue().set("age", "年龄");
//
//           Object age = redisTemplate.opsForValue().get("age");
//
//           System.out.println("age = " + age);
//
//   }


}
