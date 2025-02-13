package lk.acpt.demofx;/*Auther : Yasindu Sathsara
Place : ACPT's Lab*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    Student[] students = new Student[10];
    int index = 0;

    @FXML
    void login(ActionEvent event) {
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        if(email.equals("admin@gmail.com") && password.equals("admin123")){
            System.out.println("Login Success !");
        }else{
            System.out.println("Login Failed !");
        }

        Student std = new Student(email,34,password,56.8);
        students[index] = std;
        index++;
    }
}
