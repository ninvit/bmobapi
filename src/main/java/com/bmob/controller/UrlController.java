package com.bmob.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmob.exception.ResourceNotFoundException;
import com.bmob.model.Url;
import com.bmob.service.UrlService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/urls")
public class UrlController {

	@Autowired
	private UrlService urlService;

	@GetMapping()
	public List<Url> getAllUrls() {
		return urlService.getUrls();
	}
	
	@GetMapping("/{alias}")
	public ResponseEntity<Url> getUrlByAlias(@PathVariable(value = "alias") String urlAlias) {
		Url url = urlService.getUrlByAlias(urlAlias);
		System.out.println(url.getLongUrl());
		return ResponseEntity.ok().body(url);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Url> getUrlById(@PathVariable(value = "id") Long urlId)
			throws ResourceNotFoundException {
		Url url = urlService.getUrlById(urlId);
		return ResponseEntity.ok().body(url);
	}

	@PostMapping()
	public Url createUrl(@Valid @RequestBody Url url) {
		return urlService.add(url);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Url> updateUrl(@PathVariable(value = "id") Long urlId, @Valid @RequestBody Url urlDetails) {
		Url url = urlService.getUrlById(urlId);
		url.setAlias(urlDetails.getAlias());
		url.setLongUrl(urlDetails.getLongUrl());
		Url updatedUrl = urlService.add(url);
		System.out.println(url.getAlias());
		return ResponseEntity.ok(updatedUrl);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteUrl(@PathVariable(value = "id") Long urlId) throws ResourceNotFoundException {
		Url url = urlService.getUrlById(urlId);
		urlService.delete(url.getId());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
