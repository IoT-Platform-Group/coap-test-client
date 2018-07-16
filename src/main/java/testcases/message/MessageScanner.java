package testcases.message;

import scanner.ParamScanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 实现了ParamScanner接口的具体实现类，用以模拟形如"coap://127.0.0.1:5683/chat/receive?target_user=user&message=message!"的URI
 * 输入文件置于testcases目录下
 */
public class MessageScanner implements ParamScanner {
	
	private Scanner scanner;
	
	public MessageScanner() {
		try {
			String root = "src/main/java/testcases/message/";
			scanner = new Scanner(new FileInputStream(new File(root + "Message.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String scan() {
		String resource = scanResource();
		String targetUser = scanTargetUser();
		String message = scanMessage();
		String result = "";
		result += resource;
		result += "?";
		result += "target_user=" + targetUser;
		result += "&";
		result += "message=" + message;
		return result;
	}
	
	private String inputNextLine() {
		String input = "";
		if (scanner.hasNextLine()) {
			input = scanner.nextLine();
		}
		return input;
	}
	
	private String scanResource() {
		System.out.println("resource: ");
		String inputNextLine = inputNextLine();
		System.out.println(inputNextLine);
		return inputNextLine;
	}
	
	private String scanTargetUser() {
		System.out.println("username: ");
		String inputNextLine = inputNextLine();
		System.out.println(inputNextLine);
		return inputNextLine;
	}
	
	private String scanMessage() {
		System.out.println("message");
		String inputNextLine = inputNextLine();
		System.out.println(inputNextLine);
		return inputNextLine;
	}
	
}
