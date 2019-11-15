package com.bmob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bmob.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>{
	@Query("SELECT u FROM Url u WHERE u.alias = ?1")
    public Url getUrlByAlias(String alias);
}
