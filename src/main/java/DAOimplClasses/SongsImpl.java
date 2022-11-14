package DAOimplClasses;

import DAOInterfaces.SongsInterface;
import Model.Songs;

import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class SongsImpl implements SongsInterface {
    @Override
    public List<Songs> displayAll() {
        List<Songs> l1=new ArrayList<>();
        Connection con= DBCConnection.getCon();
        try{
            Statement st= con.createStatement();
            String squl= "select * from songs";
            ResultSet rs=st.executeQuery(squl);
            while (rs.next()){
                Songs s1=new Songs();
                s1.setSong_name(rs.getString(1));
                s1.setSong_id(rs.getInt(2));
                s1.setSong_duration(rs.getString(3));
                s1.setArtist_name(rs.getString(4));
                s1.setGenre(rs.getString(5));
                s1.setSong_file_path(rs.getString(6));
                s1.setP_id(rs.getInt(7));
                l1.add(s1);
            }


        }
        catch (Exception e){
            System.out.println(e);
        }
        return l1;

    }

    @Override
    public List<Songs> sortSong() {
        Connection con=DBCConnection.getCon();
        List<Songs> songlist=new ArrayList<>();

        try{
        Statement s1= con.createStatement();
      ResultSet r1=  s1.executeQuery("select * from songs order by song_name");

            while (r1.next()){
                Songs st=new Songs();
                st.setSong_name(r1.getString(1));
                st.setSong_id(r1.getInt(2));
                st.setSong_duration(r1.getString(3));
                st.setArtist_name(r1.getString(4));
                st.setGenre(r1.getString(5));
                st.setSong_file_path(r1.getString(6));
                st.setP_id(r1.getInt(7));
                songlist.add(st);
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        return songlist;
    }

    @Override
    public Songs searchSong(int song_id) {
        Connection con =DBCConnection.getCon();
        Songs songs=null;
        try {
         PreparedStatement psmt=   con.prepareStatement("select * from songs where song_id = ?");
         psmt.setInt(1,song_id);
       ResultSet s1=     psmt.executeQuery();
       while(s1.next()){
           songs=new Songs();
           songs.setSong_name(s1.getString(1));
           songs.setSong_id(s1.getInt(2));
           songs.setSong_duration(s1.getString(3));
           songs.setArtist_name(s1.getString(4));
           songs.setGenre(s1.getString(5));
           songs.setSong_file_path(s1.getString(6));
            songs.setP_id(s1.getInt(7));

       }

        }
        catch (Exception e){
            System.out.println(e);
        }
        return songs;
    }

    @Override
    public void addSongToPlaylist() throws SQLException {
        System.out.println("enter the song id");
        Scanner sc=new Scanner(System.in);
        int SongId=sc.nextInt();
        System.out.println("enter the playlist id");
       int playlistId= sc.nextInt();
       Connection con=DBCConnection.getCon();
      PreparedStatement pnn= con.prepareStatement("update songs set p_id =? where song_id =?");
      pnn.setInt(1,playlistId);
      pnn.setInt(2,SongId);
      pnn.executeUpdate();
        System.out.println("we have add the song in playlist");
    }

    @Override
    public Songs searchSongBygenre(String genreName) throws SQLException {
        Connection con =DBCConnection.getCon();

        String query1="select * from songs where genre=?";
       PreparedStatement ptt= con.prepareStatement(query1);
       ptt.setString(1,genreName);
      ResultSet rls= ptt.executeQuery();
      Songs s4=null;
       while (rls.next()){
           s4=new Songs();
           s4.setSong_name(rls.getString(1));
           s4.setSong_id(rls.getInt(2));
           s4.setSong_duration(rls.getString(3));
           s4.setArtist_name(rls.getString(4));
           s4.setGenre(rls.getString(5));
           s4.setSong_file_path(rls.getString(6));
           s4.setP_id(rls.getInt(7));


       }
        System.out.println(s4);
        return s4;
    }
}
