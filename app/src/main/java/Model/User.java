package Model;


import java.util.Arrays;
import java.util.List;

public class User {
    public static List<String> legalAccounts = Arrays.asList("USER", "Location Employee", "Admin", "Manager");

    private String name;
    private String id;
    private String password;
    private enum accountType{};
    private boolean accountState;

    public User(String name, String id, String password, boolean accountState) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.accountState = accountState;
    }
}
