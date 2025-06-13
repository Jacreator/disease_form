package com.jacreator.disease_form.views.mpox;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class MpoxContactTracingView extends VerticalLayout {
  private final Map<String, List<String>> lgaData = new HashMap<>();
  private ComboBox<String> lgaCombo;
  private ComboBox<String> wardCombo;

  public MpoxContactTracingView() {
    setWidthFull();

    // LGA data
    lgaData.put("FCT", Arrays.asList("AMAC", "Bwari", "Kwali"));
    lgaData.put("Enugu", Arrays.asList("Nsukka", "Enugu south", "Udi"));

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Contact first name
    TextField contactFirstName = new TextField("Contact first name");
    contactFirstName.setRequired(true);
    contactFirstName.setPlaceholder("Enter First Name");

    // Contact last name
    TextField contactLastName = new TextField("Contact last name");
    contactLastName.setRequired(true);
    contactLastName.setPlaceholder("Enter Last Name");

    // Date of birth
    DatePicker contactDateOfBirth = new DatePicker("Date of birth");
    contactDateOfBirth.setMax(LocalDate.now());
    contactDateOfBirth.setRequired(true);

    // Contact age (years and months)
    TextField contactAgeYears = new TextField();
    contactAgeYears.setPlaceholder("Estimated Years");
    contactAgeYears.setRequired(true);
    contactAgeYears.setTooltipText("Estimated Years");

    TextField contactAgeMonths = new TextField();
    contactAgeMonths.setPlaceholder("Estimated Months");
    contactAgeMonths.setTooltipText("Estimated Months");
    contactAgeMonths.setEnabled(false);

    // Contact sex
    RadioButtonGroup<String> contactSex = new RadioButtonGroup<>();
    contactSex.setLabel("Contact sex");
    contactSex.setItems("Male", "Female");
    contactSex.setRequired(true);

    // State of residence
    ComboBox<String> stateCombo = new ComboBox<>("Contact state of residence");
    stateCombo.setItems("FCT", "Enugu");
    stateCombo.setRequired(true);
    stateCombo.setPlaceholder("Select State");

    // LGA of residence (populated dynamically)
    lgaCombo = new ComboBox<>("Contact LGA of residence");
    lgaCombo.setRequired(true);
    lgaCombo.setPlaceholder("Select LGA");

    // Ward of residence (populated dynamically, using same LGA list for demo)
    wardCombo = new ComboBox<>("Contact ward of residence");
    wardCombo.setRequired(true);
    wardCombo.setPlaceholder("Select Ward");

    // Update LGA and Ward options when state changes
    stateCombo.addValueChangeListener(event -> {
      List<String> lgas = lgaData.getOrDefault(event.getValue(), Collections.emptyList());
      lgaCombo.setItems(lgas);
      wardCombo.setItems(lgas); // You can replace with actual ward data if available
    });

    // Contact residential address
    TextField contactResidentialAddress = new TextField("Contact residential address");
    contactResidentialAddress.setRequired(true);
    contactResidentialAddress.setPlaceholder("Enter Contact Address");

    // Relationship with case
    ComboBox<String> relationshipWithCase = new ComboBox<>("Relationship with case");
    relationshipWithCase.setItems(
        "Parent", "Sibling", "Child", "Neighbour", "Work/School Colleague",
        "Healthcare giver", "Patient", "Others");
    relationshipWithCase.setRequired(true);
    relationshipWithCase.setPlaceholder("Select Relationship");

    // Responsive steps
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("800px", 2),
        new FormLayout.ResponsiveStep("1200px", 3));

    // Add all fields to the form
    form.add(
        contactFirstName,
        contactLastName,
        contactDateOfBirth,
        contactAgeYears,
        contactAgeMonths,
        contactSex,
        stateCombo,
        lgaCombo,
        wardCombo,
        contactResidentialAddress,
        relationshipWithCase);

    return form;
  }
}
