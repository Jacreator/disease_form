package com.jacreator.disease_form.views.measles;

import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class MeaslesEpidemiologicalView extends VerticalLayout {
  // State for conditional fields
  private String vaccinationStatusValue = null;

  // Form fields that need to be shown/hidden
  private RadioButtonGroup<String> numberVaccineDose;
  private DatePicker dateLastVaccination;
  private RadioButtonGroup<String> sourceVaccinationInformation;

  public MeaslesEpidemiologicalView() {
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

    // Number of vaccine dose(s) received (conditional)
    numberVaccineDose = new RadioButtonGroup<>();
    numberVaccineDose.setLabel("Number of vaccine dose(s) received");
    numberVaccineDose.setItems("1", "2", "3+");
    numberVaccineDose.setRequired(true);
    numberVaccineDose.setVisible(false);

    // Date of last vaccination (conditional)
    dateLastVaccination = new DatePicker("Date of last vaccination");
    dateLastVaccination.setMax(LocalDate.now());
    dateLastVaccination.setRequired(true);
    dateLastVaccination.setVisible(false);

    // Source of vaccination information (conditional)
    sourceVaccinationInformation = new RadioButtonGroup<>();
    sourceVaccinationInformation.setLabel("Source of vaccination information");
    sourceVaccinationInformation.setItems("Immunization card", "Verbal");
    sourceVaccinationInformation.setRequired(true);
    sourceVaccinationInformation.setVisible(false);

    // History of contact with person with rash/measles
    RadioButtonGroup<String> contactPersonSimilarSymptoms = new RadioButtonGroup<>();
    contactPersonSimilarSymptoms.setLabel("History of contact with person with rash/measles");
    contactPersonSimilarSymptoms.setItems("Yes", "No", "Unknown");
    contactPersonSimilarSymptoms.setRequired(true);

    // Ongoing measles outbreak in your community
    RadioButtonGroup<String> ongoingMeaslesOutbreakCommunity = new RadioButtonGroup<>();
    ongoingMeaslesOutbreakCommunity.setLabel("Ongoing measles outbreak in your community");
    ongoingMeaslesOutbreakCommunity.setItems("Yes", "No", "Unknown");
    ongoingMeaslesOutbreakCommunity.setRequired(false);

    // Responsive steps
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));

    // Add all fields to the form
    form.add(
        vaccinationStatus,
        numberVaccineDose,
        dateLastVaccination,
        sourceVaccinationInformation,
        contactPersonSimilarSymptoms,
        ongoingMeaslesOutbreakCommunity);

    // Conditional logic for vaccinationStatus
    vaccinationStatus.addValueChangeListener(event -> {
      boolean show = "Vaccinated".equals(event.getValue());
      numberVaccineDose.setVisible(show);
      dateLastVaccination.setVisible(show);
      sourceVaccinationInformation.setVisible(show);
    });

    return form;
  }
}
