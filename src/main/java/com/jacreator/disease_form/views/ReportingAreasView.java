package com.jacreator.disease_form.views;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ReportingAreasView extends VerticalLayout {

  private final List<String> stateData = Arrays.asList("FCT", "Enugu");
  private final List<String> fctLgas = Arrays.asList("AMAC", "Bwari", "Kwali");
  private final List<String> enuguLgas = Arrays.asList("Nsukka", "Enugu south", "Udi");

  public ReportingAreasView() {
    setWidthFull();

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();
    // Date of Result Available
    DatePicker dateResultAvailable = new DatePicker("Date of Result");
    dateResultAvailable.setMax(LocalDate.now());
    dateResultAvailable.setRequired(true);

    // State Of Residence
    ComboBox<String> stateOfResidence = new ComboBox<>("State Of Reporting");
    stateOfResidence.setItems(stateData);
    stateOfResidence.setRequired(true);

    // LGA Of Residence
    ComboBox<String> lgaOfResidence = new ComboBox<>("LGA Of Reporting");
    lgaOfResidence.setRequired(true);

    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2));

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

    form.add(dateResultAvailable, stateOfResidence,
    lgaOfResidence);

    return form;
  }
}
