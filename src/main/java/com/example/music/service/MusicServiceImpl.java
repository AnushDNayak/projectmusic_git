package com.example.music.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.model.Music;
import com.example.music.repo.MusicRepo;

@Service
public class MusicServiceImpl implements MusicService {
	
	@Autowired
	MusicRepo musicRepo;

	@Override
	public Music saveMusic(Music music) {
		// TODO Auto-generated method stub
		return musicRepo.save(music);
	}

	@Override
	public List<Music> getMusics() {
		// TODO Auto-generated method stub
		return musicRepo.findAll();
	}

	@Override
	public List<Music> findByCategory(String category) {
		// TODO Auto-generated method stub
		return musicRepo.findByCategory(category);
	}
	@Override
	public List<Music> findByAlbum(String album) {
		// TODO Auto-generated method stub
		return musicRepo.findByMovieName(album);
	}

	@Override
	public List<Music> findByTitle(String title) 
	{
		// TODO Auto-generated method stub
		//return musicRepo.findByTitle(title);
		boolean flag=false;
		 List<Music> music=musicRepo.findAll();
		if(title==null) {
			return music;
		}
		
		 List<Music> result=new ArrayList<Music>();
		 for(Music i :music)
		 {
			 if(i.getTitle().toLowerCase().startsWith(title.toLowerCase()))
			 {
				 result.add(i);
				 flag=true;
			 }
		 }
		 if(flag) {
			 return result;
		 }else {
			 return music;
		 }
		 //return result;
		
	}

}
