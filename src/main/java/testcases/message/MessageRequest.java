package testcases.message;

import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import request.POSTRequest;
import scanner.ParamScanner;

public class MessageRequest extends POSTRequest {
	
	@Override
	public ParamScanner generateURIScanner(){
		return new MessageScanner();
	}
	
	@Override
	public void onLoad(CoapResponse response){
		System.out.println(Utils.prettyPrint(response));
	}
	
	@Override
	public String getPayload(){
		return "message";
	}
	
}
