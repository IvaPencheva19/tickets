package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.User;
import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;

public class LoginService {

    private UserRepository userRepo = new UserRepository();

    public void setUserRepo(UserRepository userRepo)
    {
        this.userRepo = userRepo;
    }

    public User validateUserLogin(String username, String password)
    {
        User user = userRepo.getByUsername(username);
        if (user != null)
        {
            if (user.getPassword().equals(password))
            {
                return user;
            }
            return null;
        }
        return null;
    }
}
