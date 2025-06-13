package com.jacreator.disease_form.views.csm;

import java.time.LocalDate;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class CSMEpidemiologicalView extends VerticalLayout {
  private RadioButtonGroup<String> patientEverReceivedAnyMeningococalVaccine;
  private DatePicker dateOfVaccination;
  private RadioButtonGroup<String> numberOfVaccineDoses;
  private RadioButtonGroup<String> sourceOfVaccinationHistory;
  private RadioButtonGroup<String> noVaccineReason;

  private RadioButtonGroup<String> travelInLast10Days;
  private TextField travelLocation;

  private RadioButtonGroup<String> contactWithAnyoneWithSymptomsOrConfirmed;
  private TextField contactLocation;

  public CSMEpidemiologicalView() {
    setWidthFull();
    setPadding(true);
    setSpacing(true);

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();
    form.setWidthFull();
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("900px", 2));

    // Vaccine status
    patientEverReceivedAnyMeningococalVaccine = new RadioButtonGroup<>(
        "Patient ever received any meningococaal vaccine?");
    patientEverReceivedAnyMeningococalVaccine.setItems("vaccinated", "notVaccinated", "unknown");
    patientEverReceivedAnyMeningococalVaccine.setRequired(true);
    patientEverReceivedAnyMeningococalVaccine.setRequiredIndicatorVisible(true);

    // Conditional fields for vaccinated
    dateOfVaccination = new DatePicker("Date of vaccination");
    dateOfVaccination.setMax(LocalDate.now());
    dateOfVaccination.setVisible(false);

    numberOfVaccineDoses = new RadioButtonGroup<>("Number of vaccine doses");
    numberOfVaccineDoses.setItems("1", "2", "3", "4");
    numberOfVaccineDoses.setVisible(false);

    sourceOfVaccinationHistory = new RadioButtonGroup<>("Source of vaccination history");
    sourceOfVaccinationHistory.setItems("card", "verbal", "no");
    sourceOfVaccinationHistory.setVisible(false);

    // Conditional field for not vaccinated
    noVaccineReason = new RadioButtonGroup<>("If not vaccinated, indicate reason");
    noVaccineReason.setItems(
        "religious_exemption",
        "medical_contraindication",
        "under_age",
        "parental_refusal",
        "unknown");
    noVaccineReason.setVisible(false);

    // Travel in last 10 days
    travelInLast10Days = new RadioButtonGroup<>("History of travel in the last 10 days");
    travelInLast10Days.setItems("yes", "no", "unknown");
    travelInLast10Days.setRequired(true);
    travelInLast10Days.setRequiredIndicatorVisible(true);

    travelLocation = new TextField("If yes to above, where?");
    travelLocation.setPlaceholder("Enter Address");
    travelLocation.setVisible(false);

    // Contact with anyone with symptoms/confirmed
    contactWithAnyoneWithSymptomsOrConfirmed = new RadioButtonGroup<>(
        "Have you had contact with anyone with similar symptoms/confirmed case in the last 10 days");
    contactWithAnyoneWithSymptomsOrConfirmed.setItems("yes", "no", "unknown");
    contactWithAnyoneWithSymptomsOrConfirmed.setRequired(true);
    contactWithAnyoneWithSymptomsOrConfirmed.setRequiredIndicatorVisible(true);

    contactLocation = new TextField("Location of contact(s)");
    contactLocation.setPlaceholder("Enter Contact Location");
    contactLocation.setVisible(false);

    // Dynamic logic for showing/hiding fields
    patientEverReceivedAnyMeningococalVaccine.addValueChangeListener(e -> {
      String value = e.getValue();
      boolean vaccinated = "vaccinated".equals(value);
      boolean notVaccinated = "notVaccinated".equals(value);

      dateOfVaccination.setVisible(vaccinated);
      numberOfVaccineDoses.setVisible(vaccinated);
      sourceOfVaccinationHistory.setVisible(vaccinated);

      noVaccineReason.setVisible(notVaccinated);

      if (!vaccinated) {
        dateOfVaccination.clear();
        numberOfVaccineDoses.clear();
        sourceOfVaccinationHistory.clear();
      }
      if (!notVaccinated) {
        noVaccineReason.clear();
      }
    });

    travelInLast10Days.addValueChangeListener(e -> {
      boolean show = "yes".equals(e.getValue());
      travelLocation.setVisible(show);
      if (!show)
        travelLocation.clear();
    });

    contactWithAnyoneWithSymptomsOrConfirmed.addValueChangeListener(e -> {
      boolean show = "yes".equals(e.getValue());
      contactLocation.setVisible(show);
      if (!show)
        contactLocation.clear();
    });

    form.add(
        patientEverReceivedAnyMeningococalVaccine,
        dateOfVaccination,
        numberOfVaccineDoses,
        sourceOfVaccinationHistory,
        noVaccineReason,
        travelInLast10Days,
        travelLocation,
        contactWithAnyoneWithSymptomsOrConfirmed,
        contactLocation);

    return form;
  }
}
