package br.edu.entregas.service;

import io.github.cdimascio.dotenv.Dotenv;

public class LoginService {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String USUARIO = dotenv.get("DB_USER", "admin");
    private static final String SENHA = dotenv.get("DB_PASSWORD", "12345678");

    public boolean autenticar(String usuario, String senha) {
        return USUARIO.equals(usuario) && SENHA.equals(senha);
    }
}
