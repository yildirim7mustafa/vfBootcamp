package yildirim.vfBootcamp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import yildirim.vfBootcamp.Entity.User;

public interface UserRepository extends MongoRepository<User, String> {

}
