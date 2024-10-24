package nl.scoutinghilvarenbeek;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.fazecast.jSerialComm.SerialPort;

@Component
public class Printer {

	private final SerialPort commPort;

	public Printer() {
		SerialPort[] commPorts = SerialPort.getCommPorts();

		if (commPorts.length == 0) {
			throw new IllegalStateException("No com ports found");
		}

		if (commPorts.length > 1) {
			System.out.println("WARNING: Multiple com ports found.");
			Arrays.stream(commPorts).forEach(System.out::println);
			System.out.println("Picking the first one: " + commPorts[0]);
		}

		this.commPort = commPorts[0];
	}

	public void print(String message) {
		byte[] buffer = (message + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n").getBytes(StandardCharsets.US_ASCII);

		commPort.openPort();
		commPort.writeBytes(buffer, buffer.length);
		commPort.closePort();
	}

}
