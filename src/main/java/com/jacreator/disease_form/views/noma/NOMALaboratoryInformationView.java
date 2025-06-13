package com.jacreator.disease_form.views.noma;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class NOMALaboratoryInformationView extends VerticalLayout {
  private FormLayout form;
  private CheckboxGroup<String> typeOfSpecimenCollected;
  private DatePicker dateSpecimenCollected;
  private DatePicker dateSpecimenSent;
  private ComboBox<String> nameOfTestingLaboratory;
  private RadioButtonGroup<String> specimenReceived;
  private CheckboxGroup<String> specimenType;
  private DatePicker dateSpecimenReceived;
  private RadioButtonGroup<String> specimenCondition;

  public NOMALaboratoryInformationView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    form = new FormLayout();

    // Laboratory options
    List<String> laboratoryOptions = Arrays.asList(
        "ACEGID -African Centre of Excellence for Genomics of Infectious Diseases, Ogun",
        "AE-FUTHA -Alex Ekwueme Federal University Teaching Hospital Virology Laboratory",
        "BUK -Bayero University Kano Centre for Infectious Disease and Research, Kano",
        "FMC JALINGO -Federal Medical Centre, Jalingo, Taraba",
        "FMC OWO -Federal Medical Centre Owo, Ondo",
        "ISTH -Irrua Specialist Teaching Hospital, Edo",
        "LUTH -Lagos University Teaching Hospital Virology Laboratory, Lagos",
        "MOGID -Molecular Genetics and Infectious Diseases Research Laboratory, Bauchi",
        "NRL -National Reference Laboratory Gaduwa, FCT");

    List<String> conditionOfSampleOptions = Arrays.asList("Adequate", "Not adequate");

    // Specimen collected
    RadioButtonGroup<String> specimenCollected = new RadioButtonGroup<>();
    specimenCollected.setLabel("Specimen collected");
    specimenCollected.setItems("Yes", "No", "Unknown");
    specimenCollected.setRequired(true);

    // Type of specimen collected (initially hidden)
    typeOfSpecimenCollected = new CheckboxGroup<>();
    typeOfSpecimenCollected.setLabel("Type of specimen collected");
    typeOfSpecimenCollected.setItems("Oral Swab", "Nasal Swab", "Nasopharyngeal Swab");
    typeOfSpecimenCollected.setRequired(true);
    typeOfSpecimenCollected.setVisible(false);

    // Date specimen collected (initially hidden)
    dateSpecimenCollected = new DatePicker("Date specimen collected");
    dateSpecimenCollected.setMax(LocalDate.now());
    dateSpecimenCollected.setRequired(true);
    dateSpecimenCollected.setVisible(false);

    // Date specimen sent (initially hidden)
    dateSpecimenSent = new DatePicker("Date specimen sent");
    dateSpecimenSent.setMax(LocalDate.now());
    dateSpecimenSent.setRequired(true);
    dateSpecimenSent.setVisible(false);

    // Name of testing laboratory (initially hidden)
    nameOfTestingLaboratory = new ComboBox<>("Name of testing laboratory");
    nameOfTestingLaboratory.setItems(laboratoryOptions);
    nameOfTestingLaboratory.setPlaceholder("Select Laboratory Name");
    nameOfTestingLaboratory.setVisible(false);

    // Specimen received (initially hidden)
    specimenReceived = new RadioButtonGroup<>();
    specimenReceived.setLabel("Specimen received");
    specimenReceived.setItems("Yes", "No", "Unknown");
    specimenReceived.setRequired(true);
    specimenReceived.setVisible(false);

    // Type of specimen received (initially hidden)
    specimenType = new CheckboxGroup<>();
    specimenType.setLabel("Type of specimen received");
    specimenType.setItems("Oral Swab", "Nasal Swab", "Nasopharyngeal Swab");
    specimenType.setRequired(true);
    specimenType.setVisible(false);

    // Date specimen received (initially hidden)
    dateSpecimenReceived = new DatePicker("Date specimen received");
    dateSpecimenReceived.setMax(LocalDate.now());
    dateSpecimenReceived.setRequired(true);
    dateSpecimenReceived.setVisible(false);

    // Specimen condition (initially hidden)
    specimenCondition = new RadioButtonGroup<>();
    specimenCondition.setLabel("Specimen condition");
    specimenCondition.setItems(conditionOfSampleOptions);
    specimenCondition.setRequired(true);
    specimenCondition.setVisible(false);

    // Add value change listeners for conditional visibility
    specimenCollected.addValueChangeListener(event -> {
      boolean showFields = "Yes".equals(event.getValue());
      typeOfSpecimenCollected.setVisible(showFields);
      dateSpecimenCollected.setVisible(showFields);
      dateSpecimenSent.setVisible(showFields);
      nameOfTestingLaboratory.setVisible(showFields);
      specimenReceived.setVisible(showFields);

      // Hide second level fields when specimen collected is not "Yes"
      if (!showFields) {
        specimenType.setVisible(false);
        dateSpecimenReceived.setVisible(false);
        specimenCondition.setVisible(false);
      }
    });

    specimenReceived.addValueChangeListener(event -> {
      boolean showFields = "Yes".equals(event.getValue());
      specimenType.setVisible(showFields);
      dateSpecimenReceived.setVisible(showFields);
      specimenCondition.setVisible(showFields);
    });

    // Responsive steps
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("800px", 2));

    // Add all fields to the form
    form.add(
        specimenCollected,
        typeOfSpecimenCollected,
        dateSpecimenCollected,
        dateSpecimenSent,
        nameOfTestingLaboratory,
        specimenReceived,
        specimenType,
        dateSpecimenReceived,
        specimenCondition);

    return form;
  }
}
