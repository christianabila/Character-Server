package server;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Random;

public class CharacterServer implements Runnable {

	private DatagramSocket server;
	private DatagramPacket p;
	private Thread thread;

	public CharacterServer(DatagramSocket server, DatagramPacket p)
	{
		this.server = server;
		this.p = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Random r = new Random();
			int random = r.nextInt(128);
			System.out.println(random);
			byte[] randomChar = ByteBuffer.allocate(4).putInt(random).array();
			p = new DatagramPacket(randomChar, randomChar.length, p.getAddress(), p.getPort());
			server.send(p);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start()
	{
		if(thread == null)
		{
			thread = new Thread(this, "serverListeningThread");
			thread.start();
		}
	}
}

