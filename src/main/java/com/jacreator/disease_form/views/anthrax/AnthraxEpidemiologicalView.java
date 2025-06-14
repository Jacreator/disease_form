package com.jacreator.disease_form.views.anthrax;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class AnthraxEpidemiologicalView extends VerticalLayout {
  public AnthraxEpidemiologicalView() {
    // Open by default if you want: accordion.open(0);
    add(createForm());
  }

  private FormLayout createForm() {
    FormLayout formLayout = new FormLayout();

    // Options
    List<String> yesNoUnknown = Arrays.asList("Yes", "No", "Unknown");
    List<String> kindAnimals = Arrays.asList("Goat", "Sheep", "Dog", "Monkey", "Lion", "Beer");
    List<Integer> doses = Arrays.asList(1, 2, 3, 4, 5);

    // Vaccinated with anthrax vaccine
    RadioButtonGroup<String> vaccinatedWithAnthrax = new RadioButtonGroup<>();
    vaccinatedWithAnthrax.setLabel("Vaccinated with anthrax vaccine");
    vaccinatedWithAnthrax.setItems(yesNoUnknown);

    // If yes, name of vaccine
    TextField nameOfVaccine = new TextField("If yes, name of vaccine");
    nameOfVaccine.setVisible(false);

    // Route of vaccine administration
    RadioButtonGroup<String> routeOfVaccineAdministration = new RadioButtonGroup<>();
    routeOfVaccineAdministration.setLabel("Route of vaccine administration");
    routeOfVaccineAdministration.setItems(yesNoUnknown);
    routeOfVaccineAdministration.setVisible(false);

    // Number of anthrax vaccine doses
    ComboBox<Integer> numberOfAnthraxVaccineDoses = new ComboBox<>("Number of anthrax vaccine doses");
    numberOfAnthraxVaccineDoses.setItems(doses);
    numberOfAnthraxVaccineDoses.setVisible(false);

    // Date of last vaccination
    DatePicker dateOfLastVaccination = new DatePicker("Date of last vaccination");
    dateOfLastVaccination.setMax(LocalDate.now());
    dateOfLastVaccination.setVisible(false);

    // Date of last booster dose
    DatePicker dateOfLastDose = new DatePicker("Date of last booster dose");
    dateOfLastDose.setMax(LocalDate.now());
    dateOfLastDose.setVisible(false);

    // Close contact with suspected or confirmed human case of anthrax
    RadioButtonGroup<String> closeContactWithSuspectedOrConfirmedCase = new RadioButtonGroup<>();
    closeContactWithSuspectedOrConfirmedCase
        .setLabel("Close contact with suspected or confirmed human case of anthrax");
    closeContactWithSuspectedOrConfirmedCase.setItems(yesNoUnknown);
    closeContactWithSuspectedOrConfirmedCase.setVisible(false);

    // Show/hide vaccine-related fields
    vaccinatedWithAnthrax.addValueChangeListener(event -> {
      boolean show = "Yes".equals(event.getValue());
      nameOfVaccine.setVisible(show);
      routeOfVaccineAdministration.setVisible(show);
      numberOfAnthraxVaccineDoses.setVisible(show);
      dateOfLastVaccination.setVisible(show);
      dateOfLastDose.setVisible(show);
      closeContactWithSuspectedOrConfirmedCase.setVisible(show);
    });

    // Associated with an outbreak
    RadioButtonGroup<String> associatedWithAnOutbreak = new RadioButtonGroup<>();
    associatedWithAnOutbreak.setLabel("Associated with an outbreak");
    associatedWithAnOutbreak.setItems(yesNoUnknown);

    // Contact with animals or animal products
    RadioButtonGroup<String> contactWithAnimalProduct = new RadioButtonGroup<>();
    contactWithAnimalProduct.setLabel("Contact with animals or animal products");
    contactWithAnimalProduct.setItems(yesNoUnknown);

    // If yes, what kind of animal
    ComboBox<String> whatKindOfAnimal = new ComboBox<>("If yes to above, what kind of animal?");
    whatKindOfAnimal.setItems(kindAnimals);
    whatKindOfAnimal.setVisible(false);

    contactWithAnimalProduct.addValueChangeListener(event -> {
      whatKindOfAnimal.setVisible("Yes".equals(event.getValue()));
    });

    // Most probable place of exposure to anthrax and contact
    RadioButtonGroup<String> placeOfExposureToAnthrax = new RadioButtonGroup<>();
    placeOfExposureToAnthrax.setLabel("Most probable place of exposure to anthrax and contact");
    placeOfExposureToAnthrax.setItems(yesNoUnknown);

    // Source confirmed positive for anthrax
    RadioButtonGroup<String> sourceConfirmedPositiveForAnthrax = new RadioButtonGroup<>();
    sourceConfirmedPositiveForAnthrax.setLabel("Source confirmed positive for anthrax");
    sourceConfirmedPositiveForAnthrax.setItems(yesNoUnknown);

    // Human exposures in the 14 days before illness onset
    RadioButtonGroup<String> humanExposures = new RadioButtonGroup<>();
    humanExposures.setLabel("Human exposures in the 14 days before illness onset");
    humanExposures.setItems(yesNoUnknown);

    formLayout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));

    // Add all fields to the form
    formLayout.add(
        vaccinatedWithAnthrax, nameOfVaccine, routeOfVaccineAdministration,
        numberOfAnthraxVaccineDoses, dateOfLastVaccination, dateOfLastDose,
        closeContactWithSuspectedOrConfirmedCase,
        associatedWithAnOutbreak, contactWithAnimalProduct, whatKindOfAnimal,
        placeOfExposureToAnthrax, sourceConfirmedPositiveForAnthrax, humanExposures);

    return formLayout;
  }
}
