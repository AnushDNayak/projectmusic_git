package com.example.music.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.music.model.Music;
import com.example.music.model.MusicFav;

@Repository
public interface MusicRepoFav extends MongoRepository<MusicFav, Integer> {

	List<MusicFav> findByUserNameAndPassword(String userName, String password);

	Long deleteByUserNameAndTitle(String userName, String title);

}

