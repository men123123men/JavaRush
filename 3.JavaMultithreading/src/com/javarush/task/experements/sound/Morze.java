package com.javarush.task.experements.sound;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Morze {
    public static void main(String[]args) throws MidiUnavailableException {
        Synthesizer synth = MidiSystem.getSynthesizer();
        synth.open();
        MidiChannel[] channels = synth.getChannels();
        channels[0].noteOn(65, 80);



        String userEnter =  new Scanner(System.in).nextLine();
        Map<Character, String> hm = new HashMap<>();
        hm.put('а', ".-");
        hm.put('б', "-...");
        hm.put('в', ".--");
        hm.put('г', "--.");
        hm.put('д', "-..");
        hm.put('е', ".");
        hm.put('ж', "...-");
        hm.put('з', "--..");
        hm.put('и', "..");
        hm.put('й', ".---");
        hm.put('к', "-.-");
        hm.put('л', ".-..");
        hm.put('м', "--");
        hm.put('н', "-.");
        hm.put('о', "---");
        hm.put('п', ".--.");
        hm.put('р', ".-.");
        hm.put('с', "...");
        hm.put('т', "-");
        hm.put('у', "..-");
        hm.put('ф', "..-.");
        hm.put('х', "....");
        hm.put('ц', "-.-.");
        hm.put('ч', "---.");
        hm.put('ш', "----");
        hm.put('щ', "--.-");
        hm.put('ъ', ".--.-.");
        hm.put('ы', "-.--");
        hm.put('ь', "-..-");
        hm.put('э', "..-..");
        hm.put('ю', "..--");
        hm.put('я', ".-.-");
        for(char letter : userEnter.toCharArray()){
            for(char key : hm.keySet()) {
                if(letter == key) {

                    System.out.print(hm.get(key));
                    System.out.print("   ");
                }
            }
        }












    }
}
