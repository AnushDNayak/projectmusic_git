package com.example.music.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Music {
     
   String title;
   String desc;
   String category;
   String singer;
   String movieName;
   float  ratings;
   String track;
   String image;
}
