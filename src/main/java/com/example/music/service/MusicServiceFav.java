package com.example.music.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.music.model.Music;
import com.example.music.model.MusicFav;

@Service
public interface MusicServiceFav {
	
	public MusicFav saveMusicFav(MusicFav musicFav);
	public List<MusicFav> getMusics();
	public List<MusicFav> findByUserNameAndPassword(String userName, String password);
	public Long deleteByUserNameAndTitle(String userName, String title);
}
