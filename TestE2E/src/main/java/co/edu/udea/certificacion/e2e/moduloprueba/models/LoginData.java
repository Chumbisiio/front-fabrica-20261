package co.edu.udea.certificacion.e2e.moduloprueba.models;

public class LoginData {

    private final String email;
    private final String password;

    public LoginData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
