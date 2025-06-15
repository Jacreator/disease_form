package com.jacreator.disease_form.views.cholera;

import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class CholeraClinicalHistoryView extends VerticalLayout {
  public CholeraClinicalHistoryView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Date of symptom onset
    DatePicker dateOfSymptomOnset = new DatePicker("Date of symptom onset");
    dateOfSymptomOnset.setMax(LocalDate.now());
    dateOfSymptomOnset.setRequired(true);

    // Diarrhea
    RadioButtonGroup<String> diarrhea = new RadioButtonGroup<>();
    diarrhea.setLabel("Diarrhea");
    diarrhea.setItems("Yes", "No", "Unknown");
    diarrhea.setRequired(true);

    // Myalgia
    RadioButtonGroup<String> myalgia = new RadioButtonGroup<>();
    myalgia.setLabel("Myalgia");
    myalgia.setItems("Yes", "No", "Unknown");
    myalgia.setRequired(true);

    // Restlessness
    RadioButtonGroup<String> restlessness = new RadioButtonGroup<>();
    restlessness.setLabel("Restlessness");
    restlessness.setItems("Yes", "No", "Unknown");
    restlessness.setRequired(true);

    // Fever
    RadioButtonGroup<String> fever = new RadioButtonGroup<>();
    fever.setLabel("Fever");
    fever.setItems("Yes", "No", "Unknown");
    fever.setRequired(true);

    // Abdominal cramp
    RadioButtonGroup<String> abdominalCramp = new RadioButtonGroup<>();
    abdominalCramp.setLabel("Abdominal cramp");
    abdominalCramp.setItems("Yes", "No", "Unknown");
    abdominalCramp.setRequired(true);

    // Vomiting
    RadioButtonGroup<String> vomiting = new RadioButtonGroup<>();
    vomiting.setLabel("Vomiting");
    vomiting.setItems("Yes", "No", "Unknown");
    vomiting.setRequired(true);

    // Thirst
    RadioButtonGroup<String> thirst = new RadioButtonGroup<>();
    thirst.setLabel("Thirst");
    thirst.setItems("Yes", "No", "Unknown");
    thirst.setRequired(true);

    // Dehydration
    RadioButtonGroup<String> dehydrated = new RadioButtonGroup<>();
    dehydrated.setLabel("Dehydration");
    dehydrated.setItems("Yes", "No", "Unknown");
    dehydrated.setRequired(true);

    // Blood in stool
    RadioButtonGroup<String> bloodInStool = new RadioButtonGroup<>();
    bloodInStool.setLabel("Blood in stool");
    bloodInStool.setItems("Yes", "No", "Unknown");
    bloodInStool.setRequired(true);

    // Other symptom, please specify
    TextField otherSymptoms = new TextField("Other symptom, please specify");
    otherSymptoms.setPlaceholder("Other symptoms");

    // Was the patient admitted to a health facility for at least one night?
    RadioButtonGroup<String> patientAdmittedAtLeastOneNight = new RadioButtonGroup<>();
    patientAdmittedAtLeastOneNight.setLabel("Was the patient admitted to a health facility for at least one night?");
    patientAdmittedAtLeastOneNight.setItems("Yes", "No", "Unknown");
    patientAdmittedAtLeastOneNight.setRequired(true);

    // Date of admission (conditional)
    DatePicker datePatientAdmittedAtLeastOneNight = new DatePicker("Date of admission");
    datePatientAdmittedAtLeastOneNight.setMax(LocalDate.now());
    datePatientAdmittedAtLeastOneNight.setVisible(false);
    datePatientAdmittedAtLeastOneNight.setRequired(true);

    // Date of discharge (conditional)
    DatePicker datePatientDischargedAtLeastOneNight = new DatePicker("Date of discharge");
    datePatientDischargedAtLeastOneNight.setMax(LocalDate.now());
    datePatientDischargedAtLeastOneNight.setVisible(false);
    datePatientDischargedAtLeastOneNight.setRequired(true);

    // Show/hide admission/discharge dates based on admission answer
    patientAdmittedAtLeastOneNight.addValueChangeListener(e -> {
      boolean show = "Yes".equals(e.getValue());
      datePatientAdmittedAtLeastOneNight.setVisible(show);
      datePatientDischargedAtLeastOneNight.setVisible(show);
    });

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    // Add all fields to the form
    form.add(dateOfSymptomOnset, diarrhea,
        myalgia, restlessness, fever,
        abdominalCramp, vomiting, thirst,
        dehydrated, datePatientAdmittedAtLeastOneNight, datePatientDischargedAtLeastOneNight, bloodInStool,
        patientAdmittedAtLeastOneNight, otherSymptoms);

    return form;
  }
}
