package com.example.search.blogSearch.domain.repositories;

import com.example.search.blogSearch.domain.model.aggregate.Keyword;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, String> {

  Optional<Keyword> findByKeyword(String keyword);
}
