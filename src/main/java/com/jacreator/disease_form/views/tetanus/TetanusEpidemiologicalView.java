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

public class TetanusEpidemiologicalView extends VerticalLayout {

  public TetanusEpidemiologicalView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Mother Vaccinated with TT
    RadioButtonGroup<String> motherVaccinated = createYesNoUnknown("Mother Vaccinated with TT");
    motherVaccinated.setRequired(true);

    // If yes, number of doses (conditional)
    TextField numberOfDoses = new TextField("If yes, number of doses");
    numberOfDoses.setPlaceholder("Specify number of doses");
    numberOfDoses.setPattern("\\d*");
    numberOfDoses.setVisible(false);

    // Date of last dose
    DatePicker dateOfLastDose = new DatePicker("Date of last dose");
    dateOfLastDose.setMax(LocalDate.now());
    dateOfLastDose.setRequired(true);

    // Source of Vaccination history
    RadioButtonGroup<String> sourceOfVaccinationHistory = new RadioButtonGroup<>();
    sourceOfVaccinationHistory.setLabel("Source of Vaccination history");
    sourceOfVaccinationHistory.setItems("Card", "Verbal");
    sourceOfVaccinationHistory.setRequired(true);

    // Vaccination status of mother prior to delivery
    RadioButtonGroup<String> vaccinationStatusPrior = new RadioButtonGroup<>();
    vaccinationStatusPrior.setLabel("Vaccination status of mother prior to delivery");
    vaccinationStatusPrior.setItems("Up to date", "Not up to date", "Unknown");
    vaccinationStatusPrior.setRequired(true);

    // Location of birth
    RadioButtonGroup<String> locationOfBirth = new RadioButtonGroup<>();
    locationOfBirth.setLabel("Location of birth");
    locationOfBirth.setItems(
        "Hospital", "Health center", "Home trained attendant",
        "Home untrained attendant", "home, no attendant", "Unknown");
    locationOfBirth.setRequired(true);

    // If birth in institution, name of institution (conditional)
    TextField nameOfBirthInstitution = new TextField("If birth in institution, name of institution");
    nameOfBirthInstitution.setPlaceholder("Specify institution of birth");
    nameOfBirthInstitution.setVisible(false);

    // Cut cord with sterile blade
    RadioButtonGroup<String> cutCordWithSterileBlade = createYesNoUnknown("Cut cord with sterile blade");
    cutCordWithSterileBlade.setRequired(true);

    // Cord treated with anything
    RadioButtonGroup<String> cordTreated = createYesNoUnknown("Cord treated with anything");
    cordTreated.setRequired(true);

    // Describe Treatment
    TextField describeTreatment = new TextField("Describe Treatment");
    describeTreatment.setPlaceholder("Describe treatment");
    describeTreatment.setRequired(true);

    // Mother received antenatal care
    RadioButtonGroup<String> motherReceivedAntenatalCare = createYesNoUnknown("Mother received antenatal care");
    motherReceivedAntenatalCare.setRequired(true);

    // If yes, where? (conditional)
    TextField locationOfAntenatalReceived = new TextField("If yes, where ?");
    locationOfAntenatalReceived.setPlaceholder("Specify location of antenatal care received");
    locationOfAntenatalReceived.setVisible(false);

    // How many prenatal visits
    TextField numberOfPrenatalVisits = new TextField("How many prenatal visits");
    numberOfPrenatalVisits.setPlaceholder("Specify number of prenatal visits");
    numberOfPrenatalVisits.setPattern("\\d*");
    numberOfPrenatalVisits.setRequired(true);

    // Attended to by a Doctor ?
    RadioButtonGroup<String> attendedByDoctor = createYesNoUnknown("Attended to by a Doctor ?");
    attendedByDoctor.setRequired(true);

    // Attended by a trained TBA/Midwife
    RadioButtonGroup<String> attendedByTrainedTbaOrMidwife = createYesNoUnknown("Attended by a trained TBA/Midwife");
    attendedByTrainedTbaOrMidwife.setRequired(true);

    // Conditional logic
    motherVaccinated.addValueChangeListener(e -> {
      boolean show = "Yes".equalsIgnoreCase(e.getValue());
      numberOfDoses.setVisible(show);
      if (!show)
        numberOfDoses.clear();
    });

    motherReceivedAntenatalCare.addValueChangeListener(e -> {
      boolean show = "Yes".equalsIgnoreCase(e.getValue());
      locationOfAntenatalReceived.setVisible(show);
      if (!show)
        locationOfAntenatalReceived.clear();
    });

    locationOfBirth.addValueChangeListener(e -> {
      boolean show = "Hospital".equalsIgnoreCase(e.getValue());
      nameOfBirthInstitution.setVisible(show);
      if (!show)
        nameOfBirthInstitution.clear();
    });

    // Add all fields to the form
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));
    form.add(
        motherVaccinated, numberOfDoses,
        dateOfLastDose, sourceOfVaccinationHistory,
        vaccinationStatusPrior, locationOfBirth,
        nameOfBirthInstitution, cutCordWithSterileBlade,
        cordTreated, describeTreatment,
        motherReceivedAntenatalCare, locationOfAntenatalReceived,
        numberOfPrenatalVisits, attendedByDoctor,
        attendedByTrainedTbaOrMidwife);

    return form;
  }

  private RadioButtonGroup<String> createYesNoUnknown(String label) {
    RadioButtonGroup<String> group = new RadioButtonGroup<>();
    group.setLabel(label);
    group.setItems("Yes", "No", "Unknown");
    return group;
  }
}
