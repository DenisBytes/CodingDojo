public class User {
    protected Integer id;
    protected int pin;

    public User (Integer userId){
        this.id = userId;
    }

    public int getPin() {
        return pin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
