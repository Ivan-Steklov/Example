//package entity;
//// используется для хранения классов, представляющих сущности базы данных.
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//
//@Entity
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String lastName;
//    private String firstName;
//    private String middleName;
//    private LocalDate birthDate;
//    private BigDecimal balance;
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//
//    public BigDecimal getBalance() {
//        return balance;
//    }
//
//    // Сеттеры
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public void setMiddleName(String middleName) {
//        this.middleName = middleName;
//    }
//
//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }
//}
//
