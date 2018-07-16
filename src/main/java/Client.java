import checker.Checker;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapResponse;
import request.Request;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.coap.MediaTypeRegistry;

import java.util.concurrent.CountDownLatch;

public class Client extends CoapClient {
	
	private Request request;
	private Checker checker;
	private CountDownLatch latch;
	private boolean[] result;
	
	public Client(Request request, Checker checker, CountDownLatch latch) {
		super(request.getURI());
		this.request = request;
		this.checker = checker;
		this.latch = latch;
		result = new boolean[Request.Type.values().length];
	}
	
	public void test(Request.Type type) {
		switch (type) {
			case GET:
				testGET();
				break;
			case POST:
				testPOST();
				break;
			case PUT:
				break;
			case DELETE:
				break;
		}
	}
	
	public boolean getResult(Request.Type type) {
		return result[type.ordinal()];
	}
	
	public void testGET() {
		super.get(new CoapHandler() {
			@Override
			public void onLoad(CoapResponse coapResponse) {
				request.onLoad(coapResponse);
				result[Request.Type.GET.ordinal()] = checker.check(coapResponse);
				latch.countDown();
			}
			
			@Override
			public void onError() {
				request.onError();
				result[Request.Type.GET.ordinal()] = false;
			}
		});
	}
	
	public void testPOST() {
		super.post(new CoapHandler() {
			@Override
			public void onLoad(CoapResponse coapResponse) {
				request.onLoad(coapResponse);
				result[Request.Type.POST.ordinal()] = checker.check(coapResponse);
				latch.countDown();
			}
			
			@Override
			public void onError() {
				request.onError();
				result[Request.Type.POST.ordinal()] = false;
			}
		}, request.getPayload(), MediaTypeRegistry.TEXT_PLAIN);
	}
	
}
