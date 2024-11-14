import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.CS5800.SongServiceProxy;
import org.CS5800.SongService;
import org.CS5800.Song;

import java.util.List;

class SongServiceProxyTest {
    private SongService songService;

    @BeforeEach
    void setUp() {
        songService = new SongServiceProxy();
    }

    @Test
    void testSearchByIdCachesResult() {
        long startTime = System.currentTimeMillis();
        Song song1 = songService.searchById(1);  // Should take 1 second (real service)
        long duration1 = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        Song cachedSong1 = songService.searchById(1);  // Should be immediate (from cache)
        long duration2 = System.currentTimeMillis() - startTime;

        assertEquals(song1, cachedSong1, "The cached song should be the same as the initially retrieved song.");
        assertTrue(duration2 < duration1, "The second call should be significantly faster due to caching.");
    }

    @Test
    void testSearchByTitleCachesResult() {
        long startTime = System.currentTimeMillis();
        List<Song> songs1 = songService.searchByTitle("Song1");  // Should take 1 second (real service)
        long duration1 = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        List<Song> cachedSongs1 = songService.searchByTitle("Song1");  // Should be immediate (from cache)
        long duration2 = System.currentTimeMillis() - startTime;

        assertEquals(songs1, cachedSongs1, "The cached result should match the initial result.");
        assertTrue(duration2 < duration1, "The second call should be significantly faster due to caching.");
    }

    @Test
    void testSearchByAlbumCachesResult() {
        long startTime = System.currentTimeMillis();
        List<Song> songs1 = songService.searchByAlbum("Album1");  // Should take 1 second (real service)
        long duration1 = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        List<Song> cachedSongs1 = songService.searchByAlbum("Album1");  // Should be immediate (from cache)
        long duration2 = System.currentTimeMillis() - startTime;

        assertEquals(songs1, cachedSongs1, "The cached result should match the initial result.");
        assertTrue(duration2 < duration1, "The second call should be significantly faster due to caching.");
    }
}
