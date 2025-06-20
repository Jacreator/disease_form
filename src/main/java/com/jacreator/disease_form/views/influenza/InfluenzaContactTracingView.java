package com.jacreator.disease_form.views.influenza;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class InfluenzaContactTracingView extends VerticalLayout {
  private final Map<String, List<String>> lgaData = new HashMap<>();
  private ComboBox<String> contactLgaOfResidence;
  private ComboBox<String> contactWardOfResidence;

  public InfluenzaContactTracingView() {
    setWidthFull();

    // State and LGA data
    lgaData.put("FCT", Arrays.asList("AMAC", "Bwari", "Kwali"));
    lgaData.put("Enugu", Arrays.asList("Nsukka", "Enugu south", "Udi"));

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Contact First Name
    TextField contactFirstName = new TextField("Contact First Name");
    contactFirstName.setPlaceholder("Enter First Name");
    contactFirstName.setRequired(true);

    // Contact Middle Name
    TextField contactMiddleName = new TextField("Contact Middle Name");
    contactMiddleName.setPlaceholder("Enter Middle Name");
    contactMiddleName.setRequired(true);

    // Contact Last Name
    TextField contactLastName = new TextField("Contact Last Name");
    contactLastName.setPlaceholder("Enter Last Name");
    contactLastName.setRequired(true);

    // Date of Birth
    DatePicker dateOfBirth = new DatePicker("Date of Birth");
    dateOfBirth.setMax(LocalDate.now());
    dateOfBirth.setRequired(true);

    // Age (Years and Months) - Using HorizontalLayout to mimic Input.Group
    Div ageContainer = new Div();
    ageContainer.getStyle().set("display", "flex");
    ageContainer.getStyle().set("gap", "8px");

    TextField ageYears = new TextField("Estimated Years");
    ageYears.setPlaceholder("Estimated Years");
    ageYears.setTooltipText("Estimated Years");
    ageYears.setRequired(true);

    // TextField ageMonths = new TextField("Estimated Months");
    // ageMonths.setPlaceholder("Estimated Months");
    // ageMonths.setTooltipText("Estimated Months");

    // Create a wrapper for the age field with label

    // Phone Number
    TextField phone = new TextField("Phone Number");
    phone.setPlaceholder("Phone Number");
    phone.setRequired(true);

    // Contact State of Residence
    ComboBox<String> contactStateOfResidence = new ComboBox<>("Contact State of Residence");
    contactStateOfResidence.setItems("FCT", "Enugu");
    contactStateOfResidence.setPlaceholder("Select State");
    contactStateOfResidence.setRequired(true);

    // Contact LGA of Residence
    contactLgaOfResidence = new ComboBox<>("Contact LGA of Residence");
    contactLgaOfResidence.setPlaceholder("Select LGA");
    contactLgaOfResidence.setRequired(true);

    // Contact Ward of Residence
    contactWardOfResidence = new ComboBox<>("Contact Ward of Residence");
    contactWardOfResidence.setPlaceholder("Select Ward");
    contactWardOfResidence.setRequired(true);

    // Dynamic LGA and Ward population
    contactStateOfResidence.addValueChangeListener(event -> {
      String state = event.getValue();
      List<String> lgas = lgaData.getOrDefault(state, Collections.emptyList());
      contactLgaOfResidence.setItems(lgas);
      contactWardOfResidence.setItems(lgas); // Assuming wards are same as LGAs for this example
    });

    // Contact Residential Address
    TextField contactResidentialAddress = new TextField("Contact Residential Address");
    contactResidentialAddress.setPlaceholder("Enter Address");

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

    // Responsive steps
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));

    // Add all fields to the form
    form.add(
        contactFirstName,
        contactMiddleName,
        contactLastName,
        dateOfBirth,
        ageYears,
        phone,
        contactStateOfResidence,
        contactLgaOfResidence,
        contactWardOfResidence,
        contactResidentialAddress);

    return form;
  }
}
