package com.jacreator.disease_form.views.noma;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class NOMAEpidemiologicalView extends VerticalLayout {
  public NOMAEpidemiologicalView() {
    setWidthFull();
    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();

    // Family occupation
    List<String> occupationOptions = Arrays.asList("Farmer", "Business", "Trader", "Teacher");
    ComboBox<String> familyOccupation = new ComboBox<>("Family occupation");
    familyOccupation.setItems(occupationOptions);
    familyOccupation.setPlaceholder("Select occupation");
    familyOccupation.setRequired(true);

    // Confirmed immunocompromised patient
    RadioButtonGroup<String> confirmedImmunocompromisedPatient = new RadioButtonGroup<>();
    confirmedImmunocompromisedPatient.setLabel("Confirmed immunocompromised patient");
    confirmedImmunocompromisedPatient.setItems("Yes", "No", "Unknown");
    confirmedImmunocompromisedPatient.setRequired(true);

    // Vaccination status
    RadioButtonGroup<String> vaccinationStatus = new RadioButtonGroup<>();
    vaccinationStatus.setLabel("Vaccination status");
    vaccinationStatus.setItems("Vaccinated", "Not vaccinated", "Partial vaccinated", "Unknown");
    vaccinationStatus.setRequired(true);

    // Any family history of NOMA
    RadioButtonGroup<String> anyFamilyHistoryOfNoma = new RadioButtonGroup<>();
    anyFamilyHistoryOfNoma.setLabel("Any family history of NOMA");
    anyFamilyHistoryOfNoma.setItems("Yes", "No", "Unknown");
    anyFamilyHistoryOfNoma.setRequired(true);

    // Oral hygiene
    RadioButtonGroup<String> oralHygiene = new RadioButtonGroup<>();
    oralHygiene.setLabel("Oral hygiene");
    oralHygiene.setItems("Good", "Fair", "Poor");
    oralHygiene.setRequired(true);

    // Responsive steps
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("800px", 2));

    // Add all fields to the form
    form.add(
        familyOccupation,
        confirmedImmunocompromisedPatient,
        vaccinationStatus,
        anyFamilyHistoryOfNoma,
        oralHygiene);

    return form;
  }
}
