package com.leightonobrien.pi.serialcomm;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class TacsListener implements SerialPortDataListener {

	public int getListeningEvents() {
		return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
	}

	public void serialEvent(SerialPortEvent event) {
		if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
	         return;
		byte[] newData = new byte[event.getSerialPort().bytesAvailable()];
		int numRead=event.getSerialPort().readBytes(newData, newData.length);
		//redirect input to Tacs server
		System.out.println("Received data of size: " + numRead);
		for (int i = 0; i < newData.length; ++i)
	         System.out.print((char)newData[i]);
	      System.out.println("\n");
	}

}
