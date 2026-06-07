import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String,User> usermap=new HashMap<>();
    private User currentUser=null;

    public boolean registerUser(String username,String password,String fullName,String contact){
      if(usermap.containsKey(username)){
           System.out.println("no user found");
           return false;
        }
        User user=new User(username,password,fullName,contact);
        usermap.put(username,user);
        System.out.println("registration successful");
        return true;
    }
    public boolean loginUser(String username, String password){
        if(!usermap.containsKey(username)){
            System.out.println("incorrect password");
            return false;
        }
        User user=usermap.get(username);
        if (!user.getPassword().equals(password)){
            System.out.println("incorrect password");
        }
        currentUser=user;
        System.out.println("welcome  :"+currentUser.getFullName()+"!");
        return true;
    }
    public void logOutUser(){
        if (currentUser!=null){
            System.out.println("logged out "+currentUser.getFullName());
        }
        currentUser=null;
    }
    public User getCurrentUser(){
        return currentUser;
    }
    public boolean isloggenIn(){
        return currentUser!=null;
    }

}
