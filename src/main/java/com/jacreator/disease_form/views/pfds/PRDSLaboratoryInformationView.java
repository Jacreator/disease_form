package com.jacreator.disease_form.views.pfds;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class PRDSLaboratoryInformationView extends VerticalLayout {
  // Data for testing laboratories
  private static final String[] TESTING_LABORATORIES = {
      "ACEGID -African Centre of Excellence for Genomics of Infectious Diseases, Ogun",
      "AE-FUTHA -Alex Ekwueme Federal University Teaching Hospital Virology Laboratory",
      "BUK -Bayero University Kano Centre for Infectious Disease and Research, Kano",
      "FMC JALINGO -Federal Medical Centre, Jalingo, Taraba",
      "FMC OWO -Federal Medical Centre Owo, Ondo",
      "ISTH -Irrua Specialist Teaching Hospital, Edo",
      "LUTH -Lagos University Teaching Hospital Virology Laboratory, Lagos",
      "MOGID -Molecular Genetics and Infectious Diseases Research Laboratory, Bauchi",
      "NRL -National Reference Laboratory Gaduwa, FCT"
  };

  public PRDSLaboratoryInformationView() {
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

    // Date specimen collected (conditional)
    DatePicker dateSpecimenCollected = new DatePicker("Date specimen collected");
    dateSpecimenCollected.setMax(LocalDate.now());
    dateSpecimenCollected.setVisible(false);

    // Type of specimen collected (conditional)
    CheckboxGroup<String> specimenType = new CheckboxGroup<>();
    specimenType.setLabel("Type of specimen collected");
    specimenType.setItems("Nasal swab", "Throat swab", "Nasopharyngeal", "Oropharyngeal");
    specimenType.setVisible(false);

    // Date specimen sent (conditional)
    DatePicker dateSpecimenSent = new DatePicker("Date specimen sent");
    dateSpecimenSent.setMax(LocalDate.now());
    dateSpecimenSent.setVisible(false);

    // Name of testing laboratory (conditional)
    ComboBox<String> nameOfTestingLaboratory = new ComboBox<>("Name Of testing laboratory");
    nameOfTestingLaboratory.setItems(TESTING_LABORATORIES);
    nameOfTestingLaboratory.setAllowCustomValue(false);
    nameOfTestingLaboratory.setClearButtonVisible(true);
    nameOfTestingLaboratory.setVisible(false);

    // Laboratory result divider
    Div labResultDivider = new Div();
    labResultDivider.setText("Laboratory result");
    labResultDivider.getStyle().set("font-weight", "bold").set("margin", "16px 0 8px 0");
    labResultDivider.setVisible(false);

    // Swab received radio groups (conditional)
    RadioButtonGroup<String> nSwabSpecimenReceived = createSwabRadio("Nasal swab received?");
    RadioButtonGroup<String> tSwabSpecimenReceived = createSwabRadio("Throat swab received?");
    RadioButtonGroup<String> npSwabSpecimenReceived = createSwabRadio("Nasopharyngeal swab received?");
    RadioButtonGroup<String> opSwabSpecimenReceived = createSwabRadio("Oropharyngeal swab received?");
    nSwabSpecimenReceived.setVisible(false);
    tSwabSpecimenReceived.setVisible(false);
    npSwabSpecimenReceived.setVisible(false);
    opSwabSpecimenReceived.setVisible(false);

    // Date specimen received (conditional)
    DatePicker dateSpecimenReceived = new DatePicker("Date specimen received");
    dateSpecimenReceived.setMax(LocalDate.now());
    dateSpecimenReceived.setVisible(false);

    // Laboratory ID (conditional)
    TextField laboratoryId = new TextField("Laboratory ID");
    laboratoryId.setPlaceholder("Enter Lab ID");
    laboratoryId.setVisible(false);

    // Specimen condition (conditional)
    RadioButtonGroup<String> specimenCondition = new RadioButtonGroup<>();
    specimenCondition.setLabel("Specimen condition");
    specimenCondition.setItems("Adequate", "Not Adequate");
    specimenCondition.setVisible(false);

    // Test conducted (conditional)
    CheckboxGroup<String> testConductedNasal = new CheckboxGroup<>();
    testConductedNasal.setLabel("Test conducted");
    testConductedNasal.setVisible(false);

    // PCR result (conditional)
    RadioButtonGroup<String> pcrResult = new RadioButtonGroup<>();
    pcrResult.setLabel("PCR result");
    pcrResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    pcrResult.setVisible(false);

    // Date result released for PCR (conditional)
    DatePicker dateResultSentPCR = new DatePicker("Date result released");
    dateResultSentPCR.setMax(LocalDate.now());
    dateResultSentPCR.setVisible(false);

    // RDT result (conditional)
    RadioButtonGroup<String> rdtResult = new RadioButtonGroup<>();
    rdtResult.setLabel("RDT result");
    rdtResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    rdtResult.setVisible(false);

    // Date result released for RDT (conditional)
    DatePicker dateResultSentOutNasal = new DatePicker("Date result released");
    dateResultSentOutNasal.setMax(LocalDate.now());
    dateResultSentOutNasal.setVisible(false);

    // Show/hide fields based on specimenCollected
    specimenCollected.addValueChangeListener(e -> {
      boolean collected = "Yes".equalsIgnoreCase(e.getValue());
      dateSpecimenCollected.setVisible(collected);
      specimenType.setVisible(collected);
      nameOfTestingLaboratory.setVisible(collected);
      labResultDivider.setVisible(collected);
    });

    // Show/hide fields based on specimenType selection
    specimenType.addValueChangeListener(e -> {
      Set<String> types = e.getValue() != null ? e.getValue() : new LinkedHashSet<>();
      dateSpecimenSent.setVisible(types.size() >= 1);
      nSwabSpecimenReceived.setVisible(types.contains("Nasal swab"));
      tSwabSpecimenReceived.setVisible(types.contains("Throat swab"));
      npSwabSpecimenReceived.setVisible(types.contains("Nasopharyngeal"));
      opSwabSpecimenReceived.setVisible(types.contains("Oropharyngeal"));
    });

    // Show/hide result fields based on swab received
    nSwabSpecimenReceived.addValueChangeListener(
        e -> updateResultFields(form, nSwabSpecimenReceived, tSwabSpecimenReceived, npSwabSpecimenReceived,
            opSwabSpecimenReceived, dateSpecimenReceived, laboratoryId, specimenCondition, testConductedNasal));
    tSwabSpecimenReceived.addValueChangeListener(
        e -> updateResultFields(form, nSwabSpecimenReceived, tSwabSpecimenReceived, npSwabSpecimenReceived,
            opSwabSpecimenReceived, dateSpecimenReceived, laboratoryId, specimenCondition, testConductedNasal));
    npSwabSpecimenReceived.addValueChangeListener(
        e -> updateResultFields(form, nSwabSpecimenReceived, tSwabSpecimenReceived, npSwabSpecimenReceived,
            opSwabSpecimenReceived, dateSpecimenReceived, laboratoryId, specimenCondition, testConductedNasal));
    opSwabSpecimenReceived.addValueChangeListener(
        e -> updateResultFields(form, nSwabSpecimenReceived, tSwabSpecimenReceived, npSwabSpecimenReceived,
            opSwabSpecimenReceived, dateSpecimenReceived, laboratoryId, specimenCondition, testConductedNasal));

    // Show/hide test conducted options based on specimenType
    testConductedNasal.addValueChangeListener(e -> {
      Set<String> tests = e.getValue() != null ? e.getValue() : new LinkedHashSet<>();
      pcrResult.setVisible(tests.contains("PCR"));
      rdtResult.setVisible(tests.contains("RDT"));
    });

    // Show/hide date result released for PCR
    pcrResult.addValueChangeListener(e -> {
      String val = e.getValue();
      dateResultSentPCR.setVisible("Positive".equalsIgnoreCase(val) || "Negative".equalsIgnoreCase(val)
          || "Indeterminate".equalsIgnoreCase(val));
    });

    // Show/hide date result released for RDT
    rdtResult.addValueChangeListener(e -> {
      String val = e.getValue();
      dateResultSentOutNasal.setVisible("Positive".equalsIgnoreCase(val) || "Negative".equalsIgnoreCase(val)
          || "Indeterminate".equalsIgnoreCase(val));
    });

    // Add all fields to the form
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    form.add(
        specimenCollected, dateSpecimenCollected, specimenType, dateSpecimenSent,
        nameOfTestingLaboratory, labResultDivider,
        nSwabSpecimenReceived, tSwabSpecimenReceived, npSwabSpecimenReceived, opSwabSpecimenReceived,
        dateSpecimenReceived, laboratoryId, specimenCondition, testConductedNasal,
        pcrResult, dateResultSentPCR, rdtResult, dateResultSentOutNasal);

    return form;
  }

  private RadioButtonGroup<String> createSwabRadio(String label) {
    RadioButtonGroup<String> group = new RadioButtonGroup<>();
    group.setLabel(label);
    group.setItems("Yes", "No");
    return group;
  }

  private void updateResultFields(
      FormLayout form,
      RadioButtonGroup<String> nSwab,
      RadioButtonGroup<String> tSwab,
      RadioButtonGroup<String> npSwab,
      RadioButtonGroup<String> opSwab,
      DatePicker dateReceived,
      TextField labId,
      RadioButtonGroup<String> specimenCondition,
      CheckboxGroup<String> testConducted) {
    boolean anyYes = "Yes".equalsIgnoreCase(nSwab.getValue())
        || "Yes".equalsIgnoreCase(tSwab.getValue())
        || "Yes".equalsIgnoreCase(npSwab.getValue())
        || "Yes".equalsIgnoreCase(opSwab.getValue());
    dateReceived.setVisible(anyYes);
    labId.setVisible(anyYes);
    specimenCondition.setVisible(anyYes);
    testConducted.setVisible(anyYes);

    // Set test options based on specimenType (for demo, always show both)
    testConducted.setItems("PCR", "RDT", "Serology");
  }
}
