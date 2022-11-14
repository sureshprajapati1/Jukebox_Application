package DAOInterfaces;

import Model.Songs;

import java.sql.SQLException;
import java.util.List;

public interface SongsInterface {
    public List<Songs> displayAll();

    public List<Songs> sortSong();

    public Songs searchSong(int song_id);

    public void addSongToPlaylist() throws SQLException;

    public Songs searchSongBygenre(String genre) throws SQLException;

}
