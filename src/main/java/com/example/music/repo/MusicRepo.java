package com.example.music.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.music.model.Music;


@Repository
public interface MusicRepo extends MongoRepository<Music, Integer> {

	public List<Music> findByCategory(String category);
	public List<Music> findByMovieName(String album);
	public List<Music> findByTitle(String title);

}
