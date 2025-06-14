package com.jacreator.disease_form.views.mpox;

import java.time.LocalDate;

import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class MpoxClinicalHistoryView extends VerticalLayout {
  // State for conditional fields
  private String feverValue = null;
  private String presentOfLesionValue = null;
  private String outcomeValue = null;

  // Form fields that need to be shown/hidden
  private DatePicker dateOfFeverOnset;
  private RadioButtonGroup<String> lesionSameStateOnTheBody;
  private RadioButtonGroup<String> leslesionSameSize;
  private RadioButtonGroup<String> lesionDeepAndProfound;
  private CheckboxGroup<String> localisationOfLesions;
  private DatePicker dateOfDeath;
  private TextField placeOfDeath;

  public MpoxClinicalHistoryView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Helper for Yes/No/Unknown
    String[] yesNoUnknown = { "Yes", "No", "Unknown" };

    // Fever
    RadioButtonGroup<String> fever = new RadioButtonGroup<>();
    fever.setLabel("Fever (≥38 °C)");
    fever.setItems(yesNoUnknown);
    fever.setRequired(true);

    // Date of fever onset (conditional)
    dateOfFeverOnset = new DatePicker("Date of fever onset");
    dateOfFeverOnset.setMax(LocalDate.now());
    dateOfFeverOnset.setRequired(true);
    dateOfFeverOnset.setVisible(false);

    // Present of lesions
    RadioButtonGroup<String> presentOfLesion = new RadioButtonGroup<>();
    presentOfLesion.setLabel("Present of lesions?");
    presentOfLesion.setItems(yesNoUnknown);
    presentOfLesion.setRequired(true);

    // Lesion conditional fields
    lesionSameStateOnTheBody = new RadioButtonGroup<>();
    lesionSameStateOnTheBody.setLabel("Are the lesions in the same state of development on the body?");
    lesionSameStateOnTheBody.setItems(yesNoUnknown);
    lesionSameStateOnTheBody.setRequired(true);
    lesionSameStateOnTheBody.setVisible(false);

    leslesionSameSize = new RadioButtonGroup<>();
    leslesionSameSize.setLabel("Are all of the lesions the same size?");
    leslesionSameSize.setItems(yesNoUnknown);
    leslesionSameSize.setRequired(true);
    leslesionSameSize.setVisible(false);

    lesionDeepAndProfound = new RadioButtonGroup<>();
    lesionDeepAndProfound.setLabel("Are the lesions deep and profound?");
    lesionDeepAndProfound.setItems(yesNoUnknown);
    lesionDeepAndProfound.setRequired(true);
    lesionDeepAndProfound.setVisible(false);

    localisationOfLesions = new CheckboxGroup<>();
    localisationOfLesions.setLabel("Localisation of the lesions?");
    localisationOfLesions.setItems(
        "Face", "Leg", "Soles of the Feet", "Palms of the Hands", "Thorax", "Arms", "Genitals", "All over the Body");
    localisationOfLesions.setRequired(true);
    localisationOfLesions.setVisible(false);

    // Red eyes (Conjunctivities)
    RadioButtonGroup<String> redEyes = new RadioButtonGroup<>();
    redEyes.setLabel("Red eyes (Conjunctivities)");
    redEyes.setItems(yesNoUnknown);
    redEyes.setRequired(true);

    // Sensitivity to light
    RadioButtonGroup<String> sensitivityToLight = new RadioButtonGroup<>();
    sensitivityToLight.setLabel("Sensitivity to light");
    sensitivityToLight.setItems(yesNoUnknown);
    sensitivityToLight.setRequired(true);

    // Vomitting or Nausea
    RadioButtonGroup<String> vomittingNausea = new RadioButtonGroup<>();
    vomittingNausea.setLabel("Vomitting or Nausea");
    vomittingNausea.setItems(yesNoUnknown);
    vomittingNausea.setRequired(true);

    // Cough
    RadioButtonGroup<String> cough = new RadioButtonGroup<>();
    cough.setLabel("Cough");
    cough.setItems(yesNoUnknown);
    cough.setRequired(true);

    // Oral ulcer
    RadioButtonGroup<String> oralUlcer = new RadioButtonGroup<>();
    oralUlcer.setLabel("Oral ulcer");
    oralUlcer.setItems(yesNoUnknown);
    oralUlcer.setRequired(true);

    // Lymphadenopathy
    RadioButtonGroup<String> lymphadenopathy = new RadioButtonGroup<>();
    lymphadenopathy.setLabel("Lymphadenopathy");
    lymphadenopathy.setItems(yesNoUnknown);
    lymphadenopathy.setRequired(true);

    // Sore throat
    RadioButtonGroup<String> soreThroat = new RadioButtonGroup<>();
    soreThroat.setLabel("Sore throat");
    soreThroat.setItems(yesNoUnknown);
    soreThroat.setRequired(true);

    // Muscle pain
    RadioButtonGroup<String> musclePain = new RadioButtonGroup<>();
    musclePain.setLabel("Muscle pain");
    musclePain.setItems(yesNoUnknown);
    musclePain.setRequired(true);

    // Headache
    RadioButtonGroup<String> headache = new RadioButtonGroup<>();
    headache.setLabel("Headache");
    headache.setItems(yesNoUnknown);
    headache.setRequired(true);

    // Chills or Sweats
    RadioButtonGroup<String> chillsOrSweats = new RadioButtonGroup<>();
    chillsOrSweats.setLabel("Chills or Sweats");
    chillsOrSweats.setItems(yesNoUnknown);
    chillsOrSweats.setRequired(true);

    // Fatigue
    RadioButtonGroup<String> fatigue = new RadioButtonGroup<>();
    fatigue.setLabel("Fatigue");
    fatigue.setItems(yesNoUnknown);
    fatigue.setRequired(true);

    // Pruritus
    RadioButtonGroup<String> pruritus = new RadioButtonGroup<>();
    pruritus.setLabel("Pruritus");
    pruritus.setItems(yesNoUnknown);
    pruritus.setRequired(true);

    // Pregnancy status
    RadioButtonGroup<String> pregnancyStatus = new RadioButtonGroup<>();
    pregnancyStatus.setLabel("Pregnancy status");
    pregnancyStatus.setItems(yesNoUnknown);
    pregnancyStatus.setRequired(true);

    // Skin ulcer
    RadioButtonGroup<String> skinUlcer = new RadioButtonGroup<>();
    skinUlcer.setLabel("Skin ulcer");
    skinUlcer.setItems(yesNoUnknown);
    skinUlcer.setRequired(true);

    // HIV/AIDS status
    RadioButtonGroup<String> hivAidsStatus = new RadioButtonGroup<>();
    hivAidsStatus.setLabel("HIV/AIDS status");
    hivAidsStatus.setItems("Positive", "Negative", "Unknown");
    hivAidsStatus.setRequired(true);

    // Other symptoms(s): (specify)
    TextField otherSymptom = new TextField("Other symptoms(s): (specify)");
    otherSymptom.setPlaceholder("Enter other symptoms");

    // Outcome
    RadioButtonGroup<String> outcome = new RadioButtonGroup<>();
    outcome.setLabel("Outcome");
    outcome.setItems("Alive", "Dead");
    outcome.setRequired(true);

    // Date of death (conditional)
    dateOfDeath = new DatePicker("Date of death");
    dateOfDeath.setMax(LocalDate.now());
    dateOfDeath.setRequired(true);
    dateOfDeath.setVisible(false);

    // Place of death (conditional)
    placeOfDeath = new TextField("Place of death");
    placeOfDeath.setPlaceholder("Place of death");
    placeOfDeath.setRequired(true);
    placeOfDeath.setVisible(false);

    // Date of symptom onset
    DatePicker dateOfSymptomOnset = new DatePicker("Date of symptom onset");
    dateOfSymptomOnset.setMax(LocalDate.now());
    dateOfSymptomOnset.setRequired(true);

    // Responsive steps
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));

    // Add all fields to the form
    form.add(
        fever,
        dateOfFeverOnset,
        presentOfLesion,
        lesionSameStateOnTheBody,
        leslesionSameSize,
        lesionDeepAndProfound,
        localisationOfLesions,
        redEyes,
        sensitivityToLight,
        vomittingNausea,
        cough,
        oralUlcer,
        lymphadenopathy,
        soreThroat,
        musclePain,
        headache,
        chillsOrSweats,
        fatigue,
        pruritus,
        pregnancyStatus,
        skinUlcer,
        hivAidsStatus,
        otherSymptom,
        outcome,
        dateOfDeath,
        placeOfDeath,
        dateOfSymptomOnset);

    // Conditional logic for fever
    fever.addValueChangeListener(event -> {
      boolean show = "Yes".equals(event.getValue());
      dateOfFeverOnset.setVisible(show);
    });

    // Conditional logic for presentOfLesion
    presentOfLesion.addValueChangeListener(event -> {
      boolean show = "Yes".equals(event.getValue());
      lesionSameStateOnTheBody.setVisible(show);
      leslesionSameSize.setVisible(show);
      lesionDeepAndProfound.setVisible(show);
      localisationOfLesions.setVisible(show);
    });

    // Conditional logic for outcome
    outcome.addValueChangeListener(event -> {
      boolean show = "Dead".equals(event.getValue());
      dateOfDeath.setVisible(show);
      placeOfDeath.setVisible(show);
    });

    return form;
  }
}
