package co.edu.udea.certificacion.e2e.moduloprueba.models;

public class TestUsers {

    public static final LoginData EXISTING_USER = new LoginData("existing@test.com", "Passw0rd!");

    public static RegisterData newUser() {
        return new RegisterData(
                "John Doe",
                String.format("user+%d@test.com", System.currentTimeMillis()),
                "Passw0rd!"
        );
    }

    public static RegisterData existingRegistration() {
        return new RegisterData(
                "John Doe",
                EXISTING_USER.getEmail(),
                EXISTING_USER.getPassword()
        );
    }

    public static LoginData invalidUser() {
        return new LoginData("wrong@test.com", "wrongpass");
    }
}
