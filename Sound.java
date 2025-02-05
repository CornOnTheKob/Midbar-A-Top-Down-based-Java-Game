/**
    This is a class that handles the sound effects and background
    music of the game.

    @author Jacob Lorenzo A. Cano (221303)
    @author Maigela Zia L. Garcia (222810)
    @version May 12, 2023
**/

/*
    I have not discussed the Java language code in my program
    with anyone other than my instructor or the teaching assistants
    assigned to this course.

    I have not used Java language code obtained from another student,
    or any other unauthorized source, either modified or unmodified.

    If any Java language code or documentation used in my program
    was obtained from another source, such as a textbook or website,
    that has been clearly noted with a proper citation in the comments
    of my program.
*/


import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {

    Clip clip; //to open audio file
    URL[] soundURL = new URL[30];


    public Sound(){
        soundURL[0] = getClass().getResource("/Midbar/Sound/fantasy music.wav");
        soundURL[1] = getClass().getResource("/Midbar/Sound/heart.wav");
        soundURL[2] = getClass().getResource("/Midbar/Sound/gem found.wav");
        soundURL[3] = getClass().getResource("/Midbar/Sound/Heaven.wav");
        soundURL[4] = getClass().getResource("/Midbar/Sound/game over.wav"); 
        soundURL[5] = getClass().getResource("/Midbar/Sound/signage.wav");
        soundURL[6] = getClass().getResource("/Midbar/Sound/hitmonster.wav");
        soundURL[7] = getClass().getResource("/Midbar/Sound/receivedamage.wav");
        soundURL[8] = getClass().getResource("/Midbar/Sound/healingpool.wav");
        soundURL[9] = getClass().getResource("/Midbar/Sound/iceball.wav");
        soundURL[10] = getClass().getResource("/Midbar/Sound/fireball.wav");
        soundURL[11] = getClass().getResource("/Midbar/Sound/earthball.wav");
        soundURL[12] = getClass().getResource("/Midbar/Sound/wind.wav");
        soundURL[13] = getClass().getResource("/Midbar/Sound/lose.wav");

    }

    public void setFile(int i){

        try{

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        }catch(Exception e){


        }
    }

    public void play(){

        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-28.0f);
        clip.start();

    }

    public void play2(){

        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f);
        clip.start();

    }


    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void stop(){

        clip.stop();

    }

    
}
