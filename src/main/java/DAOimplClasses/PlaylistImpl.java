package DAOimplClasses;

import DAOInterfaces.PlaylistInterface;
import Model.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistImpl implements PlaylistInterface {
    @Override
    public List<Playlist> displayAllPlaylist() {

        Connection con=DBCConnection.getCon();
        List<Playlist> list=new ArrayList<>();
        try{
      Statement st= con.createStatement();
     ResultSet r1= st.executeQuery("select * from playlist");
     while (r1.next()){
         Playlist p1=new Playlist();
         p1.setPlaylist_id(r1.getInt(1));
         p1.setPlaylist_name(r1.getString(2));
         p1.setUser_id(r1.getString(3));
         list.add(p1);
     }
        }
        catch(Exception e){
            System.out.println(e);
        }
        for(Playlist pl:list){
            System.out.println(pl);
        }
        return list;
    }



    @Override
    public List<Playlist> sortPlaylst() {

        Connection con=DBCConnection.getCon();
        List<Playlist> list1=new ArrayList<>();
        try {
        Statement st1= con.createStatement();
       ResultSet rt1= st1.executeQuery("select * from playlist  order by playlist_name");
       while (rt1.next()){
           Playlist p2=new Playlist();
           p2.setPlaylist_id(rt1.getInt(1));
           p2.setPlaylist_name(rt1.getString(2));
           p2.setUser_id(rt1.getString(3));
           list1.add(p2);
       }
        }
        catch (Exception e){
            System.out.println(e);
        }

        return list1;
    }

    @Override
    public void playSongInPlaylist(int playlist_id) throws SQLException {
        Connection con=DBCConnection.getCon();
String query="select song_file_path from songs where p_id =?";
PreparedStatement psvp= con.prepareStatement(query);
psvp.setInt(1,playlist_id);
      ResultSet rt1=  psvp.executeQuery();
        String filepath="";
      while(rt1.next()){
        filepath=  rt1.getString(1);
          PlaySong pl=new PlaySong();
          pl.readAudio(filepath,1);
      }
 //PlaySong pl=new PlaySong();
//pl.readAudio(filepath,1);
    }
    public void createPlayList() throws SQLException {
        Connection con=DBCConnection.getCon();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the playlist id");
        int id=  sc.nextInt();
        System.out.println("enter the playlist name");
        String playlistName=sc.next();
        System.out.println("enter the user id");
        String userId=sc.next();
    PreparedStatement pppl=con.prepareStatement("insert into playlist(platlist_id,playlist_name,user_id) values(?,?,?)");
pppl.setInt(1,id);
pppl.setString(2,playlistName);
pppl.setString(3,userId);
int i=pppl.executeUpdate();
    }
}
