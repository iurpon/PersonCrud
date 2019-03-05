package ru.trandefil.tm.repository;

import lombok.NonNull;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import ru.trandefil.tm.entity.User;

import java.util.List;

@Repository
public interface DSUserRepository extends FullEntityRepository<User, String> {

    @Override
    void persist(User user);

    @Override
    User merge(User user);

    @Override
    User getReference(Object o);

    @Override
    User findBy(String s);

    @Override
    List<User> findAll();

    @Override
    void remove(User user);

    @Query(value = "delete from User u where u.id = :id")
    int deleteById(@NonNull @QueryParam("id") String id);

    @Query(value = "delete from User u where u.name = :name")
    int deleteByName(@NonNull @QueryParam("name") String name);

    @Query(value = "select u from User u where u.name = :name and u.password = :pass")
    User getLoggedUser(@NonNull @QueryParam("name") String name, @NonNull @QueryParam("pass") String pass);

}
