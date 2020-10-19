package nl.scoutinghilvarenbeek;

import com.fazecast.jSerialComm.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import org.apache.commons.lang3.StringUtils;

public class BonnetjesPrinterService {
	
	public void print(String naam, String bericht) {
		String message = LocalDateTime.now() + "\n"
					   + StringUtils.stripAccents(StringUtils.abbreviate(naam, 40)) + ":\n"
					   + StringUtils.stripAccents(StringUtils.abbreviate(bericht, 80)) + "\n\n";
		System.out.println(message);
		byte[] buffer = message.getBytes(StandardCharsets.US_ASCII);

		SerialPort commPort = SerialPort.getCommPort("COM1");
		commPort.openPort();
		commPort.writeBytes(buffer, buffer.length);
		commPort.closePort();
	}
}