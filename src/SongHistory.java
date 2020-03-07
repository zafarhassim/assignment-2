import java.io.IOException;

public class SongHistory {
    public SortedLinkL history;
    public SongHistory(){
        history = new SortedLinkL();
    }
    public boolean empty(){
        return history.isEmpty();
    }

    public String peek(){
        return history.firstPeek();
    }

    public void addSong(String string){
        history.insertFirst(string);
    }

}
