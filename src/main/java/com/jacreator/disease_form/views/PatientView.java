package com.jacreator.disease_form.views;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class PatientView extends VerticalLayout{

  public PatientView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
// Patient Information Form
    FormLayout patientForm = new FormLayout();
    TextField cardNumber = new TextField("Card Number");
    cardNumber.setRequired(true);

    RadioButtonGroup<String> diseaseRadio = new RadioButtonGroup<>();
    diseaseRadio.setLabel("Disease");
    diseaseRadio.setItems("Diphtheria", "Other");

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

    TextField wardOfResidence = new TextField("Ward of residence");
    wardOfResidence.setRequired(true);

    TextField address = new TextField("Patient’s residential address");
    RadioButtonGroup<String> treatmentCenter = new RadioButtonGroup<>();
    treatmentCenter.setLabel("Name of treatment center/HF");
    treatmentCenter.setItems("MMSH", "Other");

    TextField dateOfBirth = new TextField("Date of birth");
    dateOfBirth.setRequired(true);

    TextField age = new TextField("Age (years)");
    age.setReadOnly(true);

    RadioButtonGroup<String> sex = new RadioButtonGroup<>();
    sex.setLabel("Sex");
    sex.setItems("Female", "Male");
    sex.setRequired(true);

    TextField dateOfOnset = new TextField("Date of onset");
    dateOfOnset.setRequired(true);

    // Add fields to form
    patientForm.add(
        cardNumber, diseaseRadio, firstName, middleName, lastName,
        stateOfResidence, lgaOfResidence, wardOfResidence, address,
        treatmentCenter, dateOfBirth, age, sex, dateOfOnset);

    return patientForm;
  }
}
