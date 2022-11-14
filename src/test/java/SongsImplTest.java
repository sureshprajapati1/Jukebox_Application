import DAOimplClasses.SongsImpl;
import Model.Songs;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

public class SongsImplTest {
    SongsImpl songimpl;

    @Before
    public void setup() {
        songimpl = new SongsImpl();
    }

    @After
    public void tearDown() {
        songimpl = null;
    }

    @Test
    public void displayAllSongDetails() {
        List<Songs> list = songimpl.displayAll();
        assertEquals("sanam re", songimpl.displayAll().get(0).getSong_name());
    }

    @Test
    public void sortSongDetails() {
        List<Songs> list = songimpl.sortSong();
        assertEquals("dard dilo", songimpl.sortSong().get(0).getSong_name());
    }
@Test
    public void searchSongDetails() {
        Songs result = songimpl.searchSong(2);
        assertEquals("ganpati bappa",result.getSong_name() );
    }
@Test
public void serachSongByGenre() throws SQLException {
        assertEquals("london tumkta",songimpl.searchSongBygenre("pop").getSong_name());
}
}
