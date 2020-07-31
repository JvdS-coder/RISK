package nl.novi.risk.payload.request;

public class LoginRequest {

    private String naam_gebruiker;
    private String password;

    public String getNaam_gebruiker() {
        return naam_gebruiker;
    }

    public void setNaam_gebruiker(String naam_gebruiker) {
        this.naam_gebruiker = naam_gebruiker;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
