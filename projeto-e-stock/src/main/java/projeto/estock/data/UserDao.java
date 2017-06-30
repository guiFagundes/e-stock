package projeto.estock.data;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import projeto.estock.entity.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

	public User findByEmail(String email);

}
