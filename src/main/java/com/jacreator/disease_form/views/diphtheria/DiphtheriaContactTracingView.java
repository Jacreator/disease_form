package com.jacreator.disease_form.views.diphtheria;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class DiphtheriaContactTracingView extends VerticalLayout {
  private static final List<String> STATE_DATA = Arrays.asList("FCT", "Enugu");
  private static final Map<String, List<String>> LGA_DATA = new HashMap<>() {
    {
      put("FCT", Arrays.asList("AMAC", "Bwari", "Kwali"));
      put("Enugu", Arrays.asList("Nsukka", "Enugu south", "Udi"));
    }
  };
  private static final List<String> RELATIONSHIP_WITH_CASE = Arrays.asList(
      "Parent", "Sibling", "Child", "Neighbor", "Work/School Colleague",
      "Healthcare giver", "Patient", "Others");

  private ComboBox<String> stateOfResidence;
  private ComboBox<String> lgaOfResidence;
  private ComboBox<String> wardOfResidence;

  public DiphtheriaContactTracingView() {
    setWidthFull();
    setPadding(true);
    setSpacing(true);

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();
    form.setWidthFull();
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("900px", 3));

    // Contact First Name
    TextField contactFirstName = new TextField("Contact First Name");
    contactFirstName.setRequired(true);
    contactFirstName.setRequiredIndicatorVisible(true);

    // Contact Last Name
    TextField contactLastName = new TextField("Contact Last Name");
    contactLastName.setRequired(true);
    contactLastName.setRequiredIndicatorVisible(true);

    // Date of Birth
    DatePicker dateOfBirth = new DatePicker("Date of Birth");
    dateOfBirth.setMax(LocalDate.now());
    dateOfBirth.setRequired(true);
    dateOfBirth.setRequiredIndicatorVisible(true);

    // Contact Age (Years and Months)
    TextField ageYears = new TextField("Contact Age (Years)");
    ageYears.setRequired(true);
    ageYears.setRequiredIndicatorVisible(true);
    ageYears.setEnabled(false);

    // TextField ageMonths = new TextField("Contact Age (Months)");
    // ageMonths.setPlaceholder("Estimated Months");
    // ageMonths.setEnabled(false);

    // Contact Sex
    RadioButtonGroup<String> contactSex = new RadioButtonGroup<>("Contact Sex");
    contactSex.setItems("Male", "Female");
    contactSex.setRequired(true);
    contactSex.setRequiredIndicatorVisible(true);

    // State of Residence
    stateOfResidence = new ComboBox<>("Contact State of Residence");
    stateOfResidence.setItems(STATE_DATA);
    stateOfResidence.setRequired(true);
    stateOfResidence.setRequiredIndicatorVisible(true);

    // LGA of Residence
    lgaOfResidence = new ComboBox<>("Contact LGA of Residence");
    lgaOfResidence.setRequired(true);
    lgaOfResidence.setRequiredIndicatorVisible(true);

    // Ward of Residence
    wardOfResidence = new ComboBox<>("Contact Ward of Residence");
    wardOfResidence.setRequired(true);
    wardOfResidence.setRequiredIndicatorVisible(true);

    // Contact Residential Address
    TextField contactResidentialAddress = new TextField("Contact Residential Address");
    contactResidentialAddress.setRequired(true);
    contactResidentialAddress.setRequiredIndicatorVisible(true);

    // Relationship with Case
    ComboBox<String> relationshipWithCase = new ComboBox<>("Relationship with Case");
    relationshipWithCase.setItems(RELATIONSHIP_WITH_CASE);
    relationshipWithCase.setRequired(true);
    relationshipWithCase.setRequiredIndicatorVisible(true);

    // Dynamic LGA and Ward population
    stateOfResidence.addValueChangeListener(e -> {
      String selectedState = e.getValue();
      List<String> lgas = LGA_DATA.getOrDefault(selectedState, Collections.emptyList());
      lgaOfResidence.setItems(lgas);
      wardOfResidence.setItems(lgas); // Assuming wards are same as LGAs for this example
    });

    // Listener to calculate and set age
    dateOfBirth.addValueChangeListener(event -> {
      LocalDate dob = event.getValue();
      if (dob != null) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dob, today);

        int years = period.getYears();
        int months = period.getMonths();

        StringBuilder ageText = new StringBuilder();
        if (years > 0) {
          ageText.append(years).append(" year").append(years > 1 ? "s" : "");
        }
        if (months > 0) {
          if (ageText.length() > 0)
            ageText.append(", ");
          ageText.append(months).append(" month").append(months > 1 ? "s" : "");
        }
        if (ageText.length() == 0) {
          ageText.append("Less than a month");
        }

        ageYears.setValue(ageText.toString());
      } else {
        ageYears.clear();
      }
    });
    // Add all components to the form
    form.add(
        contactFirstName,
        contactLastName,
        dateOfBirth,
        ageYears,
        contactSex,
        stateOfResidence,
        lgaOfResidence,
        wardOfResidence,
        contactResidentialAddress,
        relationshipWithCase);

    return form;
  }
}
