package org.CS5800;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RealSongService implements SongService {
    private final Map<Integer, Song> songDatabase = new HashMap<>();

    public RealSongService() {
        // Initialize with sample songs
        songDatabase.put(1, new Song("Song1", "Artist1", "Album1", 210));
        songDatabase.put(2, new Song("Song2", "Artist2", "Album2", 180));
        songDatabase.put(3, new Song("Song3", "Artist3", "Album1", 200));
        songDatabase.put(4, new Song("Song4", "Artist2", "Album2", 300));
        songDatabase.put(5, new Song("Song5", "Artist3", "Album1", 250));
    }

    private void simulateNetworkDelay() {
        try {
            Thread.sleep(1000); // Simulate 1-second delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Song searchById(Integer songID) {
        simulateNetworkDelay();
        return songDatabase.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateNetworkDelay();
        return songDatabase.values().stream()
                .filter(song -> song.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateNetworkDelay();
        return songDatabase.values().stream()
                .filter(song -> song.getAlbum().equalsIgnoreCase(album))
                .collect(Collectors.toList());
    }
}
