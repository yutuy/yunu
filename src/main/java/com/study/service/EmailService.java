package com.study.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import com.study.util.DateUtil;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
@Configuration
public class EmailService {

    //邮件的发送者
    @Value("${spring.mail.username}")
    private String from;

    //注入MailSender
    @Autowired
    private JavaMailSender mailSender;

    //发送邮件的模板引擎
    @Autowired
    private FreeMarkerConfigurer configurer;

    /**
     * @param params       发送邮件的主题对象 object
     * @param title        邮件标题
     * @param templateName 模板名称
     */
    public void sendMessageMail(Object params, String to, String title, String templateName,String filePath,String fileName) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(InternetAddress.parse(to));//发送给谁

            helper.setSubject("【" + title + "-" + DateUtil.getDate(DateUtil.getCurrentDate()) + "】");//邮件标题

            Map<String, Object> model = new HashMap<String, Object>();
            model.put("params", params);
            try {
                Template template = configurer.getConfiguration().getTemplate(templateName);
                try {
                    String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
                    helper.setText(text, true);
                    
                    //携带附件操作 ，可携带多个附件
                    if(!"".equals(filePath)&&!"".equals(fileName)) {
                    	FileSystemResource file=new FileSystemResource(new File(filePath));
//                        String fileName=filePath.substring(filePath.lastIndexOf(File.separator));
                        helper.addAttachment(fileName,file);
//                    	 //带附件 
//                        Date d=new Date();
//                        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
//                        String fn= f.format(d);
//                        //注意项目路径问题，自动补用项目路径
//           	            FileSystemResource file = new FileSystemResource(new File("D:\\sfa\\upload\\img\\2018\\05\\11\\"+"20180511140300391984.png"));
//           	            //加入邮件
//           	            helper.addAttachment(fn+".png", file);
                        
                    }
                    mailSender.send(mimeMessage);
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
