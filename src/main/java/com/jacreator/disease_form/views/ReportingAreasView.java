package com.jacreator.disease_form.views;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ReportingAreasView extends VerticalLayout {

  private final List<String> stateData = Arrays.asList("FCT", "Enugu");
  private final List<String> fctLgas = Arrays.asList("AMAC", "Bwari", "Kwali");
  private final List<String> enuguLgas = Arrays.asList("Nsukka", "Enugu south", "Udi");
  private final List<String> healthFacilities = Arrays.asList("Federal Medical Center", "Jabi Clinic");
  private final List<String> place = Arrays.asList("Health Facility, General Hospital, School");
  private final List<String> notifiedList = Arrays.asList("Focal Person, DSNO");

  public ReportingAreasView() {
    setWidthFull();

    add(buildForm());
  }

  private Map<String, List<String>> wardData = new HashMap<String, List<String>>() {
    {
      put("AMAC", Arrays.asList("Ward 1", "Ward 2", "Ward 3"));
      put("Bwari", Arrays.asList("Ward 4", "Ward 5"));
      put("Kwali", Arrays.asList("Ward 6", "Ward 7"));
      put("Nsukka", Arrays.asList("Ward 8", "Ward 9"));
      put("Enugu South", Arrays.asList("Ward 10", "Ward 11"));
      put("Udi", Arrays.asList("Ward 12", "Ward 13"));
    }
  };

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();
    // Date of Result Available
    DatePicker dateResultAvailable = new DatePicker("Date of Result");
    dateResultAvailable.setMax(LocalDate.now());
    dateResultAvailable.setRequired(true);

    // date of Investigation
    DatePicker dateOfInvestigation = new DatePicker("Date of Investigation");
    dateOfInvestigation.setMax(LocalDate.now());
    dateOfInvestigation.setRequired(true);

    // date of notification
    DatePicker dateOfNotice = new DatePicker("Date of Notification");
    dateOfNotice.setMax(LocalDate.now());
    dateOfNotice.setRequired(true);

    // State Of Residence
    ComboBox<String> stateOfResidence = new ComboBox<>("State Of Reporting");
    stateOfResidence.setItems(stateData);
    stateOfResidence.setRequired(true);

    // Place of Detection
    ComboBox<String> placeOfDetection = new ComboBox<>("Place of Detection");
    placeOfDetection.setItems(place);
    placeOfDetection.setRequired(true);

    ComboBox<String> notifiedBy = new ComboBox<>("Notified By");
    notifiedBy.setItems(notifiedList);
    notifiedBy.setRequired(true);

    // health facility
    ComboBox<String> healthFacility = new ComboBox<>("Health Facility");
    healthFacility.setItems(healthFacilities);
    healthFacility.setRequired(true);

    // health facility
    ComboBox<String> wardOfReporting = new ComboBox<>("Ward of Reporting");
    healthFacility.setRequired(true);

    // LGA Of Residence
    ComboBox<String> lgaOfResidence = new ComboBox<>("LGA Of Reporting");
    lgaOfResidence.setRequired(true);

    // Dynamic logic: Update LGA options based on state
    stateOfResidence.addValueChangeListener(e -> {
      String state = e.getValue();
      if ("FCT".equals(state)) {
        lgaOfResidence.setItems(fctLgas);
      } else if ("Enugu".equals(state)) {
        lgaOfResidence.setItems(enuguLgas);
      } else {
        lgaOfResidence.clear();
        lgaOfResidence.setItems();
      }
    });

    // Dynamic logic: Update Ward options based on LGA
    lgaOfResidence.addValueChangeListener(e -> {
      String lga = e.getValue();
      if (lga != null && wardData.containsKey(lga)) {
        wardOfReporting.setItems(wardData.get(lga));
      } else {
        wardOfReporting.clear();
        wardOfReporting.setItems();
      }
    });

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));

    form.add(dateResultAvailable, stateOfResidence,
        lgaOfResidence, wardOfReporting,
        placeOfDetection, healthFacility,
        notifiedBy, dateOfNotice, dateOfInvestigation);

    return form;
  }
}
