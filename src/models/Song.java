package models;

public class Song implements Comparable<Song> {
    private String name;
    private int id;
    private int releaseYear;
    private int rating;
    private String lyrics;

    public Song(String name, int id, int releaseYear, int rating, String lyrics) {
        this.name = name;
        this.id = id;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.lyrics = lyrics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    @Override
    public int compareTo(Song o) {
        return Integer.compare(this.id, o.id);
    }
    @Override
    public String toString() {
        return  "----- Song Info -----\n" +
                "Name: " + name + "\n" +
                "ID: " + id + "\n" +
                "Release Year: " + releaseYear + "\n" +
                "Rating: " + rating + "\n" +
                "Lyrics: " + lyrics + "\n";
    }
A
}
