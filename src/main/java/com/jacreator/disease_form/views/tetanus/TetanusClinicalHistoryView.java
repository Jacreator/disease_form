package com.jacreator.disease_form.views.tetanus;

import java.time.LocalDate;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class TetanusClinicalHistoryView extends VerticalLayout {
  public TetanusClinicalHistoryView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Date onset of symptoms
    DatePicker dateOfSymptomOnset = new DatePicker("Date onset of symptoms");
    dateOfSymptomOnset.setMax(LocalDate.now());
    dateOfSymptomOnset.setRequired(true);

    // Was baby normal at birth
    RadioButtonGroup<String> babyNormalAtBirth = createYesNoUnknown("Was baby normal at birth");

    // Normal cry and suck during first 2 days
    RadioButtonGroup<String> normalCryAndSuck = createYesNoUnknown("Normal cry and suck during first 2 days");

    // Stopped sucking after 2 days
    RadioButtonGroup<String> stoppedSuckingAfterTwoDays = createYesNoUnknown("Stopped sucking after 2 days");

    // Spasms or Convulsion
    RadioButtonGroup<String> spasmsOrConvulsion = createYesNoUnknown("Spasms or Convulsion");

    // Arched back
    RadioButtonGroup<String> archedBack = createYesNoUnknown("Arched back");

    // Complications
    RadioButtonGroup<String> complications = createYesNoUnknown("Complications");

    // Baby died
    RadioButtonGroup<String> babyDied = createYesNoUnknown("Baby died");

    // Seen at OPD
    RadioButtonGroup<String> seenAtOpd = createYesNoUnknown("Seen at OPD");

    // Hospitalized
    RadioButtonGroup<String> hospitalized = createYesNoUnknown("Hospitalized");

    // Date of admission
    DatePicker dateOfAdmission = new DatePicker("Date of admission");
    dateOfAdmission.setMax(LocalDate.now());
    dateOfAdmission.setRequired(true);

    // Facility Address
    TextField facilityAddress = new TextField("Facility Address");
    facilityAddress.setPlaceholder("Specify Facility");

    // Medical/File Number
    TextField fileNumber = new TextField("Medical/File Number");
    fileNumber.setPlaceholder("Specify Facility");
    fileNumber.setPattern("\\d*"); // Only numbers

    // Mother given protective dose of TT within 3 months
    RadioButtonGroup<String> motherGivenProtectiveDose = createYesNoUnknown(
        "Mother given protective dose of TT within 3 months");

    // Supplemental Immunization Within same locality
    RadioButtonGroup<String> supplementalImmunizationGiven = createYesNoUnknown(
        "Supplemental Immunization Within same locality");

    // Date of response for supplemental
    DatePicker dateOfResponseForSupplement = new DatePicker("Date of response for supplemental");
    dateOfResponseForSupplement.setMax(LocalDate.now());
    dateOfResponseForSupplement.setRequired(true);

    // Details of response
    TextField detailsOfResponse = new TextField("Details of response");
    detailsOfResponse.setPlaceholder("Specify Facility");

    // Add all fields to the form
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));
    form.add(
        dateOfSymptomOnset, babyNormalAtBirth,
        normalCryAndSuck, stoppedSuckingAfterTwoDays,
        spasmsOrConvulsion, archedBack,
        complications, babyDied,
        seenAtOpd, hospitalized,
        dateOfAdmission, facilityAddress,
        fileNumber, motherGivenProtectiveDose,
        supplementalImmunizationGiven, dateOfResponseForSupplement,
        detailsOfResponse);

    return form;
  }

  private RadioButtonGroup<String> createYesNoUnknown(String label) {
    RadioButtonGroup<String> group = new RadioButtonGroup<>();
    group.setLabel(label);
    group.setItems("Yes", "No", "Unknown");
    group.setRequired(true);
    return group;
  }
}
