package com.example.music.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.music.model.Music;
import com.example.music.model.MusicFav;
import com.example.music.model.MusicRate;

@Repository
public interface MusicRepoRate extends MongoRepository<MusicRate, String> {

	List<MusicRate> findByEmail(String email);
	Long deleteByEmailAndTitle(String email, String title);
	//Long deleteByUserNameAndTitle(String userName, String title);

}

