package com.jacreator.disease_form.views.cholera;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class CholeraLaboratoryInformationView extends VerticalLayout {
  private final List<String> laboratoryData = Arrays.asList(
      "ACEGID -African Centre of Excellence for Genomics of Infectious Diseases, Ogun",
      "AE-FUTHA -Alex Ekwueme Federal University Teaching Hospital Virology Laboratory",
      "BUK -Bayero University Kano Centre for Infectious Disease and Research, Kano",
      "FMC JALINGO -Federal Medical Centre, Jalingo, Taraba",
      "FMC OWO -Federal Medical Centre Owo, Ondo",
      "ISTH -Irrua Specialist Teaching Hospital, Edo",
      "LUTH -Lagos University Teaching Hospital Virology Laboratory, Lagos",
      "MOGID -Molecular Genetics and Infectious Diseases Research Laboratory, Bauchi",
      "NRL -National Reference Laboratory Gaduwa, FCT");

  public CholeraLaboratoryInformationView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Specimen collected
    RadioButtonGroup<String> specimenCollected = new RadioButtonGroup<>();
    specimenCollected.setLabel("Specimen collected");
    specimenCollected.setItems("Yes", "No");
    specimenCollected.setRequired(true);

    // Date specimen was collected
    DatePicker dateSpecimenCollected = new DatePicker("Date specimen was collected");
    dateSpecimenCollected.setMax(LocalDate.now());
    dateSpecimenCollected.setRequired(true);
    dateSpecimenCollected.setVisible(false);

    // Type of specimen collected
    CheckboxGroup<String> specimenType = new CheckboxGroup<>();
    specimenType.setLabel("Type of specimen collected");
    specimenType.setItems("Stool", "Rectal swab");
    specimenType.setVisible(false);

    // Name of testing laboratory
    ComboBox<String> nameOfTestingLaboratory = new ComboBox<>("Name of testing laboratory");
    nameOfTestingLaboratory.setItems(laboratoryData);
    nameOfTestingLaboratory.setRequired(true);
    nameOfTestingLaboratory.setVisible(false);

    // Date specimen was sent
    DatePicker dateSpecimenSent = new DatePicker("Date specimen was sent");
    dateSpecimenSent.setMax(LocalDate.now());
    dateSpecimenSent.setRequired(true);
    dateSpecimenSent.setVisible(false);

    // RDT result
    RadioButtonGroup<String> rdtResult = new RadioButtonGroup<>();
    rdtResult.setLabel("RDT result");
    rdtResult.setItems("Positive", "Negative", "Not done");
    rdtResult.setRequired(true);
    rdtResult.setVisible(false);

    // Divider
    Label labResultDivider = new Label("Laboratory Result");
    labResultDivider.getStyle().set("font-weight", "bold").set("margin", "16px 0 8px 0");
    labResultDivider.setVisible(false);

    // Stool specimen fields
    Div stoolFields = buildStoolFields();
    stoolFields.setVisible(false);

    // Rectal swab specimen fields
    Div rectalSwabFields = buildRectalSwabFields();
    rectalSwabFields.setVisible(false);

    // Show/hide specimen fields based on "Specimen collected"
    specimenCollected.addValueChangeListener(e -> {
      boolean yes = "Yes".equals(e.getValue());
      dateSpecimenCollected.setVisible(yes);
      specimenType.setVisible(yes);
      nameOfTestingLaboratory.setVisible(yes);
      dateSpecimenSent.setVisible(yes);
      rdtResult.setVisible(yes);
      labResultDivider.setVisible(yes);
      if (!yes) {
        stoolFields.setVisible(false);
        rectalSwabFields.setVisible(false);
      }
    });

    // Show/hide stool/rectal swab fields based on specimenType selection
    specimenType.addValueChangeListener(e -> {
      Set<String> selected = e.getValue();
      stoolFields.setVisible(selected.contains("Stool"));
      rectalSwabFields.setVisible(selected.contains("Rectal swab"));
    });

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    // Add all fields to the form
    form.add(specimenCollected, dateSpecimenCollected, specimenType);
    form.add(nameOfTestingLaboratory, dateSpecimenSent, rdtResult);
    form.add(labResultDivider, 3);
    form.add(stoolFields, 3);
    form.add(rectalSwabFields, 3);

    return form;
  }

  private Div buildStoolFields() {
    Div container = new Div();
    container.setHeightFull();
    

    // Stool specimen received
    RadioButtonGroup<String> stoolSpecimenReceived = new RadioButtonGroup<>();
    stoolSpecimenReceived.setLabel("Stool specimen received");
    stoolSpecimenReceived.setItems("Yes", "No");
    stoolSpecimenReceived.setRequired(true);

    // Date specimen received
    DatePicker dateSpecimenReceivedStool = new DatePicker("Stool date specimen received");
    dateSpecimenReceivedStool.setMax(LocalDate.now());
    dateSpecimenReceivedStool.setRequired(true);
    dateSpecimenReceivedStool.setVisible(false);

    // Specimen condition
    RadioButtonGroup<String> specimenConditionStool = new RadioButtonGroup<>();
    specimenConditionStool.setLabel("Specimen condition?");
    specimenConditionStool.setItems("Adequate", "Not adequate");
    specimenConditionStool.setRequired(true);
    specimenConditionStool.setVisible(false);

    // Type of test done
    CheckboxGroup<String> typeOfTestDoneStool = new CheckboxGroup<>();
    typeOfTestDoneStool.setLabel("Type of test done");
    typeOfTestDoneStool.setItems("Microscopy", "Culture");
    typeOfTestDoneStool.setVisible(false);

    // Date of specimen tested
    DatePicker dateSpecimenTestedStool = new DatePicker("Date of specimen tested");
    dateSpecimenTestedStool.setMax(LocalDate.now());
    dateSpecimenTestedStool.setRequired(true);
    dateSpecimenTestedStool.setVisible(false);

    // Test result
    RadioButtonGroup<String> testResultStool = new RadioButtonGroup<>();
    testResultStool.setLabel("Test result");
    testResultStool.setItems("Positive", "Negative", "Pending");
    testResultStool.setRequired(true);
    testResultStool.setVisible(false);

    // Date result released
    DatePicker dateResultReleasedStool = new DatePicker("Date result released");
    dateResultReleasedStool.setMax(LocalDate.now());
    dateResultReleasedStool.setRequired(true);
    dateResultReleasedStool.setVisible(false);

    // Show/hide subfields based on "Stool specimen received"
    stoolSpecimenReceived.addValueChangeListener(e -> {
      boolean yes = "Yes".equals(e.getValue());
      dateSpecimenReceivedStool.setVisible(yes);
      specimenConditionStool.setVisible(yes);
      typeOfTestDoneStool.setVisible(yes);
      dateSpecimenTestedStool.setVisible(yes);
      testResultStool.setVisible(yes);
      dateResultReleasedStool.setVisible(yes);
    });

    container.add(stoolSpecimenReceived, dateSpecimenReceivedStool, specimenConditionStool,
        typeOfTestDoneStool, dateSpecimenTestedStool, testResultStool, dateResultReleasedStool);
    return container;
  }

  private Div buildRectalSwabFields() {
    Div container = new Div();
    container.setWidthFull();

    // Rectal swab specimen received
    RadioButtonGroup<String> rectalSwabSpecimenReceived = new RadioButtonGroup<>();
    rectalSwabSpecimenReceived.setLabel("Rectal swab specimen received");
    rectalSwabSpecimenReceived.setItems("Yes", "No");
    rectalSwabSpecimenReceived.setRequired(true);

    // Date specimen received
    DatePicker dateSpecimenReceivedRectalSwab = new DatePicker("Rectal swab date specimen received");
    dateSpecimenReceivedRectalSwab.setMax(LocalDate.now());
    dateSpecimenReceivedRectalSwab.setRequired(true);
    dateSpecimenReceivedRectalSwab.setVisible(false);

    // Specimen condition
    RadioButtonGroup<String> specimenConditionRectalSwab = new RadioButtonGroup<>();
    specimenConditionRectalSwab.setLabel("Specimen condition?");
    specimenConditionRectalSwab.setItems("Adequate", "Not adequate");
    specimenConditionRectalSwab.setRequired(true);
    specimenConditionRectalSwab.setVisible(false);

    // Type of test done
    CheckboxGroup<String> typeOfTestDoneRectalSwab = new CheckboxGroup<>();
    typeOfTestDoneRectalSwab.setLabel("Type of test done");
    typeOfTestDoneRectalSwab.setItems("Microscopy", "Culture");
    typeOfTestDoneRectalSwab.setVisible(false);

    // Date of specimen tested
    DatePicker dateSpecimenTestedRectalSwab = new DatePicker("Date of specimen tested");
    dateSpecimenTestedRectalSwab.setMax(LocalDate.now());
    dateSpecimenTestedRectalSwab.setRequired(true);
    dateSpecimenTestedRectalSwab.setVisible(false);

    // Test result
    RadioButtonGroup<String> testResultRectalSwab = new RadioButtonGroup<>();
    testResultRectalSwab.setLabel("Test result");
    testResultRectalSwab.setItems("Positive", "Negative", "Pending");
    testResultRectalSwab.setRequired(true);
    testResultRectalSwab.setVisible(false);

    // Date result released
    DatePicker dateResultReleasedRectalSwab = new DatePicker("Date result released");
    dateResultReleasedRectalSwab.setMax(LocalDate.now());
    dateResultReleasedRectalSwab.setRequired(true);
    dateResultReleasedRectalSwab.setVisible(false);

    // Show/hide subfields based on "Rectal swab specimen received"
    rectalSwabSpecimenReceived.addValueChangeListener(e -> {
      boolean yes = "Yes".equals(e.getValue());
      dateSpecimenReceivedRectalSwab.setVisible(yes);
      specimenConditionRectalSwab.setVisible(yes);
      typeOfTestDoneRectalSwab.setVisible(yes);
      dateSpecimenTestedRectalSwab.setVisible(yes);
      testResultRectalSwab.setVisible(yes);
      dateResultReleasedRectalSwab.setVisible(yes);
    });

    container.add(rectalSwabSpecimenReceived, dateSpecimenReceivedRectalSwab, specimenConditionRectalSwab,
        typeOfTestDoneRectalSwab, dateSpecimenTestedRectalSwab, testResultRectalSwab, dateResultReleasedRectalSwab);
    return container;
  }
}
