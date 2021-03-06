package Project.Service.impl;

import Project.DAO.UserDAO;
import Project.Model.User;
import Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

        @Autowired
        private UserDAO userDAO;

        @Override
        public long add(User user) {
                return  userDAO.add(user);
        }

        @Override
        public User getById(long id, boolean lazy) {
                return userDAO.getById(id,lazy);
        }

        @Override
        public void delete(User user) {
                userDAO.delete(user);
        }

        public User getByMail(String email)
        {
                return userDAO.getByMail(email);
        }

        public User getByMdp(String email,String mdp){
                return userDAO.getByMdp(email,mdp);
        }

        public List<User> getAllUser(){

                return userDAO.getAllUser();
        }

        public void changeMdp(User user){
                userDAO.changeMdp(user);
        }

}
