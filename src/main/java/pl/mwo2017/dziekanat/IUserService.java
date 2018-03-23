/**
 *
 */
package pl.mwo2017.dziekanat;

public interface IUserService {

    Iterable<User> listAllUsers();

    User getUserById(long id);

    User saveUser(User user);

    void deleteUser(long id);
}
