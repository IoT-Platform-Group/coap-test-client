package request;

import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;

/**
 * 请求基类，测试用例可以直接继承该类，也可继承其派生子类(GETRequest, POSTRequest等）
 */
public abstract class Request {
	
	public abstract String getURI();
	
	public String getPayload() {
		return "";
	}
	
	public void onLoad(CoapResponse response) {
		System.out.println(Utils.prettyPrint(response));
	}
	
	public void onError() {
	
	}
	
	public enum Type {
		GET, POST, PUT, DELETE;
	}
	
}

