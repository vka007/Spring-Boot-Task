package com.stackroute.repository;

import com.stackroute.domain.Track;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {

//public List<Track> findByName(String name);
/*
@Query("from Track where name=?1 order by id")
    List<Track> findByNameSortedById(String name);
*/


}
