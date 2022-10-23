package nl.scoutinghilvarenbeek;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

import com.fazecast.jSerialComm.SerialPort;

@Component
public class Printer {

	public void print(String message) {
		byte[] buffer = message.getBytes(StandardCharsets.US_ASCII);

		SerialPort commPort = SerialPort.getCommPort("COM1");
		commPort.openPort();
		commPort.writeBytes(buffer, buffer.length);
		commPort.closePort();
	}

}
