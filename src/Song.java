import java.io.IOException;

public class Song {
    public SortedLinkL sortedLinkL;

    public Song(){
        sortedLinkL = new SortedLinkL();
}

    public boolean empty(){
      return sortedLinkL.isEmpty();
    }
    public void addSong(String string){
        sortedLinkL.insertSort(string);
    }

    public Link listenToSong(){
        return sortedLinkL.deleteFirst();
    }

    public void display() throws IOException {
        sortedLinkL.displayList();
    }

    public int size(){
       return sortedLinkL.getSize();
    }

    public void resort(String string){
        sortedLinkL.insertFirst(string);
    }

    public int length(int number){
        return number;
    }

}
