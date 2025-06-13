package com.jacreator.disease_form.views.anthrax;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class AnthraxClinicalHistoryView extends VerticalLayout {

  public AnthraxClinicalHistoryView() {
    // Signs and symptoms options
    List<String> signs = Arrays.asList(
        "Fever", "Headache", "Skin lesions", "Chest Discomfort", "Shortness of breath",
        "Confusion or dizziness", "Cough", "Nausea", "Bloody vomiting", "Stomach pains",
        "Sweats (often drenching)", "Extreme tiredness", "Body aches", "Swelling of neck or neck glands",
        "Sore throat", "Painful swallowing", "Hoarseness of voice", "Diarrhea or bloody diarrhea",
        "Flushing (red face) and red eyes", "Fainting", "Swelling of the abdomen (stomach)",
        "Black Eschars/crusts", "Convulsions", "Others");

    add(createForm(signs));
  }

  private FormLayout createForm(List<String> signs) {
    FormLayout formLayout = new FormLayout();

    // Signs and Symptoms
    CheckboxGroup<String> signsSymptoms = new CheckboxGroup<>();
    signsSymptoms.setLabel("Signs and symptoms");
    signsSymptoms.setItems(signs);

    // "Other" field, shown only if "Others" is selected
    TextField otherSymptoms = new TextField("Other (specify)");
    otherSymptoms.setVisible(false);

    signsSymptoms.addValueChangeListener(event -> {
      otherSymptoms.setVisible(event.getValue().contains("Others"));
    });

    // Date fields
    DatePicker dateSeenAtHealthFacility = new DatePicker("Date seen at the health facility");
    dateSeenAtHealthFacility.setMax(LocalDate.now());

    DatePicker dateOfCaseInvestigation = new DatePicker("Date of case investigation");
    dateOfCaseInvestigation.setMax(LocalDate.now());

    DatePicker dateOfOnsetOfSkin = new DatePicker("Date of onset of skin lesions");
    dateOfOnsetOfSkin.setMax(LocalDate.now());

    // Has baseline serum been taken
    RadioButtonGroup<String> hasBaselineSecrum = new RadioButtonGroup<>();
    hasBaselineSecrum.setLabel("Has baseline serum been taken");
    hasBaselineSecrum.setItems("Yes", "No", "Unknown");

    // If yes, date
    DatePicker ifYesDate = new DatePicker("If yes, date");
    ifYesDate.setMax(LocalDate.now());
    ifYesDate.setVisible(false);

    hasBaselineSecrum.addValueChangeListener(event -> {
      ifYesDate.setVisible("Yes".equals(event.getValue()));
    });

    // First symptom noticed
    TextField firstSymptomNoticed = new TextField("First symptom noticed");

    // Date of onset of first symptoms
    DatePicker dateOfOnsetOfFirstSymptoms = new DatePicker("Date of onset of first symptoms");
    dateOfOnsetOfFirstSymptoms.setMax(LocalDate.now());

    // Name of sentinel lab specimen was sent
    TextField nameOfSentinelLabSpecimen = new TextField("Name of sentinel lab specimen was sent");

    // Add all fields to the form
    formLayout.add(
        signsSymptoms, otherSymptoms,
        dateSeenAtHealthFacility, dateOfCaseInvestigation, dateOfOnsetOfSkin,
        hasBaselineSecrum, ifYesDate,
        firstSymptomNoticed, dateOfOnsetOfFirstSymptoms,
        nameOfSentinelLabSpecimen);

    return formLayout;
  }
}
