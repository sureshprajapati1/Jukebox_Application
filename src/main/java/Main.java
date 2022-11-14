import DAOimplClasses.PlaylistImpl;
import DAOimplClasses.PodcastImpl;
import DAOimplClasses.SongsImpl;
import DAOimplClasses.UserImpl;
import Model.Playlist;
import Model.Podcast;
import Model.Songs;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws SQLException {
        UserImpl userImplObj=new UserImpl();
        SongsImpl songsImplObj=new SongsImpl();
        PodcastImpl podcastImplObj=new PodcastImpl();
        PlaylistImpl playlistObj=new PlaylistImpl();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter 1 for new user");
        System.out.println("enter 2 for existing user");
        int ch= sc.nextInt();
        if(ch==1){
            if(userImplObj.createAccount()){
                System.out.println("Account created");
                System.exit(0);
            }
        }
        if(ch==2){
            System.out.println("enter the username");
          String userName=  sc.next();
            System.out.println("enter the password");
            String password=sc.next();
                if(userImplObj.login(userName,password)){
                System.out.println("you are welcome");
                while (true){
                    System.out.println("enter 1 for Songs \n enter 2 for Podcast \n enter 3 for Playlist");
                    int ch1= sc.nextInt();
                    switch (ch1){
                        case 1:
                            System.out.println("enter 1 for display all song  \n enter 2 for sort song by song name\n enter 3 for search song \n enter 4 add song in playlist \n enter 5  search song by genre");
                            int ch2=sc.nextInt();
                            switch (ch2){
                                case 1: List<Songs> result= songsImplObj.displayAll();
                                for(Songs s1:result){
                                    System.out.println(s1);
                                }

                                break;
                                case 2:List<Songs> result2= songsImplObj.sortSong();
                                for(Songs s2:result2){
                                    System.out.println(s2);
                                }
                                break;
                                case 3:
                                    System.out.println("enter the song id for serach the song");
                                    int id= sc.nextInt();
                                    songsImplObj.searchSong(id);
                                    System.out.println( songsImplObj.searchSong(id));
                                break;
                                case 4:
                                    songsImplObj.addSongToPlaylist();
                                break;
                                case 5:
                                    System.out.println("enter the genre name");
                                  String genreName=  sc.next();
                                    songsImplObj.searchSongBygenre(genreName);

                            }
                            break;
                        case 2:
                            System.out.println("enter 1 for display all podcast \n enter 2 for sort podcast by podcast name \n enter 3 for search  podcast by podcast name ");
                            int ch3= sc.nextInt();
                            switch (ch3){
                                case 1: List<Podcast> resulr3=podcastImplObj.displayAllPodcast();
                                for(Podcast strr:resulr3){
                                    System.out.println(strr);
                                }
                                break;
                                case 2:List<Podcast> result4= podcastImplObj.sortPodcast();
                                for(Podcast sre:result4){
                                    System.out.println(sre);
                                }
                                break;
                                case 3:
                                    System.out.println("enter the podcast name");
                                    String podcastName=sc.next();
                                    System.out.println( podcastImplObj.searchPodcast(podcastName));

                                break;
                            }
                            break;
                        case 3:
                            System.out.println(" enter 1 display all playlist \n enter 2 for sort the playlist \n enter 3 play song \n enter 4 create play list");
                            int ch4=sc.nextInt();
                            switch (ch4){

                                case 1: List<Playlist> result5=playlistObj.displayAllPlaylist();
                                for(Playlist prr:result5){
                                    System.out.println(prr);
                                }

                                break;
                                case 2: List<Playlist> result6=playlistObj.sortPlaylst();
                                for(Playlist ptr:result6){
                                    System.out.println(result6);
                                }
                                break;
                                case 3:
                                    System.out.println("which playlist u want listen");
                                   int id =sc.nextInt();
                                    playlistObj.playSongInPlaylist(id);
                                break;
                                case 4:
                                    playlistObj.createPlayList();
                            }
                        break;
                    }
                }
            }
        }
    }
}
