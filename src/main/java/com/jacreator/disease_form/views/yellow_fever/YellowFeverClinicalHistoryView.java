package com.jacreator.disease_form.views.yellow_fever;

import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class YellowFeverClinicalHistoryView extends VerticalLayout {
  public YellowFeverClinicalHistoryView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Fever (≥38 °C)
    RadioButtonGroup<String> fever = new RadioButtonGroup<>();
    fever.setLabel("Fever (≥38 °C)");
    fever.setItems("Yes", "No", "Unknown");
    fever.setRequired(true);

    // Jaundice
    RadioButtonGroup<String> jaundice = new RadioButtonGroup<>();
    jaundice.setLabel("Jaundice");
    jaundice.setItems("Yes", "No", "Unknown");
    jaundice.setRequired(true);

    // General weakness
    RadioButtonGroup<String> generalWeakness = new RadioButtonGroup<>();
    generalWeakness.setLabel("General weakness");
    generalWeakness.setItems("Yes", "No", "Unknown");
    generalWeakness.setRequired(true);

    // Abdominal pain
    RadioButtonGroup<String> abdominalPain = new RadioButtonGroup<>();
    abdominalPain.setLabel("Abdominal pain");
    abdominalPain.setItems("Yes", "No", "Unknown");
    abdominalPain.setRequired(true);

    // Convulsion
    RadioButtonGroup<String> convulsion = new RadioButtonGroup<>();
    convulsion.setLabel("Convulsion");
    convulsion.setItems("Yes", "No", "Unknown");
    convulsion.setRequired(true);

    // Bleeding from nose, gums, skin or gastrointestinal tract
    RadioButtonGroup<String> bleedingFromBodySites = new RadioButtonGroup<>();
    bleedingFromBodySites.setLabel("Bleeding from nose, gums, skin or gastrointestinal tract");
    bleedingFromBodySites.setItems("Yes", "No", "Unknown");
    bleedingFromBodySites.setRequired(true);

    // Headache
    RadioButtonGroup<String> headache = new RadioButtonGroup<>();
    headache.setLabel("Headache");
    headache.setItems("Yes", "No", "Unknown");
    headache.setRequired(true);

    // Vomiting
    RadioButtonGroup<String> vomiting = new RadioButtonGroup<>();
    vomiting.setLabel("Vomiting");
    vomiting.setItems("Yes", "No", "Unknown");
    vomiting.setRequired(true);

    // Other symptoms, please specify
    TextField otherSymptoms = new TextField("Other symptoms, please specify");
    otherSymptoms.setPlaceholder("Other symptoms");

    // Date of symptom onset
    DatePicker dateOfOnset = new DatePicker("Date of symptom onset");
    dateOfOnset.setMax(LocalDate.now());
    dateOfOnset.setRequired(true);

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    // Add all fields to the form
    form.add(fever, jaundice, generalWeakness);
    form.add(abdominalPain, convulsion, bleedingFromBodySites);
    form.add(headache, vomiting, otherSymptoms);
    form.add(dateOfOnset);

    return form;
  }
}
