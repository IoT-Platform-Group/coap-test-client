package request;

import config.TesterConfiguration;
import scanner.ParamScanner;

public abstract class GETRequest extends Request {
	
	@Override
	public String getURI() {
		ParamScanner scanner = generateURIScanner();
		String postfix="coap://" + TesterConfiguration.SERVER_IP + ":" + TesterConfiguration.SERVER_PORT + scanner.scan();
		System.out.println(postfix);
		return postfix;
	}
	
	public abstract ParamScanner generateURIScanner();
	
}
