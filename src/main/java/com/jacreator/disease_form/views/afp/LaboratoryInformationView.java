package com.jacreator.disease_form.views.afp;

import java.time.LocalDate;

import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class LaboratoryInformationView extends VerticalLayout {
  public LaboratoryInformationView() {
    FormLayout form = new FormLayout();

    RadioButtonGroup<String> specimenCollected = new RadioButtonGroup<>();
    specimenCollected.setLabel("Specimen Collected?");
    specimenCollected.setItems("Yes", "No");

    DatePicker dateSpecimenCollected = new DatePicker("Date of Specimen Collection");
    dateSpecimenCollected.setMax(LocalDate.now());
    dateSpecimenCollected.setVisible(false);
    CheckboxGroup<String> specimenType = new CheckboxGroup<>();
    specimenType.setLabel("Type of Specimen collected?");
    specimenType.setItems("Blood", "Crust", "Swab");
    specimenType.setVisible(false);

    ComboBox<String> nameOfTestingLaboratory = new ComboBox<>("Name of Testing Laboratory");
    nameOfTestingLaboratory.setItems("National Refrence Laboratory (NRL)", "Central Public Health Laboratory (CPHL)");
    nameOfTestingLaboratory.setVisible(false);

    DatePicker dateSpecimenSent = new DatePicker("Date of Specimen Sent");
    dateSpecimenSent.setVisible(false);
    DatePicker dateSpecimenReceived = new DatePicker("Date of Specimen Received");
    dateSpecimenReceived.setVisible(false);
    CheckboxGroup<String> typeOfSpecmenReceived = new CheckboxGroup<>();
    typeOfSpecmenReceived.setLabel("Type of Specimen Received?");
    typeOfSpecmenReceived.setItems("Tissue Biopsy", "Fine Needle Aspirate", "Swab");
    typeOfSpecmenReceived.setVisible(false);

    TextField laboratoryId = new TextField("Laboratory ID");
    laboratoryId.setVisible(false);
    RadioButtonGroup<String> specimenCondition = new RadioButtonGroup<>();
    specimenCondition.setVisible(false);
    specimenCondition.setLabel("Specimen Condition?");
    specimenCondition.setItems("Adequate", "Not adequate");

    CheckboxGroup<String> typeOfTestConducted = new CheckboxGroup<>();
    typeOfTestConducted.setLabel("Type of Test Conducted?");
    typeOfTestConducted.setItems("PCR", "ZN staining", "Culture", "Histopathology");
    typeOfTestConducted.setVisible(false);

    RadioButtonGroup<String> pcrResult = new RadioButtonGroup<>();
    pcrResult.setLabel("PCR Result");
    pcrResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    pcrResult.setVisible(false);

    RadioButtonGroup<String> serologyResult = new RadioButtonGroup<>();
    serologyResult.setLabel("Serology Result");
    serologyResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");
    serologyResult.setVisible(false);

    DatePicker dateResultAvailable = new DatePicker("Date of Result Available");
    dateResultAvailable.setVisible(false);
    DatePicker dateResultSent = new DatePicker("Date Result sent");
    dateResultSent.setVisible(false);

    specimenCollected.addValueChangeListener(e -> {
      boolean yes = "Yes".equals(e.getValue());
      specimenType.setVisible(yes);
      nameOfTestingLaboratory.setVisible(yes);
      dateSpecimenSent.setVisible(yes);
      dateSpecimenReceived.setVisible(yes);
      typeOfSpecmenReceived.setVisible(yes);
      laboratoryId.setVisible(yes);
      specimenCondition.setVisible(yes);
      typeOfTestConducted.setVisible(yes);
      pcrResult.setVisible(yes);
      serologyResult.setVisible(yes);
      dateResultAvailable.setVisible(yes);
      dateResultSent.setVisible(yes);
      dateSpecimenCollected.setVisible(yes);
    });

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));

    form.add(
        specimenCollected, dateSpecimenCollected, specimenType, nameOfTestingLaboratory,
        dateSpecimenSent, dateSpecimenReceived, typeOfSpecmenReceived, laboratoryId,
        specimenCondition, typeOfTestConducted, pcrResult, serologyResult,
        dateResultAvailable, dateResultSent);

    // AccordionPanel panel = accordion.add("Laboratory information", form);
    add(form);
  }
}
