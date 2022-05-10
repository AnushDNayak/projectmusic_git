package com.example.music.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Comparator;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class MusicRate implements Comparable<MusicRate>{
	
   String email;
   String title;
   String userName;
   String desc;
   String category;
   String singer;
   String movieName;
   float  ratings;
   String track;
   String image;
@Override
public int compareTo(MusicRate arg0) {
	// TODO Auto-generated method stub
	float rat = ((MusicRate) arg0).getRatings();
	if(rat < this.ratings) {
		return -1;
	}else if(rat > this.ratings) {
		return 1;
	}else {
		return 0;
	}
	//return (int)(rat - this.ratings);
}
//@Override
//public int compare(MusicRate arg0, MusicRate arg1) {
//	// TODO Auto-generated method stub
//	return 0;
//}


}
//class Sortbyrating implements Comparator<MusicRate> {
//	 
//    // Method
//    // Sorting in ascending order of roll number
//    public float compare(MusicRate a, MusicRate b)
//    {
// 
//        return a.ratings - b.ratings;
//    }
//}

