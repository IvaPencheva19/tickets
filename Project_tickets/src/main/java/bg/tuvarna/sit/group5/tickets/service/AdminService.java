package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.Admin;

import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;

public class AdminService {
    private final UserRepository repository = UserRepository.getInstance();

    public static AdminService getInstance() {
        return AdminService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final AdminService INSTANCE = new AdminService();
    }
    public void changeUserName(Admin adm, String username){
        adm.setUsername(username);
        repository.update(adm);
    }

    public void changePassword(Admin adm, String password){
       adm.setPassword(password);
        repository.update(adm);
    }

    public void changeFirstName(Admin adm, String firstName){
        adm.setFirstname(firstName);
        repository.update(adm);
    }

    public void changeLastName(Admin adm, String lastName){
       adm.setLastname(lastName);
        repository.update(adm);
    }
    public void changePhone(Admin adm, String phone){
       adm.setPhone(phone);
        repository.update(adm);
    }
    public void changeEmail(Admin adm, String email) {
        adm.setEmail(email);
        repository.update(adm);
    }


}
