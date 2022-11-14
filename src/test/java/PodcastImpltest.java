import DAOimplClasses.PodcastImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PodcastImpltest {
    PodcastImpl podcast;
    @Before
    public void setup(){
        podcast=new PodcastImpl();
    }
    @After
    public void tearDown(){
        podcast=null;
    }
    @Test
    public void displayallDetalisOfPodcast(){
        assertEquals("hari",podcast.displayAllPodcast().get(2).getPodcast_name());
    }
    @Test
    public void searchPodcastDetails(){
        assertEquals("english",podcast.searchPodcast("hari").getPodcast_lang());
    }
    @Test
    public void sortPOdcastDetails(){
        assertEquals("ganesa",podcast.sortPodcast().get(0).getPodcast_name());
    }
}
