package com.usermanagement.UserManagement;

import com.usermanagement.UserManagement.mail.GoogleMailService;
import com.usermanagement.UserManagement.mail.MailService;
import com.usermanagement.UserManagement.mail.OutlookMailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class UserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
		// print all bean
		// ConfigurableApplicationContext ctx = SpringApplication.run(UserManagementApplication.class, args);
		// for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
		//		System.out.println(beanDefinitionName);
		// }
	}

	@Bean
	@Primary
	public MailService outlookMail() {
		// return new GoogleMailService();
		return new OutlookMailService();
	}

	@Bean
	public MailService googleMail() {
		return new GoogleMailService();
	}
}
