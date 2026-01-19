package com.example.samochod;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import com.example.samochod.symulator.*;
import javafx.scene.layout.VBox;

public class HelloController {

    private Samochod mojSamochod;

    @FXML private TextField engineWeightTextField;

    @FXML private VBox carIcon;

    private ObservableList<Samochod> listaSamochodow = FXCollections.observableArrayList();

    public void odswiezWidok() {
        if (mojSamochod == null) {
            // Dane Samochodu
            carmodelTextField.setText("");
            carregistrationTextField.setText("");
            carweightTextField.setText("");
            carspeedTextField.setText("");

            // Skrzynia Biegów
            gearboxnameTextField.setText("");
            gearboxpriceTextField.setText("");
            gearboxweightTextField.setText("");
            gearboxgearTextField.setText("");

            // Silnik
            enginenameTextField.setText("");
            enginepriceTextField.setText("");
            engineweightTextField.setText("");
            enginerpmTextField.setText("");

            // Sprzęgło
            clutchnameTextField.setText("");
            clutchpriceTextField.setText("");
            clutchweightTextField.setText("");
            clutchstateTextField.setText("");

            if (carIcon != null) {
                carIcon.setVisible(false);
            }

            return;
        }


        //wypelnianie menu samochód
        carIcon.setVisible(true);

        carmodelTextField.setText(mojSamochod.getModel());
        carregistrationTextField.setText(mojSamochod.getNrRejestracyjny());
        carweightTextField.setText(String.valueOf(mojSamochod.getWaga()));
        carspeedTextField.setText(String.format("%.1f km/h", mojSamochod.getAktualnaPredkosc()));

        //wypelnianie menu silnik
        enginenameTextField.setText(mojSamochod.getSilnik().getNazwa());
        enginerpmTextField.setText(String.valueOf(mojSamochod.getSilnik().getObroty()));
        enginepriceTextField.setText(String.valueOf(mojSamochod.getSilnik().getCena()));
        engineweightTextField.setText(String.valueOf(mojSamochod.getSilnik().getWaga()));

        //wypelnianie menu skrzynia biegow
        gearboxgearTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getAktualnyBieg()));
        gearboxnameTextField.setText(mojSamochod.getSkrzynia().getNazwa());
        gearboxpriceTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getCena()));
        gearboxweightTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getWaga()));

        //wypelnianie menu sprzeglo
        clutchnameTextField.setText(mojSamochod.getSkrzynia().getSprzeglo().getNazwa());
        clutchpriceTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getSprzeglo().getCena()));
        clutchstateTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getSprzeglo().getStanSprzegla()));
        clutchweightTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getSprzeglo().getWaga()));

        boolean czyWlaczony = mojSamochod.getSilnik().getObroty() > 0;
        accelerateButton.setDisable(!czyWlaczony);
        deaccelerateButton.setDisable(!czyWlaczony);
        startButton.setDisable(czyWlaczony);
        stopButton.setDisable(!czyWlaczony);

        boolean czySprzeglo = mojSamochod.getSkrzynia().getSprzeglo().getStanSprzegla();

        accelerateButton.setDisable(!czyWlaczony || czySprzeglo);
        deaccelerateButton.setDisable(!czyWlaczony || czySprzeglo);
        shiftupButton.setDisable(!czyWlaczony || !czySprzeglo);
        shiftdownButton.setDisable(!czyWlaczony || !czySprzeglo);
    }

    @FXML
    public void onCarSelected() {
        mojSamochod = carComboBox.getSelectionModel().getSelectedItem();
        if (mojSamochod != null) {
            odswiezWidok();
        }
    }

    public void initialize(){
        carComboBox.setItems(listaSamochodow);

        //Samochod testowy = new Samochod("Nissan", "K4 DESQ");
        //listaSamochodow.add(testowy);
        //carComboBox.getSelectionModel().select(testowy);
        //onCarComboBoxButton();
        odswiezWidok();
    }


    public Button startButton;
    public void onStartButton(){
        if (mojSamochod != null){
            mojSamochod.wlacz();
            odswiezWidok();
        }
    }

    public Button stopButton;
    public void onStopButton(){
        if  (mojSamochod != null){
            mojSamochod.wylacz();
            odswiezWidok();
        }
    }

    @FXML public TextField carmodelTextField;
    @FXML public TextField carregistrationTextField;
    @FXML public TextField carweightTextField;
    @FXML public TextField carspeedTextField;
    @FXML public TextField gearboxnameTextField;
    @FXML public TextField gearboxpriceTextField;
    @FXML public TextField gearboxweightTextField;
    @FXML public TextField gearboxgearTextField;

    public Button shiftupButton;
    public void onShiftupButton(){
        if (mojSamochod != null){
            mojSamochod.getSkrzynia().zwiekszBieg();
            odswiezWidok();
        }
    }
    public Button shiftdownButton;
    public void onShiftdownButton(){
        if (mojSamochod != null){
            mojSamochod.getSkrzynia().zmniejszBieg();
            odswiezWidok();
        }
    }
    @FXML public TextField enginenameTextField;
    @FXML public TextField enginepriceTextField;
    @FXML public TextField engineweightTextField;
    @FXML public TextField enginerpmTextField;
    public Button accelerateButton;
    public void onAccelerateButton(){
        if (mojSamochod != null){
            mojSamochod.getSilnik().zwiekszObroty();
            odswiezWidok();
        }
    }
    public Button deaccelerateButton;
    public void onDeaccelerateButton(){
        if (mojSamochod != null){
            mojSamochod.getSilnik().zmniejszObroty();
            odswiezWidok();
        }
    }
    @FXML public TextField clutchnameTextField;
    @FXML public TextField clutchpriceTextField;
    @FXML public TextField clutchweightTextField;
    @FXML public TextField clutchstateTextField;
    public Button clutchengButton;
    public void  onClutchEngButton(){
        if (mojSamochod != null){
            mojSamochod.getSkrzynia().getSprzeglo().wcisnij();
            System.out.println("Wciśnięto sprzęgło.");
            odswiezWidok();
        }
    }
    public Button clutchdngButton;
    public void onClutchDngButton(){
        if (mojSamochod != null){
            mojSamochod.getSkrzynia().getSprzeglo().zwolnij();
            System.out.println("Zwolniono sprzęgło.");
            odswiezWidok();
        }
    }

    public ComboBox carComboBox;
    public void onCarComboBoxButton(){
        Samochod wybrane = (Samochod) carComboBox.getSelectionModel().getSelectedItem();
        if (wybrane != null){
            mojSamochod = wybrane;
            odswiezWidok();
        }
        odswiezWidok();
    }

    public Button addcarButton;
    public void onAddCarButton(){
        //kazda wartosc zapisywana jest w Stringu
        //samochod
        String model = carmodelTextField.getText();
        String nr = carregistrationTextField.getText();
        String weight = carweightTextField.getText();
        String speed = carspeedTextField.getText();
        //skrzynia
        String gearboxname = gearboxnameTextField.getText();
        String gearboxprice = gearboxpriceTextField.getText();
        String gearboxweight = gearboxweightTextField.getText();
        String gearboxgear = gearboxgearTextField.getText();
        //silnik
        String enginename = enginenameTextField.getText();
        String engineweight = engineweightTextField.getText();
        String enginerpm = enginerpmTextField.getText();
        String engineprice = enginepriceTextField.getText();
        //sprzeglo
        String clutchname = clutchnameTextField.getText();
        String clutchprice = clutchpriceTextField.getText();
        String clutchweight = clutchweightTextField.getText();
        String clutchstate = clutchstateTextField.getText();


        if (model != null && !model.isEmpty() && nr != null && !nr.isEmpty()){
            Samochod nowe = new Samochod(model, nr);
            //wypelnianie obiektu silnik
            nowe.getSilnik().setNazwa(enginename);
            try {
                nowe.getSilnik().setWaga(Double.parseDouble(engineweight));
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba! Ustawiam wage 300!.");
                nowe.getSilnik().setWaga(300.0);
            }
            try {
                nowe.getSilnik().setMaxObroty(Integer.parseInt(enginerpm));
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba! Ustawiam RPM'y 5000!");
                nowe.getSilnik().setMaxObroty(5000);
            }
            try {
                nowe.getSilnik().setCena(Double.parseDouble(engineprice));
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba! Ustawiam Cenę 1000!");
                nowe.getSilnik().setCena(1000);
            }
            //wypelnianie obiektu skrzynia
            nowe.getSkrzynia().setNazwa(gearboxname);
            try {
                nowe.getSkrzynia().setWaga(Double.parseDouble(gearboxweight));
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba! Ustawiam wage 300!.");
                nowe.getSkrzynia().setWaga(300.0);
            }
            try {
                nowe.getSkrzynia().setIloscBiegow(Integer.parseInt(gearboxgear));
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba! Ustawiam liczbę biegów na 6!");
                nowe.getSkrzynia().setIloscBiegow(6);
            }
            try {
                nowe.getSkrzynia().setCena(Double.parseDouble(gearboxprice));
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba! Ustawiam Cenę 1000!");
                nowe.getSkrzynia().setCena(1000);
            }
            //wypelnianie obiektu sprzeglo
            nowe.getSkrzynia().getSprzeglo().setNazwa(clutchname);
            try {
                nowe.getSkrzynia().getSprzeglo().setWaga(Double.parseDouble(clutchweight));
            }  catch (NumberFormatException e) {
                System.out.println("To nie jest liczba! Ustawiam wage 300!.");
                nowe.getSkrzynia().setWaga(300.0);
            }
            try {
                nowe.getSkrzynia().getSprzeglo().setCena(Double.parseDouble(clutchprice));
            } catch (NumberFormatException e) {
                System.out.println("To  nie jest liczba! Ustawiam cenę 300!.");
                nowe.getSkrzynia().getSprzeglo().setCena(300);
            }
            try {
                nowe.getSkrzynia().getSprzeglo().setStanSprzegla(Boolean.parseBoolean(clutchstate));
            } catch (NumberFormatException e) {
                System.out.println("Wpisz true lub false! Ustawiam fasle!");
                nowe.getSkrzynia().getSprzeglo().setStanSprzegla(Boolean.FALSE);
            }

            listaSamochodow.add(nowe);
            carComboBox.getSelectionModel().select(nowe);
            onCarComboBoxButton();
            odswiezWidok();
        }
    }

    public Button rmcarButton;
    public void onRmCarButton(){
        int selectedIndex = carComboBox.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0){
            listaSamochodow.remove(selectedIndex);

            mojSamochod = null;
            carComboBox.getSelectionModel().clearSelection();

            odswiezWidok();
            System.out.println("Samochód usunięty.");
        }
    }

    public void onGasButton(){
        if (mojSamochod != null){
            mojSamochod.getSilnik().zwiekszObroty();
            mojSamochod.jedz();
            carIcon.setLayoutX(mojSamochod.getPozycja().getX());
            odswiezWidok();
        }else {
            System.out.println("Najpierw wybierz lub dodaj samochód!");
        }
    }

}