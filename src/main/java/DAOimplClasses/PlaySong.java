package DAOimplClasses;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class PlaySong {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        new PlaySong().readAudio("C:\\NIIT PGP in SE\\Jukebox_Final_Project_Java\\src\\main\\resources\\a_song.wav",1);
    }


    public  void readAudio(String audioSrcFile, int count) {
        PlayAudio playAudio = new PlayAudio();
        int c = 0;
        count = count-1;
        try {

            playAudio.playAudio1(audioSrcFile,count);

            playAudio.play();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");

                if (c == 4) {
                    break;
                }

                if (scanner.hasNextInt()) {
                    c = scanner.nextInt();
                } else {
                    break;
                }
                switch (c) {
                    case 1:
                        playAudio.pause();
                        break;
                    case 2:
                        playAudio.resumeAudio();
                        break;
                    case 3:
                        playAudio.restart();
                        break;
                    case 4:
                        playAudio.stop();
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound." + ex);
        }
    }
}
