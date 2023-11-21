package ro.uvt.info.partiallab2023;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PartialLab2023Application {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(PartialLab2023Application.class, args);
		partial();
	}
	private static void partial() throws IOException {
		MessageController messageController = new MessageController();
		messageController.processMessages();
	}
}
