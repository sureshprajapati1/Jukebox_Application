import DAOimplClasses.PlaylistImpl;
import Model.Playlist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.assertEquals;
public class PlaylistImpltest {
    PlaylistImpl playlist;

    @Before
    public void setup() {
        playlist = new PlaylistImpl();
    }

    @After
    public void tearDown() {
        playlist = null;
    }
    @Test
    public void displayallDetailsofPlaylist(){
     List<Playlist> result= playlist.displayAllPlaylist();
     assertEquals("bhajan",result.get(0).getPlaylist_name());
    }
    @Test
    public void sortPlaylistDetails(){
       List<Playlist> result6= playlist.sortPlaylst();
       assertEquals("bhajan",result6.get(0).getPlaylist_name());
    }

}
