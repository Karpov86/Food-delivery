package by.delivery.dao;

/**
 * This interface realised CRUD methods
 *
 * @param <T> this is entity class {@link by.delivery.entity.User}
 */
public interface UserDao<T> {

    /**
     * A method to save {@link by.delivery.entity.User}
     *
     * @param user is a persistent object
     * @return true if the user was saved
     */
    boolean save(T user);

    /**
     * A method to update {@link by.delivery.entity.User}
     *
     * @param id   indicates which one user needs to be changed
     * @param user this is new data
     * @return true if the user was updated
     */
    boolean update(Long id, T user);

    /**
     * A method to delete {@link by.delivery.entity.User}
     *
     * @param id indicates which one user needs to be deleted
     * @return true if the user was deleted
     */
    boolean delete(Long id);

    /**
     * A method to find {@link by.delivery.entity.User}
     *
     * @param id indicates which one user needs to be found
     * @return object User {@link by.delivery.entity.User}
     */
    T find(Long id);
}
