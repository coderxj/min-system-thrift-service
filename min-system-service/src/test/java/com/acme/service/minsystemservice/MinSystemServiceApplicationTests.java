package com.acme.service.minsystemservice;

import com.acme.service.Dto.Expression;
import com.acme.service.Dto.ExpressionResult;
import com.acme.service.Enums.OPERATE;
import com.acme.service.service.TCalculate;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MinSystemServiceApplicationTests {

	@Test
	public void testConnect() throws TException {
		// 创建 TTransport
		TTransport transport = new TSocket("127.0.0.1", 8080, 2000);
		// 创建 TProtocol
		TProtocol protocol = new TBinaryProtocol(transport);

		// 创建客户端.
		TCalculate.Client client = new TCalculate.Client(protocol);

		// 打开 TTransport
		transport.open();

		// 调用服务方法
		ExpressionResult result = client.calculate(new Expression(OPERATE.DIV, 1, 0));
		System.out.println(result.getResult());
		transport.close();
	}

}
