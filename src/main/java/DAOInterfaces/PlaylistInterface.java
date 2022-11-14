package DAOInterfaces;

import Model.Playlist;

import java.sql.SQLException;
import java.util.List;

public interface PlaylistInterface {
    public List<Playlist> displayAllPlaylist();

    public List<Playlist> sortPlaylst();
    public void playSongInPlaylist(int playlist_id ) throws SQLException;
    public void createPlayList() throws SQLException;
}
