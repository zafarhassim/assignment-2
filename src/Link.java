class Link {
    public String fileWeek;
    public Link next;

    Link(String filename){
        fileWeek = filename;
    }

    public String getFile(){
        return fileWeek;
    }
}
