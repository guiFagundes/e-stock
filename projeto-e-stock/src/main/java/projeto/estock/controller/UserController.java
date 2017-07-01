package projeto.estock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import projeto.estock.data.UserDao;
import projeto.estock.entity.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/create")
	@ResponseBody
	public String create(String email, String name) {
		String userId = "";
		try {
			User user = new User(email, name);
			userDao.save(user);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			User user = new User(id);
			userDao.delete(user);
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}

	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String userId = "";
		try {
			User user = userDao.findByEmail(email);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "User not found";
		}
		return "The user id is: " + userId;
	}

	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id, String email, String name) {
		try {
			User user = userDao.findOne(id);
			user.setEmail(email);
			user.setName(name);
			userDao.save(user);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

	/**
	 * List all users.
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("users", userDao.findAll());
		System.out.println("Returning user:");
		return "users";
	}

	/**
	 * View a specific user by its id.
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("user/{id}")
	public String showUser(@PathVariable Long id, Model model) {
		model.addAttribute("user", userDao.findOne(id));
		return "usershow";
	}

	@RequestMapping("user/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("user", userDao.findOne(id));
		return "userform";
	}

	/**
	 * New user.
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("user/new")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "userform";
	}
	
	@GetMapping("gohome")
    String index(Model model) {
        //model.addAttribute("now", LocalDateTime.now());
        return "index";
    }

	/**
	 * Save user to database.
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public String saveUser(User user) {
		userDao.save(user);
		return "redirect:/user/" + user.getId();
	}

	/**
	 * Delete user by its id.
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("user/delete/{id}")
	public String delete(@PathVariable Long id) {
		userDao.delete(id);
		return "redirect:/users";
	}

}
