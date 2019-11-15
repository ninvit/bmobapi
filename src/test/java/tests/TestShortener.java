package tests;

import utils.UrlUtil;

public class TestShortener {
	public static void main(String[] args) {
		String encoded = UrlUtil.shortenUrl("www.globo.com/endereçoqualquerpassadoporparamentroaqui/asdasda/123a/testandoparabemobi/index.html");
		System.out.println(encoded);
		String decoded = UrlUtil.retrieveUrl(encoded);
		System.out.println(decoded);
		
	}

}
