package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.bmob.Application;
import com.bmob.model.Url;

import utils.UrlUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UrlControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port + "bmobapi";
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllUrls() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/urls",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetUrlById() {
		Url url = restTemplate.getForObject(getRootUrl() + "/urls/1", Url.class);
		System.out.println(url.getAlias());
		assertNotNull(url);
	}
	

	@Test
	public void testCreateUrl() {
		Url url = new Url();
		url.setAlias("novo teste");
		url.setLongUrl("testa se entra!");

		ResponseEntity<Url> postResponse = restTemplate.postForEntity(getRootUrl() + "/urls", url, Url.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateUrl() {
		int id = 1;
		Url url = restTemplate.getForObject(getRootUrl() + "/urls/" + id, Url.class);
		url.setAlias("testAtualizado");
		url.setLongUrl("testAtualizado");
		url.setShortUrl(UrlUtil.shortenUrl(url.getLongUrl()));

		restTemplate.put(getRootUrl() + "/urls/" + id, url);

		Url updatedUrl = restTemplate.getForObject(getRootUrl() + "/urls/" + id, Url.class);
		assertNotNull(updatedUrl);
	}

	@Test
	public void testDeleteUrl() {
		int id = 66;
		Url url = restTemplate.getForObject(getRootUrl() + "/urls/" + id, Url.class);
		assertNotNull(url);

		restTemplate.delete(getRootUrl() + "/urls/" + id);

		try {
			url = restTemplate.getForObject(getRootUrl() + "/urls/" + id, Url.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
