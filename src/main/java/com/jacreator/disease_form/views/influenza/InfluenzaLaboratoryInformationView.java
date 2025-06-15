package com.jacreator.disease_form.views.influenza;

import java.time.LocalDate;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class InfluenzaLaboratoryInformationView extends VerticalLayout {
  public InfluenzaLaboratoryInformationView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Specimen Collected?
    RadioButtonGroup<String> specimenCollected = new RadioButtonGroup<>();
    specimenCollected.setLabel("Specimen Collected?");
    specimenCollected.setItems("Yes", "No");
    specimenCollected.setRequired(true);

    // Date of Specimen Collected
    DatePicker dateSpecimenCollected = new DatePicker("Date of Specimen Collected");
    dateSpecimenCollected.setMax(LocalDate.now());
    dateSpecimenCollected.setRequired(true);
    dateSpecimenCollected.setVisible(false);

    // Type of Specimen collected?
    CheckboxGroup<String> specimenType = new CheckboxGroup<>();
    specimenType.setLabel("Type of Specimen collected?");
    specimenType.setItems("Throat/Oropharyngeal", "Nasal/Nasopahryngeal");
    specimenType.setRequired(true);
    specimenType.setVisible(false);

    // Name of Testing Laboratory
    RadioButtonGroup<String> nameOfTestingLaboratory = new RadioButtonGroup<>();
    nameOfTestingLaboratory.setLabel("Name of Testing Laboratory");
    nameOfTestingLaboratory.setItems("National Refrence Laboratory (NRL)");
    nameOfTestingLaboratory.setRequired(true);
    nameOfTestingLaboratory.setVisible(false);

    // Date of Sample Sent
    DatePicker dateSampleSent = new DatePicker("Date of Sample Sent");
    dateSampleSent.setMax(LocalDate.now());
    dateSampleSent.setRequired(true);
    dateSampleSent.setVisible(false);

    // Type of Specimen Received?
    CheckboxGroup<String> typeOfSpecimenReceived = new CheckboxGroup<>();
    typeOfSpecimenReceived.setLabel("Type of Specimen Received?");
    typeOfSpecimenReceived.setItems("Throat/Oropharyngeal", "Nasal/Nasopahryngeal");
    typeOfSpecimenReceived.setRequired(true);
    typeOfSpecimenReceived.setVisible(false);

    // Date of Specimen Received
    DatePicker dateSpecimenReceived = new DatePicker("Date of Specimen Received");
    dateSpecimenReceived.setMax(LocalDate.now());
    dateSpecimenReceived.setRequired(true);
    dateSpecimenReceived.setVisible(false);

    // Laboratory ID
    TextField laboratoryId = new TextField("Laboratory ID");
    laboratoryId.setPlaceholder("Enter specimen Id");
    laboratoryId.setRequired(true);
    laboratoryId.setVisible(false);

    // Specimen Condition?
    RadioButtonGroup<String> specimenCondition = new RadioButtonGroup<>();
    specimenCondition.setLabel("Specimen Condition?");
    specimenCondition.setItems("Adequate", "Not adequate");
    specimenCondition.setRequired(true);
    specimenCondition.setVisible(false);

    // Type of Test Conducted?
    CheckboxGroup<String> typeOfTestConducted = new CheckboxGroup<>();
    typeOfTestConducted.setLabel("Type of Test Conducted?");
    typeOfTestConducted.setItems("PCR");
    typeOfTestConducted.setRequired(true);
    typeOfTestConducted.setVisible(false);

    // PCR Result
    RadioButtonGroup<String> pcrResult = new RadioButtonGroup<>();
    pcrResult.setLabel("PCR Result");
    pcrResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    pcrResult.setRequired(true);
    pcrResult.setVisible(false);

    // Date of Result Available
    DatePicker dateResultAvailable = new DatePicker("Date of Result Available");
    dateResultAvailable.setMax(LocalDate.now());
    dateResultAvailable.setRequired(true);
    dateResultAvailable.setVisible(false);

    // Date Result sent
    DatePicker dateResultSent = new DatePicker("Date Result sent");
    dateResultSent.setMax(LocalDate.now());
    dateResultSent.setRequired(true);
    dateResultSent.setVisible(false);

    // Responsive steps
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));

        specimenCollected.addValueChangeListener(e -> {
          boolean yes = "Yes".equals(e.getValue());
          dateSpecimenCollected.setVisible(yes);
          specimenType.setVisible(yes);
          nameOfTestingLaboratory.setVisible(yes);
          dateSampleSent.setVisible(yes);
          typeOfSpecimenReceived.setVisible(yes);
          dateSpecimenReceived.setVisible(yes);
          laboratoryId.setVisible(yes);
          specimenCondition.setVisible(yes);
          typeOfTestConducted.setVisible(yes);
          pcrResult.setVisible(yes);
          dateResultAvailable.setVisible(yes);
          dateResultSent.setVisible(yes);
        });

    // Add all fields to the form
    form.add(
        specimenCollected,
        dateSpecimenCollected,
        specimenType,
        nameOfTestingLaboratory,
        dateSampleSent,
        typeOfSpecimenReceived,
        dateSpecimenReceived,
        laboratoryId,
        specimenCondition,
        typeOfTestConducted,
        pcrResult,
        dateResultAvailable,
        dateResultSent);

    return form;
  }
}
