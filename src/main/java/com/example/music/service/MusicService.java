package com.example.music.service;

import java.util.List;


import org.springframework.stereotype.Service;


import com.example.music.model.Music;


@Service
public interface MusicService {
	
	public Music saveMusic(Music music);
	public List<Music> getMusics();
	public List<Music> findByCategory(String category);
	public List<Music> findByAlbum(String album);
	public List<Music> findByTitle(String title);

}
