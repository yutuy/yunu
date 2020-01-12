package com.study.config;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.study.entity.Message;
import com.study.service.EmailService;
import com.study.util.DateStyle;
import com.study.util.DateUtil;

/**
 * @Description:定时器设置
 * @version 1.0
 * @author william
 * @createDate 2018年10月15日下午4:24:19
 * @modifyBy william
 * @modifyDate 2018年10月15日下午4:24:19
*/
@Configuration         
@EnableScheduling       //打开定时器总开关
public class TimerConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(TimerConfig.class);
	@Autowired
	private EmailService emailService;
//	@Autowired
//	private FlowService flowService;
//	@Autowired
//	private BaseUserService baseUserService;
//	@Autowired
//	private BaseExcuteProcessService baseExcuteProcessService;
//	@Autowired
//	private BaseExcutionRecordService baseExcutionRecordService;
//	@Autowired
//	private FreeMarkerExcelUtil freeMarkerExcelUtil;
//	@Autowired
//	private BaseRoleService  baseRoleService;
	
	
//	@Value("${gyl.save.file.path}")
//	protected String gylSaveFilePath;
//	
//	@Value("${synchronizd.gyl.save.file.path}")
//	protected String synchronizdFilePath;	
//	
//	@Value("${synchronizd.gyl.move.suceess.path}")
//	protected String synchronizdSucessPath;	
//	
//	@Value("${synchronizd.gyl.move.error.path}")
//	protected String synchronizdErrorPath;	
	
	
	//private String to = "amos.le@mobizone.cn";
	private String to = "m15618335861@163.com";
	
	/**
	 * 定时去看这个申请单是否超时(等于55天是去提醒一次，提醒这个人以及他的直属上级.到了60天，设置为超时)
	 * @author william
	 */
	@SuppressWarnings("unchecked")
	//@Scheduled(cron = "*/16 * * * * ?")
//	@Scheduled(cron = "0 0 0 * * ?")
    public void timeout(){
	    Message message = null;
//	    String regex = Const.MAIL_REGEX;
	    String title = "通知邮件";
	    Map<String, Object> param = new HashMap<String, Object>();
	    param.put("nowTime", DateUtil.DateToString(DateUtil.getCurrentDate(),DateStyle.YYYY_MM_DD_HH_MM_SS));
        try {
        	 logger.info("发送邮件开始"+DateUtil.DateToString(new Date(),DateStyle.YYYY_MM_DD_HH_MM_SS));
        	 message =new Message();
     		 message.setName("yut先生");
     		 message.setNum(11);
     		 emailService.sendMessageMail(message,to,title,"unprocessedsq.ftl","","");
        	 logger.info("发送邮件结束"+DateUtil.DateToString(new Date(),DateStyle.YYYY_MM_DD_HH_MM_SS));
		} catch (Exception e) {
			logger.error("发送邮件异常"+e.toString() +DateUtil.DateToString(new Date(),DateStyle.YYYY_MM_DD_HH_MM_SS));
		}
	}
	
	
//	 /**
//	 * 根据文件的结果移动文件
//	 * @param param1
//	 *        参数说明1
//	 * @return 
//	 *        返回说明  
//	 * @author william
//	 */
//	 private boolean moveFile(String fileName) {
//		   File file = new File(synchronizdFilePath);
//	       File newName = new File(fileName);
//	       return file.renameTo(newName);
//	 }
}
