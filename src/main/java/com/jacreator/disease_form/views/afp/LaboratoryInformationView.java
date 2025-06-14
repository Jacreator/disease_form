package com.jacreator.disease_form.views.afp;

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
    CheckboxGroup<String> specimenType = new CheckboxGroup<>();
    specimenType.setLabel("Type of Specimen collected?");
    specimenType.setItems("Blood", "Crust", "Swab");

    ComboBox<String> nameOfTestingLaboratory = new ComboBox<>("Name of Testing Laboratory");
    nameOfTestingLaboratory.setItems("National Refrence Laboratory (NRL)", "Central Public Health Laboratory (CPHL)");

    DatePicker dateSpecimenSent = new DatePicker("Date of Specimen Sent");
    DatePicker dateSpecimenReceived = new DatePicker("Date of Specimen Received");
    CheckboxGroup<String> typeOfSpecmenReceived = new CheckboxGroup<>();
    typeOfSpecmenReceived.setLabel("Type of Specimen Received?");
    typeOfSpecmenReceived.setItems("Tissue Biopsy", "Fine Needle Aspirate", "Swab");

    TextField laboratoryId = new TextField("Laboratory ID");
    RadioButtonGroup<String> specimenCondition = new RadioButtonGroup<>();
    specimenCondition.setLabel("Specimen Condition?");
    specimenCondition.setItems("Adequate", "Not adequate");

    CheckboxGroup<String> typeOfTestConducted = new CheckboxGroup<>();
    typeOfTestConducted.setLabel("Type of Test Conducted?");
    typeOfTestConducted.setItems("PCR", "ZN staining", "Culture", "Histopathology");

    RadioButtonGroup<String> pcrResult = new RadioButtonGroup<>();
    pcrResult.setLabel("PCR Result");
    pcrResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");

    RadioButtonGroup<String> serologyResult = new RadioButtonGroup<>();
    serologyResult.setLabel("Serology Result");
    serologyResult.setItems("Positive", "Negative", "Indeterminate", "Pending", "Not Done");

    DatePicker dateResultAvailable = new DatePicker("Date of Result Available");
    DatePicker dateResultSent = new DatePicker("Date Result sent");

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
