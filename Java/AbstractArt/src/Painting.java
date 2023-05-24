public class Painting extends Art{
    String painType;

    public Painting(String title, String author, String desc, String painType){
        super.title = title;
        super.author = author;
        super.description = desc;
        this.painType = painType;
    }

    public String getPainType() {
        return painType;
    }

    public void setPainType(String painType) {
        this.painType = painType;
    }

    public void viewArt(){
        System.out.printf("Title: %s, Author: %s, desc: %s, Paint Type: %s\n",title,author,description,painType);
    }
}
