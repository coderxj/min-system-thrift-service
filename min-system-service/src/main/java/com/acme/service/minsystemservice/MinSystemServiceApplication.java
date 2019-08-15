package com.acme.service.minsystemservice;

import com.acme.service.minsystemservice.thriftservice.TCalculateImpl;
import com.acme.service.service.TCalculate;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class MinSystemServiceApplication {

	public static void main(String[] args) throws TTransportException {

		SpringApplication sa = new SpringApplication(MinSystemServiceApplication.class);
		sa.addListeners(new ApplicationPidFileWriter());
		sa.run(args);
		start();
	}



	public static void start() throws TTransportException {
		//创建一个处理器，看代码最后new TCalculateImpl()就知道，thrift需要知道，是哪个类来处理接口的请求。
		TProcessor tProcessor = new TCalculate.Processor<TCalculate.Iface>(new TCalculateImpl());

		//创建一个服务端socket，最简单的，只需要指定绑定的端口
		TServerSocket serverTransport = new TServerSocket(9000);

		//暂且理解为使用thrift的默认传输协议，我也没具体研究
		TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();

		//将参数设置进去
		TServer.Args tArgs = new TServer.Args(serverTransport);

		tArgs.processor(tProcessor);
		tArgs.protocolFactory(protocolFactory);

		// 创建 TServer
		TServer server = new TSimpleServer(tArgs);

		// 启动 thrift.Server
		System.out.println("[info] min system bootup successful");
		server.serve();
	}
}
