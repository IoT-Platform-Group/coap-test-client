package checker;

import org.eclipse.californium.core.CoapResponse;

/**
 * 检查器接口，获取CoapResponse并将其与期望输出信息作比较。
 */
public interface Checker {
	
	public boolean check(CoapResponse response);
	
}
