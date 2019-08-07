package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {
    @Autowired
    private TrackRepository trackRepository;
    private Track track1;
    
    @Before
    public void setUp()
    {
        track1 = new Track();
        track1.setId(30);
        track1.setName("Mites");
        track1.setComment("OK");
    }
    
    @After
    public void tearDown(){
        trackRepository.deleteAll();
    }
    
    @Test
    public void testSaveTrack(){
        trackRepository.save(track1);
        Track fetchUser = trackRepository.findById(track1.getId()).get();
        Assert.assertEquals(30,fetchUser.getId());
    
   }
    
    @Test
    public void testUpdateComment(){
        trackRepository.save(track1);
        track1.setComment("good");
        trackRepository.save(track1);
        String comment = (trackRepository.findById(30).get()).getComment();
        Assert.assertEquals("good", comment);
    }
   
    @Test
    public void testGetAllTrack(){
        Track tracktest = new Track(10,"Jones","nice");
        Track tracktest2 = new Track(11,"Gary","average");
        trackRepository.save(tracktest);
        trackRepository.save(tracktest2);
        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("Jones",list.get(0).getName());
    }
}
