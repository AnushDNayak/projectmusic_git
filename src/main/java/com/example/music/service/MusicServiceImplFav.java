package com.example.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.model.Music;
import com.example.music.model.MusicFav;
import com.example.music.repo.MusicRepo;
import com.example.music.repo.MusicRepoFav;

@Service
public class MusicServiceImplFav implements MusicServiceFav {
	
	@Autowired
	MusicRepoFav musicRepoFav;

	@Override
	public MusicFav saveMusicFav(MusicFav musicFav) {
		// TODO Auto-generated method stub
		return musicRepoFav.save(musicFav);
	}

	@Override
	public List<MusicFav> getMusics() {
		// TODO Auto-generated method stub
		return musicRepoFav.findAll();
	}

	@Override
	public List<MusicFav> findByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return musicRepoFav.findByUserNameAndPassword(userName, password);
	}

	@Override
	public Long deleteByUserNameAndTitle(String userName, String title) {
		// TODO Auto-generated method stub
		return musicRepoFav.deleteByUserNameAndTitle(userName, title);
	}

}
