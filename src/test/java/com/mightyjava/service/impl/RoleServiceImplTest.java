package com.mightyjava.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mightyjava.domain.Role;
import com.mightyjava.repository.RoleRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RoleServiceImpl.class})
@ExtendWith(SpringExtension.class)
class RoleServiceImplTest {
    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    /**
     * Method under test: {@link RoleServiceImpl#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Role> roleList = new ArrayList<>();
        when(this.roleRepository.findAll()).thenReturn(roleList);
        Collection<Role> actualFindAllResult = this.roleServiceImpl.findAll();
        assertSame(roleList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.roleRepository).findAll();
    }

    /**
     * Method under test: {@link RoleServiceImpl#findById(Long)}
     */
    @Test
    void testFindById() {
        Optional<Role> ofResult = Optional.of(new Role());
        when(this.roleRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Role> actualFindByIdResult = this.roleServiceImpl.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.roleRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link RoleServiceImpl#findByName(String)}
     */
    @Test
    void testFindByName() {
        Role role = new Role();
        when(this.roleRepository.findByName((String) any())).thenReturn(role);
        assertSame(role, this.roleServiceImpl.findByName("Name"));
        verify(this.roleRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link RoleServiceImpl#saveOrUpdate(Role)}
     */
    @Test
    void testSaveOrUpdate() {
        Role role = new Role();
        when(this.roleRepository.saveAndFlush((Role) any())).thenReturn(role);
        assertSame(role, this.roleServiceImpl.saveOrUpdate(new Role()));
        verify(this.roleRepository).saveAndFlush((Role) any());
    }

    /**
     * Method under test: {@link RoleServiceImpl#deleteById(Long)}
     */
    @Test
    void testDeleteById() {
        doNothing().when(this.roleRepository).deleteById((Long) any());
        assertEquals("{\"message\":\"Role deleted successfully\"}", this.roleServiceImpl.deleteById(123L));
        verify(this.roleRepository).deleteById((Long) any());
    }
}

