package com.jacreator.disease_form.views.ebola;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class EbolaContactTracingView extends VerticalLayout {
  // Static data
  private static final List<String> RELATIONSHIP_WITH_CASE = Arrays.asList(
      "Parent", "Sibling", "Child", "Neighbour", "Work/School Colleague",
      "Healthcare giver", "Patient", "Others");

  private static final List<String> STATE_DATA = Arrays.asList("FCT", "Enugu");

  private static final Map<String, List<String>> LGA_DATA = new HashMap<>();
  static {
    LGA_DATA.put("FCT", Arrays.asList("AMAC", "Bwari", "Kwali"));
    LGA_DATA.put("Enugu", Arrays.asList("Nsukka", "Enugu south", "Udi"));
  }

  // Form fields
  private TextField firstNameContact;
  private TextField lastName;
  private DatePicker dateOfBirth;
  private TextField phone;
  private TextField ageYears;
  private TextField ageMonths;
  private ComboBox<String> residenceState;
  private ComboBox<String> residenceLga;
  private ComboBox<String> residenceWard;
  private ComboBox<String> relationshipWithCase;

  public EbolaContactTracingView() {
    setWidthFull();
    setPadding(true);
    setSpacing(true);
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();
    form.setWidthFull();

    // Set responsive steps for 3-column layout on larger screens

    // Contact First Name
    firstNameContact = new TextField("Contact First Name");
    firstNameContact.setPlaceholder("Enter First Name");
    firstNameContact.setRequired(true);
    firstNameContact.setRequiredIndicatorVisible(true);

    // Contact Last Name
    lastName = new TextField("Contact Last Name");
    lastName.setPlaceholder("Enter Last Name");
    lastName.setRequired(true);
    lastName.setRequiredIndicatorVisible(true);

    // Date of Birth
    dateOfBirth = new DatePicker("Date of Birth");
    dateOfBirth.setMax(LocalDate.now());
    dateOfBirth.setRequired(true);
    dateOfBirth.setRequiredIndicatorVisible(true);
    dateOfBirth.setPlaceholder("YYYY-MM-DD");

    // Phone Number
    phone = new TextField("Phone Number");
    phone.setRequired(true);
    phone.setPlaceholder("Phone Number");
    phone.setRequiredIndicatorVisible(true);

    // Age (Years and Months)
    ageYears = new TextField("Age (Years)");
    ageYears.setPlaceholder("Estimated Years");
    ageYears.setTooltipText("Estimated Years");

    ageMonths = new TextField("Age (Months)");
    ageMonths.setPlaceholder("Estimated Months");
    ageMonths.setTooltipText("Estimated Months");

    // Create a wrapper for age with label

    // State of Residence
    residenceState = new ComboBox<>("State of Residence");
    residenceState.setItems(STATE_DATA);
    residenceState.setPlaceholder("Select State");
    residenceState.setRequired(true);
    residenceState.setRequiredIndicatorVisible(true);
    residenceState.setClearButtonVisible(true);

    // Handle state change to update LGA options
    residenceState.addValueChangeListener(event -> {
      String selectedState = event.getValue();
      if (selectedState != null) {
        List<String> lgaOptions = LGA_DATA.get(selectedState);
        residenceLga.setItems(lgaOptions != null ? lgaOptions : Arrays.asList());
        residenceWard.setItems(lgaOptions != null ? lgaOptions : Arrays.asList());
      } else {
        residenceLga.clear();
        residenceWard.clear();
        residenceLga.setItems();
        residenceWard.setItems();
      }
    });

    // LGA of Residence
    residenceLga = new ComboBox<>("LGA of Residence");
    residenceLga.setPlaceholder("Select LGA");
    residenceLga.setRequired(true);
    residenceLga.setRequiredIndicatorVisible(true);
    residenceLga.setClearButtonVisible(true);

    // Ward of Residence
    residenceWard = new ComboBox<>("Ward of Residence");
    residenceWard.setPlaceholder("Select Ward");
    residenceWard.setRequired(true);
    residenceWard.setRequiredIndicatorVisible(true);
    residenceWard.setClearButtonVisible(true);

    // Relationship with Case
    relationshipWithCase = new ComboBox<>("Relationship with Case");
    relationshipWithCase.setItems(RELATIONSHIP_WITH_CASE);
    relationshipWithCase.setRequired(true);
    relationshipWithCase.setRequiredIndicatorVisible(true);
    relationshipWithCase.setClearButtonVisible(true);

    // Add all components to the form
    form.add(
        firstNameContact,
        lastName,
        dateOfBirth,
        phone,
        ageYears,
        ageMonths,
        residenceState,
        residenceLga,
        residenceWard,
        relationshipWithCase);

    // Set colspan for relationship field to span 2 columns (as in original lg={12})
    // form.add(relationshipWithCase);
    // form.setColspan(relationshipWithCase, 2);

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));

    return form;
  }
}
