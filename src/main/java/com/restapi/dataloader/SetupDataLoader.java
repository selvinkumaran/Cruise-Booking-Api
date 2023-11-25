package com.restapi.dataloader;

import com.restapi.model.AppUser;
import com.restapi.model.BookingStatus;
import com.restapi.model.Role;
import com.restapi.repository.BookingStatusRepository;
import com.restapi.repository.RoleRepository;
import com.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private BookingStatusRepository bookingStatusRepository;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

//        Create user roles
        Role userRole = createRoleIfNotFound(Role.USER);
        Role adminRole = createRoleIfNotFound(Role.ADMIN);
//        Create user
        createUserIfNotFound("selvin@gmail.com", "Selvin@2001", userRole);
        createUserIfNotFound("admin@gmail.com", "Admin@2001", adminRole);
//        Create Booking Status
        createStatus("Confirmed");
        createStatus("Cancelled");

        alreadySetup = true;
    }

    private void createStatus(String status) {
        List<BookingStatus> bookingStatusList = bookingStatusRepository.findByStatus(status);
        if (bookingStatusList.isEmpty()) {
            bookingStatusRepository.save(new BookingStatus(status));
        }
    }


    @Transactional
    private Role createRoleIfNotFound(final String username) {
        Role role = roleRepository.findByName(username);
        if (role == null) {
            role = new Role();
            role.setName(username);
            role = roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    private AppUser createUserIfNotFound(final String username, final String password,
                                         final Role role) {
        Optional<AppUser> optionalUser = userRepository.findByUsername(username);
        AppUser user = null;
        if (optionalUser.isEmpty()) {
            user = new AppUser();
            user.setUsername(username);
            user.setName(username);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setRoles(role);
            user = userRepository.save(user);
        }
        return user;
    }
}
