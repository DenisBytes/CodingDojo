import java.util.Date;
import java.time.LocalDateTime;

public class AlfredQuotes {

    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

/*
    public String getDayPeriod(String name) {
        LocalDateTime now = LocalDateTime.now();
        String output = "";

        if (now.getHour() > 5 && now.getHour() <= 12){
            output = String.format("Good Morning %s",name);
        }
        else if (now.getHour() > 12 && now.getHour() <= 18){
            output = String.format("Good Afternoon %s",name);
        }
        else if (now.getHour() > 18 && now.getHour() <=5){
            output = String.format("Good Evening %s", name);
        }
        return output;
    }
*/

    public String guestGreeting(String name) {
        String output = String.format("Hello, %s. Lovely to see you.",name);
        return output;
    }
    public String guestGreeting(String name, String dayPeriod) {
        String output = "";
        if (dayPeriod == "morning"){
            output = String.format("Good Morning, %s. Lovely to see you.",name);
        }
        else if (dayPeriod == "afternoon"){
            output = String.format("Good Afternoon, %s. Lovely to see you.",name);
        }
        else if (dayPeriod == "evening") {
            output = String.format("Good Evening, %s. Lovely to see you.",name);
        }
        return output;
    }

    public String dateAnnouncement() {
        Date date = new Date();
        String output = String.format("It is currently %s",date);
        return output;
    }

    public String respondBeforeAlexis(String conversation) {
        String output = "";
        if (conversation.indexOf("Alexis") >= 0){
            output = "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if (conversation.indexOf("Alfred") >= 0){
            output = "At your service. As you wish, naturally.";
        }
        else {
            output = "Right. And with that I shall retire.";
        }

        return output;
    }

    public String coffeeOrder (String conversation){
        String output = "";
        if (conversation.indexOf("coffee") >= 0){
            output = "Your coffee will be ready in a moment sir";
        }
        return output;
    }

    // NINJA BONUS
    // See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

