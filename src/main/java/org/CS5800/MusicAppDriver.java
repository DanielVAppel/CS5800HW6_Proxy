package org.CS5800;

public class MusicAppDriver {
    public static void main(String[] args) {
        SongService songService = new SongServiceProxy();

         // First access - real service call (with delay)
        System.out.println("First call by ID (1): " + songService.searchById(1));
        // Second access - should be faster due to caching
        System.out.println("Second call by ID (1): " + songService.searchById(1));

        // First access by title - real service call
        System.out.println("First call by title 'Song1': " + songService.searchByTitle("Song1"));
        // Second access by title - should be faster due to caching
        System.out.println("Second call by title 'Song1': " + songService.searchByTitle("Song1"));

        // First access by title - real service call
        System.out.println("First call by title 'Song4': " + songService.searchByTitle("Song4"));
        // Second access by title - should be faster due to caching
        System.out.println("Second call by title 'Song4': " + songService.searchByTitle("Song4"));

        // First access by title - real service call
        System.out.println("First call by title 'Song5': " + songService.searchByTitle("Song5"));
        // Second access by title - should be faster due to caching
        System.out.println("Second call by title 'Song5': " + songService.searchByTitle("Song5"));

        // First access by album - real service call
        System.out.println("First call by album 'Album1': " + songService.searchByAlbum("Album1"));
        // Second access by album - should be faster due to caching
        System.out.println("Second call by album 'Album1': " + songService.searchByAlbum("Album1"));


    }
}
