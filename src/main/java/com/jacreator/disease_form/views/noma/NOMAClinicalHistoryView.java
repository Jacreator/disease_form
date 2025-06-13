package com.jacreator.disease_form.views.noma;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class NOMAClinicalHistoryView extends VerticalLayout {
  public NOMAClinicalHistoryView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Helper for Yes/No/Unknown
    List<String> yesNoUnknown = Arrays.asList("Yes", "No", "Unknown");

    // Hospitalization status
    RadioButtonGroup<String> hospitalizationStatus = new RadioButtonGroup<>();
    hospitalizationStatus.setLabel("Hospitalization status");
    hospitalizationStatus.setItems("Inpatient", "Outpatient", "Refered");
    hospitalizationStatus.setRequired(true);

    // Date Of symptom onset
    DatePicker dateOfOnset = new DatePicker("Date Of symptom onset");
    dateOfOnset.setMax(LocalDate.now());
    dateOfOnset.setRequired(true);

    // Onset season
    RadioButtonGroup<String> onsetSeason = new RadioButtonGroup<>();
    onsetSeason.setLabel("Onset season");
    onsetSeason.setItems("Rainy", "Dry", "Unknown");
    onsetSeason.setRequired(true);

    // Bleeding gums
    RadioButtonGroup<String> bleedingGums = new RadioButtonGroup<>();
    bleedingGums.setLabel("Bleeding gums");
    bleedingGums.setItems(yesNoUnknown);
    bleedingGums.setRequired(true);

    // Drooling/Excessive salivation
    RadioButtonGroup<String> droolingOrExcessiveSalivation = new RadioButtonGroup<>();
    droolingOrExcessiveSalivation.setLabel("Drooling/Excessive salivation");
    droolingOrExcessiveSalivation.setItems(yesNoUnknown);
    droolingOrExcessiveSalivation.setRequired(true);

    // Swollen gum
    RadioButtonGroup<String> swollenGum = new RadioButtonGroup<>();
    swollenGum.setLabel("Swollen gum");
    swollenGum.setItems(yesNoUnknown);
    swollenGum.setRequired(true);

    // Sore on the gum
    RadioButtonGroup<String> soreOnTheGum = new RadioButtonGroup<>();
    soreOnTheGum.setLabel("Sore on the gum");
    soreOnTheGum.setItems(yesNoUnknown);
    soreOnTheGum.setRequired(true);

    // Facial swelling
    RadioButtonGroup<String> facialSwelling = new RadioButtonGroup<>();
    facialSwelling.setLabel("Facial swelling");
    facialSwelling.setItems(yesNoUnknown);
    facialSwelling.setRequired(true);

    // Wound on the face
    RadioButtonGroup<String> woundOnTheFace = new RadioButtonGroup<>();
    woundOnTheFace.setLabel("Wound on the face");
    woundOnTheFace.setItems(yesNoUnknown);
    woundOnTheFace.setRequired(true);

    // Tissue Loss/bone of the jaw exposed
    RadioButtonGroup<String> tissueLossOrBoneOfTheJawExposed = new RadioButtonGroup<>();
    tissueLossOrBoneOfTheJawExposed.setLabel("Tissue Loss/bone of the jaw exposed");
    tissueLossOrBoneOfTheJawExposed.setItems(yesNoUnknown);
    tissueLossOrBoneOfTheJawExposed.setRequired(true);

    // Difficulty closing or opening mouth
    RadioButtonGroup<String> difficultyClosingOrOpeningMouth = new RadioButtonGroup<>();
    difficultyClosingOrOpeningMouth.setLabel("Difficulty closing or opening mouth");
    difficultyClosingOrOpeningMouth.setItems(yesNoUnknown);
    difficultyClosingOrOpeningMouth.setRequired(true);

    // Diarrhea
    RadioButtonGroup<String> diarrhea = new RadioButtonGroup<>();
    diarrhea.setLabel("Diarrhea");
    diarrhea.setItems(yesNoUnknown);
    diarrhea.setRequired(true);

    // Symptoms of malnutrition
    RadioButtonGroup<String> symptomsOfMalnutrition = new RadioButtonGroup<>();
    symptomsOfMalnutrition.setLabel("Symptoms of malnutrition");
    symptomsOfMalnutrition.setItems(yesNoUnknown);
    symptomsOfMalnutrition.setRequired(true);

    // Swollen abdomen
    RadioButtonGroup<String> swollenAbdomen = new RadioButtonGroup<>();
    swollenAbdomen.setLabel("Swollen abdomen");
    swollenAbdomen.setItems(yesNoUnknown);
    swollenAbdomen.setRequired(true);

    // Wisened look
    RadioButtonGroup<String> wisenedLook = new RadioButtonGroup<>();
    wisenedLook.setLabel("Wisened look");
    wisenedLook.setItems(yesNoUnknown);
    wisenedLook.setRequired(true);

    // Responsive steps
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("800px", 2),
        new FormLayout.ResponsiveStep("1200px", 3));

    // Add all fields to the form
    form.add(
        hospitalizationStatus,
        dateOfOnset,
        onsetSeason,
        bleedingGums,
        droolingOrExcessiveSalivation,
        swollenGum,
        soreOnTheGum,
        facialSwelling,
        woundOnTheFace,
        tissueLossOrBoneOfTheJawExposed,
        difficultyClosingOrOpeningMouth,
        diarrhea,
        symptomsOfMalnutrition,
        swollenAbdomen,
        wisenedLook);

    return form;
  }
}
