package com.jacreator.disease_form.views.cholera;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class CholeraEpidemiologicalView extends VerticalLayout {
  public CholeraEpidemiologicalView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Exposure details known
    RadioButtonGroup<String> exposureDetails = new RadioButtonGroup<>();
    exposureDetails.setLabel("Exposure details known");
    exposureDetails.setItems("Yes", "No", "Unknown");
    exposureDetails.setRequired(true);

    // Activity details
    RadioButtonGroup<String> activityDetails = new RadioButtonGroup<>();
    activityDetails.setLabel("Activity details");
    activityDetails.setItems("Yes", "No", "Unknown");
    activityDetails.setRequired(true);

    // Living or working in an area with high risk of transmission
    RadioButtonGroup<String> livingOrWorkingInHighRiskEnvironment = new RadioButtonGroup<>();
    livingOrWorkingInHighRiskEnvironment.setLabel("Living or working in an area with high risk of transmission");
    livingOrWorkingInHighRiskEnvironment.setItems("Yes", "No", "Unknown");
    livingOrWorkingInHighRiskEnvironment.setRequired(true);

    // Residing or traveled to areas with high risk
    RadioButtonGroup<String> areasWithHighRisk = new RadioButtonGroup<>();
    areasWithHighRisk.setLabel("Residing or traveled to areas with high risk");
    areasWithHighRisk.setItems("Yes", "No", "Unknown");
    areasWithHighRisk.setRequired(true);

    // Contact with source case known
    RadioButtonGroup<String> contactWithSourceCase = new RadioButtonGroup<>();
    contactWithSourceCase.setLabel("Contact with source case known");
    contactWithSourceCase.setItems("Yes", "No", "Unknown");
    contactWithSourceCase.setRequired(true);
    // Vaccination Status
    RadioButtonGroup<String> vaccinationStatus = new RadioButtonGroup<>();
    vaccinationStatus.setLabel("Vaccination status");
    vaccinationStatus.setItems("yes", "no", "unknown");

    RadioButtonGroup<String> vaccinationDose = new RadioButtonGroup<>();
    vaccinationDose.setLabel("Vaccination dose");
    vaccinationDose.setItems("firstDose", "secondDose", "thirdDose");

    TextField vaccinationName = new TextField("Name of vaccine");

    DatePicker vaccinationDate = new DatePicker("Date of vaccine");

    // Initially hidden
    vaccinationDose.setVisible(false);
    vaccinationName.setVisible(false);
    vaccinationDate.setVisible(false);

    vaccinationStatus.addValueChangeListener(event -> {
      boolean show = "yes".equals(event.getValue());
      vaccinationDose.setVisible(show);
      vaccinationName.setVisible(show);
      vaccinationDate.setVisible(show);
    });

    // Travel History
    RadioButtonGroup<String> travelHistory = new RadioButtonGroup<>();
    travelHistory.setLabel("Travel history");
    travelHistory.setItems("yes", "no", "unknown");

    TextField villageName = new TextField("Name of village where the patient fell ill");
    RadioButtonGroup<String> travelInThreeWeeks = new RadioButtonGroup<>();
    travelInThreeWeeks.setLabel("Did the patient travel anytime in the three weeks before becoming ill");
    travelInThreeWeeks.setItems("yes", "no", "unknown");

    villageName.setVisible(false);
    travelInThreeWeeks.setVisible(false);

    travelHistory.addValueChangeListener(event -> {
      boolean show = "yes".equals(event.getValue());
      villageName.setVisible(show);
      travelInThreeWeeks.setVisible(show);
    });

    // Contact History
    RadioButtonGroup<String> contactHistory = new RadioButtonGroup<>();
    contactHistory.setLabel("Contact history");
    contactHistory.setItems("yes", "no", "unknown");

    RadioButtonGroup<String> travelDuringIllness = new RadioButtonGroup<>();
    travelDuringIllness.setLabel("Did the patient travel during illness");
    travelDuringIllness.setItems("yes", "no", "unknown");

    RadioButtonGroup<String> contactWithinThreeWeeks = new RadioButtonGroup<>();
    contactWithinThreeWeeks.setLabel(
        "During the three weeks preceding symptoms, did the patient have contact with someone showing symptoms?");
    contactWithinThreeWeeks.setItems("yes", "no", "unknown");

    DatePicker contactDate = new DatePicker("Date of contact");

    travelDuringIllness.setVisible(false);
    contactWithinThreeWeeks.setVisible(false);
    contactDate.setVisible(false);

    contactHistory.addValueChangeListener(event -> {
      boolean show = "yes".equals(event.getValue());
      travelDuringIllness.setVisible(show);
      contactWithinThreeWeeks.setVisible(show);
      contactDate.setVisible(show);
    });

    // Risk Factors
    TextField riskFactors = new TextField("Risk factors");

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    // Add all fields to the form

    form.add(exposureDetails,
        activityDetails, livingOrWorkingInHighRiskEnvironment, areasWithHighRisk, contactWithSourceCase,
        vaccinationStatus,
        vaccinationDose,
        vaccinationName,
        vaccinationDate,
        travelHistory,
        villageName,
        travelInThreeWeeks,
        contactHistory,
        travelDuringIllness,
        contactWithinThreeWeeks,
        contactDate,
        riskFactors);

    return form;
  }
}
