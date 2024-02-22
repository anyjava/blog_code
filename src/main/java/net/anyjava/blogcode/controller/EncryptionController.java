package net.anyjava.blogcode.controller;

import net.anyjava.blogcode.ecrypt.EncryptCardNumber;
import net.anyjava.blogcode.ecrypt.PasswordEncryptionService;
import net.anyjava.blogcode.ecrypt.PlainCardNumber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptionController {
    private final PasswordEncryptionService passwordEncryptionService;

    public EncryptionController(PasswordEncryptionService passwordEncryptionService) {
        this.passwordEncryptionService = passwordEncryptionService;
    }

    @GetMapping("/encrypt")
    public EncryptCardNumber encrypt(String password) {
        var plainPassword = PlainCardNumber.of(password);
        return this.passwordEncryptionService.encryptPassword(plainPassword);
    }

    @GetMapping("/decrypt")
    public PlainCardNumber decrypt(String password) {
        var encryptPassword = EncryptCardNumber.of(password);
        return this.passwordEncryptionService.decryptPassword(encryptPassword);
    }
}
