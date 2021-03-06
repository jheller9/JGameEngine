package utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.joml.Vector3f;

public class FileUtils {
	private static int readInd;

	public static InputStream getInputStream(String path) {
		return Class.class.getResourceAsStream("/"+path);
	}

	public static BufferedReader getReader(String path) throws Exception {
		try {
			InputStreamReader isr = new InputStreamReader(getInputStream(path));
			BufferedReader reader = new BufferedReader(isr);
			return reader;
		} catch (Exception e) {
			System.err.println("Failed to reader for "+path);
			throw e;
		}
	}

	public static void startReading() {
		readInd = 0;
	}
	
	public static byte readByte(byte[] data) {
		return data[readInd++];
	}
	
	public static int readFloat(byte[] data) {
		return data[readInd++];
	}
	
	public static int readInt(byte[] data) {
		return data[readInd++];
	}

	public static Vector3f readVec3(DataInputStream in) throws IOException {
		return new Vector3f(in.readFloat(), in.readFloat(), in.readFloat());
	}

	public static String readString(DataInputStream in) throws IOException {
		//byte[] str = new byte[in.readByte()];
		//in.read(str, 0, str.length);
		//return new String(str);
		String str = "";
		byte len = in.readByte();
		for(int i = 0; i < len; i++) {
			str += in.readChar();
		}
		
		return str;
		
	}

	public static boolean[] getFlags(byte b) {
		boolean[] flags = new boolean[8];
		byte j = 1;
		for(int i = 0; i < 8; i++) {
			flags[i] = (b & j) != 0;
			j *= 2;
		}
		
		return flags;
	}
}
