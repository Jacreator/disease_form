package com.jacreator.disease_form.views.pfds;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

public class PRDSEpidemiologicalView extends VerticalLayout {
  public PRDSEpidemiologicalView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout formLayout = new FormLayout();

    // Investigation Number
    TextField investigationNumber = new TextField("Investigation Number");

    // Infection Confirmed
    RadioButtonGroup<String> infectionConfirmed = new RadioButtonGroup<>();
    infectionConfirmed.setLabel("Infection Confirmed");
    infectionConfirmed.setItems("Yes", "No");

    // Investigation Conducted
    RadioButtonGroup<String> investigationConducted = new RadioButtonGroup<>();
    investigationConducted.setLabel("Investigation Conducted");
    investigationConducted.setItems("Yes", "No");

    // Investigation Conducted By
    TextField investigationConductedBy = new TextField("Investigation Conducted By");

    // Infection Source
    RadioButtonGroup<String> infectionSource = new RadioButtonGroup<>();
    infectionSource.setLabel("Infection Source");
    infectionSource.setItems("Health Facility", "Community", "Other");

    // Other Infection Source
    TextField otherInfectionSource = new TextField("Specify Other Infection Source");

    // Travel History
    RadioButtonGroup<String> travelHistory = new RadioButtonGroup<>();
    travelHistory.setLabel("Travel History (14 Days Prior)");
    travelHistory.setItems("Yes", "No");

    TextField travelHistoryDetails = new TextField("If Yes, Specify");

    // Contact with Animal
    RadioButtonGroup<String> contactWithAnimal = new RadioButtonGroup<>();
    contactWithAnimal.setLabel("Contact with Animal");
    contactWithAnimal.setItems("Yes", "No");

    TextField contactAnimalDetails = new TextField("If Yes, Specify");

    // Contact with Confirmed Case
    RadioButtonGroup<String> contactWithConfirmedCase = new RadioButtonGroup<>();
    contactWithConfirmedCase.setLabel("Contact with Confirmed Case");
    contactWithConfirmedCase.setItems("Yes", "No");

    TextField contactCaseDetails = new TextField("If Yes, Specify");

    // Symptom Onset Date
    DatePicker symptomOnsetDate = new DatePicker("Date of Onset of First Symptom");

    // Duration Between Onset and Notification
    NumberField daysBetweenOnsetNotification = new NumberField("Days Between Onset and Notification");

    // Exposure Risk
    RadioButtonGroup<String> exposureRisk = new RadioButtonGroup<>();
    exposureRisk.setLabel("Risk of Exposure");
    exposureRisk.setItems("Low", "Medium", "High");

    // Symptom Status
    RadioButtonGroup<String> symptomStatus = new RadioButtonGroup<>();
    symptomStatus.setLabel("Was the Patient Symptomatic?");
    symptomStatus.setItems("Yes", "No");

    // Outcome
    RadioButtonGroup<String> outcome = new RadioButtonGroup<>();
    outcome.setLabel("Outcome");
    outcome.setItems("Recovered", "Deceased", "Still Sick");

    formLayout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));

    formLayout.add(
        investigationNumber,
        infectionConfirmed,
        investigationConducted,
        investigationConductedBy,
        infectionSource,
        otherInfectionSource,
        travelHistory,
        travelHistoryDetails,
        contactWithAnimal,
        contactAnimalDetails,
        contactWithConfirmedCase,
        contactCaseDetails,
        symptomOnsetDate,
        daysBetweenOnsetNotification,
        exposureRisk,
        symptomStatus,
        outcome);

    return formLayout;
  }
}
