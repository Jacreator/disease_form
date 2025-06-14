package com.jacreator.disease_form.views.yellow_fever;

import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class YellowFeverEpidemiologicalView extends VerticalLayout {
  public YellowFeverEpidemiologicalView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Vaccination status
    RadioButtonGroup<String> vaccinationStatus = new RadioButtonGroup<>();
    vaccinationStatus.setLabel("Vaccination status");
    vaccinationStatus.setItems("Vaccinated", "Not vaccinated", "Unknown");
    vaccinationStatus.setRequired(true);

    // Number of vaccine doses (conditional)
    RadioButtonGroup<String> numberOfVaccineDose = new RadioButtonGroup<>();
    numberOfVaccineDose.setLabel("Number of vaccine doses");
    numberOfVaccineDose.setItems("1", "2+");
    numberOfVaccineDose.setRequired(true);
    numberOfVaccineDose.setVisible(false);

    // Date of vaccination (conditional)
    DatePicker dateOfVaccination = new DatePicker("Date of vaccination");
    dateOfVaccination.setMax(LocalDate.now());
    dateOfVaccination.setRequired(true);
    dateOfVaccination.setVisible(false);

    // Source of vaccination history (conditional)
    RadioButtonGroup<String> sourceVaccinationHistory = new RadioButtonGroup<>();
    sourceVaccinationHistory.setLabel("Source of vaccination history");
    sourceVaccinationHistory.setItems("Vaccine card", "Verbal");
    sourceVaccinationHistory.setRequired(true);
    sourceVaccinationHistory.setVisible(false);

    // Show/hide vaccination fields based on vaccinationStatus
    vaccinationStatus.addValueChangeListener(e -> {
      boolean show = "Vaccinated".equals(e.getValue());
      numberOfVaccineDose.setVisible(show);
      dateOfVaccination.setVisible(show);
      sourceVaccinationHistory.setVisible(show);
    });

    // Travel history
    TextField travelHistory = new TextField(
        "List names of villages, towns or LGAs that patient visited in the last 3 weeks");
    travelHistory.setPlaceholder("Enter travel history");

    // Have cases of fever and jaundice been seen or reported...
    RadioButtonGroup<String> locationHistoryOfFever = new RadioButtonGroup<>();
    locationHistoryOfFever.setLabel(
        "Have cases of fever and jaundice been seen or reported in places visited by the patient in the last 2 weeks before onset of symptoms?");
    locationHistoryOfFever.setItems("Yes", "No", "Unknown");
    locationHistoryOfFever.setRequired(true);

    // Patient present condition
    RadioButtonGroup<String> patientPresentCondition = new RadioButtonGroup<>();
    patientPresentCondition.setLabel("Patient present condition");
    patientPresentCondition.setItems("Alive", "Dead", "Unknown");
    patientPresentCondition.setRequired(true);

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    // Add all fields to the form
    form.add(vaccinationStatus, numberOfVaccineDose, dateOfVaccination, sourceVaccinationHistory);
    form.add(travelHistory, locationHistoryOfFever, patientPresentCondition);

    return form;
  }
}
