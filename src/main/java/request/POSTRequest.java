package request;

import config.TesterConfiguration;
import scanner.ParamScanner;

public abstract class POSTRequest extends Request {
	
	@Override
	public String getURI() {
		ParamScanner scanner = generateURIScanner();
		return "coap://" + TesterConfiguration.SERVER_IP + ":" + TesterConfiguration.SERVER_PORT + scanner.scan();
	}
	
	@Override
	public String getPayload() {
		ParamScanner scanner = generatePayloadScanner();
		return scanner.scan();
	}
	
	public ParamScanner generateURIScanner() {
		return null;
	}
	
	public ParamScanner generatePayloadScanner() {
		return null;
	}
	
}
