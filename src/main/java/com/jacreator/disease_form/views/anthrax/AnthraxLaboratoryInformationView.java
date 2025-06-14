package com.jacreator.disease_form.views.anthrax;


import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

import java.time.LocalDate;
import java.util.*;

public class AnthraxLaboratoryInformationView extends VerticalLayout {

  // Data sources
  private final List<String> typeSpecimen = Arrays.asList("Blood", "Swab", "Body Fluid", "Tissue", "Stool");
  private final List<String> tests = Arrays.asList("Serology", "Culture", "Others");
  private final List<String> conTest = Arrays.asList("Positive", "Negative", "Indeterminate", "Not done", "Pending");
  private final List<String> infections = Arrays.asList("Cutaneous Anthrax", "Inhalation Anthrax",
      "Gastrointestinal Anthrax", "Injection Anthrax");
  private final List<String> testingLaboratoryData = Arrays.asList(
      "National Reference Laboratory",
      "Central Public health laboratory ",
      "Maitama district hospital laboratory");

  // Main fields
  private final RadioButtonGroup<String> sampleCollected = new RadioButtonGroup<>();
  private final DatePicker dateSpecimenCollected = new DatePicker("Date Specimen collected");
  private final CheckboxGroup<String> sampleType = new CheckboxGroup<>();
  private final DatePicker dateSpecimenSent = new DatePicker("Date Specimen Sent");
  private final ComboBox<String> nameOfTestingLaboratory = new ComboBox<>("Name Of Testing Laboratory");
  private final Div divider = new Div();

  // Specimen sections
  private final Div bloodFields = new Div();
  private final Div swabFields = new Div();
  private final Div bodyFluidFields = new Div();
  private final Div tissueFields = new Div();
  private final Div stoolFields = new Div();

  public AnthraxLaboratoryInformationView() {
    add(createForm());
  }

  private FormLayout createForm() {
    FormLayout formLayout = new FormLayout();

    // Setup main fields
    sampleCollected.setLabel("Sample Collected");
    sampleCollected.setItems("Yes", "No");

    dateSpecimenCollected.setMax(LocalDate.now());
    dateSpecimenCollected.setVisible(false);

    sampleType.setLabel("Type of Specimen collected?");
    sampleType.setItems(typeSpecimen);
    sampleType.setVisible(false);

    dateSpecimenSent.setMax(LocalDate.now());
    dateSpecimenSent.setVisible(false);

    nameOfTestingLaboratory.setItems(testingLaboratoryData);
    nameOfTestingLaboratory.setVisible(false);

    divider.setText("Laboratory result");
    divider.getStyle().set("font-weight", "bold").set("margin", "16px 0 8px 0");
    divider.setVisible(false);

    // Specimen fields
    bloodFields.setVisible(false);
    swabFields.setVisible(false);
    bodyFluidFields.setVisible(false);
    tissueFields.setVisible(false);
    stoolFields.setVisible(false);

    // Dynamic logic for main fields
    sampleCollected.addValueChangeListener(event -> {
      boolean show = "Yes".equals(event.getValue());
      dateSpecimenCollected.setVisible(show);
      sampleType.setVisible(show);
      nameOfTestingLaboratory.setVisible(show);
      divider.setVisible(show);
      if (!show) {
        dateSpecimenSent.setVisible(false);
        bloodFields.setVisible(false);
        swabFields.setVisible(false);
        bodyFluidFields.setVisible(false);
        tissueFields.setVisible(false);
        stoolFields.setVisible(false);
      }
    });

    sampleType.addValueChangeListener(event -> {
      Set<String> selected = event.getValue();
      boolean show = !selected.isEmpty();
      dateSpecimenSent.setVisible(show);
      bloodFields.setVisible(selected.contains("Blood"));
      swabFields.setVisible(selected.contains("Swab"));
      bodyFluidFields.setVisible(selected.contains("Body Fluid"));
      tissueFields.setVisible(selected.contains("Tissue"));
      stoolFields.setVisible(selected.contains("Stool"));
    });

    // Build all specimen sections
    buildBloodFields();
    buildSwabFields();
    buildBodyFluidFields();
    buildTissueFields();
    buildStoolFields();

    formLayout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    // Add all fields to the form
    formLayout.add(
        sampleCollected,
        dateSpecimenCollected,
        sampleType,
        dateSpecimenSent,
        nameOfTestingLaboratory,
        divider,
        bloodFields,
        swabFields,
        bodyFluidFields,
        tissueFields,
        stoolFields);

    return formLayout;
  }

  // BLOOD FIELDS
  private void buildBloodFields() {
    bloodFields.removeAll();

    RadioButtonGroup<String> bloodSampleReceived = new RadioButtonGroup<>();
    bloodSampleReceived.setLabel("Blood sample received");
    bloodSampleReceived.setItems("Yes", "No");

    DatePicker bloodDateReceived = new DatePicker("Date Specimen Received");
    bloodDateReceived.setMax(LocalDate.now());
    bloodDateReceived.setVisible(false);

    TextField bloodLabId = new TextField("Laboratory ID");
    bloodLabId.setVisible(false);

    RadioButtonGroup<String> bloodSpecimenCondition = new RadioButtonGroup<>();
    bloodSpecimenCondition.setLabel("Specimen Condition");
    bloodSpecimenCondition.setItems("Adequate", "Not Adequate");
    bloodSpecimenCondition.setVisible(false);

    RadioButtonGroup<String> bloodSentinelRuledOut = new RadioButtonGroup<>();
    bloodSentinelRuledOut.setLabel("Has sentinel lab ruled out anthrax?");
    bloodSentinelRuledOut.setItems("Yes", "No", "Indeterminate");
    bloodSentinelRuledOut.setVisible(false);

    ComboBox<String> bloodConfirmatoryTestResult = new ComboBox<>("Anthrax confirmatory test result");
    bloodConfirmatoryTestResult.setItems(conTest);
    bloodConfirmatoryTestResult.setVisible(false);

    ComboBox<String> bloodDefinitiveCharacterization = new ComboBox<>("Definitive characterization of infection");
    bloodDefinitiveCharacterization.setItems(infections);
    bloodDefinitiveCharacterization.setVisible(false);

    DatePicker bloodDateConfirmatorySent = new DatePicker("Date confirmatory lab result sent out");
    bloodDateConfirmatorySent.setMax(LocalDate.now());
    bloodDateConfirmatorySent.setVisible(false);

    // Dynamic logic for blood fields
    bloodSampleReceived.addValueChangeListener(e -> {
      boolean yes = "Yes".equals(e.getValue());
      bloodDateReceived.setVisible(yes);
      bloodLabId.setVisible(yes);
      bloodSpecimenCondition.setVisible(yes);
      bloodSentinelRuledOut.setVisible(yes);
      bloodConfirmatoryTestResult.setVisible(yes);
      bloodDefinitiveCharacterization.setVisible(yes);
      bloodDateConfirmatorySent.setVisible(yes);
    });

    bloodFields.add(
        bloodSampleReceived,
        bloodDateReceived,
        bloodLabId,
        bloodSpecimenCondition,
        bloodSentinelRuledOut,
        bloodConfirmatoryTestResult,
        bloodDefinitiveCharacterization,
        bloodDateConfirmatorySent);
  }

  // SWAB FIELDS
  private void buildSwabFields() {
    swabFields.removeAll();

    RadioButtonGroup<String> swabSampleReceived = new RadioButtonGroup<>();
    swabSampleReceived.setLabel("Swab sample received");
    swabSampleReceived.setItems("Yes", "No");

    DatePicker swabDateReceived = new DatePicker("Date Specimen Received");
    swabDateReceived.setMax(LocalDate.now());
    swabDateReceived.setVisible(false);

    TextField swabLabId = new TextField("Laboratory ID");
    swabLabId.setVisible(false);

    RadioButtonGroup<String> swabSpecimenCondition = new RadioButtonGroup<>();
    swabSpecimenCondition.setLabel("Specimen Condition");
    swabSpecimenCondition.setItems("Adequate", "Not Adequate");
    swabSpecimenCondition.setVisible(false);

    RadioButtonGroup<String> swabSentinelRuledOut = new RadioButtonGroup<>();
    swabSentinelRuledOut.setLabel("Has sentinel lab ruled out anthrax?");
    swabSentinelRuledOut.setItems("Yes", "No", "Indeterminate");
    swabSentinelRuledOut.setVisible(false);

    ComboBox<String> swabConfirmatoryTestResult = new ComboBox<>("Anthrax confirmatory test result");
    swabConfirmatoryTestResult.setItems(conTest);
    swabConfirmatoryTestResult.setVisible(false);

    ComboBox<String> swabDefinitiveCharacterization = new ComboBox<>("Definitive characterization of infection");
    swabDefinitiveCharacterization.setItems(infections);
    swabDefinitiveCharacterization.setVisible(false);

    DatePicker swabDateConfirmatorySent = new DatePicker("Date confirmatory lab result sent out");
    swabDateConfirmatorySent.setMax(LocalDate.now());
    swabDateConfirmatorySent.setVisible(false);

    // Dynamic logic for swab fields
    swabSampleReceived.addValueChangeListener(e -> {
      boolean yes = "Yes".equals(e.getValue());
      swabDateReceived.setVisible(yes);
      swabLabId.setVisible(yes);
      swabSpecimenCondition.setVisible(yes);
      swabSentinelRuledOut.setVisible(yes);
      swabConfirmatoryTestResult.setVisible(yes);
      swabDefinitiveCharacterization.setVisible(yes);
      swabDateConfirmatorySent.setVisible(yes);
    });

    swabFields.add(
        swabSampleReceived,
        swabDateReceived,
        swabLabId,
        swabSpecimenCondition,
        swabSentinelRuledOut,
        swabConfirmatoryTestResult,
        swabDefinitiveCharacterization,
        swabDateConfirmatorySent);
  }

  // BODY FLUID FIELDS
  private void buildBodyFluidFields() {
    bodyFluidFields.removeAll();

    RadioButtonGroup<String> bodyFluidSampleReceived = new RadioButtonGroup<>();
    bodyFluidSampleReceived.setLabel("Body Fluid sample received");
    bodyFluidSampleReceived.setItems("Yes", "No");

    DatePicker bodyFluidDateReceived = new DatePicker("Date Specimen Received");
    bodyFluidDateReceived.setMax(LocalDate.now());
    bodyFluidDateReceived.setVisible(false);

    TextField bodyFluidLabId = new TextField("Laboratory ID");
    bodyFluidLabId.setVisible(false);

    RadioButtonGroup<String> bodyFluidSpecimenCondition = new RadioButtonGroup<>();
    bodyFluidSpecimenCondition.setLabel("Specimen Condition");
    bodyFluidSpecimenCondition.setItems("Adequate", "Not Adequate");
    bodyFluidSpecimenCondition.setVisible(false);

    RadioButtonGroup<String> bodyFluidSentinelRuledOut = new RadioButtonGroup<>();
    bodyFluidSentinelRuledOut.setLabel("Has sentinel lab ruled out anthrax?");
    bodyFluidSentinelRuledOut.setItems("Yes", "No", "Indeterminate");
    bodyFluidSentinelRuledOut.setVisible(false);

    ComboBox<String> bodyFluidConfirmatoryTestResult = new ComboBox<>("Anthrax confirmatory test result");
    bodyFluidConfirmatoryTestResult.setItems(conTest);
    bodyFluidConfirmatoryTestResult.setVisible(false);

    ComboBox<String> bodyFluidDefinitiveCharacterization = new ComboBox<>("Definitive characterization of infection");
    bodyFluidDefinitiveCharacterization.setItems(infections);
    bodyFluidDefinitiveCharacterization.setVisible(false);

    DatePicker bodyFluidDateConfirmatorySent = new DatePicker("Date confirmatory lab result sent out");
    bodyFluidDateConfirmatorySent.setMax(LocalDate.now());
    bodyFluidDateConfirmatorySent.setVisible(false);

    // Dynamic logic for body fluid fields
    bodyFluidSampleReceived.addValueChangeListener(e -> {
      boolean yes = "Yes".equals(e.getValue());
      bodyFluidDateReceived.setVisible(yes);
      bodyFluidLabId.setVisible(yes);
      bodyFluidSpecimenCondition.setVisible(yes);
      bodyFluidSentinelRuledOut.setVisible(yes);
      bodyFluidConfirmatoryTestResult.setVisible(yes);
      bodyFluidDefinitiveCharacterization.setVisible(yes);
      bodyFluidDateConfirmatorySent.setVisible(yes);
    });

    bodyFluidFields.add(
        bodyFluidSampleReceived,
        bodyFluidDateReceived,
        bodyFluidLabId,
        bodyFluidSpecimenCondition,
        bodyFluidSentinelRuledOut,
        bodyFluidConfirmatoryTestResult,
        bodyFluidDefinitiveCharacterization,
        bodyFluidDateConfirmatorySent);
  }

  // TISSUE FIELDS
  private void buildTissueFields() {
    tissueFields.removeAll();

    RadioButtonGroup<String> tissueSampleReceived = new RadioButtonGroup<>();
    tissueSampleReceived.setLabel("Tissue sample received");
    tissueSampleReceived.setItems("Yes", "No");

    DatePicker tissueDateReceived = new DatePicker("Date Specimen Received");
    tissueDateReceived.setMax(LocalDate.now());
    tissueDateReceived.setVisible(false);

    TextField tissueLabId = new TextField("Laboratory ID");
    tissueLabId.setVisible(false);

    RadioButtonGroup<String> tissueSpecimenCondition = new RadioButtonGroup<>();
    tissueSpecimenCondition.setLabel("Specimen Condition");
    tissueSpecimenCondition.setItems("Adequate", "Not Adequate");
    tissueSpecimenCondition.setVisible(false);

    RadioButtonGroup<String> tissueSentinelRuledOut = new RadioButtonGroup<>();
    tissueSentinelRuledOut.setLabel("Has sentinel lab ruled out anthrax?");
    tissueSentinelRuledOut.setItems("Yes", "No", "Indeterminate");
    tissueSentinelRuledOut.setVisible(false);

    ComboBox<String> tissueConfirmatoryTestResult = new ComboBox<>("Anthrax confirmatory test result");
    tissueConfirmatoryTestResult.setItems(conTest);
    tissueConfirmatoryTestResult.setVisible(false);

    ComboBox<String> tissueDefinitiveCharacterization = new ComboBox<>("Definitive characterization of infection");
    tissueDefinitiveCharacterization.setItems(infections);
    tissueDefinitiveCharacterization.setVisible(false);

    DatePicker tissueDateConfirmatorySent = new DatePicker("Date confirmatory lab result sent out");
    tissueDateConfirmatorySent.setMax(LocalDate.now());
    tissueDateConfirmatorySent.setVisible(false);

    // Dynamic logic for tissue fields
    tissueSampleReceived.addValueChangeListener(e -> {
      boolean yes = "Yes".equals(e.getValue());
      tissueDateReceived.setVisible(yes);
      tissueLabId.setVisible(yes);
      tissueSpecimenCondition.setVisible(yes);
      tissueSentinelRuledOut.setVisible(yes);
      tissueConfirmatoryTestResult.setVisible(yes);
      tissueDefinitiveCharacterization.setVisible(yes);
      tissueDateConfirmatorySent.setVisible(yes);
    });

    tissueFields.add(
        tissueSampleReceived,
        tissueDateReceived,
        tissueLabId,
        tissueSpecimenCondition,
        tissueSentinelRuledOut,
        tissueConfirmatoryTestResult,
        tissueDefinitiveCharacterization,
        tissueDateConfirmatorySent);
  }

  // STOOL FIELDS
  private void buildStoolFields() {
    stoolFields.removeAll();

    RadioButtonGroup<String> stoolSampleReceived = new RadioButtonGroup<>();
    stoolSampleReceived.setLabel("Stool sample received");
    stoolSampleReceived.setItems("Yes", "No");

    DatePicker stoolDateReceived = new DatePicker("Date Specimen Received");
    stoolDateReceived.setMax(LocalDate.now());
    stoolDateReceived.setVisible(false);

    TextField stoolLabId = new TextField("Laboratory ID");
    stoolLabId.setVisible(false);

    RadioButtonGroup<String> stoolSpecimenCondition = new RadioButtonGroup<>();
    stoolSpecimenCondition.setLabel("Specimen Condition");
    stoolSpecimenCondition.setItems("Adequate", "Not Adequate");
    stoolSpecimenCondition.setVisible(false);

    RadioButtonGroup<String> stoolSentinelRuledOut = new RadioButtonGroup<>();
    stoolSentinelRuledOut.setLabel("Has sentinel lab ruled out anthrax?");
    stoolSentinelRuledOut.setItems("Yes", "No", "Indeterminate");
    stoolSentinelRuledOut.setVisible(false);

    ComboBox<String> stoolConfirmatoryTestResult = new ComboBox<>("Anthrax confirmatory test result");
    stoolConfirmatoryTestResult.setItems(conTest);
    stoolConfirmatoryTestResult.setVisible(false);

    ComboBox<String> stoolDefinitiveCharacterization = new ComboBox<>("Definitive characterization of infection");
    stoolDefinitiveCharacterization.setItems(infections);
    stoolDefinitiveCharacterization.setVisible(false);

    DatePicker stoolDateConfirmatorySent = new DatePicker("Date confirmatory lab result sent out");
    stoolDateConfirmatorySent.setMax(LocalDate.now());
    stoolDateConfirmatorySent.setVisible(false);

    // Dynamic logic for stool fields
    stoolSampleReceived.addValueChangeListener(e -> {
      boolean yes = "Yes".equals(e.getValue());
      stoolDateReceived.setVisible(yes);
      stoolLabId.setVisible(yes);
      stoolSpecimenCondition.setVisible(yes);
      stoolSentinelRuledOut.setVisible(yes);
      stoolConfirmatoryTestResult.setVisible(yes);
      stoolDefinitiveCharacterization.setVisible(yes);
      stoolDateConfirmatorySent.setVisible(yes);
    });

    stoolFields.add(
        stoolSampleReceived,
        stoolDateReceived,
        stoolLabId,
        stoolSpecimenCondition,
        stoolSentinelRuledOut,
        stoolConfirmatoryTestResult,
        stoolDefinitiveCharacterization,
        stoolDateConfirmatorySent);
  }
}