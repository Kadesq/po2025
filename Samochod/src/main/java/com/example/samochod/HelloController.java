package com.example.samochod;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import com.example.samochod.symulator.*;

public class HelloController {

    private Samochod mojSamochod;


    private ObservableList<Samochod> listaSamochodow = FXCollections.observableArrayList();

    public void odswiezWidok() {
        if (mojSamochod == null) {
            carmodelTextField.setText("");
            carregistrationTextField.setText("");
            enginenameTextField.setText("");
            enginerpmTextField.setText("");
            gearboxgearTextField.setText("");
            return;
        }
        //wypelnianie menu samochód
        carmodelTextField.setText(mojSamochod.getModel());
        carregistrationTextField.setText(mojSamochod.getNrRejestracyjny());
        carweightTextField.setText(String.valueOf(mojSamochod.getWaga()));
        //carspeedTextField.setText(mojSamochod.getPredkosc());

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

    }

    public void initialize(){
        carComboBox.setItems(listaSamochodow);

        //Samochod testowy = new Samochod("Passat", "K1 DIS");
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
    public TextField carmodelTextField;

    public TextField carregistrationTextField;
    public TextField carweightTextField;
    public TextField carspeedTextField;
    public TextField gearboxnameTextField;
    public TextField gearboxpriceTextField;
    public TextField gearboxweightTextField;
    public TextField gearboxgearTextField;
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
    public TextField enginenameTextField;
    public TextField enginepriceTextField;
    public TextField engineweightTextField;
    public TextField enginerpmTextField;
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
    public TextField clutchnameTextField;
    public TextField clutchpriceTextField;
    public TextField clutchweightTextField;
    public TextField clutchstateTextField;
    public Button clutchengButton;
    public void  onClutchEngButton(){}
    public Button clutchdngButton;
    public void onClutchDngButton(){}
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
    public void onRmCarButton(){}


}