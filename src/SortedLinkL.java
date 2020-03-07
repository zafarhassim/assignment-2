import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class SortedLinkL {
    public Link first;
    public Link last;
    int size = 0;

    public void SortedLinkL(){

        first = null;
    }
    public boolean isEmpty(){

        return (first == null);
    }
    public String firstPeek(){
        return first.getFile();
    }

    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() throws IOException {
        String homework = "data/tracks.txt";
        File f = new File(homework);
        FileWriter fw = new FileWriter(f, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("Playlist: ");
        Link current = first;
        while(current != null){
            pw.println(current.getFile());
            System.out.println(current.getFile());
            current = current.next;
        }
        pw.println();
        pw.close();
    }

    public int getSize(){

            Link temp = first;
            int count = 0;
            while (temp != null)
            {
                count++;
                temp = temp.next;
            }
            return count;

    }

    public void insertSort(String string)  {
        Link newLink = new Link(string);
        Link previous = null;
        Link current = first;
        while(current != null && string.compareTo(current.getFile()) <= 0) {
            previous = current;
            current = current.next;
            size++;
        }if (previous == null)
            first = newLink;
        else{
            previous.next = newLink;
            newLink.next = current;
        }
    }

    public void insertFirst(String string){

            Link newLink = new Link(string);
            newLink.next = first;
            first = newLink;

    }



}

