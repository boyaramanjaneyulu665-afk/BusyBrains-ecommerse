package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository userrepo;
	@Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(Users user) {
        // 1. Check if user already exists
        if (userrepo.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken!");
        }

        // 2. Encrypt the password (CRITICAL)
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 3. Set a default role if none is provided
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("ROLE_USER");
        }

        userrepo.save(user);
        return "User registered successfully!";
    }

//	public Student saveStudent(Student s) {
//		
//		return sturepo.save(s);
//	}
//
//	public Optional<Student> findStudent(int id) {
//		
//		return sturepo.findById(id);
//	}
//
//	public Student updateStudent(int id, String newname) {
//		Student s=sturepo.findById(id).get();
//		s.setName(newname);
//		
//		return sturepo.save(s);
//	}
	

}
