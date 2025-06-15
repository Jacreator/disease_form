package com.jacreator.disease_form.views;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class PatientView extends VerticalLayout {
private Map<String, List<String>> wardData = new HashMap<String, List<String>>() {
    {
      put("AMAC", Arrays.asList("City Centre", "Garki", "Kabusa", "Wuse", "Gwarinpa"));
      put("Bwari", Arrays.asList("Bwari Central", "Kuduru", "Igu", "Shere", "Kawu", "Ushafa"));
      put("KUJE", Arrays.asList("Kuje", "Chibiri", "Gaube", "Kwaku"));
      put("Nsukka", Arrays.asList("IBEKU", "ALOR-UNO", "EDE-UKWU", "EDE-NTA", "EDEM-ANI"));
      put("Enugu South", Arrays.asList("Akwuke", "Amechi I", "Achara Layout East", "Achara Layout West"));
      put("Udi", Arrays.asList("Oghu", "Affa", "Okpatu", "Awhum", "Ukana", "Abor"));
    }
  };

  public PatientView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    // Patient Information Form
    FormLayout patientForm = new FormLayout();
    TextField cardNumber = new TextField("Card Number");
    cardNumber.setRequired(true);

    // RadioButtonGroup<String> diseaseRadio = new RadioButtonGroup<>();
    // diseaseRadio.setLabel("Disease");
    // diseaseRadio.setItems("Diphtheria", "Other");

    TextField firstName = new TextField("First name");
    firstName.setRequired(true);

    TextField middleName = new TextField("Middle name");
    TextField lastName = new TextField("Last name");
    lastName.setRequired(true);

    ComboBox<String> stateOfResidence = new ComboBox<>("State of residence");
    stateOfResidence.setItems("FCT", "Enugu");
    stateOfResidence.setRequired(true);

    ComboBox<String> lgaOfResidence = new ComboBox<>("LGA of residence");
    lgaOfResidence.setRequired(true);

    // Update LGA options based on state
    stateOfResidence.addValueChangeListener(e -> {
      if ("FCT".equals(e.getValue())) {
        lgaOfResidence.setItems("AMAC", "Bwari", "Kwali");
      } else if ("Enugu".equals(e.getValue())) {
        lgaOfResidence.setItems("Nsukka", "Enugu south", "Udi");
      } else {
        lgaOfResidence.clear();
      }
    });

    ComboBox<String> wardOfResidence = new ComboBox<>("Ward of residence");
    wardOfResidence.setRequired(true);

    TextField address = new TextField("Patient’s residential address");
    RadioButtonGroup<String> treatmentCenter = new RadioButtonGroup<>();
    treatmentCenter.setLabel("Name of treatment center/HF");
    treatmentCenter.setItems("MMSH", "Other");

    DatePicker dateOfBirth = new DatePicker("Date of birth");
    dateOfBirth.setMax(LocalDate.now());
    dateOfBirth.setRequired(true);

    TextField age = new TextField("Age (years)");
    age.setReadOnly(true);

    RadioButtonGroup<String> sex = new RadioButtonGroup<>();
    sex.setLabel("Sex");
    sex.setItems("Female", "Male");
    sex.setRequired(true);

    DatePicker dateOfOnset = new DatePicker("Date of onset");
    dateOfOnset.setMax(LocalDate.now());
    dateOfOnset.setRequired(true);

    // Listener to calculate and set age
    dateOfBirth.addValueChangeListener(event -> {
      LocalDate dob = event.getValue();
      if (dob != null) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dob, today);

        int years = period.getYears();
        int months = period.getMonths();

        StringBuilder ageText = new StringBuilder();
        if (years > 0) {
          ageText.append(years).append(" year").append(years > 1 ? "s" : "");
        }
        if (months > 0) {
          if (ageText.length() > 0)
            ageText.append(", ");
          ageText.append(months).append(" month").append(months > 1 ? "s" : "");
        }
        if (ageText.length() == 0) {
          ageText.append("Less than a month");
        }

        age.setValue(ageText.toString());
      } else {
        age.clear();
      }
    });

    lgaOfResidence.addValueChangeListener(e -> {
      String lga = e.getValue();
      if (lga != null && wardData.containsKey(lga)) {
        wardOfResidence.setItems(wardData.get(lga));
      } else {
        wardOfResidence.clear();
        wardOfResidence.setItems();
      }
    });

    patientForm.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    // Add fields to form
    patientForm.add(
        cardNumber, firstName, middleName, lastName,
        stateOfResidence, lgaOfResidence, wardOfResidence, address,
        treatmentCenter, dateOfBirth, age, sex, dateOfOnset);

    return patientForm;
  }
}
