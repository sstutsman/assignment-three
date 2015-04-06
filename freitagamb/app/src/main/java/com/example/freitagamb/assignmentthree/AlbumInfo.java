package com.example.freitagamb.assignmentthree;

import java.util.ArrayList;
import java.util.List;

public class AlbumInfo {
    int artID;
    String artist;
    String publisher;
    String album;
    int year;
    int trackCnt;
    List<TrackInfo> tracks;

    AlbumInfo(int artID, String artist, String album, int trackCnt, int year, String publisher,List<TrackInfo> tracks) {
        this.artID = artID;
        this.artist = artist;
        this.album = album;
        this.trackCnt = trackCnt;
        this.year = year;
        this.publisher = publisher;
        this.tracks = tracks;
    }

    public static List<AlbumInfo> setData(){
        List<AlbumInfo> albums;
        albums = new ArrayList<>();

        List<TrackInfo> chiefTracks;
        chiefTracks = new ArrayList<>();
        chiefTracks.add(new TrackInfo("3:52", "Creepin'"));
        chiefTracks.add(new TrackInfo("3:11", "Drink In My Hand"));
        chiefTracks.add(new TrackInfo("2:38", "Keep On"));
        chiefTracks.add(new TrackInfo("3:18", "Like Jesus Does"));
        chiefTracks.add(new TrackInfo("2:53", "Hungover & Hard Up"));
        chiefTracks.add(new TrackInfo("3:47", "Homeboy"));
        chiefTracks.add(new TrackInfo("3:52", "Country Music Jesus"));
        chiefTracks.add(new TrackInfo("5:04", "Jack Daniels"));
        chiefTracks.add(new TrackInfo("4:23", "Springsteen"));
        chiefTracks.add(new TrackInfo("4:02", "I'm Gettin' Stoned"));
        chiefTracks.add(new TrackInfo("2:39", "Over When It's Over"));
        albums.add(new AlbumInfo(R.drawable.echurch, "Eric Church", "Chief", chiefTracks.size(), 2011, "EMI Nashville",chiefTracks));

        List<TrackInfo> cfwmTracks;
        cfwmTracks = new ArrayList<>();
        cfwmTracks.add(new TrackInfo("3:18", "Come Fly With Me"));
        cfwmTracks.add(new TrackInfo("3:21", "Around The World"));
        cfwmTracks.add(new TrackInfo("2:29", "Isle Of Capri"));
        cfwmTracks.add(new TrackInfo("3:31", "Moonlight In Vermont"));
        cfwmTracks.add(new TrackInfo("4:33", "Autumn In New York"));
        cfwmTracks.add(new TrackInfo("3:26", "On The Road To Mandalay"));
        cfwmTracks.add(new TrackInfo("3:25", "It Happened In Monterey"));
        cfwmTracks.add(new TrackInfo("2:11", "Let's Get Away From It All"));
        cfwmTracks.add(new TrackInfo("2:42", "April In Paris"));
        cfwmTracks.add(new TrackInfo("3:33", "London By Night"));
        cfwmTracks.add(new TrackInfo("2:53", "Brazil"));
        cfwmTracks.add(new TrackInfo("2:44", "Blue Hawaii"));
        cfwmTracks.add(new TrackInfo("3:49", "It's Nice To Go A Trav'ling"));
        albums.add(new AlbumInfo(R.drawable.fsinatra, "Frank Sinatra", "Come Fly With Me", cfwmTracks.size(), 1958, "Capitol Records",cfwmTracks));

        List<TrackInfo> pmTracks;
        pmTracks = new ArrayList<>();
        pmTracks.add(new TrackInfo("4:17", "Travelin' Prayer"));
        pmTracks.add(new TrackInfo("5:39", "Piano Man"));
        pmTracks.add(new TrackInfo("3:19", "Ain't No Crime"));
        pmTracks.add(new TrackInfo("3:13", "You're My Home"));
        pmTracks.add(new TrackInfo("5:19", "The Balland of Billy the Kid"));
        pmTracks.add(new TrackInfo("3:16", "Worse Comes to Worst"));
        pmTracks.add(new TrackInfo("3:56", "Stop in Nevada"));
        pmTracks.add(new TrackInfo("3:35", "If I Only Had the Words(To Tell You)"));
        pmTracks.add(new TrackInfo("3:20", "Somewhere Along The Line"));
        pmTracks.add(new TrackInfo("7:18", "Captian Jack"));
        albums.add(new AlbumInfo(R.drawable.bjoel, "Billy Joel", "Piano Man", pmTracks.size(), 1973, "Columbia",pmTracks));

        List<TrackInfo> faithTracks;
        faithTracks = new ArrayList<>();
        faithTracks.add(new TrackInfo("3:16", "Faith"));
        faithTracks.add(new TrackInfo("5:37", "Father Figure"));
        faithTracks.add(new TrackInfo("9:13", "I Want Your Sex (Parts I & II)"));
        faithTracks.add(new TrackInfo("5:54", "One More Try"));
        faithTracks.add(new TrackInfo("4:48", "Hard Day"));
        faithTracks.add(new TrackInfo("4:36", "Hand to Mouth"));
        faithTracks.add(new TrackInfo("4:36", "Look at Your Hands"));
        faithTracks.add(new TrackInfo("5:05", "Monkey"));
        faithTracks.add(new TrackInfo("4:35", "Kissing a Fool"));
        faithTracks.add(new TrackInfo("6:30", "Hard Day (Shep Pettibone Remix)"));
        faithTracks.add(new TrackInfo("3:48", "A Last Request"));
        albums.add(new AlbumInfo(R.drawable.gmichael, "George Michael", "Faith", faithTracks.size(), 1987, "Epic Records",faithTracks));

        List<TrackInfo> iauTracks;
        iauTracks = new ArrayList<>();
        iauTracks.add(new TrackInfo("3:23", "Scarecrow"));
        iauTracks.add(new TrackInfo("3:12", "Give Me Something"));
        iauTracks.add(new TrackInfo("4:00", "Bumper Cars"));
        iauTracks.add(new TrackInfo("3:23", "Almost Home"));
        iauTracks.add(new TrackInfo("3:23", "Here We Go"));
        iauTracks.add(new TrackInfo("1:01", "It's About Us (Interlude)"));
        iauTracks.add(new TrackInfo("3:05", "Little Do You Know"));
        iauTracks.add(new TrackInfo("2:27", "Cheating"));
        iauTracks.add(new TrackInfo("2:27", "Just Kids"));
        iauTracks.add(new TrackInfo("3:24", "I Love You"));
        iauTracks.add(new TrackInfo("3:40", "Broken Flame"));
        iauTracks.add(new TrackInfo("3:52", "Back To You"));
        iauTracks.add(new TrackInfo("3:11", "All For You"));
        albums.add(new AlbumInfo(R.drawable.alexsierra, "Alex & Sierra", "It's About Us", iauTracks.size(), 2014, "Sony",iauTracks));

        List<TrackInfo> imTracks;
        imTracks = new ArrayList<>();
        imTracks.add(new TrackInfo("3:15", "Invisible Touch"));
        imTracks.add(new TrackInfo("8:51", "Tonight Tonight Tonight"));
        imTracks.add(new TrackInfo("4:45", "Land of Confusion"));
        imTracks.add(new TrackInfo("4:58", "In Too Deep"));
        imTracks.add(new TrackInfo("4:09", "Anything She Does"));
        imTracks.add(new TrackInfo("10:45", "Domino"));
        imTracks.add(new TrackInfo("3:51", "Throwing It All Away"));
        imTracks.add(new TrackInfo("4:49", "The Brazilian"));
        albums.add(new AlbumInfo(R.drawable.genisis, "Genisis", "Invisible Touch", imTracks.size(), 1986, "Atlantic Records",imTracks));

        List<TrackInfo> nevermindTracks;
        nevermindTracks = new ArrayList<>();
        nevermindTracks.add(new TrackInfo("5:01", "Smells Like Teen Spirit"));
        nevermindTracks.add(new TrackInfo("4:13", "In Bloom"));
        nevermindTracks.add(new TrackInfo("3:39", "Come As You Are"));
        nevermindTracks.add(new TrackInfo("3:03", "Breed"));
        nevermindTracks.add(new TrackInfo("4:16", "Lithium"));
        nevermindTracks.add(new TrackInfo("2:57", "Polly"));
        nevermindTracks.add(new TrackInfo("2:22", "Territorial Pissings"));
        nevermindTracks.add(new TrackInfo("3:37", "Drain You"));
        nevermindTracks.add(new TrackInfo("2:37", "Lounge Act"));
        nevermindTracks.add(new TrackInfo("3:27", "Stay Away"));
        nevermindTracks.add(new TrackInfo("2:52", "On a Plain"));
        nevermindTracks.add(new TrackInfo("20:35", "Something in the Way"));
        albums.add(new AlbumInfo(R.drawable.nirvana, "Nirvana", "Nevermind", nevermindTracks.size(), 1991, "DGC Records ORG",nevermindTracks));

        List<TrackInfo> notwTracks;
        notwTracks = new ArrayList<>();
        notwTracks.add(new TrackInfo("2:02", "We Will Rock You"));
        notwTracks.add(new TrackInfo("3:01", "We Are The Champions"));
        notwTracks.add(new TrackInfo("3:28", "Sheer Heart Attack"));
        notwTracks.add(new TrackInfo("3:10", "All Dead, All Dead"));
        notwTracks.add(new TrackInfo("4:35", "Spread Your Wings"));
        notwTracks.add(new TrackInfo("3:04", "Fight From the Inside"));
        notwTracks.add(new TrackInfo("3:51", "Get Down, Make Love "));
        notwTracks.add(new TrackInfo("3:09", "Sleeping on the Sidewalk"));
        notwTracks.add(new TrackInfo("3:07", "Who Needs You"));
        notwTracks.add(new TrackInfo("6:27", "It's Late"));
        notwTracks.add(new TrackInfo("3:31", "My Melancholy Blues"));
        albums.add(new AlbumInfo(R.drawable.queen, "Queen", "News of the World", notwTracks.size(), 1977, "EMI",notwTracks));

        List<TrackInfo> littTracks;
        littTracks = new ArrayList<>();
        littTracks.add(new TrackInfo("3:11", "When I Fall in Love"));
        littTracks.add(new TrackInfo("3:15", "Star Dust"));
        littTracks.add(new TrackInfo("3:00", "Stay as Sweet as You Are"));
        littTracks.add(new TrackInfo("2:59", "Where Can I Go Without You?"));
        littTracks.add(new TrackInfo("2:50", "Maybe It's Because I Love You Too Much"));
        littTracks.add(new TrackInfo("2:48", "Love Letters"));
        littTracks.add(new TrackInfo("3:18", "Ain't Misbehavin'"));
        littTracks.add(new TrackInfo("3:09", "I Thought About Marie"));
        littTracks.add(new TrackInfo("3:01", "At Last"));
        littTracks.add(new TrackInfo("3:09", "It's All in the Game"));
        littTracks.add(new TrackInfo("2:48", "When Sunny Gets Blue"));
        littTracks.add(new TrackInfo("3:02", "Love Is the Thing"));
        albums.add(new AlbumInfo(R.drawable.ncole, "Nat King Cole", "Love Is the Thing", littTracks.size(), 1957, "Capitol Records",littTracks));

        List<TrackInfo> itwlTracks;
        itwlTracks = new ArrayList<>();
        itwlTracks.add(new TrackInfo("4:01", "Scream"));
        itwlTracks.add(new TrackInfo("3:37", "I Am the Fire"));
        itwlTracks.add(new TrackInfo("3:27", "Sick Individual"));
        itwlTracks.add(new TrackInfo("2:58", "Amen"));
        itwlTracks.add(new TrackInfo("4:46", "Dear Daughter"));
        itwlTracks.add(new TrackInfo("3:38", "New Modern Love"));
        itwlTracks.add(new TrackInfo("3:38", "Mayhem"));
        itwlTracks.add(new TrackInfo("5:08", "Bad Girls World"));
        itwlTracks.add(new TrackInfo("2:57", "Gonna Get Mine"));
        itwlTracks.add(new TrackInfo("3:44", "The Reckoning"));
        itwlTracks.add(new TrackInfo("3:17", "Apocalyptic"));
        itwlTracks.add(new TrackInfo("3:33", "What Sober Couldn't Say"));
        itwlTracks.add(new TrackInfo("4:53", "I Like It Heavy"));
        itwlTracks.add(new TrackInfo("3:08", "Jumb The Gun"));
        itwlTracks.add(new TrackInfo("4:09", "Unapologetic"));
        albums.add(new AlbumInfo(R.drawable.halestorm, "Halestorm", "Into the Wild Life", itwlTracks.size(), 2015, "Atlanta Records",itwlTracks));

        return albums;
    }
}