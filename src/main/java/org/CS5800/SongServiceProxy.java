package org.CS5800;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {
    private final RealSongService realService = new RealSongService();
    private final Map<Integer, Song> idCache = new HashMap<>();
    private final Map<String, List<Song>> titleCache = new HashMap<>();
    private final Map<String, List<Song>> albumCache = new HashMap<>();

    @Override
    public Song searchById(Integer songID) {
        return idCache.computeIfAbsent(songID, realService::searchById);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return titleCache.computeIfAbsent(title.toLowerCase(), realService::searchByTitle);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        return albumCache.computeIfAbsent(album.toLowerCase(), realService::searchByAlbum);
    }
}