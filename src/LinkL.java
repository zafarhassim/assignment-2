import java.util.ArrayList;
import java.util.Arrays;

class LinkL {
    public Link first;
    public Link last;

    public LinkL() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertLast(String dd) {
        Link newLink = new Link(dd);
        if( isEmpty() )
            first = newLink;
        else
        last.next = newLink;
        last = newLink;
    }

    public String deleteFirst(){
        String temp = first.fileWeek;
        if(first.next == null)
            last = null;
        first = first.next;
        return temp;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {

            System.out.println(current.getFile());
            current = current.next;
        }

    }
}
