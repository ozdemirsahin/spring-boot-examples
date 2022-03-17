package com.example.repository;

import com.example.entity.Personal;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PersonalRepository extends ElasticsearchRepository<Personal,String> {
    @Query("{\"bool\":{\"must\":[{\"match\":{\"name\":\"?0\"}}]}}")
    List<Personal> getByCustomQuery(String search);

    List<Personal> findByNameLikeOrSurnameLike(String name, String surname);

}
