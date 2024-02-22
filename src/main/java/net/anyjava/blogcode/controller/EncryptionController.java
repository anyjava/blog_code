package net.anyjava.blogcode.controller;

import net.anyjava.blogcode.ecrypt.EncryptPassword;
import net.anyjava.blogcode.ecrypt.PasswordEncryptionService;
import net.anyjava.blogcode.ecrypt.PlainPassword;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptionController {
    private final PasswordEncryptionService passwordEncryptionService;

    public EncryptionController(PasswordEncryptionService passwordEncryptionService) {
        this.passwordEncryptionService = passwordEncryptionService;
    }

    @GetMapping("/encrypt")
    public EncryptPassword encrypt(String password) {
        var plainPassword = PlainPassword.of(password);
        return this.passwordEncryptionService.encryptPassword(plainPassword);
    }

    @GetMapping("/decrypt")
    public PlainPassword decrypt(String password) {
        var encryptPassword = EncryptPassword.of(password);
        return this.passwordEncryptionService.decryptPassword(encryptPassword);
    }
}
