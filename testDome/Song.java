package testDome;

import java.util.HashSet;
import java.util.Set;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isInRepeatingPlaylist() {
        Set<Song> playList = new HashSet<>();
        while (nextSong != null) {
            if (playList.contains(nextSong)) {
                return true;
            }
            playList.add(nextSong);
            nextSong = nextSong.nextSong;
        }
        return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
        Song third = new Song("Wake me up");
        first.setNextSong(second);
        second.setNextSong(third);
        third.setNextSong(second);
        System.out.println(first.isInRepeatingPlaylist());
    }
}
