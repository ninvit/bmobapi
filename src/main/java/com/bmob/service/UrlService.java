package com.bmob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bmob.model.Url;
import com.bmob.repository.UrlRepository;

import utils.UrlUtil;

@Component
public class UrlService {

	@Autowired
	UrlRepository urlRepository;

	public Url add(Url url) {
		
		if (url.getAlias() == null || url.getAlias() == "") {
			url.setAlias(UrlUtil.generateAlias(url.getLongUrl()));
		}
		url.setShortUrl(UrlUtil.shortenUrl(url.getLongUrl()));
		
		return urlRepository.save(url);
	}

	public List<Url> getUrls() {
		return urlRepository.findAll();
	}

	public Url getUrlById(Long id) {
		return urlRepository.getOne(id);

	}

	public void delete(Long id) {
		urlRepository.deleteById(id);
	}

	public Url getUrlByAlias(String alias) {
		return urlRepository.getUrlByAlias(alias);
	}


}
