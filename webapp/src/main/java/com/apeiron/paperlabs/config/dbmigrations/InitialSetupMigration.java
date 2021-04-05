package com.apeiron.paperlabs.config.dbmigrations;

import com.apeiron.paperlabs.domain.Authority;
import com.apeiron.paperlabs.domain.User;
import com.apeiron.paperlabs.security.AuthoritiesConstants;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.Instant;

/**
 * Creates the initial database setup.
 */
@ChangeLog(order = "001")
public class InitialSetupMigration {

    @ChangeSet(order = "01", author = "initiator", id = "01-addAuthorities")
    public void addAuthorities(MongoTemplate mongoTemplate) {
        Authority adminAuthority = new Authority();
        adminAuthority.setName(AuthoritiesConstants.ADMIN);
        Authority userAuthority = new Authority();
        userAuthority.setName(AuthoritiesConstants.USER);
        mongoTemplate.save(adminAuthority);
        mongoTemplate.save(userAuthority);
    }

    @ChangeSet(order = "02", author = "initiator", id = "02-addUsers")
    public void addUsers(MongoTemplate mongoTemplate) {
        Authority adminAuthority = new Authority();
        adminAuthority.setName(AuthoritiesConstants.ADMIN);
        Authority userAuthority = new Authority();
        userAuthority.setName(AuthoritiesConstants.USER);
        
        User adminUser = new User();
        adminUser.setId("user-16");
        adminUser.setLogin("n.jnifen@falaw.tn");
        adminUser.setPassword("$2a$10$J8Bgt097LZNc4YKq0BiueuyyAim6cW/0maX7nWie6e7fRYufK31lu");
        adminUser.setFirstName("n");
        adminUser.setLastName("jnifen");
        adminUser.setEmail("n.jnifen@falaw.tn");
        adminUser.setActivated(true);
        adminUser.setLangKey("fr");
        adminUser.setCreatedBy(adminUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);
        
        
        adminUser.setId("user-15");
        adminUser.setLogin("r.ferchiou@falaw.tn");
        adminUser.setPassword("$2a$10$n0LYhRcohL48qUGk0FNaJO4NAByHcEwLNlwwqNqeYrHG6tZzgYarq");
        adminUser.setFirstName("r");
        adminUser.setLastName("ferchiou");
        adminUser.setEmail("r.ferchiou@falaw.tn");
        adminUser.setActivated(true);
        adminUser.setLangKey("fr");
        adminUser.setCreatedBy(adminUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);
        
        adminUser.setId("user-14");
        adminUser.setLogin("achraf.khelil@gmail.com");
        adminUser.setPassword("$2a$10$J8Bgt097LZNc4YKq0BiueuyyAim6cW/0maX7nWie6e7fRYufK31lu");
        adminUser.setFirstName("Achraf");
        adminUser.setLastName("khaelil");
        adminUser.setEmail("achraf.khelil@gmail.com");
        adminUser.setActivated(true);
        adminUser.setLangKey("fr");
        adminUser.setCreatedBy(adminUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);
        
        adminUser.setId("user-13");
        adminUser.setLogin("bensaadmohameddhia@gmail.com");
        adminUser.setPassword("$2a$10$J8Bgt097LZNc4YKq0BiueuyyAim6cW/0maX7nWie6e7fRYufK31lu");
        adminUser.setFirstName("Mohamed dhia");
        adminUser.setLastName("Ben saad");
        adminUser.setEmail("bensaadmohameddhia@gmail.com");
        adminUser.setActivated(true);
        adminUser.setLangKey("fr");
        adminUser.setCreatedBy(adminUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);
        
        
        
   
        adminUser.setId("user-12");
        adminUser.setLogin("i.chaouali@falaw.tn");
        adminUser.setPassword("$2a$10$J8Bgt097LZNc4YKq0BiueuyyAim6cW/0maX7nWie6e7fRYufK31lu");
        adminUser.setFirstName("Chaouali");
        adminUser.setLastName("I");
        adminUser.setEmail("i.chaouali@falaw.tn");
        adminUser.setActivated(true);
        adminUser.setLangKey("fr");
        adminUser.setCreatedBy(adminUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);
        
        adminUser.setId("user-11");
        adminUser.setLogin("k.ferchiou@falaw.tn");
        adminUser.setPassword("$2a$10$J8Bgt097LZNc4YKq0BiueuyyAim6cW/0maX7nWie6e7fRYufK31lu");
        adminUser.setFirstName("Ferchiou");
        adminUser.setLastName("K");
        adminUser.setEmail("k.ferchiou@falaw.tn");
        adminUser.setActivated(true);
        adminUser.setLangKey("fr");
        adminUser.setCreatedBy(adminUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);
               
        adminUser.setId("user-10");
        adminUser.setLogin("s.elleuch@falaw.tn");
        adminUser.setPassword("$2a$10$J8Bgt097LZNc4YKq0BiueuyyAim6cW/0maX7nWie6e7fRYufK31lu");
        adminUser.setFirstName("Elleuch");
        adminUser.setLastName("S");
        adminUser.setEmail("s.elleuch@falaw.tn");
        adminUser.setActivated(true);
        adminUser.setLangKey("fr");
        adminUser.setCreatedBy(adminUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);
        
        
        adminUser.setId("user-9");
        adminUser.setLogin("a.ferchiou@falaw.tn");
        adminUser.setPassword("$2a$10$J8Bgt097LZNc4YKq0BiueuyyAim6cW/0maX7nWie6e7fRYufK31lu");
        adminUser.setFirstName("Ferchiou");
        adminUser.setLastName("A");
        adminUser.setEmail("a.ferchiou@falaw.tn");
        adminUser.setActivated(true);
        adminUser.setLangKey("fr");
        adminUser.setCreatedBy(adminUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);
                      
        
        adminUser.setId("user-8");
        adminUser.setLogin("paperlabs20@gmail.com");
        adminUser.setPassword("$2a$10$1xi7b7xBie/DCiFF9u2Bme0c1e.f6jJM9i76kA0e1C4Ues0dGea2u");
        adminUser.setFirstName("F");
        adminUser.setLastName("A");
        adminUser.setEmail("paperlabs20@gmail.com");
        adminUser.setActivated(true);
        adminUser.setLangKey("fr");
        adminUser.setCreatedBy(adminUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);
        
        adminUser = new User();
        adminUser.setId("user-1");
        adminUser.setLogin("rhimiirami@gmail.com");
        adminUser.setPassword("$2a$10$1xi7b7xBie/DCiFF9u2Bme0c1e.f6jJM9i76kA0e1C4Ues0dGea2u");
        adminUser.setFirstName("Rami");
        adminUser.setLastName("Rhimi");
        adminUser.setEmail("rhimiirami@gmail.com");
        adminUser.setActivated(true);
        adminUser.setLangKey("fr");
        adminUser.setCreatedBy(adminUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);

       
    }}
