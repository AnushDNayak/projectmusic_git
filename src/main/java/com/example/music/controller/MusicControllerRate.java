package com.example.music.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.music.model.Music;
import com.example.music.model.MusicFav;
import com.example.music.model.MusicRate;
import com.example.music.service.MusicService;
import com.example.music.service.MusicServiceFav;
import com.example.music.service.MusicServiceRate;

@CrossOrigin
@RequestMapping("musicRate")
@RestController
public class MusicControllerRate {
	
	@Autowired
	MusicServiceRate musicServiceRate;
	
	@GetMapping
	public ResponseEntity<List<MusicRate>> getMusics()
	{
	
	List<MusicRate> musics=musicServiceRate.getMusics();
		
		return new ResponseEntity<List<MusicRate>>(musics,HttpStatus.OK);
		
	}
	
	
	@PostMapping
	public ResponseEntity<String> saveMusicFav(@RequestBody MusicRate musicRate)
	{
		String savemusicRate= musicServiceRate.saveMusicRate(musicRate);
		
		return new ResponseEntity<String>(savemusicRate,HttpStatus.OK);
	}


}
