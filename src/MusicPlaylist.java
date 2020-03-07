import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class MusicPlaylist {
    public static void main(String[] args) throws IOException {
        String homework = "data/tracks.txt";
        File file = new File(homework);
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        //List files
        String week1 = "data/weekOne.csv";
        String week2 = "data/weekTwo.csv";
        String week3 = "data/weekThree.csv";
        String[] myFiles = {week1, week2, week3};

        //Declare Queue and insert files into queue
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i <= myFiles.length - 1; i++) {
            myQueue.push(myFiles[i]);
        }

        //week one array
        String[]weekO = arr(myQueue.pop());
        //System.out.println(Arrays.toString(weekO));

        //week two array
        String[]weekT = arr(myQueue.pop());
        //System.out.println(Arrays.toString(weekT));

        //week three array
        String[]weekTh = arr(myQueue.pop());
        //System.out.println(Arrays.toString(weekTh));

        //merge arrays
        ArrayList<String> allWeeks = new ArrayList<String>();
        fillIn(allWeeks, weekO);
        fillIn(allWeeks, weekT);
        fillIn(allWeeks, weekTh);

        //delete duplicates
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(allWeeks);
        ArrayList<String> allWeeksNoDups = new ArrayList<>(hashSet);

        //Display playlist
        Song song = new Song();
        for(int k =0; k <= allWeeksNoDups.size()-1; k++){
            song.addSong(allWeeksNoDups.get(k));
        }
        Song songList = new Song();
        while (!song.empty()){
            songList.resort(song.listenToSong().getFile());
        }
        songList.display();

        SongHistory songHistory = new SongHistory();

        //listen to ten songs and record them
        printWriter.println("Recently listen to tracks: ");
        printWriter.println(lastListened(songHistory, songList));
        printWriter.println(lastListened(songHistory, songList));
        printWriter.println(lastListened(songHistory, songList));
        printWriter.println(lastListened(songHistory, songList));
        printWriter.println(lastListened(songHistory, songList));
        printWriter.println(lastListened(songHistory, songList));
        printWriter.println(lastListened(songHistory, songList));
        printWriter.println(lastListened(songHistory, songList));
        printWriter.println(lastListened(songHistory, songList));
        printWriter.println(lastListened(songHistory, songList));

        printWriter.close();

    }
    //method to record history of song last listened to from the playlist
    public static String lastListened(SongHistory songHistory, Song songList){
        songHistory.addSong(songList.listenToSong().getFile());
        System.out.println("Last listened too: " + songHistory.peek());
        return "Last listened too: " + songHistory.peek();
        //printWriter.println("Last listened too: " + songHistory.peek());
    }

    //merges arrays
    public static void fillIn(ArrayList<String> arrayList, String []strings){
        for (int j = 0; j <= strings.length-1;j++){
            arrayList.add(strings[j]);
        }
    }

    //reads in songs to array
    public static String []arr(String note) throws IOException {
        String line = "";
        String cvsSplitBy = ",";
        String[] singer;
        final int size = 202;
        String[] original = new String[size];
        int j = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(note));
        while((line =bufferedReader.readLine())!=null) {
        singer = line.split(cvsSplitBy);
        original[j] = singer[1].toLowerCase().trim();
        j++;
    }
        bufferedReader.close();
        removeQuotes(original);
        return namesAdjust(original);
    }

    //removes quotes and spaces
    public static void removeQuotes(String[] arrSinger) {
        for (int z = 0; z <= arrSinger.length - 1; z++) {
            if (arrSinger[z].startsWith("\"")) {
                arrSinger[z] = arrSinger[z].substring(1, arrSinger[z].length() - 1).trim();
            }
            if (arrSinger[z].endsWith("\"")) {
                arrSinger[z] = arrSinger[z].substring(0, arrSinger[z].length() - 1).trim();
            }
        }
    }

    //removes null values from array
    public static String [] namesAdjust(String[]arr){
        String[]temp = new String[arr.length-2];
        int ele2 = 2;
        for(int i = 0; i<= arr.length-3;i++){
            temp[i] = arr[ele2];
            ele2++;
        }return temp;
    }
}
