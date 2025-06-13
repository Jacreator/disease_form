package com.jacreator.disease_form.views.guinea_worm;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class GuineaWormLaboratoryInformationView extends VerticalLayout {
  // Main form state
  private RadioButtonGroup<String> sampleCollected;
  private Div sampleCollectedSection;
  private RadioButtonGroup<String> specimenPreserved;
  private TextField ifNoWhy;
  private DatePicker dateSpecimenCollected;
  private CheckboxGroup<String> sampleType;
  private DatePicker dateSpecimenSent;
  private TextField specifyIfOthers;
  private ComboBox<String> nameOfTestingLaboratory;

  // Blood sample fields
  private RadioButtonGroup<String> bloodSampleReceived;
  private Div bloodSection;
  private DatePicker bloodDateSpecimenReceived;
  private TextField bloodLabId;
  private RadioButtonGroup<String> bloodSpecimenCondition;
  private DatePicker bloodDateConfirmatoryLabResult;
  private CheckboxGroup<String> bloodTestConducted;

  // Blood PCR fields
  private Div bloodPcrSection;
  private RadioButtonGroup<String> bloodPcrResult;
  private DatePicker bloodPcrDateResultAvailable;
  private DatePicker bloodPcrDateResultSent;

  // Blood RDT fields
  private Div bloodRdtSection;
  private RadioButtonGroup<String> bloodRdtResult;
  private DatePicker bloodRdtDateResultAvailable;
  private DatePicker bloodRdtDateResultSentOut;

  // Blood Culture fields
  private Div bloodCultureSection;
  private RadioButtonGroup<String> bloodCultureResult;
  private DatePicker bloodCultureDateResultAvailable;
  private DatePicker bloodCultureDateResultSentOut;

  // Swab sample fields
  private RadioButtonGroup<String> swabSampleReceived;
  private Div swabSection;
  private DatePicker swabDateSpecimenReceived;
  private TextField swabLabId;
  private RadioButtonGroup<String> swabSpecimenCondition;
  private RadioButtonGroup<String> swabTypeOfTest;
  private RadioButtonGroup<String> swabHasSentinelLab;
  private DatePicker swabDateSpecimenSentForConfirmation;
  private CheckboxGroup<String> swabTestConducted;

  // Swab test result sections
  private Div swabPcrSection;
  private RadioButtonGroup<String> swabPcrResult;
  private DatePicker swabPcrDateResultAvailable;
  private DatePicker swabPcrDateResultSentOut;

  private Div swabRdtSection;
  private RadioButtonGroup<String> swabRdtResult;
  private DatePicker swabRdtDateResultAvailable;
  private DatePicker swabRdtDateResultSentOut;

  private Div swabCultureSection;
  private RadioButtonGroup<String> swabCultureResult;
  private DatePicker swabCultureDateResultAvailable;
  private DatePicker swabCultureDateResultSentOut;

  // Body Fluid sample fields
  private RadioButtonGroup<String> bodyFluidSampleReceived;
  private Div bodyFluidSection;
  private DatePicker bodyFluidDateSpecimenReceived;
  private TextField bodyFluidLabId;
  private RadioButtonGroup<String> bodyFluidSpecimenCondition;
  private DatePicker bodyFluidDateConfirmatoryLabResult;
  private CheckboxGroup<String> bodyFluidTestConducted;

  // Body Fluid test sections
  private Div bodyFluidPcrSection;
  private RadioButtonGroup<String> bodyFluidPcrResult;
  private DatePicker bodyFluidPcrDateResultAvailable;
  private DatePicker bodyFluidPcrDateResultSent;

  private Div bodyFluidRdtSection;
  private RadioButtonGroup<String> bodyFluidRdtResult;
  private DatePicker bodyFluidRdtDateResultAvailable;
  private DatePicker bodyFluidRdtDateResultSentOut;

  private Div bodyFluidCultureSection;
  private RadioButtonGroup<String> bodyFluidCultureResult;
  private DatePicker bodyFluidCultureDateResultAvailable;
  private DatePicker bodyFluidCultureDateResultSentOut;

  // Tissue sample fields
  private RadioButtonGroup<String> tissueSampleReceived;
  private Div tissueSection;
  private DatePicker tissueDateSpecimenReceived;
  private TextField tissueLabId;
  private RadioButtonGroup<String> tissueSpecimenCondition;
  private DatePicker tissueDateConfirmatoryLabResult;
  private CheckboxGroup<String> tissueTestConducted;

  // Tissue test sections
  private Div tissuePcrSection;
  private RadioButtonGroup<String> tissuePcrResult;
  private DatePicker tissuePcrDateResultAvailable;
  private DatePicker tissuePcrDateResultSent;

  private Div tissueRdtSection;
  private RadioButtonGroup<String> tissueRdtResult;
  private DatePicker tissueRdtDateResultAvailable;
  private DatePicker tissueRdtDateResultSentOut;

  private Div tissueCultureSection;
  private RadioButtonGroup<String> tissueCultureResult;
  private DatePicker tissueCultureDateResultAvailable;
  private DatePicker tissueCultureDateResultSentOut;

  // Stool sample fields
  private RadioButtonGroup<String> stoolSampleReceived;
  private Div stoolSection;
  private DatePicker stoolDateSpecimenReceived;
  private TextField stoolLabId;
  private RadioButtonGroup<String> stoolSpecimenCondition;
  private DatePicker stoolDateConfirmatoryLabResult;
  private CheckboxGroup<String> stoolTestConducted;

  // Stool test sections
  private Div stoolPcrSection;
  private RadioButtonGroup<String> stoolPcrResult;
  private DatePicker stoolPcrDateResultAvailable;
  private DatePicker stoolPcrDateResultSent;

  private Div stoolRdtSection;
  private RadioButtonGroup<String> stoolRdtResult;
  private DatePicker stoolRdtDateResultAvailable;
  private DatePicker stoolRdtDateResultSentOut;

  private Div stoolCultureSection;
  private RadioButtonGroup<String> stoolCultureResult;
  private DatePicker stoolCultureDateResultAvailable;
  private DatePicker stoolCultureDateResultSentOut;

  public GuineaWormLaboratoryInformationView() {
        setWidthFull();
        setPadding(true);
        setSpacing(true);
        add(buildForm());
    }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();
    form.setWidthFull();

    // Was a Sample Collected?
    sampleCollected = new RadioButtonGroup<>();
    sampleCollected.setLabel("Was a Sample Collected?");
    sampleCollected.setItems("Yes", "No");
    sampleCollected.setRequired(true);

    // Main conditional section for when sample is collected
    sampleCollectedSection = new Div();
    sampleCollectedSection.setVisible(false);

    // Was a specimen (worm) saved and preserved in alcohol?
    specimenPreserved = new RadioButtonGroup<>();
    specimenPreserved.setLabel("Was a specimen (worm) saved and preserved in alcohol?");
    specimenPreserved.setItems("Yes", "No");
    specimenPreserved.setRequired(true);

    // If No, Why? (conditional)
    ifNoWhy = new TextField("If No, Why?");
    ifNoWhy.setPlaceholder("If No, Why?");
    ifNoWhy.setVisible(false);

    // Date Specimen collected
    dateSpecimenCollected = new DatePicker("Date Specimen collected");
    dateSpecimenCollected.setMax(LocalDate.now());
    dateSpecimenCollected.setRequired(true);

    // Type of Specimen collected?
    sampleType = new CheckboxGroup<>();
    sampleType.setLabel("Type of Specimen collected?");
    sampleType.setItems("Blood", "Swab", "Body Fluid", "Tissue", "Stool", "Others");
    sampleType.setRequired(true);

    // Date Specimen sent to lab (conditional)
    dateSpecimenSent = new DatePicker("Date Specimen sent to lab");
    dateSpecimenSent.setMax(LocalDate.now());
    dateSpecimenSent.setRequired(true);
    dateSpecimenSent.setVisible(false);

    // Specify (conditional for Others)
    specifyIfOthers = new TextField("Specify");
    specifyIfOthers.setPlaceholder("Specify");
    specifyIfOthers.setVisible(false);

    // Name Of Testing Laboratory
    nameOfTestingLaboratory = new ComboBox<>("Name Of Testing Laboratory");
    nameOfTestingLaboratory.setItems(Arrays.asList(
        "National Reference Laboratory",
        "Central Public health laboratory",
        "Maitama district hospital laboratory"));
    nameOfTestingLaboratory.setRequired(true);

    // Laboratory result divider
    Hr divider = new Hr();
    divider.getStyle().set("margin", "20px 0");

    // Blood sample section
    bloodSampleReceived = new RadioButtonGroup<>();
    bloodSampleReceived.setLabel("Blood sample received");
    bloodSampleReceived.setItems("Yes", "No");
    bloodSampleReceived.setRequired(true);
    bloodSampleReceived.setVisible(false);

    bloodSection = createBloodSection();
    bloodSection.setVisible(false);

    // Swab sample section
    swabSampleReceived = new RadioButtonGroup<>();
    swabSampleReceived.setLabel("Swab sample received");
    swabSampleReceived.setItems("Yes", "No");
    swabSampleReceived.setRequired(true);
    swabSampleReceived.setVisible(false);

    swabSection = createSwabSection();
    swabSection.setVisible(false);

    // Body Fluid sample section
    bodyFluidSampleReceived = new RadioButtonGroup<>();
    bodyFluidSampleReceived.setLabel("Body Fluid sample received");
    bodyFluidSampleReceived.setItems("Yes", "No");
    bodyFluidSampleReceived.setRequired(true);
    bodyFluidSampleReceived.setVisible(false);

    bodyFluidSection = createBodyFluidSection();
    bodyFluidSection.setVisible(false);

    // Tissue sample section
    tissueSampleReceived = new RadioButtonGroup<>();
    tissueSampleReceived.setLabel("Tissue sample received");
    tissueSampleReceived.setItems("Yes", "No");
    tissueSampleReceived.setRequired(true);
    tissueSampleReceived.setVisible(false);

    tissueSection = createTissueSection();
    tissueSection.setVisible(false);

    // Stool sample section
    stoolSampleReceived = new RadioButtonGroup<>();
    stoolSampleReceived.setLabel("Stool sample received");
    stoolSampleReceived.setItems("Yes", "No");
    stoolSampleReceived.setRequired(true);
    stoolSampleReceived.setVisible(false);

    stoolSection = createStoolSection();
    stoolSection.setVisible(false);

    // Add event listeners for conditional logic
    setupEventListeners();

    // Add components to the collected section
    sampleCollectedSection.add(
        specimenPreserved,
        ifNoWhy,
        dateSpecimenCollected,
        sampleType,
        dateSpecimenSent,
        specifyIfOthers,
        nameOfTestingLaboratory,
        divider,
        bloodSampleReceived,
        bloodSection,
        swabSampleReceived,
        swabSection,
        bodyFluidSampleReceived,
        bodyFluidSection,
        tissueSampleReceived,
        tissueSection,
        stoolSampleReceived,
        stoolSection);

    // Responsive steps
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("800px", 2));

    // Add all fields to the form
    form.add(sampleCollected);
    form.setColspan(sampleCollected, 2);

    form.add(sampleCollectedSection);
    form.setColspan(sampleCollectedSection, 2);

    return form;
  }

  private Div createBloodSection() {
    Div section = new Div();
    section.getStyle().set("border", "1px solid #e0e0e0")
        .set("padding", "15px")
        .set("margin", "10px 0")
        .set("border-radius", "5px");

    H3 header = new H3("Blood Sample Details");
    header.getStyle().set("margin-top", "0");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    bloodDateSpecimenReceived = new DatePicker("Date lab received specimen");
    bloodDateSpecimenReceived.setMax(LocalDate.now());
    bloodDateSpecimenReceived.setRequired(true);

    bloodLabId = new TextField("Laboratory ID");
    bloodLabId.setPlaceholder("Enter Lab ID");

    bloodSpecimenCondition = new RadioButtonGroup<>();
    bloodSpecimenCondition.setLabel("Specimen condition");
    bloodSpecimenCondition.setItems("Adequate", "Not Adequate");
    bloodSpecimenCondition.setRequired(true);

    bloodDateConfirmatoryLabResult = new DatePicker("Date Specimen sent to Reference lab for confirmation");
    bloodDateConfirmatoryLabResult.setMax(LocalDate.now());

    bloodTestConducted = new CheckboxGroup<>();
    bloodTestConducted.setLabel("Test Conducted");
    bloodTestConducted.setItems("PCR", "RDT", "Culture");
    bloodTestConducted.setRequired(true);

    // PCR section
    bloodPcrSection = createBloodPcrSection();
    bloodPcrSection.setVisible(false);

    // RDT section
    bloodRdtSection = createBloodRdtSection();
    bloodRdtSection.setVisible(false);

    // Culture section
    bloodCultureSection = createBloodCultureSection();
    bloodCultureSection.setVisible(false);

    layout.add(
        bloodDateSpecimenReceived,
        bloodLabId,
        bloodSpecimenCondition,
        bloodDateConfirmatoryLabResult,
        bloodTestConducted);

    layout.setColspan(bloodTestConducted, 2);

    section.add(header, layout, bloodPcrSection, bloodRdtSection, bloodCultureSection);
    return section;
  }

  private Div createBloodPcrSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("PCR Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    bloodPcrResult = new RadioButtonGroup<>();
    bloodPcrResult.setLabel("PCR result");
    bloodPcrResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    bloodPcrResult.setRequired(true);

    bloodPcrDateResultAvailable = new DatePicker("Date result is available");
    bloodPcrDateResultAvailable.setMax(LocalDate.now());
    bloodPcrDateResultAvailable.setRequired(true);

    bloodPcrDateResultSent = new DatePicker("Date result sent out");
    bloodPcrDateResultSent.setMax(LocalDate.now());
    bloodPcrDateResultSent.setRequired(true);

    layout.add(bloodPcrResult, bloodPcrDateResultAvailable, bloodPcrDateResultSent);
    layout.setColspan(bloodPcrResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createBloodRdtSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("RDT Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    bloodRdtResult = new RadioButtonGroup<>();
    bloodRdtResult.setLabel("RDT result");
    bloodRdtResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    bloodRdtResult.setRequired(true);

    bloodRdtDateResultAvailable = new DatePicker("Date result is available");
    bloodRdtDateResultAvailable.setMax(LocalDate.now());
    bloodRdtDateResultAvailable.setRequired(true);

    bloodRdtDateResultSentOut = new DatePicker("Date result sent out");
    bloodRdtDateResultSentOut.setMax(LocalDate.now());
    bloodRdtDateResultSentOut.setRequired(true);

    layout.add(bloodRdtResult, bloodRdtDateResultAvailable, bloodRdtDateResultSentOut);
    layout.setColspan(bloodRdtResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createBloodCultureSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("Culture Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    bloodCultureResult = new RadioButtonGroup<>();
    bloodCultureResult.setLabel("Culture result");
    bloodCultureResult.setItems("Growth", "No Growth");
    bloodCultureResult.setRequired(true);

    bloodCultureDateResultAvailable = new DatePicker("Date result is available");
    bloodCultureDateResultAvailable.setMax(LocalDate.now());
    bloodCultureDateResultAvailable.setRequired(true);
    bloodCultureDateResultAvailable.setVisible(false);

    bloodCultureDateResultSentOut = new DatePicker("Date Result Sent Out");
    bloodCultureDateResultSentOut.setMax(LocalDate.now());
    bloodCultureDateResultSentOut.setRequired(true);
    bloodCultureDateResultSentOut.setVisible(false);

    layout.add(bloodCultureResult, bloodCultureDateResultAvailable, bloodCultureDateResultSentOut);
    layout.setColspan(bloodCultureResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createSwabSection() {
    Div section = new Div();
    section.getStyle().set("border", "1px solid #e0e0e0")
        .set("padding", "15px")
        .set("margin", "10px 0")
        .set("border-radius", "5px");

    H3 header = new H3("Swab Sample Details");
    header.getStyle().set("margin-top", "0");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    swabDateSpecimenReceived = new DatePicker("Date Specimen Received");
    swabDateSpecimenReceived.setMax(LocalDate.now());
    swabDateSpecimenReceived.setRequired(true);

    swabLabId = new TextField("Laboratory ID");
    swabLabId.setPlaceholder("Enter Lab ID");

    swabSpecimenCondition = new RadioButtonGroup<>();
    swabSpecimenCondition.setLabel("Specimen Condition");
    swabSpecimenCondition.setItems("Adequate", "Not Adequate");
    swabSpecimenCondition.setRequired(true);

    swabTypeOfTest = new RadioButtonGroup<>();
    swabTypeOfTest.setLabel("Type of test");
    swabTypeOfTest.setItems("Serology", "Culture", "Others");

    swabHasSentinelLab = new RadioButtonGroup<>();
    swabHasSentinelLab.setLabel("Has sentinel lab ruled out anthrax?");
    swabHasSentinelLab.setItems("Yes", "No", "Indeterminate");
    swabHasSentinelLab.setRequired(true);

    swabDateSpecimenSentForConfirmation = new DatePicker(
        "If no/indeterminate, date specimen sent to reference lab for confirmation");
    swabDateSpecimenSentForConfirmation.setMax(LocalDate.now());
    swabDateSpecimenSentForConfirmation.setVisible(false);

    swabTestConducted = new CheckboxGroup<>();
    swabTestConducted.setLabel("Test Conducted");
    swabTestConducted.setItems("PCR", "RDT", "Culture");
    swabTestConducted.setRequired(true);

    // Create test result sections for swab
    swabPcrSection = createSwabPcrSection();
    swabPcrSection.setVisible(false);

    swabRdtSection = createSwabRdtSection();
    swabRdtSection.setVisible(false);

    swabCultureSection = createSwabCultureSection();
    swabCultureSection.setVisible(false);

    layout.add(
        swabDateSpecimenReceived,
        swabLabId,
        swabSpecimenCondition,
        swabTypeOfTest,
        swabHasSentinelLab,
        swabDateSpecimenSentForConfirmation,
        swabTestConducted);

    layout.setColspan(swabHasSentinelLab, 2);
    layout.setColspan(swabDateSpecimenSentForConfirmation, 2);
    layout.setColspan(swabTestConducted, 2);

    section.add(header, layout, swabPcrSection, swabRdtSection, swabCultureSection);
    return section;
  }

  private Div createSwabPcrSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("Swab PCR Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    swabPcrResult = new RadioButtonGroup<>();
    swabPcrResult.setLabel("PCR result");
    swabPcrResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    swabPcrResult.setRequired(true);

    swabPcrDateResultAvailable = new DatePicker("Date result is available");
    swabPcrDateResultAvailable.setMax(LocalDate.now());
    swabPcrDateResultAvailable.setRequired(true);

    swabPcrDateResultSentOut = new DatePicker("Date result sent out");
    swabPcrDateResultSentOut.setMax(LocalDate.now());
    swabPcrDateResultSentOut.setRequired(true);

    layout.add(swabPcrResult, swabPcrDateResultAvailable, swabPcrDateResultSentOut);
    layout.setColspan(swabPcrResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createSwabRdtSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("Swab RDT Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    swabRdtResult = new RadioButtonGroup<>();
    swabRdtResult.setLabel("RDT result");
    swabRdtResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    swabRdtResult.setRequired(true);

    swabRdtDateResultAvailable = new DatePicker("Date result is available");
    swabRdtDateResultAvailable.setMax(LocalDate.now());
    swabRdtDateResultAvailable.setRequired(true);

    swabRdtDateResultSentOut = new DatePicker("Date result sent out");
    swabRdtDateResultSentOut.setMax(LocalDate.now());
    swabRdtDateResultSentOut.setRequired(true);

    layout.add(swabRdtResult, swabRdtDateResultAvailable, swabRdtDateResultSentOut);
    layout.setColspan(swabRdtResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createSwabCultureSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("Swab Culture Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    swabCultureResult = new RadioButtonGroup<>();
    swabCultureResult.setLabel("Culture result");
    swabCultureResult.setItems("Growth", "No Growth");
    swabCultureResult.setRequired(true);

    swabCultureDateResultAvailable = new DatePicker("Date result is available");
    swabCultureDateResultAvailable.setMax(LocalDate.now());
    swabCultureDateResultAvailable.setRequired(true);

    swabCultureDateResultSentOut = new DatePicker("Date result sent out");
    swabCultureDateResultSentOut.setMax(LocalDate.now());
    swabCultureDateResultSentOut.setRequired(true);

    layout.add(swabCultureResult, swabCultureDateResultAvailable, swabCultureDateResultSentOut);
    layout.setColspan(swabCultureResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createBodyFluidSection() {
    Div section = new Div();
    section.getStyle().set("border", "1px solid #e0e0e0")
        .set("padding", "15px")
        .set("margin", "10px 0")
        .set("border-radius", "5px");

    H3 header = new H3("Body Fluid Sample Details");
    header.getStyle().set("margin-top", "0");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    bodyFluidDateSpecimenReceived = new DatePicker("Date lab received specimen");
    bodyFluidDateSpecimenReceived.setMax(LocalDate.now());
    bodyFluidDateSpecimenReceived.setRequired(true);

    bodyFluidLabId = new TextField("Laboratory ID");
    bodyFluidLabId.setPlaceholder("Enter Lab ID");

    bodyFluidSpecimenCondition = new RadioButtonGroup<>();
    bodyFluidSpecimenCondition.setLabel("Specimen condition");
    bodyFluidSpecimenCondition.setItems("Adequate", "Not Adequate");
    bodyFluidSpecimenCondition.setRequired(true);

    bodyFluidDateConfirmatoryLabResult = new DatePicker("Date Specimen sent to Reference lab for confirmation");
    bodyFluidDateConfirmatoryLabResult.setMax(LocalDate.now());

    bodyFluidTestConducted = new CheckboxGroup<>();
    bodyFluidTestConducted.setLabel("Test Conducted");
    bodyFluidTestConducted.setItems("PCR", "RDT", "Culture");
    bodyFluidTestConducted.setRequired(true);

    // Create test result sections
    bodyFluidPcrSection = createBodyFluidPcrSection();
    bodyFluidPcrSection.setVisible(false);

    bodyFluidRdtSection = createBodyFluidRdtSection();
    bodyFluidRdtSection.setVisible(false);

    bodyFluidCultureSection = createBodyFluidCultureSection();
    bodyFluidCultureSection.setVisible(false);

    layout.add(
        bodyFluidDateSpecimenReceived,
        bodyFluidLabId,
        bodyFluidSpecimenCondition,
        bodyFluidDateConfirmatoryLabResult,
        bodyFluidTestConducted);

    layout.setColspan(bodyFluidTestConducted, 2);

    section.add(header, layout, bodyFluidPcrSection, bodyFluidRdtSection, bodyFluidCultureSection);
    return section;
  }

  private Div createBodyFluidPcrSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("Body Fluid PCR Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    bodyFluidPcrResult = new RadioButtonGroup<>();
    bodyFluidPcrResult.setLabel("PCR result");
    bodyFluidPcrResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    bodyFluidPcrResult.setRequired(true);

    bodyFluidPcrDateResultAvailable = new DatePicker("Date result is available");
    bodyFluidPcrDateResultAvailable.setMax(LocalDate.now());
    bodyFluidPcrDateResultAvailable.setRequired(true);

    bodyFluidPcrDateResultSent = new DatePicker("Date result sent out");
    bodyFluidPcrDateResultSent.setMax(LocalDate.now());
    bodyFluidPcrDateResultSent.setRequired(true);

    layout.add(bodyFluidPcrResult, bodyFluidPcrDateResultAvailable, bodyFluidPcrDateResultSent);
    layout.setColspan(bodyFluidPcrResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createBodyFluidRdtSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("Body Fluid RDT Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    bodyFluidRdtResult = new RadioButtonGroup<>();
    bodyFluidRdtResult.setLabel("RDT result");
    bodyFluidRdtResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    bodyFluidRdtResult.setRequired(true);

    bodyFluidRdtDateResultAvailable = new DatePicker("Date result is available");
    bodyFluidRdtDateResultAvailable.setMax(LocalDate.now());
    bodyFluidRdtDateResultAvailable.setRequired(true);

    bodyFluidRdtDateResultSentOut = new DatePicker("Date result sent out");
    bodyFluidRdtDateResultSentOut.setMax(LocalDate.now());
    bodyFluidRdtDateResultSentOut.setRequired(true);

    layout.add(bodyFluidRdtResult, bodyFluidRdtDateResultAvailable, bodyFluidRdtDateResultSentOut);
    layout.setColspan(bodyFluidRdtResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createBodyFluidCultureSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("Body Fluid Culture Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    bodyFluidCultureResult = new RadioButtonGroup<>();
    bodyFluidCultureResult.setLabel("Culture result");
    bodyFluidCultureResult.setItems("Growth", "No Growth");
    bodyFluidCultureResult.setRequired(true);

    bodyFluidCultureDateResultAvailable = new DatePicker("Date result is available");
    bodyFluidCultureDateResultAvailable.setMax(LocalDate.now());
    bodyFluidCultureDateResultAvailable.setRequired(true);

    bodyFluidCultureDateResultSentOut = new DatePicker("Date result sent out");
    bodyFluidCultureDateResultSentOut.setMax(LocalDate.now());
    bodyFluidCultureDateResultSentOut.setRequired(true);

    layout.add(bodyFluidCultureResult, bodyFluidCultureDateResultAvailable, bodyFluidCultureDateResultSentOut);
    layout.setColspan(bodyFluidCultureResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createTissueSection() {
    Div section = new Div();
    section.getStyle().set("border", "1px solid #e0e0e0")
        .set("padding", "15px")
        .set("margin", "10px 0")
        .set("border-radius", "5px");

    H3 header = new H3("Tissue Sample Details");
    header.getStyle().set("margin-top", "0");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    tissueDateSpecimenReceived = new DatePicker("Date lab received specimen");
    tissueDateSpecimenReceived.setMax(LocalDate.now());
    tissueDateSpecimenReceived.setRequired(true);

    tissueLabId = new TextField("Laboratory ID");
    tissueLabId.setPlaceholder("Enter Lab ID");

    tissueSpecimenCondition = new RadioButtonGroup<>();
    tissueSpecimenCondition.setLabel("Specimen condition");
    tissueSpecimenCondition.setItems("Adequate", "Not Adequate");
    tissueSpecimenCondition.setRequired(true);

    tissueDateConfirmatoryLabResult = new DatePicker("Date Specimen sent to Reference lab for confirmation");
    tissueDateConfirmatoryLabResult.setMax(LocalDate.now());

    tissueTestConducted = new CheckboxGroup<>();
    tissueTestConducted.setLabel("Test Conducted");
    tissueTestConducted.setItems("PCR", "RDT", "Culture");
    tissueTestConducted.setRequired(true);

    // Create test result sections
    tissuePcrSection = createTissuePcrSection();
    tissuePcrSection.setVisible(false);

    tissueRdtSection = createTissueRdtSection();
    tissueRdtSection.setVisible(false);

    tissueCultureSection = createTissueCultureSection();
    tissueCultureSection.setVisible(false);

    layout.add(
        tissueDateSpecimenReceived,
        tissueLabId,
        tissueSpecimenCondition,
        tissueDateConfirmatoryLabResult,
        tissueTestConducted);

    layout.setColspan(tissueTestConducted, 2);

    section.add(header, layout, tissuePcrSection, tissueRdtSection, tissueCultureSection);
    return section;
  }

  private Div createTissuePcrSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("Tissue PCR Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    tissuePcrResult = new RadioButtonGroup<>();
    tissuePcrResult.setLabel("PCR result");
    tissuePcrResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    tissuePcrResult.setRequired(true);

    tissuePcrDateResultAvailable = new DatePicker("Date result is available");
    tissuePcrDateResultAvailable.setMax(LocalDate.now());
    tissuePcrDateResultAvailable.setRequired(true);

    tissuePcrDateResultSent = new DatePicker("Date result sent out");
    tissuePcrDateResultSent.setMax(LocalDate.now());
    tissuePcrDateResultSent.setRequired(true);

    layout.add(tissuePcrResult, tissuePcrDateResultAvailable, tissuePcrDateResultSent);
    layout.setColspan(tissuePcrResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createTissueRdtSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("Tissue RDT Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    tissueRdtResult = new RadioButtonGroup<>();
    tissueRdtResult.setLabel("RDT result");
    tissueRdtResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    tissueRdtResult.setRequired(true);

    tissueRdtDateResultAvailable = new DatePicker("Date result is available");
    tissueRdtDateResultAvailable.setMax(LocalDate.now());
    tissueRdtDateResultAvailable.setRequired(true);

    tissueRdtDateResultSentOut = new DatePicker("Date result sent out");
    tissueRdtDateResultSentOut.setMax(LocalDate.now());
    tissueRdtDateResultSentOut.setRequired(true);

    layout.add(tissueRdtResult, tissueRdtDateResultAvailable, tissueRdtDateResultSentOut);
    layout.setColspan(tissueRdtResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createTissueCultureSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("Tissue Culture Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    tissueCultureResult = new RadioButtonGroup<>();
    tissueCultureResult.setLabel("Culture result");
    tissueCultureResult.setItems("Growth", "No Growth");
    tissueCultureResult.setRequired(true);

    tissueCultureDateResultAvailable = new DatePicker("Date result is available");
    tissueCultureDateResultAvailable.setMax(LocalDate.now());
    tissueCultureDateResultAvailable.setRequired(true);

    tissueCultureDateResultSentOut = new DatePicker("Date result sent out");
    tissueCultureDateResultSentOut.setMax(LocalDate.now());
    tissueCultureDateResultSentOut.setRequired(true);

    layout.add(tissueCultureResult, tissueCultureDateResultAvailable, tissueCultureDateResultSentOut);
    layout.setColspan(tissueCultureResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createStoolSection() {
    Div section = new Div();
    section.getStyle().set("border", "1px solid #e0e0e0")
        .set("padding", "15px")
        .set("margin", "10px 0")
        .set("border-radius", "5px");

    H3 header = new H3("Stool Sample Details");
    header.getStyle().set("margin-top", "0");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    stoolDateSpecimenReceived = new DatePicker("Date lab received specimen");
    stoolDateSpecimenReceived.setMax(LocalDate.now());
    stoolDateSpecimenReceived.setRequired(true);

    stoolLabId = new TextField("Laboratory ID");
    stoolLabId.setPlaceholder("Enter Lab ID");

    stoolSpecimenCondition = new RadioButtonGroup<>();
    stoolSpecimenCondition.setLabel("Specimen condition");
    stoolSpecimenCondition.setItems("Adequate", "Not Adequate");
    stoolSpecimenCondition.setRequired(true);

    stoolDateConfirmatoryLabResult = new DatePicker("Date Specimen sent to Reference lab for confirmation");
    stoolDateConfirmatoryLabResult.setMax(LocalDate.now());

    stoolTestConducted = new CheckboxGroup<>();
    stoolTestConducted.setLabel("Test Conducted");
    stoolTestConducted.setItems("PCR", "RDT", "Culture");
    stoolTestConducted.setRequired(true);

    // Create test result sections
    stoolPcrSection = createStoolPcrSection();
    stoolPcrSection.setVisible(false);

    stoolRdtSection = createStoolRdtSection();
    stoolRdtSection.setVisible(false);

    stoolCultureSection = createStoolCultureSection();
    stoolCultureSection.setVisible(false);

    layout.add(
        stoolDateSpecimenReceived,
        stoolLabId,
        stoolSpecimenCondition,
        stoolDateConfirmatoryLabResult,
        stoolTestConducted);

    layout.setColspan(stoolTestConducted, 2);

    section.add(header, layout, stoolPcrSection, stoolRdtSection, stoolCultureSection);
    return section;
  }

  private Div createStoolPcrSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("Stool PCR Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    stoolPcrResult = new RadioButtonGroup<>();
    stoolPcrResult.setLabel("PCR result");
    stoolPcrResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    stoolPcrResult.setRequired(true);

    stoolPcrDateResultAvailable = new DatePicker("Date result is available");
    stoolPcrDateResultAvailable.setMax(LocalDate.now());
    stoolPcrDateResultAvailable.setRequired(true);

    stoolPcrDateResultSent = new DatePicker("Date result sent out");
    stoolPcrDateResultSent.setMax(LocalDate.now());
    stoolPcrDateResultSent.setRequired(true);

    layout.add(stoolPcrResult, stoolPcrDateResultAvailable, stoolPcrDateResultSent);
    layout.setColspan(stoolPcrResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createStoolRdtSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("Stool RDT Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    stoolRdtResult = new RadioButtonGroup<>();
    stoolRdtResult.setLabel("RDT result");
    stoolRdtResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    stoolRdtResult.setRequired(true);

    stoolRdtDateResultAvailable = new DatePicker("Date result is available");
    stoolRdtDateResultAvailable.setMax(LocalDate.now());
    stoolRdtDateResultAvailable.setRequired(true);

    stoolRdtDateResultSentOut = new DatePicker("Date result sent out");
    stoolRdtDateResultSentOut.setMax(LocalDate.now());
    stoolRdtDateResultSentOut.setRequired(true);

    layout.add(stoolRdtResult, stoolRdtDateResultAvailable, stoolRdtDateResultSentOut);
    layout.setColspan(stoolRdtResult, 2);

    section.add(header, layout);
    return section;
  }

  private Div createStoolCultureSection() {
    Div section = new Div();
    section.getStyle().set("background-color", "#f9f9f9")
        .set("padding", "10px")
        .set("margin", "10px 0")
        .set("border-radius", "3px");

    H3 header = new H3("Stool Culture Test Results");
    header.getStyle().set("margin-top", "0").set("font-size", "1.1em");

    FormLayout layout = new FormLayout();
    layout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

    stoolCultureResult = new RadioButtonGroup<>();
    stoolCultureResult.setLabel("Culture result");
    stoolCultureResult.setItems("Growth", "No Growth");
    stoolCultureResult.setRequired(true);

    stoolCultureDateResultAvailable = new DatePicker("Date result is available");
    stoolCultureDateResultAvailable.setMax(LocalDate.now());
    stoolCultureDateResultAvailable.setRequired(true);

    stoolCultureDateResultSentOut = new DatePicker("Date result sent out");
    stoolCultureDateResultSentOut.setMax(LocalDate.now());
    stoolCultureDateResultSentOut.setRequired(true);

    layout.add(stoolCultureResult, stoolCultureDateResultAvailable, stoolCultureDateResultSentOut);
    layout.setColspan(stoolCultureResult, 2);

    section.add(header, layout);
    return section;
  }

  private void setupEventListeners() {
    // Main sample collected listener
    sampleCollected.addValueChangeListener(event -> {
      boolean show = "Yes".equals(event.getValue());
      sampleCollectedSection.setVisible(show);
      if (!show) {
        clearAllFields();
      }
    });

    // Specimen preserved listener
    specimenPreserved.addValueChangeListener(event -> {
      boolean showWhy = "No".equals(event.getValue());
      ifNoWhy.setVisible(showWhy);
      if (!showWhy) {
        ifNoWhy.clear();
      }
    });

    // Sample type listener
    sampleType.addValueChangeListener(event -> {
      Set<String> selectedTypes = event.getValue();

      // Show date specimen sent if any type is selected
      dateSpecimenSent.setVisible(!selectedTypes.isEmpty());

      // Show specify field if Others is selected
      specifyIfOthers.setVisible(selectedTypes.contains("Others"));

      // Show/hide sample type sections
      bloodSampleReceived.setVisible(selectedTypes.contains("Blood"));
      swabSampleReceived.setVisible(selectedTypes.contains("Swab"));
      bodyFluidSampleReceived.setVisible(selectedTypes.contains("Body Fluid"));
      tissueSampleReceived.setVisible(selectedTypes.contains("Tissue"));
      stoolSampleReceived.setVisible(selectedTypes.contains("Stool"));

      // Clear sections that are not selected
      if (!selectedTypes.contains("Blood")) {
        bloodSampleReceived.clear();
        bloodSection.setVisible(false);
      }
      if (!selectedTypes.contains("Swab")) {
        swabSampleReceived.clear();
        swabSection.setVisible(false);
      }
      if (!selectedTypes.contains("Body Fluid")) {
        bodyFluidSampleReceived.clear();
        bodyFluidSection.setVisible(false);
      }
      if (!selectedTypes.contains("Tissue")) {
        tissueSampleReceived.clear();
        tissueSection.setVisible(false);
      }
      if (!selectedTypes.contains("Stool")) {
        stoolSampleReceived.clear();
        stoolSection.setVisible(false);
      }
    });

    // Blood sample received listener
    bloodSampleReceived.addValueChangeListener(event -> {
      boolean show = "Yes".equals(event.getValue());
      bloodSection.setVisible(show);
      if (!show) {
        clearBloodFields();
      }
    });

    // Blood test conducted listener
    bloodTestConducted.addValueChangeListener(event -> {
      Set<String> selectedTests = event.getValue();
      bloodPcrSection.setVisible(selectedTests.contains("PCR"));
      bloodRdtSection.setVisible(selectedTests.contains("RDT"));
      bloodCultureSection.setVisible(selectedTests.contains("Culture"));
    });

    // Blood culture result listener
    bloodCultureResult.addValueChangeListener(event -> {
      boolean showDates = "Growth".equals(event.getValue());
      bloodCultureDateResultAvailable.setVisible(showDates);
      bloodCultureDateResultSentOut.setVisible(showDates);
    });

    // Swab sample received listener
    swabSampleReceived.addValueChangeListener(event -> {
      boolean show = "Yes".equals(event.getValue());
      swabSection.setVisible(show);
      if (!show) {
        clearSwabFields();
      }
    });

    // Swab sentinel lab listener
    swabHasSentinelLab.addValueChangeListener(event -> {
      boolean showDate = "No".equals(event.getValue()) || "Indeterminate".equals(event.getValue());
      swabDateSpecimenSentForConfirmation.setVisible(showDate);
    });

    // Swab test conducted listener
    swabTestConducted.addValueChangeListener(event -> {
      Set<String> selectedTests = event.getValue();
      swabPcrSection.setVisible(selectedTests.contains("PCR"));
      swabRdtSection.setVisible(selectedTests.contains("RDT"));
      swabCultureSection.setVisible(selectedTests.contains("Culture"));
    });

    // Body Fluid sample received listener
    bodyFluidSampleReceived.addValueChangeListener(event -> {
      boolean show = "Yes".equals(event.getValue());
      bodyFluidSection.setVisible(show);
      if (!show) {
        clearBodyFluidFields();
      }
    });

    // Body Fluid test conducted listener
    bodyFluidTestConducted.addValueChangeListener(event -> {
      Set<String> selectedTests = event.getValue();
      bodyFluidPcrSection.setVisible(selectedTests.contains("PCR"));
      bodyFluidRdtSection.setVisible(selectedTests.contains("RDT"));
      bodyFluidCultureSection.setVisible(selectedTests.contains("Culture"));
    });

    // Tissue sample received listener
    tissueSampleReceived.addValueChangeListener(event -> {
      boolean show = "Yes".equals(event.getValue());
      tissueSection.setVisible(show);
      if (!show) {
        clearTissueFields();
      }
    });

    // Tissue test conducted listener
    tissueTestConducted.addValueChangeListener(event -> {
      Set<String> selectedTests = event.getValue();
      tissuePcrSection.setVisible(selectedTests.contains("PCR"));
      tissueRdtSection.setVisible(selectedTests.contains("RDT"));
      tissueCultureSection.setVisible(selectedTests.contains("Culture"));
    });

    // Stool sample received listener
    stoolSampleReceived.addValueChangeListener(event -> {
      boolean show = "Yes".equals(event.getValue());
      stoolSection.setVisible(show);
      if (!show) {
        clearStoolFields();
      }
    });

    // Stool test conducted listener
    stoolTestConducted.addValueChangeListener(event -> {
      Set<String> selectedTests = event.getValue();
      stoolPcrSection.setVisible(selectedTests.contains("PCR"));
      stoolRdtSection.setVisible(selectedTests.contains("RDT"));
      stoolCultureSection.setVisible(selectedTests.contains("Culture"));
    });
  }

  private boolean validateForm() {
    // Basic validation - check if sample collected is selected
    if (sampleCollected.getValue() == null) {
      return false;
    }

    if ("Yes".equals(sampleCollected.getValue())) {
      // Validate required fields when sample is collected
      if (specimenPreserved.getValue() == null ||
          dateSpecimenCollected.getValue() == null ||
          sampleType.getValue().isEmpty() ||
          nameOfTestingLaboratory.getValue() == null) {
        return false;
      }

      // Validate conditional fields
      if ("No".equals(specimenPreserved.getValue()) &&
          (ifNoWhy.getValue() == null || ifNoWhy.getValue().trim().isEmpty())) {
        return false;
      }

      if (sampleType.getValue().contains("Others") &&
          (specifyIfOthers.getValue() == null || specifyIfOthers.getValue().trim().isEmpty())) {
        return false;
      }
    }

    return true;
  }

  private void clearAllFields() {
    // Clear all form fields when sample collected is "No"
    specimenPreserved.clear();
    ifNoWhy.clear();
    dateSpecimenCollected.clear();
    sampleType.clear();
    dateSpecimenSent.clear();
    specifyIfOthers.clear();
    nameOfTestingLaboratory.clear();

    // Clear all sample type fields
    clearBloodFields();
    clearSwabFields();
    clearBodyFluidFields();
    clearTissueFields();
    clearStoolFields();
  }

  private void clearBloodFields() {
    bloodSampleReceived.clear();
    bloodDateSpecimenReceived.clear();
    bloodLabId.clear();
    bloodSpecimenCondition.clear();
    bloodDateConfirmatoryLabResult.clear();
    bloodTestConducted.clear();
    bloodCultureResult.clear();
    bloodCultureDateResultAvailable.clear();
    bloodCultureDateResultSentOut.clear();
  }

  private void clearSwabFields() {
    swabSampleReceived.clear();
    swabDateSpecimenReceived.clear();
    swabHasSentinelLab.clear();
    swabDateSpecimenSentForConfirmation.clear();
    swabLabId.clear();
    swabSpecimenCondition.clear();
    swabTestConducted.clear();
    swabCultureResult.clear();
  }

  private void clearBodyFluidFields() {
    bodyFluidSampleReceived.clear();
    bodyFluidDateSpecimenReceived.clear();
    bodyFluidLabId.clear();
    bodyFluidSpecimenCondition.clear();
    bodyFluidDateConfirmatoryLabResult.clear();
    bodyFluidTestConducted.clear();
    bodyFluidCultureResult.clear();
  }

  private void clearTissueFields() {
    tissueSampleReceived.clear();
    tissueDateSpecimenReceived.clear();
    tissueLabId.clear();
    tissueSpecimenCondition.clear();
    tissueDateConfirmatoryLabResult.clear();
    tissueTestConducted.clear();
    tissueCultureResult.clear();
  }

  private void clearStoolFields() {
    stoolSampleReceived.clear();
    stoolDateSpecimenReceived.clear();
    stoolLabId.clear();
    stoolSpecimenCondition.clear();
    stoolDateConfirmatoryLabResult.clear();
    stoolTestConducted.clear();
    stoolCultureResult.clear();
  }
}
