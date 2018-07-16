import testcases.message.MessageChecker;
import testcases.message.MessageRequest;
import request.Request;

import java.util.concurrent.CountDownLatch;

public class Main {
	
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(1);
		Client client = new Client(new MessageRequest(), new MessageChecker(), latch);
		client.test(Request.Type.POST);
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(client.getResult(Request.Type.POST));
	}
	
}
