package com.parkcharge.mail.service;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * 简单的邮件发送器
 * 
 * @author 陈捷
 *
 */
@Service
public class SimpleMailSender {
	private MailSender mailSender;
	private SimpleMailMessage templateMessage;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}

	/**
	 * 发送邮件
	 * 
	 * @param toMailAddress 对方的邮件地址
	 * @param mailTitle 邮件标题
	 * @param mailContent 邮件内容
	 */
	public void sendMail(String toMailAddress, String mailTitle, String mailContent) {
		SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
		msg.setTo(toMailAddress);
		msg.setSubject(mailTitle);
		msg.setText(mailContent);
		try {
			mailSender.send(msg);
		} catch (MailException e) {
			e.printStackTrace();
		}
	}
}
