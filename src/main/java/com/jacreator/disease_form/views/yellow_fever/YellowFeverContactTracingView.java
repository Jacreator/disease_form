package com.jacreator.disease_form.views.yellow_fever;

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
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class YellowFeverContactTracingView extends VerticalLayout {
  private static final List<String> RELATIONSHIP_WITH_CASE = Arrays.asList(
      "Parent", "Sibling", "Child", "Neighbour", "Work/School Colleague",
      "Healthcare giver", "Patient", "Others");

  private static final List<String> STATE_DATA = Arrays.asList("FCT", "Enugu");

  private static final Map<String, List<String>> LGA_DATA = new HashMap<>() {
    {
      put("FCT", Arrays.asList("AMAC", "Bwari", "Kwali"));
      put("Enugu", Arrays.asList("Nsukka", "Enugu south", "Udi"));
    }
  };

  private Map<String, List<String>> wardData = new HashMap<String, List<String>>() {
    {
      put("AMAC", Arrays.asList("City Centre", "Garki", "Kabusa", "Wuse", "Gwarinpa"));
      put("Bwari", Arrays.asList("Bwari Central", "Kuduru", "Igu", "Shere", "Kawu", "Ushafa"));
      put("KUJE", Arrays.asList("Kuje", "Chibiri", "Gaube", "Kwaku"));
      put("Nsukka", Arrays.asList("IBEKU", "ALOR-UNO", "EDE-UKWU", "EDE-NTA", "EDEM-ANI"));
      put("Enugu South", Arrays.asList("Akwuke", "Amechi I", "Achara Layout East", "Achara Layout West"));
      put("Udi", Arrays.asList("Oghu", "Affa", "Okpatu", "Awhum", "Ukana", "Abor"));
    }
  };

  public YellowFeverContactTracingView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Contact first name
    TextField contactFirstName = new TextField("Contact first name");
    contactFirstName.setPlaceholder("Enter First Name");
    contactFirstName.setRequired(true);

    // Contact last name
    TextField contactLastName = new TextField("Contact last name");
    contactLastName.setPlaceholder("Enter Last Name");
    contactLastName.setRequired(true);

    // Date of birth
    DatePicker contactDateOfBirth = new DatePicker("Date of birth");
    contactDateOfBirth.setMax(LocalDate.now());
    contactDateOfBirth.setRequired(true);

    // Contact age (years and months)
    TextField contactAgeYears = new TextField("Contact age (years)");
    contactAgeYears.setPlaceholder("Estimated Years");
    contactAgeYears.setRequired(true);

    // TextField contactAgeMonths = new TextField("Contact age (months)");
    // contactAgeMonths.setPlaceholder("Estimated Months");
    // contactAgeMonths.setEnabled(false); // As in your code

    // Contact sex
    RadioButtonGroup<String> contactSex = new RadioButtonGroup<>();
    contactSex.setLabel("Contact sex");
    contactSex.setItems("Male", "Female");
    contactSex.setRequired(true);

    // Contact state of residence
    ComboBox<String> contactStateOfResidence = new ComboBox<>("Contact state of residence");
    contactStateOfResidence.setItems(STATE_DATA);
    contactStateOfResidence.setPlaceholder("Select State");
    contactStateOfResidence.setRequired(true);

    // Contact LGA of residence
    ComboBox<String> contactLgaOfResidence = new ComboBox<>("Contact LGA of residence");
    contactLgaOfResidence.setPlaceholder("Select LGA");
    contactLgaOfResidence.setRequired(true);

    // Contact ward of residence
    ComboBox<String> contactWardOfResidence = new ComboBox<>("Contact ward of residence");
    contactWardOfResidence.setPlaceholder("Select Ward");
    contactWardOfResidence.setRequired(true);

    // Dynamic LGA and Ward population
    contactStateOfResidence.addValueChangeListener(e -> {
      String selectedState = e.getValue();
      List<String> lgas = LGA_DATA.getOrDefault(selectedState, Collections.emptyList());
      contactLgaOfResidence.setItems(lgas);// Assuming wards are same as LGAs in your code
    });

    contactLgaOfResidence.addValueChangeListener(e -> {
      String lga = e.getValue();
      if (lga != null && wardData.containsKey(lga)) {
        contactWardOfResidence.setItems(wardData.get(lga));
      } else {
        contactWardOfResidence.clear();
        contactWardOfResidence.setItems();
      }
    });

    // Contact residential address
    TextField contactResidentialAddress = new TextField("Contact residential address");
    contactResidentialAddress.setPlaceholder("Enter Contact Address");
    contactResidentialAddress.setRequired(true);

    // Relationship with case
    ComboBox<String> relationshipWithCase = new ComboBox<>("Relationship with case");
    relationshipWithCase.setItems(RELATIONSHIP_WITH_CASE);
    relationshipWithCase.setPlaceholder("Select Relationship");
    relationshipWithCase.setRequired(true);

    // Listener to calculate and set age
    contactDateOfBirth.addValueChangeListener(event -> {
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

        contactAgeYears.setValue(ageText.toString());
      } else {
        contactAgeYears.clear();
      }
    });

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    // Add all fields to the form
    form.add(contactFirstName, contactLastName, contactDateOfBirth);
    form.add(contactAgeYears, contactSex);
    form.add(contactStateOfResidence, contactLgaOfResidence, contactWardOfResidence);
    form.add(contactResidentialAddress, relationshipWithCase);

    return form;
  }
}
