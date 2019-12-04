package com.acme.service.minsystemservice;

import org.apache.thrift.transport.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class MinSystemServiceApplication {

	public static void main(String[] args) throws TTransportException {

		SpringApplication sa = new SpringApplication(MinSystemServiceApplication.class);
		sa.addListeners(new ApplicationPidFileWriter());
		sa.run(args);
	}
}
