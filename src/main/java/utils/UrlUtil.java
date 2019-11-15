package utils;

import java.util.HashMap;
import java.util.Random;

public class UrlUtil {
	static HashMap<String, String> urlMap = new HashMap<>();

	public static String generateAlias(String longUrl) {

		Random rand = new Random();
		int urlLen = 6;
		char[] shortURL = new char[urlLen];
		String randChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

		for (int i = 0; i < urlLen; i++)
			shortURL[i] = randChars.charAt(rand.nextInt(randChars.length()));

		StringBuilder sb = new StringBuilder("");
		sb.append(new String(shortURL));

		urlMap.put(sb.toString(), longUrl);

		return sb.toString();

	}
	
	public static String shortenUrl(String longUrl) {
		
		StringBuilder sb = new StringBuilder("bmob.com/");
		sb.append(new String(generateAlias(longUrl)));

		urlMap.put(sb.toString(), longUrl);

		return sb.toString();

	}

	public static String retrieveUrl(String shortUrl) {

		return urlMap.get(shortUrl);

	}
}
