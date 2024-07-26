//package com.hello.event;
//
//import com.hello.event.exception.UserNotFoundException;
//import com.hello.event.model.User;
//import com.hello.event.repository.UserRepository;
//import com.hello.event.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//class UserServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @InjectMocks
//    private UserService userService;
//
//    private User userTest;
//
//    @BeforeEach
//    void setUp() {
//        userTest = new User();
//        userTest.setId(1L);
//        userTest.setName("admin");
//        userTest.setUsername("admin");
//        userTest.setPassword("1234");
//        userTest.setAddress("morocco");
//        userTest.setPhone("0067");
//    }
//
//    @Test
//    void testSaveUser() {
//        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
//        when(userRepository.save(any(User.class))).thenReturn(userTest);
//
//        User savedUser = userService.saveUser(userTest);
//
//        assertNotNull(savedUser);
//        assertEquals("encodedPassword", savedUser.getPassword());
//        verify(userRepository, times(1)).save(userTest);
//    }
//
//    @Test
//    void testUpdateUser() {
//        when(userRepository.findById(anyLong())).thenReturn(Optional.of(userTest));
//        when(userRepository.save(any(User.class))).thenReturn(userTest);
//
//        User updatedUser = userService.updateUser(userTest, 1L);
//
//        assertNotNull(updatedUser);
//        assertEquals("admin", updatedUser.getName());
//        verify(userRepository, times(1)).save(userTest);
//    }
//
//    @Test
//    void testDeleteUser() {
//        when(userRepository.existsById(anyLong())).thenReturn(true);
//        doNothing().when(userRepository).deleteById(anyLong());
//
//        userService.deleteUser(1L);
//
//        verify(userRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    void testGetAllUsers() {
//        when(userRepository.findAll()).thenReturn(List.of(userTest));
//
//        List<User> users = userService.getAllUsers();
//
//        assertNotNull(users);
//        assertEquals(1, users.size());
//        verify(userRepository, times(1)).findAll();
//    }
//
//    @Test
//    void testLoadUserByUsername() {
//        when(userRepository.findByUsername(anyString())).thenReturn(userTest);
//
//        assertDoesNotThrow(() -> userService.loadUserByUsername("admin"));
//
//        verify(userRepository, times(1)).findByUsername("admin");
//    }
//
//    @Test
//    void testLoadUserByUsernameNotFound() {
//        when(userRepository.findByUsername(anyString())).thenReturn(null);
//
//        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername("unknown"));
//
//        verify(userRepository, times(1)).findByUsername("unknown");
//    }
//}
