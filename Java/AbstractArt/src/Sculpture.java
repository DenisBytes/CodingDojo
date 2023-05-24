public class Sculpture extends Art{
    String material;

    public Sculpture(String title, String author, String desc, String  material){
        super.author = author;
        super.title = title;
        super.description = desc;
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void viewArt(){
        System.out.printf("Title: %s, Author: %s, desc: %s, Material: %s\n",title,author,description,material);
    }
}
