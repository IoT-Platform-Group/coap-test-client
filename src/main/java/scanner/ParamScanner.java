package scanner;

/**
 * 输入读取接口，用于生成特定的URI和Payload信息。实现此接口的类作为参数传入Client的构造方法中。
 */
public interface ParamScanner {
	public String scan();
}
