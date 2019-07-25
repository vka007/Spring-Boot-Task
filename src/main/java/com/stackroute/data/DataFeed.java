package com.stackroute.data;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
@Data
@PropertySource("application.properties")
public class DataFeed implements CommandLineRunner {

  private Track feedTrackData = new Track();

  @Value("${song.1.id}")
  private int id1;
  @Value("${song.1.name}")
  private String name1;
  @Value("${song.1.comment}")
  private String comment1;
  @Value("${song.2.id}")
  private int id2;
  @Value("${song.2.name}")
  private String name2;
  @Value("${song.2.comment}")
  private String comment2;

  @Autowired
  Environment env;
  @Autowired
  private TrackService trackServices;
  @Override
  public void run(String... args) throws Exception {
    System.out.println(env.getProperty("app.name"));
    System.out.println(env.getProperty("JAVA_HOME"));


   feedTrackData.setId(Integer.parseInt(env.getProperty("song.1.id")));
    feedTrackData.setName(env.getProperty("song.1.name"));
    feedTrackData.setComment(env.getProperty("song.1.comment"));
    trackServices.saveTrack(feedTrackData);

    feedTrackData.setId(Integer.parseInt(env.getProperty("song.2.id")));
    feedTrackData.setName(env.getProperty("song.2.name"));
    feedTrackData.setComment(env.getProperty("song.2.comment"));
    trackServices.saveTrack(feedTrackData);




  }
}
