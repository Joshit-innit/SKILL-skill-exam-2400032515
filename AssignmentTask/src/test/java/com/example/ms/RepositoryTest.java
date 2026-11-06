package com.example.ms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.example.ms.entity.EMI;
import com.example.ms.repository.TaskRepo;

// Runs against the Postgres database from application.properties.
// @DataJpaTest rolls back after each test, so rows saved here are not kept.
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RepositoryTest {

	@Autowired
    private TaskRepo repository;

    private EMI saveSample()
    {
        return repository.save(new EMI(null, "Sample", "Home Loan", true, "Vijayawada"));
    }

    @Test
    void testFindAllUsers() 
    {
        saveSample();
        List<EMI> users = repository.findAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println("Total Users: " + users.size());
    }
    
    @Test
    void testFindUserById() 
    {
        Long id = saveSample().getId();
        Optional<EMI> user = repository.findById(id);
        assertTrue(user.isPresent());
        assertEquals(id, user.get().getId());
        System.out.println("User ID: " + user.get().getId());
        
    }
    
    @Test
    void testTotalUserCount() 
    {
        long before = repository.count();
        saveSample();
        assertEquals(before + 1, repository.count());
    }

}
