package io.openslice.tmf.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.Deflater;

public class KrokiClient {

	
	
	public static String encodedGraph(String body)  {

		String graph = body;
		if ( body == null ) {
			graph = "blockdiag {}";
		}
		try {
			byte[] gg = encode( graph );
			String s = new String( gg, StandardCharsets.UTF_8);
			return s;
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	
	
	private static  byte[] encode(String decoded) throws IOException {
		return Base64.getUrlEncoder().encode(compress(decoded.getBytes()));
	}

	private static  byte[] compress(byte[] source) throws IOException {
		Deflater deflater = new Deflater(Deflater.BEST_COMPRESSION);
		deflater.setInput(source);
		deflater.finish();

		byte[] buffer = new byte[2048];
		int compressedLength = deflater.deflate(buffer);
		byte[] result = new byte[compressedLength];
		System.arraycopy(buffer, 0, result, 0, compressedLength);
		return result;
	}
}
