package nl.novi.risk.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String naam_gebruiker;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email_gebruiker;

    @NotBlank
    @Size(min = 3, max = 20)
    private String afdeling_gebruiker;


    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public SignupRequest(@NotBlank @Size(min = 3, max = 20) String naam_gebruiker, @NotBlank @Size(max = 50) @Email String email_gebruiker, @NotBlank @Size(min = 3, max = 20) String afdeling_gebruiker, @NotBlank @Size(min = 6, max = 40) String password) {
        this.naam_gebruiker = naam_gebruiker;
        this.email_gebruiker = email_gebruiker;
        this.afdeling_gebruiker = afdeling_gebruiker;
        this.password = password;
    }

    public String getNaam_gebruiker() {
        return naam_gebruiker;
    }
    public void setNaam_gebruiker(String naam_gebruiker) {
        this.naam_gebruiker = naam_gebruiker;
    }

    public String getEmail_gebruiker() {
        return email_gebruiker;
    }
    public void setEmail_gebruiker(String email_gebruiker) {
        this.email_gebruiker = email_gebruiker;
    }

    public String getAfdeling_gebruiker() {
        return afdeling_gebruiker;
    }
    public void setAfdeling_gebruiker(String afdeling_gebruiker) { this.afdeling_gebruiker = afdeling_gebruiker; }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
