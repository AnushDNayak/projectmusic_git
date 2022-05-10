package com.example.music.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.model.MusicFav;
import com.example.music.model.MusicRate;
import com.example.music.repo.MusicRepoFav;
import com.example.music.repo.MusicRepoRate;

@Service
public class MusicServiceImplRate implements MusicServiceRate{
	
	@Autowired
	MusicRepoRate musicRepoRate;

	@Override
	public List<MusicRate> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<MusicRate> getMusics() {
		// TODO Auto-generated method stub
		List<MusicRate>  allMusics=musicRepoRate.findAll();
		List<MusicRate> musics=new ArrayList<MusicRate>();
		List<String> title=new ArrayList<String>();
		
		for(int i=0;i<allMusics.size();i++) {
			if(title.contains(allMusics.get(i).getTitle())) {
				continue;
			}else {
				int count=0;
				float rate=0;
				boolean flag=false;
				for(int j=0;j<allMusics.size();j++) {
//					
					if(allMusics.get(i).getTitle().equals(allMusics.get(j).getTitle())) {
						count=count+1;
						flag=true;
						rate=rate+allMusics.get(j).getRatings();
					}
					
				}
				if(flag) {
					title.add(allMusics.get(i).getTitle());
					MusicRate mus = allMusics.get(i);
					mus.setRatings(rate/count);
					musics.add(mus);
				}else {
				title.add(allMusics.get(i).getTitle());
				MusicRate mus = allMusics.get(i);
				musics.add(mus);}
				
			}
		}
		//return musics;
		Collections.sort(musics);
		return musics;
		
	}

	@Override
	public String saveMusicRate(MusicRate musicRate) {
		// TODO Auto-generated method stub
		List<MusicRate> musics=musicRepoRate.findAll();
		for(int i=0;i<musics.size();i++) {
			if((musics.get(i).getEmail().equals(musicRate.getEmail())) && (musics.get(i).getTitle().equals(musicRate.getTitle())) ){
				
				Long n = musicRepoRate.deleteByEmailAndTitle(musicRate.getEmail(), musicRate.getTitle());
				MusicRate m =musicRepoRate.save(musicRate);
				return "Rating updated, thanks!";
			}
				
				
		}
		MusicRate m =musicRepoRate.save(musicRate);
		
		return "Thanks for rating!";
		
		
	}

	
}
