package com.example.staybooking.repository;

import com.example.staybooking.model.Location;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository // extends customlocaitonrep as well to use searchbydistance
public interface LocationRepository extends ElasticsearchRepository<Location, Long>, CustomLocationRepository {
}

