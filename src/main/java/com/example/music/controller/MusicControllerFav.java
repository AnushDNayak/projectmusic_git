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
import com.example.music.service.MusicService;
import com.example.music.service.MusicServiceFav;

@CrossOrigin
@RequestMapping("musicFav")
@RestController
public class MusicControllerFav {
	
	@Autowired
	MusicServiceFav musicServiceFav;
	
	@PostMapping
	public ResponseEntity<MusicFav> saveMusicFav(@RequestBody MusicFav musicFav)
	{
		List<MusicFav> musics=musicServiceFav.getMusics();
		for(int i=0;i<musics.size();i++) {
			if(musics.get(i).getTitle().equals(musicFav.getTitle()) && musics.get(i).getUserName().equals(musicFav.getUserName())  &&  musics.get(i).getPassword().equals(musicFav.getPassword())) {
				MusicFav dummy=new MusicFav();
				return new ResponseEntity<MusicFav>(dummy,HttpStatus.OK);
				
			}
		}
		MusicFav saveMusicFav= musicServiceFav.saveMusicFav(musicFav);
		
		return new ResponseEntity<MusicFav>(saveMusicFav,HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<MusicFav>> getMusics()
	{
	
	List<MusicFav> musics=musicServiceFav.getMusics();
		
		return new ResponseEntity<List<MusicFav>>(musics,HttpStatus.OK);
		
	}
	 @GetMapping("fav/{userName}/{password}")
		public ResponseEntity<List<MusicFav>> getUsers(@PathVariable String userName, @PathVariable String password)
		{
		
		List<MusicFav> musicss=musicServiceFav.findByUserNameAndPassword(userName, password);
			
			return new ResponseEntity<List<MusicFav>>(musicss,HttpStatus.OK);
			
		}
	 //add pass too
	 @DeleteMapping("del/{userName}/{title}")
		public ResponseEntity<Long> deleteNews(@PathVariable String userName, @PathVariable String title){
			Long delNews=musicServiceFav.deleteByUserNameAndTitle(userName, title);
			return new ResponseEntity<Long>(delNews,HttpStatus.OK);
			
		}

}
