package com.example.music.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.music.model.MusicRate;

@Service
public interface MusicServiceRate {
	
	public List<MusicRate> findByEmail(String email);

	public String saveMusicRate(MusicRate musicRate);

	List<MusicRate> getMusics();

}
