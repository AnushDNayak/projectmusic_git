package com.example.music.controller;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.music.model.Music;
import com.example.music.model.MusicRate;
import com.example.music.service.MusicService;


@CrossOrigin
@RequestMapping("music")
@RestController
public class MusicController {
	
	@Autowired
	MusicService musicService;
	
	@CacheEvict("music")
	@PostMapping
	public ResponseEntity<Music> saveMusic(@RequestBody Music music)
	{
		List<Music> musics=musicService.getMusics();
		for(int i=0;i<musics.size();i++) {
			if(musics.get(i).getTitle().equals(music.getTitle())){
				Music dummy=new Music();
				return new ResponseEntity<Music>(dummy,HttpStatus.OK);
			}
		}
		Music saveMusic= musicService.saveMusic(music);
		
		return new ResponseEntity<Music>(saveMusic,HttpStatus.OK);
	}
	
	@Cacheable("music")
	@GetMapping
	public ResponseEntity<List<Music>> getMusics()
	{
	
	List<Music> musics=musicService.getMusics();
		
		return new ResponseEntity<List<Music>>(musics,HttpStatus.OK);
		
	}
	@GetMapping("t/{title}")
	public ResponseEntity<List<Music>> getTitle(@PathVariable String title)
	{
	
	List<Music> musics=musicService.findByTitle(title);
		
		return new ResponseEntity<List<Music>>(musics,HttpStatus.OK);
		
	}
	@GetMapping("filter/{category}")
	public ResponseEntity<List<Music>> getByCategory(@PathVariable String category)
	{
	
	List<Music> musics=musicService.findByCategory(category);
		
		return new ResponseEntity<List<Music>>(musics,HttpStatus.OK);
		
	}
	@GetMapping("filterAlb/{album}")
	public ResponseEntity<List<Music>> getByAlbum(@PathVariable String album)
	{
	
	List<Music> musics=musicService.findByAlbum(album);
		
		return new ResponseEntity<List<Music>>(musics,HttpStatus.OK);
		
	}
	@GetMapping("getAlbum")
	public ResponseEntity<ArrayList<String>> getAllAlbum()
	{
	
	List<Music> musics=musicService.getMusics();
	ArrayList<String> album=new ArrayList<String>();
	for(int i=0;i<musics.size();i++) {
		
		
		if(!album.contains(musics.get(i).getMovieName())) {
			album.add(musics.get(i).getMovieName());
		}
	}
		
		return new ResponseEntity<ArrayList<String>>(album,HttpStatus.OK);
		
	}

}
