package com.jacreator.disease_form.views;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jacreator.disease_form.component.LocalDateTimePicker;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class RumourLogView extends VerticalLayout {

  private final List<String> Lgas = Arrays.asList("AMAC", "Bwari", "Kwali", "Nsukka", "Enugu south", "Udi");
  private final List<String> sourceList = Arrays.asList("Observed", "Print and Media", "Facebook", "Twitter", "WhatsApp", "Other");
  private final List<String> diseaseEventList = Arrays.asList("Increasing", "Decreasing", "Static");

  public RumourLogView() {
    setWidthFull();

    add(buildForm());
  }

  private Map<String, List<String>> wardData = new HashMap<String, List<String>>() {
    {
      put("AMAC", Arrays.asList("City Centre", "Garki", "Kabusa", "Wuse", "Gwarinpa"));
      put("Bwari", Arrays.asList("Bwari Central", "Kuduru", "Igu", "Shere", "Kawu", "Ushafa"));
      put("KUJE", Arrays.asList("Kuje", "Chibiri", "Gaube", "Kwaku"));
      put("Nsukka", Arrays.asList("IBEKU", "ALOR-UNO", "EDE-UKWU", "EDE-NTA", "EDEM-ANI"));
      put("Enugu south", Arrays.asList("Akwuke", "Amechi I", "Achara Layout East", "Achara Layout West"));
      put("Udi", Arrays.asList("Oghu", "Affa", "Okpatu", "Awhum", "Ukana", "Abor"));
    }
  };

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // community informant
    TextField communityInformant = new TextField("Name of Community Informant");

    // Telephone Number
    TextField telephoneNumber = new TextField("Telephone Number");

    // LGA Of Residence
    ComboBox<String> lgaOfResidence = new ComboBox<>("Select LGA");
    lgaOfResidence.setItems(Lgas);
    lgaOfResidence.setRequired(true);

    // Ward Of Residence
    ComboBox<String> wardOfResidence = new ComboBox<>("Select Ward");
    wardOfResidence.setRequired(true);

    // Community
    TextField communityComboBox = new TextField("Community");
    communityComboBox.setRequired(true);
    communityComboBox.setVisible(false);

    // Date of Result Available
    DatePicker dateResultAvailable = new DatePicker("Reporting Date");
    dateResultAvailable.setMax(LocalDate.now());
    dateResultAvailable.setRequired(true);

    // Illness Type
    TextField illnessType = new TextField("Type of Illness");

    ComboBox<String> sourceOfInformation = new ComboBox<>("Source of Information");
    sourceOfInformation.setItems(sourceList);
    sourceOfInformation.setRequired(true);

    // Other source of information, please specify
    TextField otherSourceOfInformation = new TextField("Other source of information, please specify");
    otherSourceOfInformation.setVisible(false);

    // date and time when did this happen
    LocalDateTimePicker whenDidThisHappen = new LocalDateTimePicker("When did this happen");
    whenDidThisHappen.setMax(LocalDate.now());
    whenDidThisHappen.setRequired(true);

    // date/time of detection
    LocalDateTimePicker dateOfDetection = new LocalDateTimePicker("Date/Time this was Detected");
    dateOfDetection.setMax(LocalDate.now());
    dateOfDetection.setRequired(true);

    TextField peopleAffected = new TextField("How many people have been affected?");

    RadioButtonGroup<String> deathResult = new RadioButtonGroup<>();
    deathResult.setLabel("Has anyone died? If Yes, please specify");
    deathResult.setItems("Yes", "No");

    TextField deathDetails = new TextField("If Yes, please specify");
    deathDetails.setVisible(false);

    RadioButtonGroup<String> animalResult = new RadioButtonGroup<>();
    animalResult.setLabel("Are there sick or dead animals involved?");
    animalResult.setItems("Yes", "No");

    RadioButtonGroup<String> diseaseEvent = new RadioButtonGroup<>();
    diseaseEvent.setLabel("Is the event ongoing as at the time of this report?");
    diseaseEvent.setItems("Yes", "No");

    ComboBox<String> diseaseEventDetails = new ComboBox<>("If Yes, please specify");
    diseaseEventDetails.setItems(diseaseEventList);
    diseaseEventDetails.setVisible(false);

    TextField actionTaken = new TextField("What action has been taken");

    RadioButtonGroup<String> healthFacilityCheck = new RadioButtonGroup<>();
    healthFacilityCheck.setLabel("Has this been verified by a health facility?");
    healthFacilityCheck.setItems("Yes", "No");

    // Dynamic logic: Update LGA options based on state
    lgaOfResidence.addValueChangeListener(e -> {
      String lga = e.getValue();
      if (lga != null && wardData.containsKey(lga)) {
        wardOfResidence.setItems(wardData.get(lga));
        communityComboBox.setVisible(true);
      } else {
        wardOfResidence.clear();
        wardOfResidence.setItems();
      }
    });

    sourceOfInformation.addValueChangeListener(e -> {
      String source = e.getValue();
      if ("Other".equals(source)) {
        otherSourceOfInformation.setVisible(true);
      } else {
        otherSourceOfInformation.setVisible(false);
      }
    });

    deathResult.addValueChangeListener(e -> {
      if ("Yes".equals(e.getValue())) {
        deathDetails.setVisible(true);
      } else {
        deathDetails.setVisible(false);
      }
    });

    diseaseEvent.addValueChangeListener(e -> {
      if ("Yes".equals(e.getValue())) {
        diseaseEventDetails.setVisible(true);
      } else {
        diseaseEventDetails.setVisible(false);
      }
    });

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));

    form.add(communityInformant, telephoneNumber, lgaOfResidence,
        wardOfResidence, communityComboBox,
        dateResultAvailable, illnessType,
        sourceOfInformation, otherSourceOfInformation, whenDidThisHappen,
        dateOfDetection, peopleAffected, deathResult,
        deathDetails, animalResult, diseaseEvent,
        diseaseEventDetails, actionTaken, healthFacilityCheck);

    return form;
  }
}
