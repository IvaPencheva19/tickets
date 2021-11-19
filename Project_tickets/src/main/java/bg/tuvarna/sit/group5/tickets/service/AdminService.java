package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;

public class AdminService {
    private final UserRepository repository = UserRepository.getInstance();

    public static UserService getInstance() {
        return AdminService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final UserService INSTANCE = new UserService();
    }


}
