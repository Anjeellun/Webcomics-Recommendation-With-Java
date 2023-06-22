/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbojayajaya;

/**
 *
 * @author ASUS
 */

interface Character {
    void introduce();
}

abstract class Webcomics<T> {
    private final String title;
    private final String author;
    private final String artist;
    private final String genre;
    private final String sinopsis;
    private final String status;
    private final String whereToRead;

    public Webcomics(String title, String author, String artist, String genre, String sinopsis, String status, String whereToRead) {
        this.title = title;
        this.author = author;
        this.artist = artist;
        this.genre = genre;
        this.sinopsis = sinopsis;
        this.status = status;
        this.whereToRead = whereToRead;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getStatus() {
        return status;
    }

    public String getWhereToRead() {
        return whereToRead;
    }

    public abstract void displayGenre();

    public abstract T getExtraInfo();
}

class Webtoon<T> extends Webcomics<T> implements Character {
    private final T extraInfo;

    public Webtoon(String title, String author, String artist, String genre, String sinopsis, String status, String whereToRead, T extraInfo) {
        super(title, author, artist, genre, sinopsis, status, whereToRead);
        this.extraInfo = extraInfo;
    }

    @Override
    public void displayGenre() {
        System.out.println("Genre: " + getGenre());
    }

    @Override
    public void introduce() {
        System.out.println("Title: " + getTitle());
    }

    @Override
    public T getExtraInfo() {
        return extraInfo;
    }
}

